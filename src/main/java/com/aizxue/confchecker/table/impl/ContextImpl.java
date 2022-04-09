package com.aizxue.confchecker.table.impl;

import java.util.HashMap;
import java.util.Map;

import com.aizxue.confchecker.table.IContext;
import com.aizxue.confchecker.table.ITable;

public class ContextImpl implements IContext{
	private Map<String,ITable> tables;
	
	public ContextImpl() {
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
