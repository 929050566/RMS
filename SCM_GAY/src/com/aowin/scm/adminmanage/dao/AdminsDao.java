package com.aowin.scm.adminmanage.dao;

import java.util.List;

import com.aowin.scm.adminmanage.pojo.Admins;
import com.aowin.scm.utils.BaseDao;

/**
 * �û�����ӿ�
 * @author haozai
 * @date 2018��11��15�� ����9:56:24
 */
public interface AdminsDao extends BaseDao{
	/**
	 * ͨ��һ��admins������һ���û�
	 * @param admins
	 * @return �Ƿ����ӳɹ�
	 */
	public boolean insertAdmins(Admins admins);
	public String ADMIN_INSERT = "insert into user (account,realname,password,createdate,lock_statu,po_permit," + 
			" depot_permit,sale_permit,finance_permit,report_permit,user_permit,networksale_permit,manager_permit)"
			+ "values(?,?,?,current_date(),?,?,?,?,?,?,?,?,?)";
	
	/**
	 * ͨ��admins���޸�һ���û�����
	 * @param admins
	 * @return �Ƿ��޸ĳɹ�
	 */
	public boolean updateAdmins(Admins admins);
	public String ADMIN_UPDATE_ACCOUNT= "update user set realname=?,password=?,lock_statu=?,po_permit=?,"+ 
			" depot_permit=?,sale_permit=?,finance_permit=?,report_permit=?,user_permit=?,networksale_permit=?,manager_permit=?"+ 
			" where account = ?";
	
	public boolean deleteAdmins(String account);
	public String ADMIN_DELETE = "delete from user where account = ?";
	
	/**
	 * ͨ���û����������ѯ�û��Ƿ����
	 * @param account �û��� 
	 * @param password ����
	 * @return �û�  ������Ϊnull
	 */
	public Admins login(String account,String password);
	public String ADMIN_SELEET_LOGIN = "select * from user where account=? and password=?";
	
	/**
	 * ͨ���û��� �ж��û����Ƿ����
	 * @param �û��� account
	 * @return �Ƿ����
	 */
	public boolean accountIsExist(String account);
	public String ADMIN_ACCOUNT_EXIST = "select account from user where account = ?";
	
	/**
	 * ͨ��sql����ѯ�û�����
	 * @param sql���
	 * @return �û�����
	 */
	public List<Admins> getAdminsBySQL(String sql);
	
	/**
	 * ͨ���˺�account��ѯ���û���Ϣ
	 * @param �˺�account
	 * @return �û���ϢAdmins
	 */
	public Admins getAdminsByAccount(String account);
	public String ADMINS_SELECT_ACCOUNT = "select * from user where account = ?";
}
