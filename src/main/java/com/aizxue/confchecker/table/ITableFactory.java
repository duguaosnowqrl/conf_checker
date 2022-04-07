package com.aizxue.confchecker.table;

public interface ITableFactory {
	public void createTable(IContext context,String path) throws Exception;
}
