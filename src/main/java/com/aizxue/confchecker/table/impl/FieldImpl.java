package com.aizxue.confchecker.table.impl;

import com.aizxue.confchecker.table.IField;
import com.aizxue.confchecker.table.IRow;

public class FieldImpl implements IField{
	private String name;
	private String cname;
	private int type;
	private boolean client;
	private boolean server;
	private int index;

	public FieldImpl(int index,String name,String cname,int type,boolean isClient,boolean isServer) {
		this.name = name;
		this.cname = cname;
		this.type = type;
		this.client = isClient;
		this.server = isServer;
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
	public boolean isForClient() {
		return true;
	}

	@Override
	public boolean isForServer() {
		return true;
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
