package czimt.edu.cn.rka.servlet.apps;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import czimt.edu.cn.rka.entity.Bar;
import czimt.edu.cn.rka.entity.News;
import czimt.edu.cn.rka.json.JSONException;
import czimt.edu.cn.rka.json.JSONObject;
import czimt.edu.cn.rka.service.BarService;
import czimt.edu.cn.rka.service.NewsService;
import czimt.edu.cn.rka.service.impl.BarServiceImpl;
import czimt.edu.cn.rka.service.impl.NewsServiceImpl;

public class GetNewsListWithID extends HttpServlet {

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
	    String result="fail";
		NewsService newservice = new NewsServiceImpl();
		String newsID = request.getParameter("newid");
		News news = new News();
		news.setNewsID(newsID);
		List list = newservice.newsSelect(news);
		JSONObject jb = new JSONObject();
		if(list != null){
			result = "success";
		} else {
			result = "failed";
		}
		try {
			jb.put("msg", result);
			jb.put("news list", list);
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
