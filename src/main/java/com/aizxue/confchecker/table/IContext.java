package com.aizxue.confchecker.table;

public interface IContext {
	public void addTable(ITable table);
	public ITable  getTable(String name);
}
