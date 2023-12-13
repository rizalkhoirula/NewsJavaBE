package czimt.edu.cn.rka.servlet.apps;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import czimt.edu.cn.rka.entity.UserInfo;
import czimt.edu.cn.rka.json.JSONException;
import czimt.edu.cn.rka.json.JSONObject;
import czimt.edu.cn.rka.service.UserService;
import czimt.edu.cn.rka.service.impl.UserServiceImpl;

public class login extends HttpServlet {

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//修改编码
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		String userName= request.getParameter("userName");
		String password= request.getParameter("password");
		JSONObject jobject= new JSONObject();
		PrintWriter out = response.getWriter();
		String result="";
		String userId = "";
		String userRealName = "";
		UserService userservice = new UserServiceImpl();
		UserInfo user = new UserInfo();
		user.setUserLoginName(userName);
		user.setUserPassword(password);
		UserInfo UserLogined = userservice.UserLogin(user);
		if(UserLogined != null)
		{
			response.sendRedirect("../index.html");
	        return;
		}
		else{
			response.setContentType("text/html;charset=UTF-8");
		    out.println("<script>alert('Login failed. Please check your username and password.');</script>");
		    out.flush();
		    out.close();

		    // If login fails, continue to show login.html
		    RequestDispatcher dispatcher = request.getRequestDispatcher("../login.html");
		    dispatcher.forward(request, response);
	}
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

}
