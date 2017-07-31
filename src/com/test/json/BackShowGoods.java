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
import com.test.model.UsersBackTotal;
import com.test.utils.DBCounter;
import com.test.utils.DBHelper;


@WebServlet("/BackShowGoods")
public class BackShowGoods extends HttpServlet {
	int pageSize = 3;
	int pageNow = 1;
	int pageCount = 0;//共有多少页
	int rowCount = 0;//共有多少条记录
	private static final long serialVersionUID = 1L;
       
    public BackShowGoods() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String str =new String();

		DBCounter dbCounter = new DBCounter("goods");
		rowCount = dbCounter.dbCount();
		pageCount = (rowCount-1)/pageSize +1;
		
		int i = 0;
		int[] goodsId = new int[pageSize]; 
		String[] goodsName = new String[pageSize];
		int[] goodsPrice = new int[pageSize];
		int[] goodsNumber = new int[pageSize];
		String[] goodsImgUrl = new String[pageSize];
		String[] goodsCatagory = new String[pageSize];
		
		//
		String tempPage = request.getParameter("pageNow");
		if (tempPage != null && tempPage !=""){
			if (Integer.valueOf(tempPage).intValue() == 0){
				if (pageNow == 1){
					pageNow = 1;
				}
				else{
					pageNow = pageNow - 1;
				}
			}
			else if (Integer.valueOf(tempPage).intValue() ==99){
				if (pageNow == pageCount){
					pageNow = pageNow;
				}
				else{
					pageNow = pageNow + 1;
				}
			}
			else{
				pageNow = Integer.valueOf(request.getParameter("pageNow")).intValue();
				}
			
		}
		
		String sql = "select * from goods limit " + (pageNow-1)*pageSize +"," +pageSize+";";
		System.out.println(sql);
		DBHelper dbHelper = new DBHelper("test");
		dbHelper.preparedStatement(sql);

		ResultSet rs = dbHelper.executeQuery();
		try {
			while(rs.next()){
				goodsId[i] =rs.getInt("goods_id");
				goodsName[i] = rs.getString("goods_name");
				goodsPrice[i] = rs.getInt("goods_price");
				goodsNumber[i] = rs.getInt("goods_number");
				goodsImgUrl[i] = rs.getString("goods_imgUrl");
				goodsCatagory[i] = rs.getString("goods_catagory");
				i++;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		dbHelper.close();
		
		List<GoodsSingle> goodsSinglelist = new ArrayList<GoodsSingle>();
		for (int k=0; k<pageSize; k++){
			goodsSinglelist.add(new GoodsSingle(goodsId[k], goodsName[k], goodsPrice[k], goodsNumber[k], goodsImgUrl[k], goodsCatagory[k]));
		}
		GoodsSingleResult gsr= new GoodsSingleResult(goodsSinglelist);
		Gson gson = new Gson();  
		String json = gson.toJson(gsr);  

		// 输出到界面  
		//System.out.println(json);
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
