package com.aizxue.confchecker.table;

import java.util.Map;

public interface IRow {
	public int getRowNum();
	public void setRowNum(int num);
	public Map<String,IField> fields();
	public IField getField(String name);
	public ITable getTable();
	public void setTable(ITable table);
	public void addField(IField field);
	public boolean isEmpty();
}
