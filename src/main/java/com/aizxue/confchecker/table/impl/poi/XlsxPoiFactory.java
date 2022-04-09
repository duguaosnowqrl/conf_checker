package com.aizxue.confchecker.table.impl.poi;

import java.io.File;
import java.util.Collection;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.aizxue.confchecker.exception.EmptyRowException;
import com.aizxue.confchecker.exception.FieldNotFoundException;
import com.aizxue.confchecker.exception.UnsupportedFieldTypeException;
import com.aizxue.confchecker.table.FieldAddress;
import com.aizxue.confchecker.table.IContext;
import com.aizxue.confchecker.table.IField;
import com.aizxue.confchecker.table.IMetaData;
import com.aizxue.confchecker.table.IRow;
import com.aizxue.confchecker.table.ITable;
import com.aizxue.confchecker.table.ITableFactory;
import com.aizxue.confchecker.table.impl.FieldImpl;
import com.aizxue.confchecker.table.impl.MetaDataImpl;
import com.aizxue.confchecker.table.impl.RowImpl;
import com.aizxue.confchecker.table.impl.TableImpl;

public class XlsxPoiFactory implements ITableFactory {
	public static final int PRIMARY_KEY_CELL_INDEX = 0;
	public static final int FIELD_EN_NAME_INDEX = 0;
	public static final int FIELD_TYPE_INDEX = 1;
	public static final int FIELD_CH_NAME_INDEX = 2;
	public static final int FIELD_CS_INDEX = 3;

	@Override
	public void createTable(IContext context, String path) throws Exception {
		File file = new File(path);
		Workbook wb = WorkbookFactory.create(file);
		Iterator<Sheet> iter = wb.sheetIterator();
		while (iter.hasNext()) {
			Sheet sheet = iter.next();
			String sheetName = sheet.getSheetName();
			if (sheetName.toUpperCase().indexOf("SHEET") > -1) {
				continue;
			}

			ITable table = new TableImpl(path, sheetName);
			IMetaData metaData = new MetaDataImpl();
			table.setMetaData(metaData);
			metaData.setTable(table);

			parseMetaData(sheet, table);
			parseTable(sheet, table);

			if (!table.isEmpty()) {
				context.addTable(table);
			}
		}
	}

	private void parseMetaData(Sheet sheet, ITable table) throws Exception {
		Row enNameRow = sheet.getRow(FIELD_EN_NAME_INDEX);
		Row typeRow = sheet.getRow(FIELD_TYPE_INDEX);
		Row chNameRow = sheet.getRow(FIELD_CH_NAME_INDEX);
		Row csRow = sheet.getRow(FIELD_CS_INDEX);

		Row[] rows = { enNameRow, typeRow, chNameRow, csRow };
		for (Row row : rows) {
			if (PoiUtil.isEmptyRow(enNameRow)) {
				String address = new FieldAddress(sheet.getSheetName(), enNameRow.getRowNum() + 1).toString();
				throw new EmptyRowException(address + " 该行数据为空");
			}
		}

		Cell cell = enNameRow.getCell(0);
		if (PoiUtil.isEmptyCell(cell)) {
			String address = PoiUtil.getAddress(sheet.getSheetName(), enNameRow.getRowNum(), 0);
			throw new FieldNotFoundException(address + "缺少主键列");
		}

		for (int i = enNameRow.getFirstCellNum(); i < enNameRow.getLastCellNum(); i++) {
			Cell nameCell = enNameRow.getCell(i);
			Cell cNameCell = chNameRow.getCell(i);
			Cell typeCell = typeRow.getCell(i);
			Cell csCell = csRow.getCell(i);

			if (PoiUtil.isEmptyCell(nameCell)) {
				String address = PoiUtil.getAddress(sheet.getSheetName(), enNameRow.getRowNum(), i);
				throw new FieldNotFoundException(address + "缺少英文字段名");
			}

			if (PoiUtil.isEmptyCell(cNameCell)) {
				String address = PoiUtil.getAddress(sheet.getSheetName(), chNameRow.getRowNum(), i);
				throw new FieldNotFoundException(address + "缺少中文字段名");
			}

			if (PoiUtil.isEmptyCell(typeCell)) {
				String address = PoiUtil.getAddress(sheet.getSheetName(), typeRow.getRowNum(), i);
				throw new FieldNotFoundException(address + "缺少数据类型");
			}

			if (PoiUtil.isEmptyCell(csCell)) {
				if(!"msg".equals(PoiUtil.getCellValue(typeCell))) {
					String address = PoiUtil.getAddress(sheet.getSheetName(), csRow.getRowNum(), i);
					throw new FieldNotFoundException(address + "缺少前后端类型");
				}
			}

			IField field = createField(i, nameCell, cNameCell, typeCell, csCell);
			table.getMetaData().addField(field);
			if (i == 0) {
				table.getMetaData().setPrimaryKey(field.getName());
			}
		}
	}

	private IField createField(int index, Cell nameCell, Cell cNameCell, Cell typeCell, Cell csCell) throws Exception {
		String name = PoiUtil.getCellValue(nameCell);
		String cname = PoiUtil.getCellValue(cNameCell);
		int type = covertToFieldType(PoiUtil.getCellValue(typeCell));
		boolean isClient = false;
		boolean isServer = false;
		if(csCell != null) {
			String value = PoiUtil.getCellValue(csCell);
			if(value != null) {
				if(value.indexOf("c") > -1) {
					isClient = true;
				}
				if(value.indexOf("s") > -1) {
					isServer = true;
				}
			}
		}
		FieldImpl field = new FieldImpl(index, name, cname, type, isClient, isServer);
		return field;
	}

	private int covertToFieldType(String typeStr) throws Exception {
		switch (typeStr) {
		case "str":
		case "string":
			return IField.TYPE_STR;
		case "msg":
		case "mark":
			return IField.TYPE_MARK;
		case "int":
			return IField.TYPE_INT;
		case "float":
			return IField.TYPE_FLOAT;
		case "int[]":
			return IField.TYPE_INTARR;
		case "arr[]":
			return IField.TYPE_ARRARR;
		default:
			throw new UnsupportedFieldTypeException("不支持的字段类型: " + typeStr);
		}
	}

	private void parseTable(Sheet sheet, ITable table) {
		for (int i = FIELD_CS_INDEX + 1; i < sheet.getLastRowNum(); i++) {
			Row row = sheet.getRow(i);
			// 空行
			if (row == null || row.toString().isEmpty()) {
				continue;
			}
			// 缺少主键
			Cell cell = row.getCell(PRIMARY_KEY_CELL_INDEX);
			if (cell == null) {
				continue;
			}
			// 注释
			String str = PoiUtil.getCellValue(cell);
			if (str == null || str.startsWith("#")) {
				continue;
			}
			this.parseRow(sheet, table, row);
		}
	}

	private void parseRow(Sheet sheet, ITable table, Row row) {
		Collection<IField> fields = table.getMetaData().fields();
		RowImpl rowImpl = new RowImpl();
		rowImpl.setRowNum(row.getRowNum() + 1);

		for (IField field : fields) {
			Cell cell = row.getCell(field.getIndex());
			if(PoiUtil.isEmptyCell(cell)) {
				continue;
			}
			String value =  PoiUtil.getCellValue(cell);
			if(field.getType() == IField.TYPE_INT) {
				value = (long)Double.parseDouble(value) + "";
			}
			rowImpl.setFieldValue(field.getName(), value);
		}

		String primaryKey = table.getMetaData().getPrimaryKey();
		String primaryValue = rowImpl.getFieldValue(primaryKey);
		rowImpl.setId(primaryValue);
		if (!rowImpl.isEmpty()) {
			table.addRow(rowImpl);
		}
	}
}
