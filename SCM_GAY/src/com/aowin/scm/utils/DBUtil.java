package com.aowin.scm.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.apache.log4j.Logger;

/**
 * ���ݿ���ʹ�����
 * @author TY
 * create date: 2018��11��5�� ����11:24:43
 */
public class DBUtil {
	
	//������־����
	private Logger log = Logger.getLogger(DBUtil.class);
	
	//���ݿ�����ʵ��
	private Connection conn;

	//����Դ
	private DataSource ds;
	/**
	 * �������ݿ�����
	 */
	public DBUtil() {
/*		//��ȡ�����ļ��е����ݿ���ʻ���������Ϣ
		Properties p = new Properties();
		
		try {
			p.load(super.getClass().getClassLoader().getResourceAsStream("database.properties"));
			
			Class.forName(p.getProperty("driver"));
			conn = DriverManager.getConnection(p.getProperty("url"), p.getProperty("username"), p.getProperty("password"));
			log.info("���ݿ����ӳɹ�");
		} catch (IOException e) {
			log.warn("�����ļ���ȡ�쳣��" + e);
		} catch (ClassNotFoundException e) {
			log.warn("���ݿ����������ʧ��: " + e);
		} catch (SQLException e) {
			log.warn("���ݿ�����ʧ��: " + e);
		}*/
		
		try {
			//��ȡ��������Ϣ
			InitialContext context = new InitialContext();
			//��ȡ����Դ
			ds = (DataSource) context.lookup("java:/comp/env/mysqlds");
			//��ȡ���ݿ����ʵ��
			conn = ds.getConnection();
			log.info("��ȡ���ݿ����ʵ��");
		} catch (NamingException e) {
			log.warn("�����Ķ����ȡʧ�ܣ�"+e);
		} catch (SQLException e) {
			log.warn("��ȡ���ݷ���ʵ��ʧ�ܣ�"+e);
		}
	}
	
	/**
	 * ��ȡPreparedStatementͨ��ʵ��
	 * @param sql ִ�����
	 * @return PreparedStatement
	 */
	public PreparedStatement getPreparedStatement(String sql) {
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(sql);
		} catch (SQLException e) {
			log.warn("PreparedStatementͨ��ʵ����ȡʧ��: " + e);
		//	e.printStackTrace();
		}
		return ps;
	}
	
	/**
	 * ͨ����Դ�ͷ�
	 * @param ps PreparedStatement
	 */
	public void psClose(PreparedStatement ps) {
		if(ps != null) {
			try {
				ps.close();
			} catch (SQLException e) {
				log.warn("PreparedStatement��Դ�ͷ�ʧ��: " + e);
			//	e.printStackTrace();
			}
		}
	}
	
	/**
	 *  �������Դ�ͷ�
	 * @param rs ResultSet
	 */
	public void rsClose(ResultSet rs) {
		if(rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				log.warn("ResultSet��Դ�ͷ�ʧ��: " + e);
			//	e.printStackTrace();
			}
		}
	}
	
	/**
	 *  ����ʵ����Դ�ͷ�
	 */
	public void connClose() {
		if(conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				log.warn("����ʵ����Դ�ͷ�ʧ��: " + e);
			//	e.printStackTrace();
			}
		}
	}


	public static void main(String[] args) {
		DBUtil db = new DBUtil();
		/*String sql = "select typeid,typename from newstypes";
		PreparedStatement ps = db.getPreparedStatement(sql);
		ResultSet rs = null;
		try {
			rs = ps.executeQuery();
			while(rs.next()) {
				System.out.println(rs.getInt("typeid") +"   "+ rs.getString("typename"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.rsClose(rs);
			db.psClose(ps);
			db.connClose();
		}*/
		
		String sql = "insert into newstypes(typename) values (?)";
		PreparedStatement ps = db.getPreparedStatement(sql);
		try {
			ps.setString(1, "��������");
			int i = ps.executeUpdate();
			System.out.println(i != 0 ? "������ӳɹ�" : "�������ʧ��");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.psClose(ps);
			db.connClose();
		}

	}

}
