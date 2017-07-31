package com.test.json;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.test.model.Goods;
import com.test.model.GoodsSingle;
import com.test.model.GoodsTotal;
import com.test.model.Users;

@WebServlet("/WxPageCatagroy")
public class WxPageCatagroy extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public WxPageCatagroy() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		GoodsSingle gs1 = new GoodsSingle("���� 500g","/image/c2.png");
		GoodsSingle gs2 = new GoodsSingle("����� 3��","/image/c4.png");
		GoodsSingle gs3 = new GoodsSingle("�滨���� 2��","/image/c3.png");
		GoodsSingle gs4 = new GoodsSingle("���� 500g","/image/c2.png");
		GoodsSingle gs5 = new GoodsSingle("����� 3��","/image/c4.png");
		GoodsSingle gs6 = new GoodsSingle("�滨���� 2��","/image/c3.png");
		
		List<GoodsSingle> goodsSinglelist1 = new ArrayList<GoodsSingle>();
		goodsSinglelist1.add(gs1);
		goodsSinglelist1.add(gs2);
		goodsSinglelist1.add(gs3);
		goodsSinglelist1.add(gs4);
		goodsSinglelist1.add(gs5);
		goodsSinglelist1.add(gs6);
		
		Goods gd1 = new Goods("��ζ" ,"guowei", "/image/c1.png", goodsSinglelist1);
		Goods gd2 = new Goods("�߲�" ,"shucai", "/image/c1.png", goodsSinglelist1);
		Goods gd3 = new Goods("����" ,"chaohuo", "/image/c1.png", goodsSinglelist1);
		Goods gd4 = new Goods("����" ,"dianxin", "/image/c1.png", goodsSinglelist1);
		Goods gd5 = new Goods("�ֲ�" ,"cucha", "/image/c1.png", goodsSinglelist1);
		Goods gd6 = new Goods("����" ,"danfan", "/image/c1.png", goodsSinglelist1);
		
		List<Goods> goodsList = new ArrayList<Goods>();
		goodsList.add(gd1);
		goodsList.add(gd2);
		goodsList.add(gd3);
		goodsList.add(gd4);
		goodsList.add(gd5);
		goodsList.add(gd6);
		
		GoodsTotal gt = new GoodsTotal(goodsList);
		Gson gson = new Gson();  
		String json = gson.toJson(gt);  

		// ���������  
		System.out.println(json);
		response.setContentType("text/plain");  
		response.setCharacterEncoding("gb2312");  
		PrintWriter out = new PrintWriter(response.getOutputStream());  
		out.print(json);  
		out.flush(); 
		
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
