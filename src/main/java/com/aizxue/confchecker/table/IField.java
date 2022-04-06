package com.aizxue.confchecker.table;

public interface IField {
	public String getName();
	public Object getValue();
	public int getType();
	public IRow getRow();
	public void setRow(IRow row);
}
