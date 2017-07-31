package com.test.json;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.test.utils.DBHelper;

@WebServlet("/WxOrdersManage")
public class WxOrdersManage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public WxOrdersManage() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String wxOrders = request.getParameter("orders");
		String totalPrice = request.getParameter("totalprice");
		String yonghu = request.getParameter("yonghu");
		String orderDetail = "";
		//
		JsonArray jsonArray = new JsonParser().parse(wxOrders).getAsJsonArray();
		for(JsonElement element : jsonArray){
			 JsonObject jsonObject = element.getAsJsonObject();
			 orderDetail = orderDetail + jsonObject.get("title").getAsString()+"-"+jsonObject.get("num").getAsString()+" ";
			 
		}
		//≤Â»Î ˝æ›
		if (wxOrders != null){
			yonghu = "cbbs";
			String sql = "insert into orders (orders_user, orders_detail, orders_total) values (?,?,?);";
			DBHelper dbHelper = new DBHelper("test");
			dbHelper.preparedStatement(sql);
			dbHelper.setString(1, yonghu);
			dbHelper.setString(2, orderDetail);
			dbHelper.setString(3, totalPrice);
			dbHelper.executeUpdate();
			dbHelper.close();
		}
		System.out.println(orderDetail);
		System.out.println(totalPrice);
		System.out.println(yonghu);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
