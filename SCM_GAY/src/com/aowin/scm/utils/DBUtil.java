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
 * 数据库访问工具类
 * @author TY
 * create date: 2018年11月5日 上午11:24:43
 */
public class DBUtil {
	
	//创建日志对象
	private Logger log = Logger.getLogger(DBUtil.class);
	
	//数据库连接实例
	private Connection conn;

	//数据源
	private DataSource ds;
	/**
	 * 建立数据库连接
	 */
	public DBUtil() {
/*		//读取属性文件中的数据库访问基本数据信息
		Properties p = new Properties();
		
		try {
			p.load(super.getClass().getClassLoader().getResourceAsStream("database.properties"));
			
			Class.forName(p.getProperty("driver"));
			conn = DriverManager.getConnection(p.getProperty("url"), p.getProperty("username"), p.getProperty("password"));
			log.info("数据库连接成功");
		} catch (IOException e) {
			log.warn("属性文件读取异常：" + e);
		} catch (ClassNotFoundException e) {
			log.warn("数据库驱动类加载失败: " + e);
		} catch (SQLException e) {
			log.warn("数据库连接失败: " + e);
		}*/
		
		try {
			//获取上下文信息
			InitialContext context = new InitialContext();
			//获取数据源
			ds = (DataSource) context.lookup("java:/comp/env/mysqlds");
			//获取数据库访问实例
			conn = ds.getConnection();
			log.info("获取数据库访问实例");
		} catch (NamingException e) {
			log.warn("上下文对象获取失败："+e);
		} catch (SQLException e) {
			log.warn("获取数据访问实例失败："+e);
		}
	}
	
	/**
	 * 获取PreparedStatement通道实例
	 * @param sql 执行语句
	 * @return PreparedStatement
	 */
	public PreparedStatement getPreparedStatement(String sql) {
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(sql);
		} catch (SQLException e) {
			log.warn("PreparedStatement通道实例获取失败: " + e);
		//	e.printStackTrace();
		}
		return ps;
	}
	
	/**
	 * 通道资源释放
	 * @param ps PreparedStatement
	 */
	public void psClose(PreparedStatement ps) {
		if(ps != null) {
			try {
				ps.close();
			} catch (SQLException e) {
				log.warn("PreparedStatement资源释放失败: " + e);
			//	e.printStackTrace();
			}
		}
	}
	
	/**
	 *  结果集资源释放
	 * @param rs ResultSet
	 */
	public void rsClose(ResultSet rs) {
		if(rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				log.warn("ResultSet资源释放失败: " + e);
			//	e.printStackTrace();
			}
		}
	}
	
	/**
	 *  连接实例资源释放
	 */
	public void connClose() {
		if(conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				log.warn("连接实例资源释放失败: " + e);
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
			ps.setString(1, "体育新闻");
			int i = ps.executeUpdate();
			System.out.println(i != 0 ? "数据添加成功" : "数据添加失败");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.psClose(ps);
			db.connClose();
		}

	}

}
