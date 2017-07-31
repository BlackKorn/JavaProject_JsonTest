package com.test.utils;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DBCounter {
	String str = "select count(*) from ";
	public DBCounter(String tableName){
		str = str + tableName;
	}
	
	public int dbCount(){
		
		DBHelper dbHelper = new DBHelper("test");
		dbHelper.preparedStatement(str);
		ResultSet rs = dbHelper.executeQuery();
		try {
			rs.next();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int i = 0;
		try {
			i = rs.getInt(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return i;
	}
	
	
	
}
