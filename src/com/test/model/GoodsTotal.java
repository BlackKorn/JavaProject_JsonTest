package com.test.model;

import java.util.List;

public class GoodsTotal {
	private List<Goods> result;
	
	//���캯��
	public GoodsTotal(List<Goods> result){
		this.result = result;
	}
	
	//set��get����
	public List<Goods> getResult() {
		return result;
	}
	public void setResult(List<Goods> result) {
		this.result = result;
	}
} 
