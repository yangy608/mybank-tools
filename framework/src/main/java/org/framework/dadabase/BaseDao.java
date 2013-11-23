package org.framework.dadabase;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

/**
 * JDBC操作类
 * @author yangy
 * @date   2012-05-23
 */
public class BaseDao {

	private static Logger logger = Logger.getLogger(BaseDao.class);
	private static Connection conn = null;
	private static Statement st = null; 
	
	/**
	 * 查询
	 */
	public static List<?> query(String sql) throws Exception {
		logger.debug("－－－－数据库操作－－－－");
		logger.debug(sql);
		List<?> resultList = null;
		ResultSet rs = null;
		try {
			conn = ConnectionManager.getInstance().getConnection();
			st = conn.createStatement();
			rs= st.executeQuery(sql);
			resultList = convertList(rs);
		}finally{
			try {
				rs.close();
			} catch (Exception e) {
			}
			try {
				st.close();
			} catch (Exception e) {
			}
			try {
				conn.close();
			} catch (Exception e) {
			}
		}		
		return resultList;
	}
	


	/**
	 * 增 删 改 
	 */
	public static boolean execute(String sql) throws Exception {
		logger.debug("－－－－数据库操作－－－－");
		logger.debug(sql);
		boolean result = true;
		try {
			conn = ConnectionManager.getInstance().getConnection();
			st = conn.createStatement();
			result= st.execute(sql);
			conn.commit();
		}finally{
			try {
				st.close();
			} catch (Exception e) {
			}
			try {
				conn.close();
			} catch (Exception e) {
			}
		}		
		return result;
	}

	/**
	 * 增 删 改 
	 */
	public static int executeUpdate(String sql) throws Exception {
		logger.debug("－－－－数据库操作－－－－");
		logger.debug(sql);
		int result = 0;
		try {
			conn = ConnectionManager.getInstance().getConnection();
			st = conn.createStatement();
			result= st.executeUpdate(sql);
			//conn.commit();
		}finally{
			try {
				st.close();
			} catch (Exception e) {
			}
			try {
				conn.close();
			} catch (Exception e) {
			}
		}		
		return result;
	}
	
	/**
	 * 获取SEQ
	 */
	public static String getSEQ() throws Exception {
		ResultSet rs = null;
		String seq = null;
		try {
			conn = ConnectionManager.getInstance().getConnection();
			st = conn.createStatement();
			rs= st.executeQuery("SELECT SEQ_TRADE.NEXTVAL seq FROM DUAL");
			if(rs.next()){
				seq = rs.getString("seq");
			}
		}finally{
			try {
				rs.close();
			} catch (Exception e) {
			}
			try {
				st.close();
			} catch (Exception e) {
			}
			try {
				conn.close();
			} catch (Exception e) {
			}
		}		
		return seq;
	}
	
//	public static void main(String[] args) {
//		   Connection conn = null;
//		   CallableStatement cs = null;
//		   ResultSet rs = null;
//		   try {
//		    conn = ConnectionManager.getInstance().getConnection();
//		    cs = conn.prepareCall("{ call BUZ_TEXMATCH(?,?,?,?) }");
//		    cs.setString(1, "20120626");
//		    cs.setString(2, "S56-201206261439087961001165.txt");
//		    cs.registerOutParameter(3, Types.INTEGER);  
//		    cs.registerOutParameter(4, OracleTypes.CURSOR); 
//		      
//		    cs.execute();
//		    int flag = cs.getInt(3);
//		    System.err.println(flag);
//		    
//		    
//		    rs = (ResultSet) cs.getObject(4);
//		 
//		    while (rs.next()) {
//		     System.err.println("\t" + rs.getString(1) + "\t"+ rs.getString(2) + "\t");
//		    }
//		   } catch (SQLException e) {
//		    e.printStackTrace();
//		   } catch (Exception e) {
//		    e.printStackTrace();
//		   } finally {
//		    try {
//		     if (rs != null) {
//		      rs.close();
//		      if (cs != null) {
//		       cs.close();
//		      }
//		      if (conn != null) {
//		       conn.close();
//		      }
//		     }
//		    } catch (SQLException e) {
//		    }
//		   }
//
//
//
//	}
	
	
	/**
	 * 将ResultSet转换为List<Map<String, Object>>
	 * @param rs
	 * @return
	 * @throws SQLException
	 */
	@SuppressWarnings("unused")
	public static List<Map<String, Object>> convertList(ResultSet rs) throws SQLException{
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		ResultSetMetaData md = rs.getMetaData();
		//获取字段count
		int columnCount = md.getColumnCount();
		while (rs.next()) {
			Map<String, Object> rowData = new HashMap<String, Object>();
			for (int i = 1; i <= columnCount; i++) {
				rowData.put(md.getColumnName(i).toLowerCase(), rs.getObject(i));
			}
			list.add(rowData);
		}
		return list;	
	}
	
}