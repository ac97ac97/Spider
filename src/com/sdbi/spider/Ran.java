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
 * @Description ������ִ������ķ���
 * @author Administrator
 *
 */
public class Ran {
	public static String crawl(String word, int x) throws IOException {
		// ���������ֻ�ܴ洢������������
		// ע������Ż�
		// ����һ�����ϣ�����һ�����ȡ��ڴ�����ʱ��������ݺܶ಻��������
		List<String> list = new ArrayList<String>(x+1);
		// ͨ��jsop��ȡ������Ҫ��������,Ȼ��Ѳ���д��
		Document doc = Jsoup.connect("https://www.baidu.com/s?wd=" + word + "&pn=" + x).get();
		// �����Doc�����л�ȡ������Ҫ������
		// ��һ�� ��ȡhead��ǩ,����һ���ڵ㣬����ڵ������ľ������ǵ�head��ǩ����������
		Elements select = doc.select("head");
		// �ڶ��� ��ȡdoc���еı�ҳ���������е����в�ѯ���
		for (int i = x + 1; i < (x + 11); i++) {
			// ÿ��ѭ������ȡһ��div
			Element id = doc.getElementById("" + i + "");
			// ���div������Ҫ�����ŵ�һ����������ȥ
			list.add(id.toString());
		}
		//������Ҫһ��·���������ǻ�ȡ�����ݳ־û���Ҳ������������ǵ�Ӳ�̵���
		String path ="D:/Users/Administrator/workspace/Spider/WebContent/jsp/baidu.html";
		//��ŵ����ǵ�file����
		File f=new File(path);
		//�ж�,������·�����ļ������ڣ���ô�ʹ���
		if (!f.exists()) {
			//��������
			f.createNewFile();
		}
		//д��
		Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(f),"utf-8"));	
		//��ͷ��ǩ������д��ȥ
		writer.write(select.toString());
		//����д��������
		PrintWriter out = new PrintWriter(writer);
		//divд����������ȥ��
		for (int i = 0; i < list.size(); i++) {
			//���ļ�����������
			out.println(list.get(i));
		}
		out.flush();
		writer.flush();
		out.close();
		writer.close();
		return path;
	}

}
