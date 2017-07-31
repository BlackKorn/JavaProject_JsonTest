package com.test.model;

import java.util.List;

public class BackUsersTotal {
	public int getPages() {
		return pages;
	}

	public void setPages(int pages) {
		this.pages = pages;
	}

	private int pages;
	private List<BackUsers> rows; // 新闻列表

	public BackUsersTotal(int pages,List<BackUsers> rows) {
		this.pages = pages;
		this.rows = rows;
	}

	public List<BackUsers> getRows() {
		return rows;
	}

	public void setRows(List<BackUsers> rows) {
		this.rows = rows;
	}
}
