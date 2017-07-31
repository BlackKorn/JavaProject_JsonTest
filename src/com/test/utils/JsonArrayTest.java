package com.test.utils;

import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.test.model.Users;
import com.test.model.orders;

public class JsonArrayTest {
	public ArrayList<orders> parseNoHeaderJArray(String stringArr) {
	    //拿到本地JSON 并转成String
	    String strByJson = stringArr;

	    //Json的解析类对象
	    JsonParser parser = new JsonParser();
	    //将JSON的String 转成一个JsonArray对象
	    JsonArray jsonArray = parser.parse(strByJson).getAsJsonArray();

	    Gson gson = new Gson();
	    ArrayList<orders> userBeanList = new ArrayList<>();

	    //加强for循环遍历JsonArray
	    for (JsonElement user : jsonArray) {
	        //使用GSON，直接转成Bean对象
	        orders userBean = gson.fromJson(user, orders.class);
	        userBeanList.add(userBean);
	        //int userId = userBean.id;
	    }
	    
	    return userBeanList;
	    
	}
}
