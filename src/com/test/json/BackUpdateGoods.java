package com.test.json;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.utils.DBHelper;

@WebServlet("/BackUpdateGoods")
public class BackUpdateGoods extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BackUpdateGoods() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String goodsId  = request.getParameter("goodsId");
		
		String updateGoodsId = request.getParameter("updateGoodsId");
		String updateGoodsName = request.getParameter("updateGoodsName");
		String updateGoodsPrice = request.getParameter("updateGoodsPrice");
		String updateGoodsNumber = request.getParameter("updateGoodsNumber");
		String updateGoodsImgUrl = request.getParameter("updateGoodsImgUrl");
		String updateGoodsCatagory = request.getParameter("updateGoodsCatagory");
		
		//String addGoodsId = request.getParameter("addGoodsId");
		String addGoodsName = request.getParameter("addGoodsName");
		String addGoodsPrice = request.getParameter("addGoodsPrice");
		String addGoodsNumber = request.getParameter("addGoodsNumber");
		String addGoodsImgUrl = request.getParameter("addGoodsImgUrl");
		String addGoodsCatagory = request.getParameter("addGoodsCatagory");
		//修改商品
		if(updateGoodsId != null){
			String sql = "update goods set goods_name =?, goods_price =?, goods_number=?, goods_imgUrl=?, goods_catagory=? where goods_id =?;";
			DBHelper dbHelper = new DBHelper("test");
			dbHelper.preparedStatement(sql);
			dbHelper.setString(1, updateGoodsName);
			dbHelper.setString(2, updateGoodsPrice);
			dbHelper.setString(3, updateGoodsNumber);
			dbHelper.setString(4, updateGoodsImgUrl);
			dbHelper.setString(5, updateGoodsCatagory);
			dbHelper.setString(6, updateGoodsId);
			dbHelper.executeUpdate();
			dbHelper.close();
			response.sendRedirect("http://localhost:8080/JsonTest/GoodsManage.jsp");
		}
		//删除商品
		if( goodsId != null){
			//System.out.println(userName);
			String sql = "delete from goods where goods_id = ?";
			DBHelper dbHelper = new DBHelper("test");
			dbHelper.preparedStatement(sql);
			dbHelper.setString(1, goodsId);
			dbHelper.executeUpdate();
			dbHelper.close();
			response.sendRedirect("http://localhost:8080/JsonTest/GoodsManage.jsp");
		}
		//新增商品
		if(addGoodsName!=null){
			String sql = "insert into goods (goods_name, goods_price, goods_number, goods_imgUrl, goods_catagory)"
					+ " values (?,?,?,?,?);";
			DBHelper dbHelper = new DBHelper("test");
			dbHelper.preparedStatement(sql);
			dbHelper.setString(1, addGoodsName);
			dbHelper.setString(2, addGoodsPrice);
			dbHelper.setString(3, addGoodsNumber);
			dbHelper.setString(4, addGoodsImgUrl);
			dbHelper.setString(5, addGoodsCatagory);
			dbHelper.executeUpdate();
			dbHelper.close();
			response.sendRedirect("http://localhost:8080/JsonTest/GoodsManage.jsp");
		}
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
