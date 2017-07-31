package com.test.model;

import java.util.List;

public class GoodsSingleResult {
	private List<GoodsSingle> result;
	//构造方法
	
	public GoodsSingleResult(List<GoodsSingle> result){
		this.result = result;
	}
	
	//get、set方法
	public List<GoodsSingle> getResult() {
		return result;
	}

	public void setResult(List<GoodsSingle> result) {
		this.result = result;
	}
}
