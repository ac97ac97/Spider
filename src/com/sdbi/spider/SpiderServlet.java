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
		// ��������ı����ʽ������ͨ���������������(����)��������������
		request.setCharacterEncoding("utf-8");
		// ���յ������Ǵ�ǰ̨�Ӵ��ݹ����Ĳ����������õĹؼ���
		String word = request.getParameter("word");
		// ���ܹ�ȥ��ѯ����������
		String num = request.getParameter("num");
		// ��numתһ�£�ת��int����
		int x = Integer.parseInt(num);
		String crawl = null;
		for (int i = 0; i < (x / 10); i++) {
			crawl = Ran.crawl(word, i * 10);
		}
		//���������ڵ�λ��
		int indexOf = crawl.indexOf("jsp");
		String substring = crawl.substring(indexOf);
		request.getRequestDispatcher("/"+substring).forward(request, response);
	}

}
