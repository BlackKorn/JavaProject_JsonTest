package com.test.model;

import java.util.List;

public class GoodsSingleResult {
	private List<GoodsSingle> result;
	//���췽��
	
	public GoodsSingleResult(List<GoodsSingle> result){
		this.result = result;
	}
	
	//get��set����
	public List<GoodsSingle> getResult() {
		return result;
	}

	public void setResult(List<GoodsSingle> result) {
		this.result = result;
	}
}
