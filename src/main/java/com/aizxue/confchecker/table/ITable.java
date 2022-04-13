package com.aizxue.confchecker.table;

import java.util.Collection;

public interface ITable {
	public String getName();
	public String getFilePath();
	public Collection<IRow> rows();
	public IRow getRowAt(int num);
	public IRow getRow(String id);
	public int  getRowCount();
	public void addRow(IRow row);
	public boolean isEmpty();
	public void setMetaData(IMetaData meta);
	public IMetaData getMetaData();
//	public Collection<IRow> findByFieldName(String fieldName,Object value);
}
