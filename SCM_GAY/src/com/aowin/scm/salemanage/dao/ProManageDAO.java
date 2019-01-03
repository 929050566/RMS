package com.aowin.scm.salemanage.dao;

import java.util.ArrayList;

import com.aowin.scm.salemanage.pojo.ProductManageModle;
import com.aowin.scm.salemanage.pojo.ProductTypeManageModel;
import com.aowin.scm.salemanage.pojo.SalePrices;
import com.aowin.scm.utils.BaseDao;

public interface ProManageDAO extends BaseDao {
	/**
	 * 根据ID获得产品
	 */
	public String GET_PRODUCT_BYID_SQL ="select proID,proName,proUnit,presentNum,onPurchaseNum,onPresaleNum,protypeid from storage where proID = ?";
	/**
	 * 根据ID获得产品信息
	 */
	public ProductManageModle getProduct(int productid);
	
	/**
	 *获得所有的产品信息 
	 * 
	 */
	public String GET_ALL_PRODUCT_SQL = "select proID,proName,proUnit,presentNum,onPurchaseNum,onPresaleNum,protypeid from storage limit ?,?";
	
	/**
	 * 获得所有的产品信息方法
	 * page=第几行 从0开始 pa=页面
	 */
	public ArrayList<ProductManageModle> getallproduct(int page, int pa);
	
	/**
	 * 
	 * 修改产品信息
	 */
	public String UPDATE_PRODUCT_SQL ="update storage set proName = ?,proUnit=?,protypeid=? where proID=?";
	/**
	 * 修改产品信息方法
	 */
	public boolean update_pro(int proid);
	
	/**
	 * 增加产品
	 */
	public String INSERT_PRODUCT_SQL ="insert into storage(proName,proUnit,presentNum,protypeid) values(?,?,?,?)";
	
	/**
	 * 增加产品方法
	 */
	public boolean insert_pro(ProductManageModle pro);
	
	/**
	 * 删除产品
	 */
	public String DELETE_PRODUCT_SQL ="delete from storage where proID = ?";
	/**
	 * 删除产品的方法
	 */
	public boolean deletepro(int proid);
	
	/**
	 * 
	 * 获得产品类别表byid
	 */
	public String GET_PRODUCT_TYPEID_SQL = "select typeid,typename,comment from producttype where typeid = ?";
	/**
	 *  获得产品类别方法byid
	 */
	public ProductTypeManageModel getprotype(int typeid);
	
	/**
	 * 获得所有类别
	 */
	public String GET_ALLTYPE_SQL ="select typeid,typename,comment from producttype "; 
	/**
	 * 获得所有类别的方法
	 */
	public ArrayList<ProductTypeManageModel> getalltype();
	
	/**
	 * 修改类别
	 */
	public String UPDATE_TYPE_SQL ="update producttype set comment = ?,typename = ? where typeid =?";
	/**
	 * 修改类别方法
	 * @return
	 */
	public boolean updatetype(ProductTypeManageModel type);
	
	/**
	 * 删除类别
	 */
	public String DELETE_TYPE_SQL ="delete from producttype where typeid =?";

	/**
	 * 删除类别
	 */
	public boolean deletetype(int typeid);
	
	/**
	 * 增加类别
	 */
	public String INSERT_PROTYPE_SQL ="insert into producttype (typename,comment) values (?,?)";
	
	/**
	 * 
	 */
	public boolean insertType(ProductTypeManageModel type);
	
	/**
	 * 获得总页数
	 */
	 public String GET_PRODUCT_SHOWPAGES_SQL ="select count(proID) total from storage";
	 
	 /**
	  *总页数方法 
	  *pages = 一页的显示量
	  */
	 public int getProPages(int pages);
	 
	 /**
	  * 向销售产品价格表添加信息
	  */
	 public String INSERT_PRO_PRICEMO_SQL ="insert into sale_price (proid,saleprice,procomd) values(?,?,?)";
	 /**
	  * 向销售产品价格表添加信息
	  */
	 public boolean insertPrice(SalePrices sale);
}
