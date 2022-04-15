package com.aizxue.confchecker;

import java.io.File;

import com.aizxue.conftable.DefaultTableContext;
import com.aizxue.conftable.IContext;
import com.aizxue.conftable.ITable;
import com.aizxue.conftable.ITableFactory;
import com.ym.bksyth.conf.YMGameXlsxConfFactory;

public class Test {
	public static void main(String[] args) throws Exception {
		String path = "E:\\jyzz\\designer\\配置表\\h伙伴相关.xlsx";
		File file = new File(path);
		ITableFactory factory = new YMGameXlsxConfFactory();
		IContext context = new DefaultTableContext();
		factory.createTable(context, path);
		ITable table = context.getTable("Hero");
		System.out.println(table.toString());
//		Workbook wb = WorkbookFactory.create(file);
////		int sheetsCount = wb.getNumberOfSheets();
////		for (int i = 0; i < sheetsCount; i++) {
////			Sheet sheet = wb.getSheetAt(i);
////			System.out.println(sheet.getSheetName());
////		}
//
//		Sheet sheet = wb.getSheet("HeroLevel");
////		System.out.println(sheet.getFirstRowNum() +1);
////		System.out.println(sheet.getLastRowNum() + 1);
////		System.out.println(sheet.getPhysicalNumberOfRows());
////		System.out.println(sheet.getRow(0));
////		System.out.println(sheet.getRow(1).toString());
////		System.out.println(sheet.getRow(2).toString());
////		System.out.println(sheet.getRow(3));
////		System.out.println(sheet.getRow(4));
////		System.out.println(sheet.getRow(5));
////		System.out.println(sheet.getRow(6));
////		System.out.println(sheet.getRow(7));
//		Iterator<Row> iter = sheet.iterator();
//		int count = 0;
//		while (iter.hasNext()) {
//			count++;
//			Row row = iter.next();
//			System.out.println(row.getFirstCellNum());
//			System.out.println(row.getLastCellNum());
//			System.out.println(row.getCell(5).getStringCellValue());
//			break;
//		}
//		System.out.println("一共有：" + count);
////		System.out.println(sheet.getFirstRowNum());
////		System.out.println(sheet.getLastRowNum());
	}
	
}
