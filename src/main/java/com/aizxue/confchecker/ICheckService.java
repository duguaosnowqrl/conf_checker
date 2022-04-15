package com.aizxue.confchecker;

import com.aizxue.conftable.IContext;

public interface ICheckService {
	public void check(IContext context) throws Exception;
	public void check(IContext context,String tableName) throws Exception;
}
