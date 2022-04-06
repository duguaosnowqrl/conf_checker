package com.aizxue.confchecker.table.impl.poi;

import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;

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
}
