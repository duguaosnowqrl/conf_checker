package com.aizxue;

import java.sql.Connection;
import java.sql.DriverManager;

public class Test {
public static void main(String[] args) throws Exception {
	String url = "jdbc:sqlite:resources/test.db";
	Connection conn =  DriverManager.getConnection(url);
	System.out.println("连接OK");
	conn.close();
}
}
