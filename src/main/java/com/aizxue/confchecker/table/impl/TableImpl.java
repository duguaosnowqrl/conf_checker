package com.aizxue.confchecker.table.impl;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

import com.aizxue.confchecker.table.IMetaData;
import com.aizxue.confchecker.table.IRow;
import com.aizxue.confchecker.table.ITable;

public class TableImpl implements ITable{
	private String name;
	private int size;
	private String path;
	private Map<Integer,IRow> indexToRows;
	private Map<String,IRow> idToRows;
	private IMetaData metaData;
	
	
	public TableImpl(String path,String name) {
		this.path = path;
		this.name = name;
		this.indexToRows = new LinkedHashMap<Integer,IRow>();
		this.idToRows = new LinkedHashMap<String, IRow>();
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
		return this.indexToRows.values();
	}

	@Override
	public IRow getRowAt(int num) {
		return this.indexToRows.get(num);
	}

	@Override
	public int getRowCount() {
		return this.size;
	}

	@Override
	public void addRow(IRow row) {
		row.setTable(this);
		this.indexToRows.put(row.getRowNum(), row);
		this.idToRows.put(row.getId(), row);
		this.size++;
	}

	@Override
	public boolean isEmpty() {
		return this.getRowCount() == 0;
	}

	@Override
	public void setMetaData(IMetaData meta) {
		this.metaData = meta;
	}

	@Override
	public IMetaData getMetaData() {
		return this.metaData;
	}

	@Override
	public IRow getRow(String id) {
		return this.idToRows.get(id);
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(this.getName());
		sb.append("={");
		if(this.getRowCount() > 0) {
			sb.append("\n");
		}
		for(IRow row : this.rows()) {
			sb.append("\"");
			sb.append(row.getId());
			sb.append("\"");
			sb.append(":");
			sb.append(row.toString());
			sb.append(",");
			sb.append("\n");
		}
		if(this.getRowCount() > 0) {
			sb.setLength(sb.length() - 2);
			sb.append("\n");
		}
		sb.append("}");
		return sb.toString();
	}
}
