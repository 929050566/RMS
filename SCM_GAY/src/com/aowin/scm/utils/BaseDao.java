package com.aowin.scm.utils;

public interface BaseDao {
	/**
	 * ��ҳ��ѯ�̵�����Ϣ
	 */
	public String COUNT_SELECT_STORAGE_SQL = "select proID,proName,presentNum,onPurchaseNum,onPresaleNum from storage order by proID desc limit ?,?";
	
	/**
	 * ��ȡ����Ʒ�ܼ�¼��
	 */
	public String COUNT_SELECT_PRO_SQL = "select count(proID) total from storage";
}
