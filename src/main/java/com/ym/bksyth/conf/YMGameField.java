package com.ym.bksyth.conf;

import com.aizxue.conftable.DefaultField;
import com.aizxue.conftable.IField;

public class YMGameField extends DefaultField{
	private String name;
	private String cname;
	private int type;
	private boolean client;
	private boolean server;
	private int index;

	public YMGameField(int index,String name,String cname,int type,boolean isClient,boolean isServer) {
		super(index,name,cname,type);
		this.client = isClient;
		this.server = isServer;
	}
	
	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public int getType() {
		return this.type;
	}

	public boolean isForClient() {
		return this.client;
	}

	public boolean isForServer() {
		return this.server;
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
