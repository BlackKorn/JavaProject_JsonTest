package com.test.utils;

import java.sql.*;

public class DBHelper {
	private String DRIVER = "com.mysql.jdbc.Driver";
	private String USERNAME = "root";
	private String PASSWORD = "root";
	private String URL = "jdbc:mysql://localhost:3306/";
	private Connection conn = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;

	/**
	 * ��һ�����������ݿ����� �ڶ������������ݿ�����
	 * 
	 * @param dbName
	 *            ���ݿ���
	 */
	public DBHelper(String dbName) {
		try {
			Class.forName(DRIVER);
			URL = URL + dbName+"?characterEncoding=utf-8&useSSL=true";
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * ����������дsql��� ���Ĳ�������sql���ִ����preparedStatement
	 * 
	 * @param sql
	 *            sql���
	 */
	public void preparedStatement(String sql) {
		try {
			ps = conn.prepareStatement(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * ���岽����ռλ���ò������
	 * 
	 * @param index
	 *            ռλ����������һ��Ϊ1��
	 * @param value
	 *            ����ֵ
	 */
	public void setString(int index, String value) {
		try {
			ps.setString(index, value);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void setInt(int index, int value) {
		try {
			ps.setInt(index, value);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * ��������ִ��sql��䣬������Ӱ������
	 * 
	 * @return ִ��sql�����Ӱ������
	 */
	public int executeUpdate() {
		try {
			// System.out.println(ps);
			return ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	/**
	 * ��������ִ��sql��䣬���ؽ����
	 * 
	 * @return ResultSet
	 */
	public ResultSet executeQuery() {
		try {
			return ps.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * �ر������Լ�����
	 */
	public void close() {
		try {
			if (rs != null) {
				rs.close();
			}
			if (ps != null) {
				ps.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
