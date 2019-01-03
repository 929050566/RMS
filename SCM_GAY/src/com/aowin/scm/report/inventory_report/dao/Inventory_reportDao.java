/**
 * 
 */
package com.aowin.scm.report.inventory_report.dao;

import java.util.List;

import com.aowin.scm.report.inventory_report.pojo.Inventory_report;
import com.aowin.scm.utils.BaseDao;

/**
 * @author �濡��
 *date:2018��11��21�� ����11:42:10
 * 
 */
public interface Inventory_reportDao extends BaseDao {

	
	/**
	 * ��ȡ��Ʒ����
	 */
	public String REPORT_SELECT_COUNT_SQL = "select count(proID) total from storage";
	/**
	 * ��ҳ��ѯ��Ʒ��Ϣ
	 */
	public String REPORT_SELECT_ALL_SQL = "select proID,proName,presentNum from storage order by proID desc limit ?,?";
	
	/**
	 * ��ѯ��Ʒ�����Ϣ
	 */
	public String REPORT_SELECT_PRESENTNUM_SQL = "select presentNum from storage ";
	/**
	 * ��ѯ��Ʒ�����Ϣ
	 */
	public String REPORT_SELECT_NAME_BY_ID_SQL = "select proName from storage where proID=? ";
	/**
	 * ������ݵ�������
	 * @return ���ݵ�������
	 */
	public int getTotalLines();
	/**
	 * �õ�������Ʒ�����
	 * @return ��Ʒ���������
	 */
	public List<Integer> gettotalpresentNum();
	/**
	 * ��ҳ��ʾ��Ʒ��Ϣ
	 * @param page ��ǰҳ
	 * @param size ÿҳ��ʾ����
	 * @return Inventory_Report����
	 */
	public List<Inventory_report> getInventory_Report(int page,int size);
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
	public List<Inventory_report> getInventoryBySql(String sql);
	/**
	 * ͨ��sql��� ��ѯ�ɹ�������
	 * @param sql���
	 * @return ��ѯ�ɹ�������
	 */
	public List<Inventory_report> getInInventoryBySql(String sql);
	/**
	 * ͨ����ƷID ��ѯ��Ʒ����
	 * @param id
	 * @return ����
	 */
	public String getNameById(int id);
}
