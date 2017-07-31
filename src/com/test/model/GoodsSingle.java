package com.test.model;

public class GoodsSingle {
	public String name;
	public String thumb;
	
	public int goodsId;
	public String goodsName;
	public int goodsPrice;
	public int goodsNumber;
	public String goodsImgUrl;
	public String goodsCatagory;
	
	//构造函数
	public GoodsSingle(String name, String thumb){
		this.name = name;
		this.thumb = thumb;
	}
	
	public GoodsSingle(int goodsId, String goodsName, int goodsPrice, int goodsNumber, String goodsImgUrl, String goodsCatagory){
		this.goodsId = goodsId;
		this.goodsName = goodsName;
		this.goodsPrice = goodsPrice;
		this.goodsNumber = goodsNumber;
		this.goodsImgUrl = goodsImgUrl;
		this.goodsCatagory = goodsCatagory;
	}
	
	//get、set方法
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getThumb() {
		return thumb;
	}
	public void setThumb(String thumb) {
		this.thumb = thumb;
	}
	public int getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(int goodsId) {
		this.goodsId = goodsId;
	}
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	public int getGoodsPrice() {
		return goodsPrice;
	}
	public void setGoodsPrice(int goodsPrice) {
		this.goodsPrice = goodsPrice;
	}
	public int getGoodsNumber() {
		return goodsNumber;
	}
	public void setGoodsNumber(int goodsNumber) {
		this.goodsNumber = goodsNumber;
	}
	public String getGoodsImgUrl() {
		return goodsImgUrl;
	}
	public void setGoodsImgUrl(String goodsImgUrl) {
		this.goodsImgUrl = goodsImgUrl;
	}
	public String getGoodsCatagory() {
		return goodsCatagory;
	}
	public void setGoodsCatagory(String goodsCatagory) {
		this.goodsCatagory = goodsCatagory;
	}
	
	
}
