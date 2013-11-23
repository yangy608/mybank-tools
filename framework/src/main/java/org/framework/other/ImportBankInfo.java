package org.framework.other;

import java.io.File;
import java.util.Iterator;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

public class ImportBankInfo {

	public static void main(String[] args) throws Exception {

		SAXReader reader = new SAXReader();
		OutputFormat format = OutputFormat.createPrettyPrint();
		format.setEncoding("gb2312");// 设置XML文件的编码格式
		String filePath = "c:/IbpsBankCodeInfoConf12.xml";
		File file = new File(filePath);
		if (file.exists()) {
			Document document = reader.read(file);// 读取XML文件
			Element root = document.getRootElement();// 得到根节点
			for (Iterator<?> i = root.elementIterator("ibps"); i.hasNext();) {
				Element bank = (Element) i.next();
				for (Iterator<?> j = bank.elementIterator("ibpsName"); j.hasNext();) {
					Element bankDetail = (Element) j.next();
					String name = bankDetail.attributeValue("name");
					System.err.println(name);
				}
			}
		}
	}
}
