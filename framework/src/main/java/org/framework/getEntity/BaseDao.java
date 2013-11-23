package org.framework.getEntity;

import java.sql.Connection;
import java.sql.Statement;

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

	
}