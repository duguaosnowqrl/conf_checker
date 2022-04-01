package com.aizxue.confchecker;

import java.io.File;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Test {
	public static void main(String[] args) throws Exception {
		File file = new File("E:\\jyzz\\designer\\配置表\\测试.xlsx");
		Workbook wb = WorkbookFactory.create(file);
//		int sheetsCount = wb.getNumberOfSheets();
//		for (int i = 0; i < sheetsCount; i++) {
//			Sheet sheet = wb.getSheetAt(i);
//			System.out.println(sheet.getSheetName());
//		}

		Sheet sheet = wb.getSheet("Sheet1");
		System.out.println(sheet.getFirstRowNum() +1);
		System.out.println(sheet.getLastRowNum() + 1);
		System.out.println(sheet.getPhysicalNumberOfRows());
//		System.out.println(sheet.getRow(0));
//		System.out.println(sheet.getRow(1).toString());
//		System.out.println(sheet.getRow(2).toString());
		System.out.println(sheet.getRow(3));
//		System.out.println(sheet.getRow(4));
//		System.out.println(sheet.getRow(5));
//		System.out.println(sheet.getRow(6));
//		System.out.println(sheet.getRow(7));
		Iterator<Row> iter = sheet.iterator();
		int count = 0;
		while (iter.hasNext()) {
			count++;
			Row row = iter.next();
			System.out.println(row.getRowNum() +1);
		}
		System.out.println("一共有：" + count);
//		System.out.println(sheet.getFirstRowNum());
//		System.out.println(sheet.getLastRowNum());
	}
	
	public static void printRow(Row row) {
	}
}
