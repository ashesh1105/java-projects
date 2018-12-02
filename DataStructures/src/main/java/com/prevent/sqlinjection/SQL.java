package com.prevent.sqlinjection;

public class SQL {
	public static void main(String[] args) {
		String userId, pwd = null;
		String sql = null;
		userId = "' OR ''='";
		pwd = "' OR ''='";
		sql = "Select * from USERS where name = '" + userId
				+ "' and password = '" + pwd + "'";
		System.out.println(sql);
	}
}
