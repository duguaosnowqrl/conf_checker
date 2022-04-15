package com.aizxue.conftable;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class DefaultRow implements IRow{
	private int num;
	private ITable table;
	private Map<String,String> valueMap; 
	private String id;
	
	public  DefaultRow() {
		this.valueMap = new HashMap<String, String>();
	}

	@Override
	public int getRowNum() {
		return this.num;
	}

	@Override
	public ITable getTable() {
		return this.table;
	}

	@Override
	public void setTable(ITable table) {
		this.table = table;
	}

	public void setRowNum(int num) {
		this.num = num;
	}

	@Override
	public boolean isEmpty() {
		return this.valueMap.size() == 0;
	}

	@Override
	public String getFieldValue(String fieldName) {
		return this.valueMap.get(fieldName);
	}

	@Override
	public boolean hasField(String fieldName) {
		if(this.getTable().getMetaData().getField(fieldName) == null) {
			return false;
		}
		return this.valueMap.containsKey(fieldName);
	}

	@Override
	public void setFieldValue(String fieldName, String value) {
		this.valueMap.put(fieldName, value);
	}

	@Override
	public String getId() {
		return this.id;
	}

	@Override
	public void setId(String id) {
		this.id = id;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("{");
		Set<Map.Entry<String,String>> values = this.valueMap.entrySet();
		for(Map.Entry<String,String> entry : values) {
			sb.append("\"");
			sb.append(entry.getKey());
			sb.append("\"");
			sb.append(":");
			sb.append("\"");
			sb.append(entry.getValue());
			sb.append("\"");
			sb.append(",");
		}
		if(values.size() > 0) {
			sb.setLength(sb.length() - 1);
		}
		sb.append("}");
		return sb.toString();
	}
}
