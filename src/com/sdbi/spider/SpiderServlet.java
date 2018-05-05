package com.sdbi.spider;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/SpiderServlet")
public class SpiderServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 设置请求的编码格式，以免通过请求过来的数据(参数)，发生乱码问题
		request.setCharacterEncoding("utf-8");
		// 接收的是我们从前台从传递过来的参数，搜索用的关键词
		String word = request.getParameter("word");
		// 我总共去查询多少条数据
		String num = request.getParameter("num");
		// 把num转一下，转成int类型
		int x = Integer.parseInt(num);
		String crawl = null;
		for (int i = 0; i < (x / 10); i++) {
			crawl = Ran.crawl(word, i * 10);
		}
		//返回他所在的位置
		int indexOf = crawl.indexOf("jsp");
		String substring = crawl.substring(indexOf);
		request.getRequestDispatcher("/"+substring).forward(request, response);
	}

}
