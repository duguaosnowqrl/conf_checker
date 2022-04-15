package com.aizxue.conftable;


import java.util.HashMap;
import java.util.Map;

public class DefaultTableContext implements IContext{
	private Map<String,ITable> tables;
	
	public DefaultTableContext() {
		this.tables = new HashMap<String, ITable>();
	}

	@Override
	public void addTable(ITable table) {
		this.tables.put(table.getName(), table);
	}

	@Override
	public ITable getTable(String name) {
		return this.tables.get(name);
	}
	
}
