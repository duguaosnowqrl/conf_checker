package com.aizxue.confchecker.table.impl.poi;

import java.io.File;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.aizxue.confchecker.table.IContext;
import com.aizxue.confchecker.table.ITable;
import com.aizxue.confchecker.table.ITableFactory;
import com.aizxue.confchecker.table.impl.TableImpl;

public class XlsxPoiFactory implements ITableFactory {

	@Override
	public void createTable(IContext context, String path) throws Exception {
		File file = new File(path);
		Workbook wb = WorkbookFactory.create(file);
		Iterator<Sheet> iter =  wb.sheetIterator();
		while(iter.hasNext()) {
				Sheet sheet = iter.next();
				String sheetName = sheet.getSheetName();
				if(sheetName.toUpperCase().indexOf("SHEET") > -1) {
					continue;
				}
				
				ITable table = new TableImpl(path, sheetName);
				if(!table.isEmpty()){
					context.addTable(table);
				}
		}
	}
	
	private void parseTable(Sheet sheet,ITable table) {
		Iterator<Row> iter = sheet.rowIterator();
		while(iter.hasNext()) {
				Row row = iter.next();
				if(row == null || row.toString().isEmpty()) {
						continue;
				}
				
		}
	}
}
