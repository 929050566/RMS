/**
 * 
 */
package com.aowin.scm.report.storage.dao;

import java.util.List;

import com.aowin.scm.report.storage.pojo.StorageBus;
import com.aowin.scm.utils.BaseDao;

/**
 * ���¼�ҵ�񱨱�
 * @author ��С��
 * date:2018��11��20�� ����8:24:49
 */
public interface StorageBusDAO extends BaseDao {
	/** 
	 * 
	 * @param sd
	 * @param ed
	 * @param page
	 * @param size
	 * @return �ɹ����ţ��������
	 */
	public List<StorageBus> getPurchasebytime(String sd,String ed);
	public String INSTORAGE_SELCETID_BYTIM_SQL = "select purchaseid,inStorageDate from intostorage where inStorageDate>=? and inStorageDate<=? and inState='1' ";
	/** 
	 * 
	 * @param sd
	 * @param ed
	 * @param page
	 * @param size
	 * @return �̵���ⵥ�ţ��������
	 */
	public List<StorageBus> getPurchasePANbytime(String sd,String ed);
	public String INSTORAGE_PANSELCETID_BYTIM_SQL = "select proid,inStorageDate,inNum from intostorage where inStorageDate>=? and inStorageDate<=? and inState='3' ";
	/** 
	 * ���ݲɹ����Ų�ѯ��Ӧ��ϸ��
	 * @param purchaseid
	 * @return ��Ʒ��ţ���Ʒ���ƣ���Ʒ������Ʒ�ܽ��
	 */
	public List<StorageBus>  getdetBYtime(String purchaseid,String intodate);
	public String INSTORAGE_SELECTMINGXIBYID_SQL = "select purchaseid,proid,proname,pronum,totalprice,unitprice from purchase_det where purchaseid=? ";
	/** 
	 * �������۵��Ų�ѯ��Ӧ��ϸ��
	 * @param saleid
	 * @return
	 */
	public List<StorageBus> getSaleDetByTime(String saleid,String outdate);
	public String INSTORAGE_SELECTMINGXISALE = "select salebillid,proid,proname,pronum,totalprice,unitprice from sale_det where salebillid=?";

	//����ҵ���
	/** 
	 * 
	 * @param sd
	 * @param ed
	 * @param page
	 * @param size
	 * @return ���۵��ţ���������
	 */
	public List<StorageBus> getSalebytime(String sd,String ed);
	public String Sale_SELCETID_BYTIM_SQL = "select  salebillid,outStorageDate from outstorage where outStorageDate>=? and outStorageDate<=? and outState='2' ";
	/** 
	 * 
	 * @param sd
	 * @param ed
	 * @param page
	 * @param size
	 * @return �̵���ⵥ�ţ���������
	 */
	public List<StorageBus> getPANSalebytime(String sd,String ed);
	public String Sale_SELCETIDPAN_BYTIM_SQL = "select proid,outStorageDate,outnum from outstorage where outStorageDate>=? and outStorageDate<=? and outState='4' ";
	
	
	public String getName(int proid);
	public String STORAGE_PRONAME_SQL = "select proName from storage where proid = ?";
	
	public String PURCHASE_SELECT_PRICE_SQL ="select totalprices from purchase where purchaseid = ?";
	public float getPtotalprices(String purchaseid);
	
	public float getStotalprices(String salebillid);
	public String SALE_SELECT_PRICES_SQL ="select totalprices from sale where salebillid = ?";

}
