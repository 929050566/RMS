/**
 * 
 */
package com.aowin.scm.storagemanage.dao;

import java.util.List;

import com.aowin.scm.storagemanage.pojo.IntoStorage;
import com.aowin.scm.utils.BaseDao;

/**
 * ������ģ��ҵ���߼��ӿ� 
 * @author ��С��
 * date:2018��11��15�� ����2:13:48
 * 
 */
public interface IntoStorageDAO extends BaseDao {
	/** 
	 * ��ѯ������Ϣ
	 */
	public String INTOSTORAGE_SELECT_SQL = "select inId,inStorageDate,inoHandle,inNum,inState,Reason,purchase_detid,purchaseid from intoStorage";
	/** 
	 * ���ݲɹ�����ѯ����ĸ�����Ϣ
	 */
	public String INTOSTORAGE_SELECT_BYPURID_SQL = "select inStorageDate,inoHandle,inNum from intoStorage where purchaseid=?";
	/** 
	 * ���ݲ�Ʒ��Ų鿴�������Ϣ
	 */
	public String INTOSTORAGE_BIAN_SELECT_BYPURID_SQL = "select inStorageDate,purchaseid,inoHandle,inNum,inState from intoStorage where purchase_detid=?";
	/** 
	 * ���ݲ�Ʒ��Ų鿴��Ʒ��ϸ���
	 */
	public String INTOSTORAGE_PURD_ETID_BYPURID ="select purchase_detid from intoStorage where purchaseid=?";
	/** 
	 * ÿ���̵� ʱ��Ӧ ��Ʒ�仯����������ԭ��
	 * ����һ���̵���Ϣ
	 */
	public String INTOSTORAGE_INSERT_SQL = "insert into intostorage(inNum,inoHandle,instate,Reason,proId,inStorageDate) values(?,?,'3',?,?,NOW())";
	/** 
	 * ͨ����Ʒ�鿴�����
	 */
	public String INTO_STORAGEPAN_SELECT_SQL = "select inStorageDate,inoHandle,inNum,Reason,purchase_detid from intoStorage where purchase_detid=? and instate=3";
	/** 
	 * ����һ�������Ϣ
	 */
	public String INTOSTORAGE_INSERT_ALL_SQL = "insert into intostorage(inStorageDate,inoHandle,inNum,instate,purchase_detid,purchaseid ) values(NOW(),?,?,'1',?,?)";
	
	/** 
	 * ��ѯ�������������Ϣ
	 * @return ������
	 */
	public List<IntoStorage> getIntoStorage();
	/** 
	 * ���ݲ�Ʒ��Ż����ؿ������Ϣ
	 * @param purchase_detid
	 * @return
	 */
	public List<IntoStorage> getIntoStorageByid(int purchase_detid);
	/** 
	 * ���ݲɹ����Ų�ѯ��������ʱ�䣬�����������⾭����
	 * @param purchaseid
	 * @return ���и�����Ϣ��������
	 */
	public IntoStorage getInto(String purchaseid);
	/** 
	 * ͨ����Ʒ��Ų鿴�����
	 * @return ��Ʒ�������������Ϣ�ļ���
	 */
	public List<IntoStorage> getPAN(int purchase_detid);
	/** 
	 *  ����һ���̵���Ϣ
	 * @return
	 */
	public boolean insertPandian(IntoStorage storage);
	/** 
	 *  ����һ�������Ϣ
	 * @return
	 */
	public boolean insertIntoStorage(IntoStorage storage);
}
