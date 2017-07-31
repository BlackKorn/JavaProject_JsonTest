package com.test.json;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.utils.DBHelper;

@WebServlet("/BackDeleteUsers")
public class BackDeleteUsers extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public BackDeleteUsers() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName  = request.getParameter("userName");
		
		String userUpdateName = request.getParameter("userUpdateName");
		String userUpdatePassword = request.getParameter("userUpdatePassword");
		
		String userAddName = request.getParameter("userAddName");
		String userAddPassword = request.getParameter("userAddPassword");
		
		//System.out.println(userUpdateName);
		//System.out.println(userUpdatePassword);
		//修改用户
		if(userUpdateName != null){
			String sql = "update users set user_password =? where user_name =?;";
			DBHelper dbHelper = new DBHelper("test");
			dbHelper.preparedStatement(sql);
			dbHelper.setString(1, userUpdatePassword);
			dbHelper.setString(2, userUpdateName);
			dbHelper.executeUpdate();
			dbHelper.close();
			response.sendRedirect("http://localhost:8080/JsonTest/userManage.jsp");
		}
		//删除用户
		if(userName != null){
			//System.out.println(userName);
			String sql = "delete from users where user_name =?";
			DBHelper dbHelper = new DBHelper("test");
			dbHelper.preparedStatement(sql);
			dbHelper.setString(1, userName);
			dbHelper.executeUpdate();
			dbHelper.close();
			response.sendRedirect("http://localhost:8080/JsonTest/userManage.jsp");
		}
		//新增用户
		if(userAddName!=null && userAddPassword!= null){
			String sql = "insert into users values (?,?);";
			DBHelper dbHelper = new DBHelper("test");
			dbHelper.preparedStatement(sql);
			dbHelper.setString(1, userAddName);
			dbHelper.setString(2, userAddPassword);
			dbHelper.executeUpdate();
			dbHelper.close();
			response.sendRedirect("http://localhost:8080/JsonTest/userManage.jsp");
		}
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
