package com.test.json;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.test.model.GoodsSingle;
import com.test.model.GoodsSingleResult;
import com.test.model.Users;
import com.test.utils.DBHelper;

@WebServlet("/WxGoodsSearch")
public class WxGoodsSearch extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public WxGoodsSearch() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//String goodsName = request.getParameter("goodsName");
		String goodsName = "apple";
		int goodsId = 0;
		int goodsPrice = 0;
		int goodsNumber = 0;
		String goodsImgUrl = "";
		String goodsCatagory = "";
		//
		if(goodsName != null){
			String sql = "select * from goods where goods_name=?;";
			DBHelper dbHelper = new DBHelper("test");
			dbHelper.preparedStatement(sql);
			dbHelper.setString(1, goodsName);
			ResultSet rs = dbHelper.executeQuery();
			try {
				if(rs.next()){
					goodsId = rs.getInt("goods_id");
					goodsPrice =rs.getInt("goods_price");
					goodsNumber = rs.getInt("goods_number");
					goodsImgUrl = rs.getString("goods_imgUrl");
					goodsCatagory = rs.getString("goods_catagory");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			dbHelper.close();
			//建立单个商品对象
			GoodsSingle gs = new GoodsSingle(goodsId, goodsName, goodsPrice, goodsNumber, goodsImgUrl, goodsCatagory);
			//将单个商品加入列表
			List<GoodsSingle> goodsSinglelist = new ArrayList<GoodsSingle>();
			goodsSinglelist.add(gs);
			//将列表 加入 ‘商品列表待转换json类’中
			GoodsSingleResult gse = new GoodsSingleResult(goodsSinglelist);
			//转化成json格式
			Gson gson = new Gson();  
			String json = gson.toJson(gse);  

			// 输出到界面  
			System.out.println(json);  
			response.setContentType("text/plain");  
			response.setCharacterEncoding("gb2312");  
			PrintWriter out = new PrintWriter(response.getOutputStream());  
			out.print(json);  
			out.flush(); 
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
