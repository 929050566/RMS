package com.aowin.scm.purchasemanager.dao;
import java.util.List;

import com.aowin.scm.purchasemanager.pojo.PurchaseDet;
import com.aowin.scm.utils.BaseDao;

/**
 * @author �濡��
 *date:2018��11��15�� ����4:21:38
 * 
 */
public interface PurchaseDetDao extends BaseDao {

	/**
	 * ��Ӳɹ�����Ϣ
	 */
	public String PURCHASEDET_INSERT_SQL = "insert into purchase_det(proid,proname,pronum,prounit,unitprice,totalprice,purchaseid) values (?,?,?,?,?,?,?)";
	/**
	 *����purchaseidɾ���ɹ�����Ϣ
	 */
	public String PURCHASEDET_DELETE_SQL="delete from purchase_det where purchaseid=?";
	/**
	 *����purchaseid�޸Ĳɹ�����Ϣ
	 */
	public String PURCHASEDET_UPDATE_SQL="update purchase_det set proid=?,proname=?,pronum=?,prounit=?,unitprice=?,totalprice=? where purchaseid=?";
	/**
	 *����purchaseid��ѯ�ɹ���ϸ����Ϣ
	 */
	public String PURCHASEDET_SELECT_SQL = "select detid,proid,proname,pronum,prounit,unitprice,totalprice from purchase_det where purchaseid=?";
	/**
	 * �����ϸ����Ϣ
	 * @param ��ϸ��������Ϣ
	 * @return �Ƿ���ӳɹ�
	 * */
	public boolean insertPurchaseDet(PurchaseDet purchasedet);
	/**
	 * ���ݲɹ������ɾ����ϸ��
	 * @param �ɹ������
	 * @return �Ƿ�ɾ���ɹ�
	 * */
	public boolean deletePurchaseDet(String purchaseid);
	
	/**
	 * �޸���ϸ����Ϣ
	 * @param ��ϸ�������Ϣ
	* @return �Ƿ��޸ĳɹ�
	 */
	public boolean updatePurchaseDet(PurchaseDet purchasedet);
	
	/**
	 * ���ݲɹ�����Ų�ѯ��ϸ��
	 * @param �ɹ������
	 * @return ��ϸ����Ϣ
	 * */
	public List<PurchaseDet> selectPurchaseDet(String purchaseid);
	
	//==================================================
	/**
	 * ͨ���ɹ���ϸ���� ���� ��Ӧ�Ĳɹ���;��
	 * @param purchaseDet����
	 * @return �Ƿ��޸ĳɹ�
	 */
	public boolean updateStorageByPurchaseDet(PurchaseDet purchaseDet);
	public String  SEORAGE_UPDATE_BY_PURCHASEID = "update storage set onPurchaseNum = onPurchaseNum - ? where proID = ?";
	
	/**
	 * ɾ���ɹ�����ϸ ͨ���ɹ���id
	 * @param detid
	 * @return �Ƿ�ɾ���ɹ�
	 */
	public boolean deletePurchaseDetByDetid(int detid);
	public String PURDET_DELETE_DETID = "delete from purchase_det where detid = ?";
}
