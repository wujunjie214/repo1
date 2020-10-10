package com.wjj.tool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.print.attribute.standard.PresentationDirection;
import javax.sql.DataSource;

/**
 * 数据库连接与关闭工具类。
 *
 * @author 北大青鸟
 */
public class BaseDao {

	private static String driver = "com.mysql.jdbc.Driver";// 数据库驱动字符串
	private static String url = "jdbc:mysql://localhost:3306/auction";// 连接URL字符串
	private static String user = "root"; // 数据库用户名
	private static String password = "123456"; // 用户密码
	protected Connection conn;

	static {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 获取数据库连接对象。
	 */
	public Connection getConnection() {
		// 获取连接并捕获异常
		try {
			if (conn == null || conn.isClosed())
				conn = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;// 返回连接对象
	}
	/**
	 * 获取数据库连接对象。
	 */
	public Connection getConnection2() {
		// 获取连接并捕获异常
		try {
			Context context = new InitialContext();
			DataSource ds = (DataSource)context.lookup("java:/comp/env/con1");
			conn = ds.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;// 返回连接对象
	}







	/**
	 * 关闭数据库连接。
	 *
	 * @param conn
	 *            数据库连接
	 * @param stmt
	 *            Statement对象
	 * @param rs
	 *            结果集
	 */
	public void closeAll(Connection conn, PreparedStatement stmt, ResultSet rs) {
		// 若结果集对象不为空，则关闭
		try {
			if (rs != null)
				rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		// 若Statement对象不为空，则关闭
		try {
			if (stmt != null)
				stmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}


		// 若数据库连接对象不为空，则关闭
		try {
			if (conn != null)
				conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}




	/**
	 * 增、删、改操作
	 *
	 * @param sql
	 *            sql语句
	 * @param
	 *
	 * @return 执行结果
	 * @throws SQLException
	 */
	public int executeUpdate(String sql, Object... params) throws SQLException {
		conn = getConnection();
		int result = 0;
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			for (int i = 0; i < params.length; i++) {
				pstmt.setObject(i + 1, params[i]);
			}
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}
		return result;
	}

}
