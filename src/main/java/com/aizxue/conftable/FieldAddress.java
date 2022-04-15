package com.aizxue.conftable;

public class FieldAddress {
	private String tableName;
	private int rowNum;
	private String fieldName;
	
	public FieldAddress(String tableName) {
		this(tableName,0,null);
	}
	
	public FieldAddress(String tableName, int rowNum) {
		this(tableName,rowNum,null);
	}

	public FieldAddress(String tableName, int rowNum, String fieldName) {
		this.tableName = tableName;
		this.rowNum = rowNum;
		this.fieldName = fieldName;
	}

	public FieldAddress(IRow row, String fieldName) {
		this(row.getTable().getName(), row.getRowNum(), fieldName);
	}
	
	public FieldAddress(IRow row) {
		this(row,null);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		if (this.tableName != null) {
			sb.append(this.tableName);
			if (this.rowNum > 0) {
				sb.append(",");
				sb.append(this.rowNum);
				if (this.fieldName != null) {
					sb.append(",");
					sb.append(this.fieldName);
				}
			}
		}
		sb.append("]");
		return sb.toString();
	}

	public String getTableName() {
		return tableName;
	}

	public int getRowNum() {
		return rowNum;
	}

	public String getFieldName() {
		return fieldName;
	}
}
