package com.aizxue.confchecker.table;

import java.util.Collection;

public interface ITable {
	public String getName();
	public String getFilePath();
	public Collection<IRow> rows();
	public IRow getRowAt(int num);
	public int  getRowCount();
	public void addRow(IRow row);
	public boolean isEmpty();
}
