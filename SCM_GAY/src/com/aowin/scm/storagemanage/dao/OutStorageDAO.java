/**
 * 
 */
package com.aowin.scm.storagemanage.dao;

import java.util.List;

import com.aowin.scm.storagemanage.pojo.OutStorage;
import com.aowin.scm.utils.BaseDao;

/**
 * �������ģ��ҵ���߼��ӿ� 
 * @author ��С��
 * date:2018��11��15�� ����3:36:28
 * 
 */
public interface OutStorageDAO extends BaseDao {
	/** 
	 * ��ѯ�������Ϣ
	 */
	public String OUTSTORAGE_SELECT_SQL = "select outId,outStorageDate,outHandle,outNum,outState,Reason,sale_detid,salebillid from outStorage";
	
	/** 
	 * ���ݲ�Ʒ��Ų鿴�������Ϣ
	 */
	public String OUTSTORAGE_BIAN_SELECT_BYPURID_SQL = "select outStorageDate,salebillid,outHandle,outNum,outState from outStorage where sale_detid=?";
	/**
	 * �������۵��Ų�ѯ
	 */
	public String OUTSTORAGE_SELECL_BYSALEID_SQL = "select outStorageDate,outHandle,outNum from outStorage where salebillid = ?";
	/** 
	 * ÿ���̵� ʱ��Ӧ ��Ʒ�仯����������ԭ��
	 * ����һ���̵���Ϣ
	 */
	public String OUTSTORAGE_INSERT_SQL = "insert into outstorage(outNum,outstate,outHandle,Reason,proId,outStorageDate) values(?,'4',?,?,?,NOW())";
	/** 
	 * ����һ�г�����Ϣ
	 */
	public String OUTSTORAGE_INSERT_ALL_SQL = "insert into outstorage(outStorageDate,outHandle,outNum,outstate,sale_detid,salebillid) values(NOW(),?,?,'2',?,?)";
	
	/** 
	 * ��ѯ��������������Ϣ
	 * @return ��ѯ�������
	 */
	public List<OutStorage> getOutStorage();
	/** 
	 * ���ݲ�Ʒ��Ż����ؿ������Ϣ
	 * @param sale_detid
	 * @return
	 */
	public List<OutStorage> getOutStorageByid(int sale_detid);
	/** 
	 *  ��ѯ��������������Ϣ
	 * @return ���г���ʱ�䣬��������������Ǽ��˵Ķ���
	 */
	public OutStorage getOut(String salebillid);
	/** 
	 *  ����һ���̵���Ϣ
	 * @return
	 */
	public boolean insertOutPandian(OutStorage storage);
	/** 
	 *  ����һ�г�����Ϣ
	 * @return
	 */
	public boolean insertOutStorage(OutStorage storage);
}
