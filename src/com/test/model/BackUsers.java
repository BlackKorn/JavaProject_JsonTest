package com.test.model;

public class BackUsers {
	public String usersTable;
	public String getUsersTable() {
		return usersTable;
	}

	public void setUsersTable(String usersTable) {
		this.usersTable = usersTable;
	}

	public String getUsersPage() {
		return usersPage;
	}

	public void setUsersPage(String usersPage) {
		this.usersPage = usersPage;
	}

	public String usersPage;
	
	public BackUsers(String usersTable, String passWord){
		this.usersTable = usersTable;
		this.usersPage = usersPage;
	}
}
