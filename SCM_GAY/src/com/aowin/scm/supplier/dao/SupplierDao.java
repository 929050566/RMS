/**
 * 
 */
package com.aowin.scm.supplier.dao;

import java.util.List;


import com.aowin.scm.supplier.pojo.Supplier;
import com.aowin.scm.utils.BaseDao;

/**
 * @author �濡��
 *date:2018��11��15�� ����11:12:41
 * 
 */
public interface SupplierDao extends BaseDao {
	
	/**
	 * ��ӹ�Ӧ����Ϣ
	 */
	public String SUPPLIER_INSERT_SQL = "insert into supplier(supplieid,suppliername,velaname,supplierpassword,address,mailnumber,createdate,phone,faxes) values (?,?,?,?,?,?,current_date,?,?)";
	/**
	 *����supplieridɾ����Ӧ����Ϣ
	 */
	public String SUPPLIER_DELETE_SQL="delete from supplier where supplieid=?";
	/**
	 *����supplierid�޸Ĺ�Ӧ����Ϣ
	 */
	public String SUPPLIER_UPDATE_SQL="update supplier set suppliername=?,velaname=?,supplierpassword=?,address=?,mailnumber=?,phone=?,faxes=? where supplieid=?";
	/**
	 * ��ѯȫ����Ӧ����Ϣ
	 */
	public String SUPPLIER_SELECT_ALL_SQL = "select supplieid,suppliername,velaname,supplierpassword,address,mailnumber,createdate,phone,faxes from supplier ";
	/**
	 * ��ѯȫ����Ӧ����Ϣ
	 */
	public String SUPPLIER_SELECT_SQL_BY_ID = "select supplieid,suppliername,velaname,supplierpassword,address,mailnumber,createdate,phone,faxes from supplier where supplieid=? ";
	
	/**
	 * ��ӹ�Ӧ����Ϣ
	 * @param supplier ��Ӧ�̻�����Ϣ
	 * @return �Ƿ���ӳɹ�
	 * */
	public boolean insertSupplier(Supplier supplier);
	
	/**
	 * ���ݹ�Ӧ�̱��ɾ����Ӧ��
	 * @param supplier ��Ӧ�̱��
	 * @return �Ƿ�ɾ���ɹ�
	 * */
	public boolean deleteSupplier(int supplieid);
	/**
	 * ���ݹ�Ӧ�̱�Ų�ѯ��Ӧ����Ϣ
	 * @param supplier ��Ӧ�̱��
	 * @return ��Ӧ����Ϣ
	 * */
	public Supplier selectSupplier(int supplieid);
	/**
	*��ȡ���й�Ӧ����Ϣ
	 * @return ��Ӧ�̼��� 
	* */
	public List<Supplier> getSupplier();
	/**
	 * �޸Ĺ�Ӧ����Ϣ
	 * @param ��Ӧ�̻�����Ϣ
	* @return �Ƿ��޸ĳɹ�
	 */
	public boolean updateSupplier(Supplier supplier);
	/**
	 * ����������ѯ��Ӧ����Ϣ
	 * @param sql���
	* @return ��Ӧ�̼���
	 */
	public List<Supplier> select(String sql);
	/**
	 * �жϹ�Ӧ�̱���Ƿ����
	 * @param  ��Ӧ�̱��
	 * @return �Ƿ����
	 * */
	public boolean getSupplierById(int supplieid);
}
