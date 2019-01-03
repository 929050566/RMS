package com.aowin.scm.salemanage.dao;

import java.util.ArrayList;

import com.aowin.scm.salemanage.pojo.ProductManageModle;
import com.aowin.scm.salemanage.pojo.ProductTypeManageModel;
import com.aowin.scm.salemanage.pojo.SalePrices;
import com.aowin.scm.utils.BaseDao;

public interface ProManageDAO extends BaseDao {
	/**
	 * ����ID��ò�Ʒ
	 */
	public String GET_PRODUCT_BYID_SQL ="select proID,proName,proUnit,presentNum,onPurchaseNum,onPresaleNum,protypeid from storage where proID = ?";
	/**
	 * ����ID��ò�Ʒ��Ϣ
	 */
	public ProductManageModle getProduct(int productid);
	
	/**
	 *������еĲ�Ʒ��Ϣ 
	 * 
	 */
	public String GET_ALL_PRODUCT_SQL = "select proID,proName,proUnit,presentNum,onPurchaseNum,onPresaleNum,protypeid from storage limit ?,?";
	
	/**
	 * ������еĲ�Ʒ��Ϣ����
	 * page=�ڼ��� ��0��ʼ pa=ҳ��
	 */
	public ArrayList<ProductManageModle> getallproduct(int page, int pa);
	
	/**
	 * 
	 * �޸Ĳ�Ʒ��Ϣ
	 */
	public String UPDATE_PRODUCT_SQL ="update storage set proName = ?,proUnit=?,protypeid=? where proID=?";
	/**
	 * �޸Ĳ�Ʒ��Ϣ����
	 */
	public boolean update_pro(int proid);
	
	/**
	 * ���Ӳ�Ʒ
	 */
	public String INSERT_PRODUCT_SQL ="insert into storage(proName,proUnit,presentNum,protypeid) values(?,?,?,?)";
	
	/**
	 * ���Ӳ�Ʒ����
	 */
	public boolean insert_pro(ProductManageModle pro);
	
	/**
	 * ɾ����Ʒ
	 */
	public String DELETE_PRODUCT_SQL ="delete from storage where proID = ?";
	/**
	 * ɾ����Ʒ�ķ���
	 */
	public boolean deletepro(int proid);
	
	/**
	 * 
	 * ��ò�Ʒ����byid
	 */
	public String GET_PRODUCT_TYPEID_SQL = "select typeid,typename,comment from producttype where typeid = ?";
	/**
	 *  ��ò�Ʒ��𷽷�byid
	 */
	public ProductTypeManageModel getprotype(int typeid);
	
	/**
	 * ����������
	 */
	public String GET_ALLTYPE_SQL ="select typeid,typename,comment from producttype "; 
	/**
	 * ����������ķ���
	 */
	public ArrayList<ProductTypeManageModel> getalltype();
	
	/**
	 * �޸����
	 */
	public String UPDATE_TYPE_SQL ="update producttype set comment = ?,typename = ? where typeid =?";
	/**
	 * �޸���𷽷�
	 * @return
	 */
	public boolean updatetype(ProductTypeManageModel type);
	
	/**
	 * ɾ�����
	 */
	public String DELETE_TYPE_SQL ="delete from producttype where typeid =?";

	/**
	 * ɾ�����
	 */
	public boolean deletetype(int typeid);
	
	/**
	 * �������
	 */
	public String INSERT_PROTYPE_SQL ="insert into producttype (typename,comment) values (?,?)";
	
	/**
	 * 
	 */
	public boolean insertType(ProductTypeManageModel type);
	
	/**
	 * �����ҳ��
	 */
	 public String GET_PRODUCT_SHOWPAGES_SQL ="select count(proID) total from storage";
	 
	 /**
	  *��ҳ������ 
	  *pages = һҳ����ʾ��
	  */
	 public int getProPages(int pages);
	 
	 /**
	  * �����۲�Ʒ�۸�������Ϣ
	  */
	 public String INSERT_PRO_PRICEMO_SQL ="insert into sale_price (proid,saleprice,procomd) values(?,?,?)";
	 /**
	  * �����۲�Ʒ�۸�������Ϣ
	  */
	 public boolean insertPrice(SalePrices sale);
}
