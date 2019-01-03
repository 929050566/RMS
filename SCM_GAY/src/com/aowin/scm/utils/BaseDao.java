package com.aowin.scm.utils;

public interface BaseDao {
	/**
	 * 分页查询盘点库存信息
	 */
	public String COUNT_SELECT_STORAGE_SQL = "select proID,proName,presentNum,onPurchaseNum,onPresaleNum from storage order by proID desc limit ?,?";
	
	/**
	 * 获取库存产品总记录数
	 */
	public String COUNT_SELECT_PRO_SQL = "select count(proID) total from storage";
}
