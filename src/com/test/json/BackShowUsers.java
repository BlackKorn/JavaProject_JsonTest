package com.test.json;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.test.model.BackUsers;
import com.test.model.BackUsersTotal;
import com.test.model.NewTotal;
import com.test.model.News;
import com.test.model.Users;
import com.test.model.UsersBackTotal;
import com.test.utils.DBCounter;
import com.test.utils.DBHelper;

@WebServlet("/BackShowUsers")
public class BackShowUsers extends HttpServlet {
	int pageSize = 3;
	int pageNow = 1;
	int pageCount = 0;//共有多少页
	int rowCount = 0;//共有多少条记录
	private static final long serialVersionUID = 1L;

	public BackShowUsers() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String str =new String();

		DBCounter dbCounter = new DBCounter("users");
		rowCount = dbCounter.dbCount();
		pageCount = (rowCount-1)/pageSize +1;
		
		int i = 0;
		String[] UserNameArray = new String[pageSize]; 
		String[] UserPasswordArray = new String[pageSize];
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
		
		String sql = "select * from users limit " + (pageNow-1)*pageSize +"," +pageSize+";";
		//System.out.println(sql);
		DBHelper dbHelper = new DBHelper("test");
		dbHelper.preparedStatement(sql);

		ResultSet rs = dbHelper.executeQuery();
		try {
			while(rs.next()){
				UserNameArray[i] =rs.getString("user_name");
				UserPasswordArray[i] = rs.getString("user_password");
				i++;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		dbHelper.close();
		
		List<Users> userslist = new ArrayList<Users>();
		for (int k=0; k<pageSize; k++){
			userslist.add(new Users(UserNameArray[k], UserPasswordArray[k]));
		}
		UsersBackTotal ubt = new UsersBackTotal(pageCount, userslist);
		Gson gson = new Gson();  
		String json = gson.toJson(ubt);  

		// 输出到界面  
		System.out.println(json);
		response.setContentType("text/plain");  
		response.setCharacterEncoding("gb2312");  
		PrintWriter out = new PrintWriter(response.getOutputStream());  
		out.print(json);  
		out.flush(); 
 

	}

	

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
