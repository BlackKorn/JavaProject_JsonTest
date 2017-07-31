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

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.test.model.NewTotal;
import com.test.model.News;
import com.test.model.UserTotal;
import com.test.model.Users;

@WebServlet("/UserLoginServlet")
public class UserLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public UserLoginServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//��ȡ����
		String uName = request.getParameter("username");
		System.out.println(uName);
		//String uName = "tom";
		String uPassword = request.getParameter("password");
		String rePassword = null;
		List<Users> userList = new ArrayList<Users>();
		//�������ݿ�
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement pst = null;
		
		String sql = "select user_password from users where user_name =?";
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","root");
			pst = conn.prepareStatement(sql);
			pst.setString(1, uName);
	        rs = pst.executeQuery();
	        while (rs.next()){
	        	rePassword = rs.getString("user_password");
	        }
	        System.out.println("ִ�гɹ�������������");
		}catch (Exception e){
			e.printStackTrace();
		}finally{
			try {
				pst.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		//����User
		Users u1 = new Users(uName, rePassword);
		userList.add(u1);
		UserTotal ut = new UserTotal(userList.size(), userList);
		// ����GSON jar���߰���װ�õ�toJson��������ֱ������JSON�ַ���  
		Gson gson = new Gson();  
		String json = gson.toJson(ut);  
		  
		// ���������  
		//System.out.println(json);  
        response.setContentType("text/plain");  
		response.setCharacterEncoding("gb2312");  
		PrintWriter out = new PrintWriter(response.getOutputStream());  
		out.print(json);  
	    out.flush();  
		// ����Jsonת��ʹ���뿴JsonTest��  
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
