/**
 * 
 */
package com.aowin.scm.storagemanage.dao;

import java.util.List;

import com.aowin.scm.storagemanage.pojo.Storage;
import com.aowin.scm.utils.BaseDao;



/**
 * @author ��С��
 * date:2018��11��15�� ����10:38:26
 * 
 */
public interface StorageDAO extends BaseDao {
	/** 
	 * ��ѯ��Ʒid�����ƣ���ǰ��棬�ɹ���;����Ԥ������
	 */
	public String STOTRAGE_SELECT_SQL = "select proID,proName,proUnit,presentNum,onPurchaseNum,onPresaleNum from storage";
	/** 
	 * ���ݲ�Ʒ��Ų�ѯ��Ʒid�����ƣ���ǰ��棬�ɹ���;����Ԥ������
	 */
	public String STOTRAGE_SELECT_ALL_SQL = "select proID,proName,proUnit,presentNum,onPurchaseNum,onPresaleNum from storage where proID=?";

	/** 
	 * ����̵��ѯ
	 */
	public String STOTRAGE_SELECT_PAN_SQL = "select proID,proName,presentNum,onPurchaseNum,onPresaleNum from storage ";
	/** 
	 * ����һ�в�Ʒ
	 */
	public String STORAGE_INSERT_SQL = "insert into storage(proID,proName,proUnit,protypeid,presentNum,onPurchaseNum,onPresaleNum) values (?,?,?,?,?,?,?)";
	/** 
	 * ���ʱ���ٲɹ���;�����ӿ��
	 */
	public String STORAGE_RKBYID_SQL = "update storage set onPurchaseNum=onPurchaseNum-? , presentNum=presentNum+? where proID=?";
	/** 
	 * ����ʱ����Ԥ�������ͼ��ٿ��
	 */
	public String STORAGE_CKBYID_SQL ="update storage set onPresaleNum=onPresaleNum-?,presentNum=presentNum-? where proID=?";

	/** 
	 * �޸Ĳɹ���;��
	 */
	public String STORAGE_UPDATE_ONPURCHASENUM_SQL ="update storage set onPurchaseNum=? where proID=?";
	
	/** 
	 * �޸�Ԥ������
	 */
	public String STORAGE_UPDATE_ONPRESALENUM_SQL ="update storage set onPresaleNum=? where proID=?";
	/** 
	 * ���ݲ�Ʒ����޸Ŀ��
	 */
	public String STORAGE_UPDATE_PRESENTNUM_SQL = "update storage set presentNum =? where proID=?";
	/** 
	 * �̵���º��޸Ŀ��
	 * @param proID ��Ʒ���
	 * @param presentNum ��ǰ���
	 * @return �̵���Ƿ��޸Ŀ��ɹ�
	 */
	public boolean updaPersentNum(int proID,int presentNum);
	/** 
	 * ���ʱ���ٲɹ���;�����ӿ��
	 * @param proid ��Ʒ���
	 * @param presentNum ��ǰ���
	 * @param onPurchaseNum �ɹ���;��
	 * @return �Ƿ����ʱ��Ӧ�����޸ĳɹ�
	 */
	public boolean updaRKBID(int proid,int presentNum,int onPurchaseNum);
	/** 
	 * ���ݲ�Ʒ����޸Ĳɹ���;��
	 * @param proID ��Ʒ���
	 * @return �Ƿ��޸Ĳɹ���;���ɹ�
	 */
	public boolean updaPurByProID(int proID,String onPurchaseNum) ;
	/** 
	 * ����ʱ����Ԥ�������ͼ��ٿ��
	 * @param proid ��Ʒ���
	 * @param presentNum Ҫ���ٵĿ����
	 * @param onPresaleNum Ҫ���ٵ�Ԥ������
	 * @return  ����ʱ�Ƿ���Ӧ�����޸ĳɹ�
	 */
	public boolean updaCKBYID(int proid,int presentNum,int onPresaleNum);
	/** 
	 * ���ݲ�Ʒ����޸�Ԥ������
	 * @param proID ��Ʒ���
	 * @return �Ƿ��޸�Ԥ�������ɹ�
	 */
	public boolean updaSaleByProID(int proID,String onPresaleNum);
	/** 
	 * ��ӿ����Ϣ
	 * @param storage ������
	 * @return �Ƿ���ӿ����Ϣ�ɹ�
	 */
	public boolean insertStorage(Storage storage);
	
	/** 
	 * ��ѯ��Ʒid�����ƣ���ǰ��棬�ɹ���;����Ԥ������
	 * @param proID ��ѯ��Ʒid
	 * @return ��Ų�Ʒid������,��λ����ǰ��棬�ɹ���;����Ԥ��������ɵĶ���
	 */
	public Storage getStorageALL(int proID);
	/** 
	 * ��ѯ��Ʒid�����ƣ���ǰ��棬�ɹ���;����Ԥ������
	 * @param proID
	 * @return ��ţ���Ʒid������,��λ����ǰ��棬�ɹ���;����Ԥ��������ɵģ�����ļ���
	 */
	public List<Storage> getStorage(int proID);
	/** 
	 * ����̵��ѯ
	 * @return ��ţ���Ʒid�����ƣ���ǰ��棬�ɹ���;����Ԥ��������ɵģ�����ļ���
	 */
	public List<Storage> getPanStorage();
	
	/**
	 * ��ҳ��ѯ�̵�����Ϣ
	 * @param pages ��ǰҳ
	 * @param pagesize ÿҳ��ʾ����
	 * @return Storage����
	 */
	public List<Storage> getCountStorage(int pages,int pagesize);
	
	/**
	 * ��ȡ����̵���ҳ��
	 * @param pagesize ÿҳ��ʾ����
	 * @return ��ҳ��
	 */
	public int getStorageTotalPages(int pagesize);
	/** 
	 * ��ȡ����̵���ܲ�Ʒ��¼��
	 * @param pagesize
	 * @return ��Ʒ�ܼ�¼��
	 */
	public int getNum(int pagesize);
	
	public List<Storage> getSelect(String sql);
	//=====================����
	/**
	 * �޸���Ʒ��;��
	 */
	
	public String STOTRAGE_UPD_PIO_SQL = "update storage set onPurchaseNum=? where proID=?";
	/**
	 * ��ȡ��Ʒ����
	 */
	
	public String STOTRAGE_SELECT_PIO_SQL = "select proID,proName,proUnit from storage ";
	/**
	 * ������Ʒ��Ϣ
	 * 
	* @return ��Ʒ����
	 */
	public List<Storage> getStorage();
	/**
	 * ������ƷID�޸�����Ʒ����
	 * @param ��ƷID ��Ʒ����
	* @return �Ƿ��޸ĳɹ�
	 */
	public boolean updateOnPurchaseNum(int proID,int num);
	
	
}
