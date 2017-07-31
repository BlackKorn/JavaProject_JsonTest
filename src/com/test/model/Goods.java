package com.test.model;

import java.util.List;

public class Goods {
	
	public String cate;
	public String id;
	public String banner;
	public List<GoodsSingle> detail;
	
	//构造函数
	
	public Goods(String cate, String id, String banner, List<GoodsSingle> detail){
		
		this.cate = cate;
		this.id = id;
		this.banner = banner;
		this.detail = detail;
		
	}
	
	//get、set方法
	public String getCate() {
		return cate;
	}
	public void setCate(String cate) {
		this.cate = cate;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getBanner() {
		return banner;
	}
	public void setBanner(String banner) {
		this.banner = banner;
	}

	
	public List<GoodsSingle> getDetail() {
		return detail;
	}
	public void setDetail(List<GoodsSingle> detail) {
		this.detail = detail;
	}
}
