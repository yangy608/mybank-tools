package org.framework.common2;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;

/**
 * @class       XmlUtil
 * @description XML工具类
 * @author      YY
 * @version     1.0
 * @date	    2011-10-31/上午09:45:16
 */
public class XmlUtil {
	protected Element elapp = null;
	protected Document doc = null;
	protected String filename = null;
	public XmlUtil(String _filename) throws Exception {
		try {

			filename = _filename;
			SAXBuilder builder = new SAXBuilder();

			//doc = builder.build(new File(filename));
			doc =
				builder.build(
					Thread
						.currentThread()
						.getContextClassLoader()
						.getResourceAsStream(
						filename));
			elapp = doc.getRootElement();
		} catch (Exception ex) {	
			throw new Exception("Xml00002", ex);
		}
	}

	public XmlUtil(String _filename, String local) throws Exception {
		try {
			filename = _filename;
			SAXBuilder builder = new SAXBuilder();
			doc = builder.build(new File(filename));
			elapp = doc.getRootElement();
		} catch (Exception ex) {
			throw new Exception("Xml00002", ex);
		}
	}

	/**
	 * 读配置文件
	 * @param sysname
	 * @return String[]
	 */
	public String[] getValue(String sysname) {
		//sysname = sysname.toLowerCase();
		List lvalue = elapp.getChild(sysname).getChildren();
		String[] value = new String[lvalue.size()];
		for (int i = 0; i < lvalue.size(); i++) {
			Element book = (Element) lvalue.get(i);
			value[i] = book.getName();
		}
		return value;
	}
	/**
	 * 读配置文件
	 * @param sysname
	 * @return String[]
	 */
	public String[] getValues(String sysname, String name) {
		//sysname = sysname.toLowerCase();
		List lvalue = elapp.getChild(sysname).getChild(name).getChildren();
		String[] value = new String[lvalue.size()];
		for (int i = 0; i < lvalue.size(); i++) {
			Element book = (Element) lvalue.get(i);
			value[i] = book.getTextTrim();
		}
		return value;
	}

	/**
	 * 读配置文件
	 * @param sysname
	 * @param name
	 * @return
	 */
	public String getValue(String sysname, String name) {
		if( elapp.getChild(sysname).getChild(name) == null ){
			return null ;
		}
		 
		String value = elapp.getChild(sysname).getChild(name).getText();
		return value;
	}

	/**
	 * 读配置文件
	 * @param sysname
	 * @param chdname
	 * @param name
	 * @return
	 */
	public String getValue(String sysname, String chdname, String name) {
		if( elapp.getChild(sysname).getChild(chdname).getChild(name) == null ){
			return null ;
		}
		if (name == null || name.length() == 0) {
			name = "default";
		}
		String value =
			elapp.getChild(sysname).getChild(chdname).getChild(name).getText();
		return value;
	}

	   /**
		* 读配置文件
		* @param sysname
		* @param chdname
		* @param name
		* @return
		*/
	public String getValue(String name[]) {
		String value = "";
		Element el = null;
		for (int i = 0; i < name.length; i++) {
			el = elapp.getChild(name[i]);
		}
		value = el.getText();
		return value;
	}

	/**
	 * 修改配置文件
	 * @param sysname
	 * @param name
	 * @param value
	 * @throws Exception
	 */
	public void setValue(String sysname, String name, String value)
		throws Exception {
		//sysname = sysname.toLowerCase();
		//name = name.toLowerCase();
		try {
			elapp.getChild(sysname).getChild(name).setText(value);
			XMLOutputter fmt = new XMLOutputter();
			FileWriter fwXML = new FileWriter(filename);
			fmt.output(doc, fwXML);
			fwXML.close();
		} catch (Exception ex) {
			throw new Exception("Xml00003", ex);
		}
	}

	/**
	 * 修改配置文件
	 * @param sysname
	 * @param chdname
	 * @param name
	 * @param value
	 * @throws Exception
	 */
	public void setValue(
		String sysname,
		String chdname,
		String name,
		String value)
		throws Exception {
		//sysname = sysname.toLowerCase();
		//name = name.toLowerCase();
		try {
			elapp.getChild(sysname).getChild(chdname).getChild(name).setText(
				value);
			XMLOutputter fmt = new XMLOutputter();
			FileWriter fwXML = new FileWriter(filename);
			fmt.output(doc, fwXML);
			fwXML.close();
		} catch (Exception ex) {
			throw new Exception("Xml00003", ex);
		}
	}

	/**
	 * 得到多条值
	 * @param sysname
	 * @param name
	 * @param valuename
	 * @return
	 * @throws Exception
	 */
	public ArrayList getValueList(
		String sysname,
		String name,
		String[] valuename)
		throws Exception {
		ArrayList alvalue = new ArrayList();
		try {
			//sysname = sysname.toLowerCase();
			//name = name.toLowerCase();
			List lvalue = elapp.getChild(sysname).getChildren(name);
			for (int i = 0; i < lvalue.size(); i++) {
				Element book = (Element) lvalue.get(i);
				String[] value = new String[valuename.length];
				for (int j = 0; j < valuename.length; j++) {
					value[j] = book.getChild(valuename[j]).getText();
				}
				alvalue.add(value);
			}
			return alvalue;
		} catch (Exception ex) {

			throw new Exception("Xml00002", ex);
		}
	}

	public ArrayList getNameList(String sysname) throws Exception {
		ArrayList alvalue = new ArrayList();
		try {
			//sysname = sysname.toLowerCase();
			Element book1 = elapp.getChild(sysname);
			List lvalue = book1.getChildren();
			for (int i = 0; i < lvalue.size(); i++) {
				Element book = (Element) lvalue.get(i);
				alvalue.add(book.getName());
			}
			return alvalue;
		} catch (Exception ex) {
			throw new Exception("Xml00002", ex);
		}
	}

	public static String buildXmlString(String _title, String _content)
		throws Exception {
		Element eRoot, eTitle, eContent;
		Document document;
		String xmlStr = "";
		try {
			eRoot = new Element("application");
			document = new Document(eRoot);
			eRoot = document.getRootElement();
			eTitle = new Element("title");
			eTitle.addContent(_title);
			eContent = new Element("content");
			eContent.addContent(_content);
			eRoot.addContent(eTitle);
			eRoot.addContent(eContent);
			XMLOutputter XMLOut = new XMLOutputter();
			Format format = XMLOut.getFormat();
			format.setEncoding("UTF-8");
			format.setIndent("  ");
			format.setLineSeparator("\r\n");
			XMLOut.setFormat(format);
			xmlStr = XMLOut.outputString(document);
		} catch (Exception ex) {

			throw new Exception("Xml00003", ex);
		}
		return xmlStr;
	}

	public ArrayList getValueListIndex(
		String sysname,
		String name,
		String[] attrname)
		throws Exception {
		ArrayList alvalue = new ArrayList();
		try {
			List lvalue = elapp.getChildren(sysname);
			for (int i = 0; i < lvalue.size(); i++) {
				Properties pvalue = new Properties();
				Element book = (Element) lvalue.get(i);
				String typename = book.getAttributeValue(attrname[0]);
				String col_id = book.getAttributeValue(attrname[1]);
				String doc_id = book.getAttributeValue(attrname[2]);
				String title = book.getAttributeValue(attrname[3]);
				String query = book.getAttributeValue(attrname[4]);
				System.out.println(i + ":" + typename);
				pvalue.put("typename", typename);
				pvalue.put("col_id", col_id);
				pvalue.put("doc_id", doc_id);
				pvalue.put("title", title);
				pvalue.put("query", query);
				List _lvalue = book.getChildren(name);
				String[] _value = new String[_lvalue.size()];
				for (int j = 0; j < _lvalue.size(); j++) {
					Element _book = (Element) _lvalue.get(j);
					_value[j] = _book.getText();
				}
				pvalue.put("attribute", _value);

				ArrayList alcvalue = new ArrayList();
				List lcvalue = book.getChildren("child");
				for (int k = 0; k < lcvalue.size(); k++) {
					Properties pcvalue = new Properties();
					Element cbook = (Element) lcvalue.get(k);
					String childname = cbook.getAttributeValue("name");
					pcvalue.put("childname", childname);

					List _lcvalue = cbook.getChildren(name);
					String[] _cvalue = new String[_lcvalue.size()];

					for (int l = 0; l < _lcvalue.size(); l++) {
						Element _cbook = (Element) _lcvalue.get(l);
						_cvalue[l] = _cbook.getText();
					}
					System.out.println(childname);
					pcvalue.put("child_arrtibute", _cvalue);
					alcvalue.add(pcvalue);
				}
				pvalue.put("child", alcvalue);
				alvalue.add(pvalue);
			}
			return alvalue;
		} catch (Exception ex) {

			throw new Exception("Xml00002", ex);
		}
	}

	public static void main(String[] args) {
		try {

		} catch (Exception e) {

		}

	}
	//取得某模块配置的字典类别
	public ArrayList getSeletClass(String moudle) {
		ArrayList classify = new ArrayList();
		Map map = null;
		try {
			List list = (elapp.getChild(moudle)).getChildren();
			for (Iterator it = list.iterator(); it.hasNext();) {
				map = new HashMap();
				Element child = (Element) it.next();
				classify.add((String) child.getAttributeValue("id"));
			}
		} catch (Exception ex) {

		}
		return classify;
	}
	public ArrayList getSeletClass() {
		ArrayList classify = new ArrayList();
		Map map = null;
		try {
			List list = elapp.getChildren();
			for (Iterator it = list.iterator(); it.hasNext();) {
				map = new HashMap();
				Element child = (Element) it.next();
				classify.add((String) child.getAttributeValue("id"));
			}
		} catch (Exception ex) {

		}
		return classify;
	}

	public ArrayList getItemClassify(String moudle, String classify) {
		ArrayList items = new ArrayList();
		Map map = null;
		try {
			List list = (elapp.getChild(moudle)).getChildren();
			for (Iterator it = list.iterator(); it.hasNext();) {
				map = new HashMap();
				Element child = (Element) it.next();
				if (classify.equals((String) child.getAttributeValue("id"))) {
					List list1 = child.getChildren();
					for (Iterator itr = list1.iterator(); itr.hasNext();) {
						Element child1 = (Element) itr.next();
						items.add(child1.getValue());
					}
					break;
				}
			}
		} catch (Exception e) {

		}
		return items;
	}
	public ArrayList getItemClassify(String classify) {
		ArrayList items = new ArrayList();
		Map map = null;
		try {
			List list = elapp.getChildren();
			for (Iterator it = list.iterator(); it.hasNext();) {
				map = new HashMap();
				Element child = (Element) it.next();
				if (classify.equals((String) child.getAttributeValue("id"))) {
					List list1 = child.getChildren();
					for (Iterator itr = list1.iterator(); itr.hasNext();) {
						Element child1 = (Element) itr.next();
						items.add(child1.getValue());
					}
					break;
				}
			}
		} catch (Exception e) {

		}
		return items;
	}
}
