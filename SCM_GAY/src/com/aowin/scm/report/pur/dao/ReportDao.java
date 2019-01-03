package com.aowin.scm.report.pur.dao;



import java.util.List;

import com.aowin.scm.report.pur.pojo.Report;
import com.aowin.scm.utils.BaseDao;

/**
 * @author �濡��
 *date:2018��11��20�� ����6:54:31
 * 
 */
public interface ReportDao extends BaseDao {
	
	/**
	 * ��ȡ�ɹ����ܼ�¼��
	 */
	public String PURCHASE_SELECT_COUNT_SQL = "select count(purchaseid) total from purchase";
	/**
	 * ��ȡ���˽�Ĳɹ�����¼��
	 */
	public String PURCHASE_SELECT_COUNT_SQL_BY_DISPOSESTATE = "select count(purchaseid) total from purchase where disposestate=4";
	/**
	 * ��ѯ���вɹ����ܼ�
	 */
	public String PURCHASE_SELECT_ALLTOTALPRICESE_SQL = "select totalprices from purchase";
	/**
	 * ��ѯ����״̬Ϊ�Ѹ�������˽�Ĳɹ����ܼ�
	 */
	public String PURCHASE_SELECT_TOTALPRICESE_BY_DISPOSESTATA_SQL = "select totalprices from purchase where disposestate=3 or disposestate=4";
	/**
	 * ��ѯ����״̬Ϊ�Ѹ�������˽�Ĳɹ����ܼ�
	 */
	public String PURCHASE_SELECT_ADVANCEPRICESE_BY_DISPOSESTATA_SQL = "select advanceprice from purchase where disposestate=5";
	/**
	 * ��ҳ��ѯ�ɹ�����Ϣ
	 */
	public String PURCHASE_SELECT_ALL_SQL = "select purchaseid,createtime,suppliername,createname,advanceprice,totalprices,paystate,disposestate from purchase order by purchaseid desc limit ?,?";
	/**
	 * ������ݵ�������
	 * @return ���ݵ�������
	 */
	public int getTotalLines();
	/**
	 * ������˽����ݵ�������
	 * @return ���˽����ݵ�������
	 */
	public int getTotalLinesBydisposestate();
	/**
	 * �õ����вɹ����ܼ�
	 * @return �ɹ����ܼۼ���
	 */
	public List<Float> gettotalprices();
	/**
	 * �õ�����״̬Ϊ�Ѹ�������˽�Ĳɹ����ܼ�
	 * @return �ɹ����ܼۼ���
	 */
	public List<Float> gettotalpricesBydisposestate();
	/**
	 * �õ�����״̬Ϊ��Ԥ���Ĳɹ���Ԥ����
	 * @return �ɹ���Ԥ�����
	 */
	public List<Float> getadvancepriceBydisposestate();
	/**
	 * ��ҳ��ʾ�ɹ�����Ϣ
	 * @param page ��ǰҳ
	 * @param size ÿҳ��ʾ����
	 * @return Report����
	 */
	public List<Report> getReport(int page,int size);
	/**
	 * ��ȡ��ҳ��
	 * @param pagesize ÿҳ��ʾ����
	 * @return ��ҳ��
	 */
	public int getTotalPages(int pagesize);
	/**
	 * ͨ��sql��� ��ѯ�ɹ�������
	 * @param sql���
	 * @return ��ѯ�ɹ�������
	 */
	public List<Report> getReportBySql(String sql);
	
}
