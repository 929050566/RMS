package com.aowin.stuff.dbconnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.aowin.stuff.exception.PasswordisErrorException;
import com.aowin.stuff.exception.UsernameIsErrorException;
import com.aowin.stuff.model.User;
import com.aowin.utils.JDBCUtils;

public class UserDao {
	private Connection conn = null;
	private PreparedStatement ps = null;
	String sql = null;
	private ResultSet rs = null;

	public int login(User user) throws UsernameIsErrorException, PasswordisErrorException {

		String username = null;
		String password = null;
		int permission = 0;
		try {
			conn = JDBCUtils.getConnection();
			ps = conn.prepareStatement("select username,password,permission from user where username = ?");
			ps.setString(1, user.getUsername());
			rs = ps.executeQuery();
			while (rs.next()) {
				username = rs.getString("username");
				password = rs.getString("password");
				permission = rs.getInt("permission");
			}
			if (username == null)
				throw new UsernameIsErrorException();
			if (!password.equals(user.getPassword()))
				throw new PasswordisErrorException();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.free(conn, ps, rs);
		}
		return permission;
	}
}
