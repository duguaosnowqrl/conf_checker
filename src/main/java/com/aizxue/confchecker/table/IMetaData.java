package com.aizxue.confchecker.table;

import java.util.Collection;

public interface IMetaData {
	public void addField(IField field);
	public IField getField(String name);
	public void setTable(ITable table);
	public ITable getTable();
	public Collection<IField> fields();
	public String getPrimaryKey();
	public void setPrimaryKey(String key);
}
