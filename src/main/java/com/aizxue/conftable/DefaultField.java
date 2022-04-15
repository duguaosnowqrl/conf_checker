package com.aizxue.conftable;

import com.aizxue.conftable.IField;

public class DefaultField implements IField{
	private String name;
	private String cname;
	private int type;
	private int index;

	public DefaultField(int index,String name,String cname,int type) {
		this.name = name;
		this.cname = cname;
		this.type = type;
		this.index = index;
	}
	
	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public int getType() {
		return this.type;
	}

	@Override
	public String getCName() {
		return this.cname;
	}

	@Override
	public int getIndex() {
		return this.index;
	}
}
