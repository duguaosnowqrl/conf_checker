package com.aizxue.conftable;

public interface IContext {
	public void addTable(ITable table);
	public ITable  getTable(String name);
}
