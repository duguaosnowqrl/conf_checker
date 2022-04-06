package com.aizxue.confchecker.table.impl;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

import com.aizxue.confchecker.table.IRow;
import com.aizxue.confchecker.table.ITable;

public class TableImpl implements ITable{
	private String name;
	private int size;
	private String path;
	private Map<Integer,IRow> rowMap;
	
	
	public TableImpl(String path,String name) {
		this.path = path;
		this.name = name;
		this.rowMap = new LinkedHashMap<Integer,IRow>();
		this.size = 0;
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public String getFilePath() {
		return this.path;
	}

	@Override
	public Collection<IRow> rows() {
		return this.rowMap.values();
	}

	@Override
	public IRow getRowAt(int num) {
		return this.rowMap.get(num);
	}

	@Override
	public int getRowCount() {
		return this.size;
	}

	@Override
	public void addRow(IRow row) {
		row.setTable(this);
		int key = row.getRowNum();
		this.rowMap.put(key, row);
		this.size++;
	}

	@Override
	public boolean isEmpty() {
		return this.getRowCount() == 0;
	}
}
