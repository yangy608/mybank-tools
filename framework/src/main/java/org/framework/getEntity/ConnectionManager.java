package org.framework.getEntity;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ResourceBundle;

import org.apache.log4j.Logger;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.mchange.v2.c3p0.DataSources;

/**
 * 连接管理类
 * @author yangy
 * @date   2012-05-23
 */
public final class ConnectionManager {

	@SuppressWarnings("unused")
	private static Logger logger = Logger.getLogger(ConnectionManager.class);

	/**
	 * 静态初始化连接池实例对象
	 */
	private static ConnectionManager instance;

	/**
	 * c3p0连接池
	 */
	private ComboPooledDataSource ds;
	
	private final static ResourceBundle RB = ResourceBundle.getBundle("createEntity/jdbc");

	/**
	 * 仅仅提供给内部使用的构造器
	 * @throws Exception
	 */
	private ConnectionManager() throws Exception {
		ds = new ComboPooledDataSource();
		ds.setDriverClass(RB.getString("db_driverClass"));
		ds.setJdbcUrl(RB.getString("db_jdbcUrl"));
		ds.setUser(RB.getString("db_user"));
		ds.setPassword(RB.getString("db_password"));
		// 初始化时获取三个连接，取值应在minPoolSize与maxPoolSize之间。Default: 3
		ds.setInitialPoolSize(Integer.parseInt(RB.getString("db_initialPoolSize")));
		// 连接池中保留的最大连接数。Default: 15
		ds.setMaxPoolSize(Integer.parseInt(RB.getString("db_maxPoolSize")));
		// 连接池中保留的最大连接数。Default: 1
		ds.setMinPoolSize(Integer.parseInt(RB.getString("db_minPoolSize")));
		// 当连接池中的连接耗尽的时候c3p0一次同时获取的连接数。Default: 3
		ds.setAcquireIncrement(Integer.parseInt(RB.getString("db_acquireIncrement")));
		// 定义在从数据库获取新连接失败后重复尝试的次数。Default: 30
		ds.setAcquireRetryAttempts(Integer.parseInt(RB.getString("db_acquireRetryAttempts")));
		// 两次连接中间隔时间，单位毫秒。Default: 1000
		ds.setAcquireRetryDelay(Integer.parseInt(RB.getString("db_acquireRetryDelay")));
		// 每60秒检查所有连接池中的空闲连接。Default: 0
		ds.setIdleConnectionTestPeriod(Integer.parseInt(RB.getString("db_idleConnectionTestPeriod")));
		// 最大空闲时间,60秒内未使用则连接被丢弃。若为0则永不丢弃。Default: 0
		ds.setMaxIdleTime(Integer.parseInt(RB.getString("db_maxIdleTime")));
		// 当连接池用完时客户端调用getConnection()后等待获取新连接的时间，超时后将抛出SQLException,如设为0则无限期等待。单位毫秒。Default: 0
		ds.setCheckoutTimeout(Integer.parseInt(RB.getString("db_checkoutTimeout")));
		// 如果设为true那么在取得连接的同时将校验连接的有效性。Default: false
		ds.setTestConnectionOnCheckin(Boolean.parseBoolean(RB.getString("db_testConnectionOnCheckin")));
		// 获取连接失败将会引起所有等待连接池来获取连接的线程抛出异常。但是数据源仍有效保留，并在下次调用getConnection()的时候继续尝试获取连接。如果设为true，那么在尝试获取连接失败后该数据源将申明已断开并永久关闭。Default: false
		ds.setBreakAfterAcquireFailure(Boolean.parseBoolean(RB.getString("db_breakAfterAcquireFailure")));
		// 连接关闭时默认将所有未提交的操作回滚。Default: false
		ds.setAutoCommitOnClose(Boolean.parseBoolean(RB.getString("db_autoCommitOnClose")));
	}

	/**
	 * 提供外部调用的静态单例模式实例化方法
	 * @return
	 */
	public static final ConnectionManager getInstance() {
		if (instance == null) {
			try {
				instance = new ConnectionManager();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return instance;
	}

	/**
	 * 线程安全的提供连接
	 * @return Connection
	 * @throws SQLException 
	 */
	public synchronized final Connection getConnection() throws SQLException {
		Connection conn = ds.getConnection();
		//conn.setAutoCommit(false);
		return conn;
	}

	protected void finalize() throws Throwable {
		DataSources.destroy(ds);
		super.finalize();
	}
	
	public static final void closeConnection(Connection conn) {

		try {
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	

}