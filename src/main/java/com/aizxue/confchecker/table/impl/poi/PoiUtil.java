package com.aizxue.confchecker.table.impl.poi;

import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.util.CellAddress;

public class PoiUtil {
	public static boolean isEmptyRow(Row row) {
		if(row == null || row.toString().isEmpty()) {
				return true;
		}
		Iterator<Cell> iter = row.iterator();
		while(iter.hasNext()) {
				Cell cell  = iter.next();
				if(cell.getCellType() != CellType.BLANK) {
					return false;
				}
		}
		return true;
	}
	
	public static boolean isEmptyCell(Cell cell) {
		if(cell == null) {
			return true;
		}
		if(cell.getCellType() == CellType.BLANK) {
			return true;
		}
		String value = getCellValue(cell);
		if(value == null || value.length() == 0) {
			return true;
		}
		return false;
	}
	
	public static String getAddress(Sheet sheet) {
		StringBuilder sb = new StringBuilder();
		if(sheet != null) {
			sb.append("[");
			sb.append(sheet.getSheetName());
			sb.append("]");
		}
		return sb.toString();
	}
	
	public static String getAddress(Row row) {
		StringBuilder sb = new StringBuilder();
		if(row != null) {
			sb.append("[");
			sb.append(row.getSheet().getSheetName());
			sb.append(":");
			sb.append(row.getRowNum() + 1);
			sb.append("]");
		}
		return sb.toString();
	}
	
	public static String getAddress(Cell cell) {
		StringBuilder sb = new StringBuilder();
		if(cell != null) {
			sb.append("[");
			sb.append(cell.getSheet().getSheetName());
			sb.append(":");
			sb.append(cell.getAddress().toString());
			sb.append("]");
		}
		return sb.toString();
	}
	
	public static String getAddress(String sheetName,int rowNum,int colNum) {
		StringBuilder sb = new StringBuilder();
		CellAddress address = new CellAddress(rowNum,colNum);
		sb.append("[");
		sb.append(sheetName);
		sb.append(":");
		sb.append(address.toString());
		sb.append("]");
		return sb.toString();
	}
	
	public static String getCellValue(Cell cell) {
		if(cell == null ) {
				return null;
		}
		String value = null;
		try {
			value = cell.getStringCellValue();
		}catch(Exception e) {
			value = String.valueOf(cell.getNumericCellValue());
		}
		return value;
	}
}
