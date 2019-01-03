package com.aowin.stuff.dbconnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.aowin.stuff.exception.AddMoreException;
import com.aowin.stuff.exception.IdIsExistException;
import com.aowin.stuff.exception.ListIsZeroException;
import com.aowin.stuff.model.Person;
import com.aowin.utils.JDBCUtils;

public class PersonDao {

	private Connection conn = null;
	private PreparedStatement ps = null;
	String sql = null;
	private ResultSet rs = null;

	// 得到全部Person
	public ArrayList<Person> getAll() {
		ArrayList<Person> list = new ArrayList<Person>();
		try {
			conn = JDBCUtils.getConnection();
			sql = "select * from person";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery(sql);
			while (rs.next()) {
				Person person = new Person(rs.getInt("id"), rs.getString("name"), rs.getInt("sex"),
						rs.getString("department"), rs.getInt("salary"));
				list.add(person);
			}
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			JDBCUtils.free(conn, ps, rs);
		}
		return list;
	}
	
	// 得到全部Person
	public int getSalById(int id) {
		ArrayList<Person> list = new ArrayList<Person>();
		int salary = 0;
		try {
			conn = JDBCUtils.getConnection();
			sql = "select salary from person where id = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery(sql);
			while (rs.next()) {
				salary = rs.getInt("salary");
			}
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			JDBCUtils.free(conn, ps, rs);
		}
		return salary;
	}

	// 添加一行
	public void  add(Person person) throws IdIsExistException {
		try {
			conn = JDBCUtils.getConnection();
			sql = "insert into person value (?,?,?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, person.getId());
			ps.setString(2, person.getName());
			ps.setInt(3, person.getSex());
			ps.setString(4, person.getDepartment());
			ps.setInt(5, person.getSalary());
			ps.executeUpdate();
		} catch (Exception e) {
			throw new IdIsExistException(person.getId());
		} finally {
			JDBCUtils.free(conn, ps, rs);
		}
	}

	// 添加更多行
	public void addMore(List<Person> list) throws AddMoreException, SQLException {
		conn = JDBCUtils.getConnection();
		sql = "insert into person value (?,?,?,?,?)";
		try {
			for (Person person : list) {
				ps = conn.prepareStatement(sql);
				ps.setInt(1, person.getId());
				ps.setString(2, person.getName());
				ps.setInt(3, person.getSex());
				ps.setString(4, person.getDepartment());
				ps.setInt(5, person.getSalary());
				int flag = ps.executeUpdate();
				if (flag != 1)
					throw new AddMoreException(person);
			}
		} catch (SQLException e) {
			throw new SQLException();
		} finally {
			JDBCUtils.free(conn, ps, rs);
		}

	}

	// 通过id 和 name 删除
	public void delByIdAndName(String name, int id) throws Exception {
		conn = JDBCUtils.getConnection();
		sql = "delete from person where id = ? and name = ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.setString(2, name);
			int flag = ps.executeUpdate();
			if (flag == 0)
				throw new Exception("删除失败！");
		} catch (SQLException e) {
			throw new SQLException();
		} finally {
			JDBCUtils.free(conn, ps, rs);
		}
	}

	// 通过sql语句 查询用户
	public ArrayList<Person> getPersonBySQL(String sql) throws ListIsZeroException {
		ArrayList<Person> list = new ArrayList<Person>();
		try {
			conn = JDBCUtils.getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery(sql);
			while (rs.next()) {
				Person person = new Person(rs.getInt("id"), rs.getString("name"), rs.getInt("sex"),
						rs.getString("department"), rs.getInt("salary"));
				list.add(person);
			}
			if(list.size() == 0) {
				throw new ListIsZeroException();
			}
		} catch (SQLException e) {
			// TODO: handle exception
		} finally {
			JDBCUtils.free(conn, ps, rs);
		}
		return list;
	}

	// 通过Person 修改 Person
	public void update(Person person, int id) throws IdIsExistException {
		try {
			conn = JDBCUtils.getConnection();
			sql = "update person set name = ? ,sex = ?,department = ?, salary = ? ,id = ? where id = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, person.getName());
			ps.setInt(2, person.getSex());
			ps.setString(3, person.getDepartment());
			ps.setInt(4, person.getSalary());
			ps.setInt(5, person.getId());
			ps.setInt(6, id);
			int flag = ps.executeUpdate();
			System.out.println("修改成功");
			if (flag != 1)
				throw new IdIsExistException(person);
		} catch (SQLException e) {
			throw new IdIsExistException(person);
		} finally {
			JDBCUtils.free(conn, ps, rs);
		}
	}

	public void updateBySQL(String sql,int newId) throws IdIsExistException {
		try {
			conn = JDBCUtils.getConnection();
			ps = conn.prepareStatement(sql);
			int flag = ps.executeUpdate();
			if (flag != 1)
				throw new IdIsExistException(newId);
		} catch (SQLException e) {
			throw new IdIsExistException(newId);
		} finally {
			JDBCUtils.free(conn, ps, rs);
		}
	}
}
