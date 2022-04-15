package com.aizxue.conftable;

public interface IField {
	public static final int TYPE_STR = 1;
	public static final int TYPE_MARK = 2;
	public static final int TYPE_INT = 3;
	public static final int TYPE_FLOAT = 4;
	public static final int TYPE_INTARR = 5;
	public static final int TYPE_ARRARR = 6;
	
	
	public String getName();
	public String getCName();
	public int getType();
	public int getIndex();
}
