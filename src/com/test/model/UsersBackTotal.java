package com.test.model;

import java.util.List;

public class UsersBackTotal {
	private List<Users> rows;
	private int pages;
	//构造函数
	public UsersBackTotal(int pages,List<Users> rows) {
		this.pages = pages;
		this.rows = rows;
	}

	public UsersBackTotal(List<Users> rows) {
		this.rows = rows;
	}
	
	//get、set方法
	public int getPages() {
		return pages;
	}

	public void setPages(int pages) {
		this.pages = pages;
	}



	public List<Users> getRows() {
		return rows;
	}

	public void setRows(List<Users> rows) {
		this.rows = rows;
	}
}
