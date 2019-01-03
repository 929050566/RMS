package com.aowin.scm.purchasemanager.dao;

import java.util.List;

import com.aowin.scm.purchasemanager.pojo.Purchase;
import com.aowin.scm.purchasemanager.pojo.PurchaseAllInfo;
import com.aowin.scm.purchasemanager.pojo.PurchaseDet;
import com.aowin.scm.utils.BaseDao;

/**
 * @author �濡��
 *date:2018��11��15�� ����12:13:24
 * 
 */
public interface PurchaseDao extends BaseDao {

	/**
	 * ��Ӳɹ�����Ϣ
	 */
	public String PURCHASE_INSERT_SQL = "insert into purchase(purchaseid,createtime,suppliername,createname,extramoney,totalproprices,advanceprice,totalprices,paystate,comment,disposestate) values (?,?,?,?,?,?,?,?,?,?,?)";
	/**
	 *����purchaseidɾ���ɹ�����Ϣ
	 */
	public String PURCHASE_DELETE_SQL="delete from purchase where purchaseid=?";
	/**
	 *����purchaseid�޸Ĳɹ�����Ϣ
	 */
	public String PURCHASE_UPDATE_SQL="update purchase set createtime=?,suppliername=?,createname=?,extramoney=?,totalproprices=?,advanceprice=?,totalprices=?,paystate=?,comment=?,closeDate=?,closeUser=?,disposestate=? where purchaseid=?";
	/**
	 * ��ҳ��ѯ�ɹ�����Ϣ
	 */
	public String PURCHASE_SELECT_ALL_SQL = "select purchaseid,createtime,suppliername,createname,extramoney,totalproprices,advanceprice,totalprices,paystate,comment,closeDate,closeUser,disposestate from purchase order by purchaseid desc limit ?,?";
	/**
	 * ��ȡ�ɹ����ܼ�¼��
	 */
	public String PURCHASE_SELECT_COUNT_SQL = "select count(purchaseid) total from purchase";
	
	
	/**
	 * ��Ӳɹ�����Ϣ
	 * @param �ɹ���������Ϣ
	 * @return �Ƿ���ӳɹ�
	 * */
	public boolean insertPurchase(Purchase purchase);
	/**
	 * ���ݲɹ������ɾ���ɹ���
	 * @param �ɹ������
	 * @return �Ƿ�ɾ���ɹ�
	 * */
	public boolean deletePurchaseid(String purchaseid);
	
	/**
	 * �޸Ĳɹ�����Ϣ
	 * @param �ɹ���������Ϣ
	* @return �Ƿ��޸ĳɹ�
	 */
	public boolean updatePurchase(Purchase purchase);
	/**
	 * �޸Ĳɹ�������״̬
	 * @param �ɹ������ �ɹ�������״̬
	* @return �Ƿ��޸ĳɹ�
	 */
	public boolean updateDisposestate(String purchaseid,String disposestate,String closeUser);
	public String PURCHASE_UPDATE_DISPOSESTATE = "update purchase set disposestate = ?, closeDate=current_date(),closeUser=? where purchaseid = ?";
	/**
	 * ��ҳ��ʾ�ɹ�����Ϣ
	 * @param pages ��ǰҳ
	 * @param pagesize ÿҳ��ʾ����
	 * @return Purchase����
	 */
	public List<Purchase> getSupplier(int pages,int pagesize);
	
	//=================================================
	/**
	 * ������ݵ�������
	 * @return ���ݵ�������
	 */
	public int getTotalLines();
	/**
	 * ͨ��sql��� ��ȡ����
	 * @param sql���
	 * @return ����
	 */
	public int getTotalLinesBySql(String sql);
	
	/**
	 * ͨ��sql��� ��ѯ�ɹ�������
	 * @param sql���
	 * @return ��ѯ�ɹ�������
	 */
	public List<Purchase> getPurchaseBySql(String sql);
	/**
	 * ��ѯ�����˽�Ĳɹ���
	 * @return ���ؿ��˽�Ĳɹ���
	 */
	public List<Purchase> getPurchaseByCondition(int page,int size);
	public String PURCHASE_SELECT_FRO_FINISH = "select * from purchase where (paystate = 1 and disposestate = 3) or (paystate = 2 and disposestate = 2) or (paystate = 3 and disposestate = 3) order by purchaseid desc limit ?,?";
	
	/**
	 * ��ѯ���п��˽�Ĳɹ�������
	 * @return ���˽�ɹ�������
	 */
	public int getPurchaseCount();;
	public String PURCHASE_SELECT_FRO_FINISH_ACCOUNT = "select count(purchaseid) as total from purchase where (paystate = 1 and disposestate = 3) or (paystate = 2 and disposestate = 2) or (paystate = 3 and disposestate = 3) ";
	
	/**
	 * ͨ�����ʽ��ѯ���п��˽�Ĳɹ�������
	 * @return ���˽�ɹ�������
	 */
	public  List<Purchase> getPurchaseConditionByPaystate(int page,int size,String paystate);
	public String PURCHASE_SELECT_FRO_FINISH_BY_PAYSTATE = "select * from purchase where ((paystate = 1 and disposestate = 3) or (paystate = 2 and disposestate = 2) or (paystate = 3 and disposestate = 3)) and( paystate = ?) order by purchaseid desc limit ?,?";
	
	/**
	 * ͨ�����ʽ��ѯ���п��˽�Ĳɹ�����������
	 * @return �ô���ת̬�¿��˽ⵥ��������
	 */
	public  int getPurchaseConditionCountByPaystate(String paystate);
	public String PURCHASE_SELECT_FOR_FINISH_ACCOUNT_PAYSTATE = "select count(purchaseid) as total from purchase where ((paystate = 1 and disposestate = 3) or (paystate = 2 and disposestate = 2) or (paystate = 3 and disposestate = 3)) and( paystate = ?) ";
		
	/**
	 * ͨ��Purchaseid �õ� PurchaseAllInfo 
	 * @param purchaseid
	 * @return ���زɹ��������ȫ����Ϣ
	 */
	public  PurchaseAllInfo getPurPurchaseAllInfoByPurchaseid(String purchaseid);
	
	//======С��======С��======С��======С��======С��======С��======С��======С��======С��======С��
	/** 
	 * ������д����Ĳɹ�������������Ϣ
	 */
	public String PURCHASE_RK_ALL_SQL = "select purchaseid,createtime,suppliername,createname,extramoney,totalproprices,totalprices,paystate,advanceprice,disposestate from Purchase where (disposestate=1 and paystate=1) or (disposestate=3 and paystate=2) or (disposestate=5 and paystate=3) order by purchaseid desc limit ?,?";
	/** 
	 * 1���������� 
	 */
	public String PURCHASE_HD_ALL_SQL ="select purchaseid,createtime,suppliername,createname,extramoney,totalproprices,totalprices,paystate,advanceprice,disposestate from Purchase where disposestate=1 and paystate=1 order by purchaseid desc limit ?,?";
	/** 
	 * 2������� 
	 */
	public String PURCHASE_KD_ALL_SQL ="select purchaseid,createtime,suppliername,createname,extramoney,totalproprices,totalprices,paystate,advanceprice,disposestate from Purchase where disposestate=3 and paystate=2 order by purchaseid desc limit ?,?";
	/** 
	 * 3��Ԥ�������
	 */
	public String PURCHASE_YF_ALL_SQL ="select purchaseid,createtime,suppliername,createname,extramoney,totalproprices,totalprices,paystate,advanceprice,disposestate from Purchase where disposestate=5 and paystate=3 order by purchaseid desc limit ?,?";
	/** 
	 * ���ݲɹ������޸Ĳɹ�����״̬ 
	 */
	public String PURCHASE_UPDA_SQL = "update Purchase set disposestate=? where purchaseid=? ";
	/** 
	 * ������д����Ĳɹ�������������Ϣ
	 * ��ҳ��ѯ�̵�����Ϣ
	 * @param pages ��ǰҳ
	 * @param pagesize ÿҳ��ʾ����
	 * @return Purchase����
	 */
	public List<Purchase> getPurchaseBYDisposestate(int pages,int pagesize);
	/**
	 * ��ȡ����̵���ҳ��
	 * @param pagesize ÿҳ��ʾ����
	 * @return ��ҳ��
	 */
	public int getPurchaseAllTotalPages(int pagesize);
	public int getALL(int pagesize);
	
	/** 
	 * ��û������� �����вɹ�������������Ϣ
	 * ��ҳ��ѯ�̵�����Ϣ
	 * @param pages ��ǰҳ
	 * @param pagesize ÿҳ��ʾ����
	 * @return Purchase����
	 */
	public List<Purchase> getPurchaseBYPaystate1(int pages,int pagesize);
	/**
	 * ��ȡ����̵���ҳ��
	 * @param pagesize ÿҳ��ʾ����
	 * @return ��ҳ��
	 */
	public int getPurchasePaystate1TotalPages(int pagesize);
	public int getPaystate1ALL(int pagesize);
	
	/** 
	 * ��ÿ���� �����вɹ�������������Ϣ
	 * ��ҳ��ѯ�̵�����Ϣ
	 * @param pages ��ǰҳ
	 * @param pagesize ÿҳ��ʾ����
	 * @return Purchase����
	 */
	public List<Purchase> getPurchaseBYPaystate2(int pages,int pagesize);
	/**
	 * ��ȡ����̵���ҳ��
	 * @param pagesize ÿҳ��ʾ����
	 * @return ��ҳ��
	 */
	public int getPurchasePaystate2TotalPages(int pagesize);
	public int getPaystate2ALL(int pagesize);
	
	/** 
	 * ���Ԥ������� �����вɹ�������������Ϣ
	 ��ҳ��ѯ�̵�����Ϣ
	 * @param pages ��ǰҳ
	 * @param pagesize ÿҳ��ʾ����
	 * @return Purchase����
	 */
	public List<Purchase> getPurchaseBYPaystate3(int pages,int pagesize);
	/**
	 * ��ȡ����̵���ҳ��
	 * @param pagesize ÿҳ��ʾ����
	 * @return ��ҳ��
	 */
	public int getPurchasePaystate3TotalPages(int pagesize);
	public int getPaystate3ALL(int pagesize);
	/** 
	 * ���ݲɹ����޸Ĵ���״̬
	 * @param purchaseid
	 * @return
	 */
	public boolean updaBYID(String purchaseid ,String disposestate);
	
	public String PURCHAASEDET_SELECT_BYTWOID_SQL = "select pronum from Purchase_Det where proid=? and purchaseid=?";
	public int getDet(int proid, String purchaseid);
	
	public String PURCHAASEDET_SELECTPROID_BYID_SQL = "select proid from Purchase_Det where purchaseid=?";
	public int getDet(String purchaseid);
	
	/** 
	 * ���ݲɹ������ڲ�Ʒ��ϸ���ѯ��һϵ���ڵĲ�Ʒ����
	 */
	public String PUREDET_PROIDSELECT_SQL = "select proid,pronum,detid from Purchase_Det where purchaseid=?";
	public String PURCHASE_UPDATE = "update purchase set paystate=?,extramoney=?,totalproprices=?,advanceprice=?,totalprices?,comment=?,disposestate=? where purchaseid = ?";
	/** 
	 * ���ݲɹ������ڲ�Ʒ��ϸ���ѯ��һϵ���ڵĲ�Ʒ����
	 * @param saleid
	 * @return
	 */
	public List<PurchaseDet> getproid(String saleid);
	public String PURCHASE_SELECT = "select purchaseid,createtime,suppliername,createname,extramoney,totalproprices,totalprices,paystate,advanceprice,disposestate from Purchase where disposestate=5 and paystate=3";
}
