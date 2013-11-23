package org.framework.getEntity;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.framework.dadabase.ConnectionManager;


public class GenEntityTool {

	private String username  = "YY";      		 //package XXX;
	private String packname  = "getEntity";      //package XXX;
	private String packpath  = "E:\\360云盘\\源码\\AAA_YY\\framework\\src\\main\\java\\getEntity";//需要生成到的绝对路径
	private String[] colnames; // 列名数组
	private String[] colTypes; // 列名类型数组
	private int[]    colSizes; // 列名大小数组
	private boolean f_util = false; // 是否需要导入包java.util.*
	private boolean f_sql  = false; // 是否需要导入包java.sql.*

	public GenEntityTool() {

		// 得到数据库连接
		Connection conn = null;

		try {
			
			conn = ConnectionManager.getInstance().getConnection();

			// 查询所有的表名
			String tblsql = "show tables";
			Statement tblst = conn.createStatement();
			ResultSet tblrs = tblst.executeQuery(tblsql);
			
			PreparedStatement prst = null;
			ResultSetMetaData rset = null;
			
			//循环每个
			while (tblrs.next()) {
				String tblname = tblrs.getString(1);    // 真实表名
				String entityname = getTblName(tblname);// 要生成的java文件名

				//查询表的信息
				String strsql = "select * from " + tblname;
				prst = conn.prepareStatement(strsql);
				rset = prst.getMetaData();
				
				int size = rset.getColumnCount(); // 共有多少列
				colnames = new String[size];
				colTypes = new String[size];
				colSizes = new int[size];
				for (int i = 0; i < rset.getColumnCount(); i++) {
					colnames[i] = getColName(rset.getColumnName(i + 1));
					colTypes[i] = rset.getColumnTypeName(i + 1);

					if (colTypes[i].equalsIgnoreCase("time") ||colTypes[i].equalsIgnoreCase("datetime") || colTypes[i].equalsIgnoreCase("date") || colTypes[i].equalsIgnoreCase("timestamp")) {
						f_util = true;
					}
					if (colTypes[i].equalsIgnoreCase("image") || colTypes[i].equalsIgnoreCase("text")) {
						f_sql = true;
					}
					colSizes[i] = rset.getColumnDisplaySize(i + 1);
				}
				
				//生成实体内容
				String content = parse(colnames, colTypes, colSizes,entityname);
				try {
					
					//生成java文件
					System.out.println("开始生成"+packpath+"\\"+entityname + ".java");
					FileWriter fw = new FileWriter(packpath+"\\"+entityname + ".java");
					PrintWriter pw = new PrintWriter(fw);
					pw.println(content);
					pw.flush();
					pw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
				

			
			}
			System.out.println("生成完毕......");
			prst.close();
			tblrs.close();
			tblst.close();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionManager.closeConnection(conn);
		}
	}

	/**
	 * 解析处理(生成实体类主体代码)
	 */
	private String parse(String[] colNames, String[] colTypes, int[] colSizes,String tblname) {
		StringBuffer sb = new StringBuffer();
		sb.append("package "+packname+";\r\n\r\n");
		if (f_util) {
			sb.append("import java.util.Date;\r\n\r\n");
		}
		if (f_sql) {
			sb.append("import java.sql.*;\r\n\r\n\r\n");
		}
		sb.append("/**\r\n");
		sb.append(" * @ClassName:  AaaaVvvSss\r\n");
		sb.append(" * @Description:工具自动生成的实体类\r\n");
		sb.append(" * @author "+username+"\r\n");
		sb.append(" * @date   "+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())+"\r\n");
		sb.append(" */\r\n");
		
		sb.append("public class " + tblname + " {\r\n\r\n");
		processAllAttrs(sb);
		sb.append("\r\n");
		processAllMethod(sb);
		sb.append("}\r\n");
		return sb.toString();

	}

	/**
	 * 生成所有的方法
	 * 
	 * @param sb
	 */
	private void processAllMethod(StringBuffer sb) {
		for (int i = 0; i < colnames.length; i++) {
			sb.append("\tpublic void set" + initcap(colnames[i]) + "(" + sqlType2JavaType(colTypes[i]) + " " + colnames[i] + "){\r\n");
			sb.append("\t\tthis." + colnames[i] + "=" + colnames[i] + ";\r\n");
			sb.append("\t}\r\n");

			sb.append("\tpublic " + sqlType2JavaType(colTypes[i]) + " get" + initcap(colnames[i]) + "(){\r\n");
			sb.append("\t\treturn " + colnames[i] + ";\r\n");
			sb.append("\t}\r\n");
		}
	}

	/**
	 * 解析输出属性
	 * 
	 * @return
	 */
	private void processAllAttrs(StringBuffer sb) {
		for (int i = 0; i < colnames.length; i++) {
			sb.append("\tprivate " + sqlType2JavaType(colTypes[i]) + " " + colnames[i] + ";\r\n");

		}
	}


	/**
	 * 获取类名和字段名
	 * 
	 * @return
	 */
	private String getTblName(String tblname) {
		char[] chr = tblname.toCharArray();
		int locat = 0;
		for (int i = 0; i < chr.length; i++) {
			if (i == 0) {
				chr[i] = Character.toUpperCase(chr[i]);
			} else {
				chr[i] = Character.toLowerCase(chr[i]);
			}
			if (chr[i] == '_') {
				locat = i + 1;
			}
			if (locat == i) {
				chr[i] = Character.toUpperCase(chr[i]);
				locat = 0;
			}
		}
		return String.valueOf(chr).replace("_", "");
	}
	
	
	/**
	 * 获取类名和字段名
	 * 
	 * @return
	 */
	private String getColName(String tblname) {
		char[] chr = tblname.toCharArray();
		int locat = 0;
		for (int i = 0; i < chr.length; i++) {

			chr[i] = Character.toLowerCase(chr[i]);
			if (chr[i] == '_') {
				locat = i + 1;
			}
			if (locat == i && locat!=0) {
				chr[i] = Character.toUpperCase(chr[i]);
				locat = 0;
			}
		}
		return String.valueOf(chr);
	}

	/**
	 * 把输入字符串的首字母改成大写
	 * 
	 * @param str
	 * @return
	 */
	private String initcap(String str) {
		char[] ch = str.toCharArray();
		if (ch[0] >= 'a' && ch[0] <= 'z') {
			ch[0] = (char) (ch[0] - 32);
		}
		return new String(ch);
	}

	private String sqlType2JavaType(String sqlType) {
		if (sqlType.equalsIgnoreCase("bit")) {
			return "Boolean";
		} else if (sqlType.equalsIgnoreCase("tinyint")) {
			return "Byte";
		} else if (sqlType.equalsIgnoreCase("smallint")) {
			return "Short";
		} else if (sqlType.equalsIgnoreCase("int")) {
			return "Integer";
		} else if (sqlType.equalsIgnoreCase("bigint")) {
			return "Long";
		} else if (sqlType.equalsIgnoreCase("float")) {
			return "Float";
		} else if (sqlType.equalsIgnoreCase("double") ||sqlType.equalsIgnoreCase("decimal") || sqlType.equalsIgnoreCase("numeric") || sqlType.equalsIgnoreCase("real")) {
			return "Double";
		} else if (sqlType.equalsIgnoreCase("money") || sqlType.equalsIgnoreCase("smallmoney")) {
			return "Double";
		} else if (sqlType.equalsIgnoreCase("varchar") || sqlType.equalsIgnoreCase("char") || sqlType.equalsIgnoreCase("nvarchar") || sqlType.equalsIgnoreCase("nchar")) {
			return "String";
		} else if (sqlType.equalsIgnoreCase("time") ||sqlType.equalsIgnoreCase("datetime") || sqlType.equalsIgnoreCase("date") || sqlType.equalsIgnoreCase("timestamp")) {
			return "Date";
		} else if (sqlType.equalsIgnoreCase("image")) {
			return "Blob";
		} else if (sqlType.equalsIgnoreCase("text")) {
			return "Clob";
		}
		return null;
	}

	public static void main(String[] args) {
		new GenEntityTool();
	}
}