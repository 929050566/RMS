package com.aowin.scm.financemanage.dao;

import java.util.List;

import com.aowin.scm.financemanage.pojo.Finance;
import com.aowin.scm.financemanage.pojo.FinanceInfo;
import com.aowin.scm.purchasemanager.pojo.Purchase;
import com.aowin.scm.salemanage.pojo.SaleMangeModel;
import com.aowin.scm.utils.BaseDao;

public interface FinanceDao extends BaseDao{
	/**
	 * ���һ�вɹ����������¼
	 * @param ��֧��¼���� finance
	 * @return  �Ƿ���ӳɹ�
	 */
	public boolean insertPurchase(Finance finance);
	public String FINANCE_INSERT_PURCHASE = "insert into finance (date,theway,handle,purchaseid) values (NOW(),?,?,?)";
	
	/**
	 * ���һ�����۵���֧����¼
	 * @param ��֧��¼���� finance
	 * @return  �Ƿ���ӳɹ�
	 */
	public boolean insertSale(Finance finance);
	public String FINANCE_INSERT_SALE = "insert into finance (date,theway,handle,salebillid) values (NOW(),?,?,?)";	
	
	/**
	 * ͨ���ɹ������ �޸� �ɹ��� ״̬Ϊ�Ѹ���
	 * @param purchaseid �ɹ������
	 * @return �Ƿ��޸ĳɹ�
	 */
	public boolean updatePurchase(String purchaseid,String disposestate);
	public String PURCHASE_UPDATE_DISPOSESTATE = "update purchase set disposestate = ? where purchaseid = ? ";
	
	/**
	 * ͨ�� ���۵���� �޸����۵�״̬Ϊ �Ѹ���
	 * @param salebillid ���۵����
	 * @return �Ƿ��޸ĳɹ�
	 */
	public boolean updateSale(String salebillid,String disposestate);
	public String SALE_UPDATE_DISPOSESTATE = "update sale set disposestate = ? where salebillid = ? ";
	
	//=============================����Ǽ� 
	/**
	 * �õ�ȫ���Ŀɸ����Ԥ������������
	 * @return ����
	 */
	public int getCountByCondition();
	public String PURCHASE_SELECT_COUNT_CONDITION = "select count(purchaseid) as total from purchase where (paystate = 1 and disposestate = 2) or (paystate = 2 and disposestate = 1) or (paystate = 3 and disposestate = 1) or (paystate = 3 and disposestate = 2) ";                      
	
	/**
	 * �õ�ȫ���Ŀɸ���Ϳ�Ԥ���� �ɹ�������
	 * @param start ��ʼ��
	 * @param size  ����
	 * @return �ɹ�������List
	 */
	public List<Purchase> getListByCondition(int start,int size);
	public String PURCHASE_SELECT_LIST_CONDITION = "select *  from purchase where (paystate = 1 and disposestate = 2) or (paystate = 2 and disposestate = 1) or (paystate = 3 and disposestate = 1) or (paystate = 3 and disposestate = 2) order by purchaseid desc limit ?,? ";                      
	
	/**
	 * ͨ������״̬ �õ�ȫ���Ŀɸ���Ϳ�Ԥ���� �ɹ������� ����
	 * @param paystate ֧����ʽ
	 * @return ����
	 */
	public int getCountByConditionAndPaystate(String paystate);
	public String PURCHASE_SELECT_COUNT_CONDITION_PAYSTATE = "select count(purchaseid) as total from purchase where ((paystate = 1 and disposestate = 2) or (paystate = 2 and disposestate = 1) or (paystate = 3 and disposestate = 1) or (paystate = 3 and disposestate = 2)) and (paystate = ?) ";                      
	
	/**
	 * ͨ������״̬ �õ�ȫ���Ŀɸ���Ϳ�Ԥ���� �ɹ�������
	 * @param start ��ʼ����
	 * @param size  ����
	 * @param paystate ����״̬
	 * @return  �ɹ������� list
	 */
	public List<Purchase> getListByConditionAndPaystate(int start,int size,String paystate);
	public String PURCHASE_SELECT_LIST_CONDITION_PAYSTATE = "select * from purchase where ((paystate = 1 and disposestate = 2) or (paystate = 2 and disposestate = 1) or (paystate = 3 and disposestate = 1) or (paystate = 3 and disposestate = 2)) and (paystate = ?)  order by purchaseid desc limit ?,?";                      
	//==================================================�տ�Ǽ�
	/**
	 * �õ�ȫ���Ŀɸ����Ԥ������������ ����
	 * @return ����
	 */
	public int getCountByConditionSale();
	public String SALE_SELECT_COUNT_CONDITION = "select count(salebillid) as total from sale where (paystate = 1 and disposestate = 2) or (paystate = 2 and disposestate = 1) or (paystate = 3 and disposestate = 1) or (paystate = 3 and disposestate = 2) ";                      
	
	/**
	 * �õ�ȫ���Ŀɸ���Ϳ�Ԥ���� ���۵�����
	 * @param start ��ʼ��
	 * @param size  ����
	 * @return �ɹ�������List
	 */
	public List<SaleMangeModel> getListByConditionSale(int start,int size);
	public String SALE_SELECT_LIST_CONDITION = "select *  from sale where (paystate = 1 and disposestate = 2) or (paystate = 2 and disposestate = 1) or (paystate = 3 and disposestate = 1) or (paystate = 3 and disposestate = 2) order by salebillid desc limit ?,? ";                      
	
	/**
	 * ͨ������״̬ �õ�ȫ���Ŀɸ���Ϳ�Ԥ���� ���۵����� ����
	 * @param paystate ֧����ʽ
	 * @return ����
	 */
	public int getCountByConditionAndPaystateSale(String paystate);
	public String SALE_SELECT_COUNT_CONDITION_PAYSTATE = "select count(salebillid) as total from sale where ((paystate = 1 and disposestate = 2) or (paystate = 2 and disposestate = 1) or (paystate = 3 and disposestate = 1) or (paystate = 3 and disposestate = 2)) and (paystate = ?) ";                      
	
	/**
	 * ͨ������״̬ �õ�ȫ���Ŀɸ���Ϳ�Ԥ���� ���۵�����
	 * @param start ��ʼ����
	 * @param size  ����
	 * @param paystate ����״̬
	 * @return  �ɹ������� list
	 */
	public List<SaleMangeModel> getListByConditionAndPaystateSale(int start,int size,String paystate);
	public String SALE_SELECT_LIST_CONDITION_PAYSTATE = "select * from sale where ((paystate = 1 and disposestate = 2) or (paystate = 2 and disposestate = 1) or (paystate = 3 and disposestate = 1) or (paystate = 3 and disposestate = 2)) and (paystate = ?)  order by salebillid desc limit ?,?";                      
	
	/**
	 * ͨ��sql���õ�ȫ��list
	 * @param sql���
	 * @return FinanceInfo����
	 */
	public List<FinanceInfo> getFinInfoListBySql(String sql);
	/**
	 * ͨ��sql �õ�����
	 * @param sql
	 * @return ����
	 */
	public int getFinInfoCountBySql(String sql);
}
