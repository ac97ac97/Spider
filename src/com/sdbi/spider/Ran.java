package com.sdbi.spider;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


/**
 * @Description 在这里执行爬虫的方法
 * @author Administrator
 *
 */
public class Ran {
	public static String crawl(String word, int x) throws IOException {
		// 让这个集合只能存储这种数据类型
		// 注意代码优化
		// 创建一个集合，给其一个长度。在创建的时候如果数据很多不会多次扩容
		List<String> list = new ArrayList<String>(x+1);
		// 通过jsop爬取我们想要爬的链接,然后把参数写上
		Document doc = Jsoup.connect("https://www.baidu.com/s?wd=" + word + "&pn=" + x).get();
		// 从这个Doc对象中获取我们想要的数据
		// 第一步 获取head标签,返回一个节点，这个节点里面存的就是我们的head标签的所有内容
		Elements select = doc.select("head");
		// 第二步 获取doc当中的本页面对象代码中的所有查询结果
		for (int i = x + 1; i < (x + 11); i++) {
			// 每次循环都获取一个div
			Element id = doc.getElementById("" + i + "");
			// 这个div我们先要把他放到一个容器里面去
			list.add(id.toString());
		}
		//我们需要一个路径，把我们获取的数据持久化，也就是输出到我们的硬盘当中
		String path ="D:/Users/Administrator/workspace/Spider/WebContent/jsp/baidu.html";
		//存放到我们的file类中
		File f=new File(path);
		//判断,如果这个路径下文件不存在，那么就创建
		if (!f.exists()) {
			//创建方法
			f.createNewFile();
		}
		//写入
		Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(f),"utf-8"));	
		//把头标签的内容写进去
		writer.write(select.toString());
		//继续写其他内容
		PrintWriter out = new PrintWriter(writer);
		//div写到集合里面去了
		for (int i = 0; i < list.size(); i++) {
			//向文件后面继续添加
			out.println(list.get(i));
		}
		out.flush();
		writer.flush();
		out.close();
		writer.close();
		return path;
	}

}
