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
	    //�õ�����JSON ��ת��String
	    String strByJson = stringArr;

	    //Json�Ľ��������
	    JsonParser parser = new JsonParser();
	    //��JSON��String ת��һ��JsonArray����
	    JsonArray jsonArray = parser.parse(strByJson).getAsJsonArray();

	    Gson gson = new Gson();
	    ArrayList<orders> userBeanList = new ArrayList<>();

	    //��ǿforѭ������JsonArray
	    for (JsonElement user : jsonArray) {
	        //ʹ��GSON��ֱ��ת��Bean����
	        orders userBean = gson.fromJson(user, orders.class);
	        userBeanList.add(userBean);
	        //int userId = userBean.id;
	    }
	    
	    return userBeanList;
	    
	}
}
