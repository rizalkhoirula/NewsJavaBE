package czimt.edu.cn.rka.servlet.app;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import czimt.edu.cn.rka.entity.Bar;
import czimt.edu.cn.rka.entity.UserInfo;
import czimt.edu.cn.rka.json.JSONException;
import czimt.edu.cn.rka.json.JSONObject;
import czimt.edu.cn.rka.service.BarService;
import czimt.edu.cn.rka.service.UserService;
import czimt.edu.cn.rka.service.impl.BarServiceImpl;
import czimt.edu.cn.rka.service.impl.UserServiceImpl;

public class GetBarListWithID extends HttpServlet {

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

		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		String barid= request.getParameter("barid");
		String result="fail";
		BarService barservice = new BarServiceImpl();
		Bar bar2 = new Bar();
		bar2.setBarID(barid);
		Bar bar1 = barservice.barSelectbyid(bar2);
		JSONObject jb = new JSONObject();
		if(bar1 != null)
		{
			result ="successSelect";
			
		}else{
			result ="failSelect";
		}
		try {
			jb.put("msg", result);
			jb.put("barid",bar1.getBarID());
			jb.put("barname", bar1.getBarName());
			jb.put("creatorid", bar1.getCreateorID());
			jb.put("date", bar1.getCreateDate());
			jb.put("yxx", bar1.getYxx());
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PrintWriter out = response.getWriter();
		out.println(jb);
		out.flush();
		out.close();
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
