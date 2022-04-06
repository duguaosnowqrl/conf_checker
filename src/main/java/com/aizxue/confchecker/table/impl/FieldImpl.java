package com.aizxue.confchecker.table.impl;

import com.aizxue.confchecker.table.IField;
import com.aizxue.confchecker.table.IRow;

public class FieldImpl implements IField{
	private String name;
	private Object value;
	private int type;
	private IRow row;

	public FieldImpl(String name,Object value,int type) {
		this.name = name;
		this.value = value;
		this.type = type;
	}
	
	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public Object getValue() {
		return this.value;
	}

	@Override
	public int getType() {
		return this.type;
	}

	@Override
	public IRow getRow() {
		return this.row;
	}

	@Override
	public void setRow(IRow row) {
		this.row = row;
	}
}
