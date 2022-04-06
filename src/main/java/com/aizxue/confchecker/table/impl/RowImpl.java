package com.aizxue.confchecker.table.impl;

import java.util.LinkedHashMap;
import java.util.Map;

import com.aizxue.confchecker.table.IField;
import com.aizxue.confchecker.table.IRow;
import com.aizxue.confchecker.table.ITable;

public class RowImpl implements IRow{
	private int num;
	private Map<String,IField> fieldsMap;
	private ITable table;
	
	public  RowImpl() {
		this.fieldsMap = new LinkedHashMap<String, IField>();
	}

	@Override
	public int getRowNum() {
		return this.num;
	}

	@Override
	public Map<String, IField> fields() {
		return this.fieldsMap;
	}

	@Override
	public IField getField(String name) {
		return this.fieldsMap.get(name);
	}

	@Override
	public ITable getTable() {
		return this.table;
	}

	@Override
	public void setTable(ITable table) {
		this.table = table;
	}

	@Override
	public void setRowNum(int num) {
		this.num = num;
	}

	@Override
	public void addField(IField field) {
		field.setRow(this);
		String key = field.getName();
		this.fieldsMap.put(field.getName(),field);
		
	}

	@Override
	public boolean isEmpty() {
		return this.fieldsMap.size() == 0;
	}
}
