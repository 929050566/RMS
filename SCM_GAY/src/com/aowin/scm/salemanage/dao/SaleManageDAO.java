package com.aowin.scm.salemanage.dao;

import java.util.ArrayList;
import java.util.List;

import com.aowin.scm.salemanage.pojo.FinanceSaleModel;
import com.aowin.scm.salemanage.pojo.OutstorageSaleModel;
import com.aowin.scm.salemanage.pojo.SaleAllInfo;
import com.aowin.scm.salemanage.pojo.SaleManageDetModel;
import com.aowin.scm.salemanage.pojo.SaleMangeModel;
import com.aowin.scm.utils.BaseDao;

public interface SaleManageDAO extends BaseDao {
	/**
	 *�õ����۱����ݵ���ϸ��Ϣ
	 */
	public String GET_SALEDET_ALLMANAGE ="select salebillid,createtime,customername,createname,extramoney,totalproprices,advanceprice,totalprices,paystate,closeDate,closeUser,comment,disposestate from sale where salebillid = ?";
	/**
	 * �õ����۱����ݵ���ϸ��Ϣ����
	 */
	public SaleMangeModel getsaleByid(int saleid);
	
	/**
	 * ������۱�
	 */
	public String INSERT_SALE_SQL ="insert into sale(salebillid,createtime,customername,createname,extramoney,totalproprices,paystate,advanceprice,totalprices,comment,disposestate) values (?,NOW(),?,?,?,?,?,?,?,?,'1')";
	/**
	 * ������۱�
	 * @return
	 */
	public boolean insertsale(SaleMangeModel sale);
	
	/**
	 *����������SQL���
	 */
	public String GET_SALEDET_BYSALEID_SQL ="select detid,proid,proname,pronum,prounit,unitprice,totalprice,salebillid from sale_det where salebillid = ?";
	
	/**
	 * ����������ķ���
	 * @param sale_id
	 * @return
	 */
	public ArrayList<SaleManageDetModel> getsale_det(String salebillid);
	public String SALEDET_SELECT_SALEID = "select * from sale_det where salebillid = ?";
	/**
	 * ������е����۱��ҳ��ʾ
	 */
	public String GET_SALE_FOREND_SQL ="select salebillid,createtime,customername,createname,extramoney,totalproprices,advanceprice,totalprices,paystate,closeDate,closeUser,comment,disposestate from sale limit ?,?";
	
	/**
	 * page �ڼ���0��ʼ��
	 * pa �ڼ�ҳ
	 */
	public ArrayList<SaleMangeModel> getsale(int page,int pa);
	
	/**
	 * ��ѯ�ͻ�����Ϣ
	 */
	public String GET_CUSTOMER_BYID_SQL ="select customerid,account,password,customername,callman,adress,postnumber,logindate,phone,fax from customer where customerid = ?";
	/**
	 * ��ѯ�ͻ�����Ϣ����
	 */
	public String getCustomer(int customerid);
	
	/**
	 * ��ѯ�������ݿ��г�����Ϣ
	 */
	public String GETMANG_OUTSTORAGE_SALEMODE_SQL ="select outId,outStorageDate,outHandle,outNum,outState,Reason,sale_detid,salebillid from outstorage where salebillid = ?";
	/**
	 * ��ѯ�������ݿ��г�����Ϣ����
	 */
	public OutstorageSaleModel getOutstorageForSale(int saleid);
	/**
	 * ��ѯ���ݿ������ڵ���Ϣ
	 */
	public String GET_FINANCE_SALEMODE_SQL ="select propertyId,date,theway,handle,purchaseid,salebillid from finance where salebillid = ?";
	/**
	 * ��ѯ���ݿ������ڵ���Ϣ����
	 */
	public FinanceSaleModel getFinaceSale(int saleid);
	/**
	 * �������۱�ID��������������
	 */
	public String INSERT_SALEDEL_BYSALEID_SQL ="insert into sale_det (proid,proname,pronum,prounit,unitprice,totalprice,salebillid) values (?,?,?,?,?,?,?)";
	
	/**
	 * �������۱�ID��������������
	 */
	public boolean insertsaledel(SaleManageDetModel saledel);
	
	
	//====�ź��������˽�
	/**
	 * �õ�ȫ���Ŀɸ����Ԥ������������ ����
	 * @return ����
	 */
	public int getCountByConditionSale();
	public String SALE_SELECT_COUNT_CONDITION = "select count(salebillid) as total from sale where (paystate = 1 and disposestate = 3) or (paystate = 2 and disposestate = 2) or (paystate = 3 and disposestate = 3) ";                      
	
	/**
	 * �õ�ȫ���Ŀɸ���Ϳ�Ԥ���� ���۵�����
	 * @param start ��ʼ��
	 * @param size  ����
	 * @return �ɹ�������List
	 */
	public List<SaleMangeModel> getListByConditionSale(int start,int size);
	public String SALE_SELECT_LIST_CONDITION = "select *  from sale where (paystate = 1 and disposestate = 3) or (paystate = 2 and disposestate = 2) or (paystate = 3 and disposestate =3)  order by salebillid desc limit ?,? ";                      
	
	/**
	 * ͨ������״̬ �õ�ȫ���Ŀɸ���Ϳ�Ԥ���� ���۵����� ����
	 * @param paystate ֧����ʽ
	 * @return ����
	 */
	public int getCountByConditionAndPaystateSale(String paystate);
	public String SALE_SELECT_COUNT_CONDITION_PAYSTATE = "select count(salebillid) as total from sale where ((paystate = 1 and disposestate = 3) or (paystate = 2 and disposestate = 2) or (paystate = 3 and disposestate =3) ) and (paystate = ?) ";                      
	
	/**
	 * ͨ������״̬ �õ�ȫ���Ŀɸ���Ϳ�Ԥ���� ���۵�����
	 * @param start ��ʼ����
	 * @param size  ����
	 * @param paystate ����״̬
	 * @return  �ɹ������� list
	 */
	public List<SaleMangeModel> getListByConditionAndPaystateSale(int start,int size,String paystate);
	public String SALE_SELECT_LIST_CONDITION_PAYSTATE = "select * from sale where ((paystate = 1 and disposestate = 3) or (paystate = 2 and disposestate = 2) or (paystate = 3 and disposestate =3) ) and (paystate = ?)  order by salebillid desc limit ?,?";                      
	
	/**
	 * ͨ�����۵���� �޸����۵�״̬
	 * @param salebillid ���۵����
	 * @param disposestate ���۵�״̬
	 * @return �Ƿ��޸ĳɹ� boolean
	 */
	public boolean updateDisposestate(String salebillid,String disposestate,String username);
	public String SALE_UPDATE_DISPOSESTATE = "update sale set disposestate = ?,closeDate=NOW(),closeUser=? where salebillid = ?";
	
	/**
	 * ͨ��sql���õ���ѯ�������۵��� ����
	 * @param sql���
	 * @return ��ѯ��������int
	 */
	public int getCountBySql(String sql);
	
	/**
	 * ͨ��sql���õ���ѯ�������۵�����
	 * @param sql���
	 * @return ���۵�����list
	 */
	public List<SaleMangeModel> getListBySql(String sql);
	
	/**
	 * �õ��������۵��еĿͻ�����
	 */
	public List<String> getAllCustomerName();
	public String SALE_SELECT_CUSTOMERNAME = "select customername from sale";
	
	/**
	 * ͨ�����۵����ɾ�����۵�
	 * @param salebillid���۵����
	 * @return �Ƿ�ɾ���ɹ�
	 */
	public boolean deleteSale(String salebillid);
	String SALE_DELETE_SALEBILLID  = "delete from sale where salebillid  = ?";
	/**
	 * ͨ�����۵����ɾ��������ϸ
	 * @param salebillid���۵����
 	 * @return �Ƿ�ɾ���ɹ�
	 */
	public boolean deleteSaleDet(String salebillid);
	String SALEDET_DELETE_SALEBILLID = "delete from sale_det where salebillid = ? ";
	
	/**
	 * ͨ�����۵���ŵõ� ���۵����������Ϣ
	 * @param salebillid  ���۵����
	 * @return  SaleAllInfo���� 
	 */
	public SaleAllInfo getSaleAllInfoBySaleid(String salebillid);
	public String SALEALLINFO_SELECT_SALEID = "select * from sale left join outstorage on sale.salebillid = outstorage.salebillid left join finance on sale.salebillid = finance.salebillid where sale.salebillid = ?";
	
	/**
	 * �޸Ĳ�Ʒ�� 
	 * @param sale��Ʒ�����
	 * @return �Ƿ��޸ĳɹ�
	 */
	public boolean updateSale(SaleMangeModel sale);
	public String  SALE_UPDATE_SALEMODEL = "update sale set paystate=?,extramoney=?,totalproprices=?,totalproprices=?,totalprices=?,comment=?,disposestate=? where  salebillid = ?";
	
	/**
	 * �޸Ĳ�Ʒ��ϸ��
	 * @param saleDet  ��Ʒ��ϸ����
	 * @return �Ƿ��޸ĳɹ�
	 */
	public boolean updateSaleDet(SaleManageDetModel saleDet);
	public String SALEDET_UPDATE_SALEDETMODEL = "update sale_det set pronum = ?,unitprice= ?,totalprice=? where detid = ?";
	
	public boolean deleteSaleDetByDetid(int detid);
	public String SALEDET_DELETE_DETID = "delete from sale_det where detid = ?";
}
