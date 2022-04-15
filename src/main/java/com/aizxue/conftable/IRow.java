package com.aizxue.conftable;

public interface IRow {
	public ITable getTable();
	public void setTable(ITable table);
	public boolean hasField(String fieldName );
	public void setFieldValue(String fieldName,String value);
	public String getFieldValue(String fieldName);
	public String getId();
	public void setId(String id);
	public boolean isEmpty();
	public int getRowNum();
}
