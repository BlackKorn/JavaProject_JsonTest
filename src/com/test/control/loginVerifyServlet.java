package com.test.control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/loginVerifyServlet")
public class loginVerifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public loginVerifyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String adminName = request.getParameter("AdminName");
		String adminPassword = request.getParameter("AdminPassword");
		//System.out.println(adminName);
		//System.out.println(adminPassword);
		if("admin".equals(adminName) && "123".equals(adminPassword))
		{
			response.sendRedirect("/JsonTest/userManage.jsp");
		}else{
			response.sendRedirect("/JsonTest/index.jsp");
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
