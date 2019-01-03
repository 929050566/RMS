package com.aowin.scm.utils;

import com.aowin.scm.financemanage.dao.FinanceDaoImpl;
import com.aowin.scm.purchasemanager.dao.PurchaseDaoImpl;
import com.aowin.scm.purchasemanager.dao.PurchaseDetDaoImpl;
import com.aowin.scm.report.inventory_report.dao.Inventory_reportDaoImpl;
import com.aowin.scm.report.pur.dao.ReportDaoImpl;
import com.aowin.scm.report.sale.dao.ReportSaleDAOimp;
import com.aowin.scm.report.storage.dao.StorageBusDAOImpl;
import com.aowin.scm.salemanage.dao.ProManageDAOImpl;
import com.aowin.scm.salemanage.dao.SaleDAOImpl;
import com.aowin.scm.salemanage.dao.SaleManageDAOImpl;
import com.aowin.scm.storagemanage.dao.IntoStorageDAOImpl;
import com.aowin.scm.storagemanage.dao.OutStorageDAOImpl;
import com.aowin.scm.storagemanage.dao.StorageDAOImpl;
import com.aowin.scm.supplier.dao.SupplierDaoImpl;

public class DaoFactory {

	public DaoFactory() {
		// TODO Auto-generated constructor stub
	}

	public static BaseDao getInstance(String string) {
		BaseDao baseDao = null;
		if ("SupplierDao".equals(string)) {
			baseDao = new SupplierDaoImpl();
		} else if ("StorageDAO".equals(string)) {
			baseDao = new StorageDAOImpl();
		} else if ("PurchaseDetDao".equals(string)) {
			baseDao = new PurchaseDetDaoImpl();
		} else if ("FinanceDAO".equals(string)) {
			baseDao = new FinanceDaoImpl();
		} else if ("ProManageDAO".equals(string)) {
			baseDao = new ProManageDAOImpl();
		} else if ("SaleManageDAO".equals(string)) {
			baseDao = new SaleManageDAOImpl();
		} else if ("PurchaseDAO".equals(string)) {
			baseDao = new PurchaseDaoImpl();
		} else if ("SaleDAO".equals(string)) {
			baseDao = new SaleDAOImpl();
		} else if ("StorageDAO".equals(string)) {
			baseDao = new StorageDAOImpl();
		} else if ("IntoStorageDAO".equals(string)) {
			baseDao = new IntoStorageDAOImpl();
		} else if ("OutStorageDAO".equals(string)) {
			baseDao = new OutStorageDAOImpl();
		} else if ("PurchaseDAO".equals(string)) {
			baseDao = new PurchaseDaoImpl();
		} else if ("SaleDAO".equals(string)) {
			baseDao = new SaleDAOImpl();
		} else if ("ReportSaleDAO".equals(string)) {
			baseDao = new ReportSaleDAOimp();
		} else if ("ReportDao".equals(string)) {
			baseDao =  new ReportDaoImpl();
		} else if ("Inventory_reportDao".equals(string)) {
			baseDao =  new Inventory_reportDaoImpl();
		} else if ("StorageBusDAO".equals(string)) {
			baseDao =  new StorageBusDAOImpl();
		}
		return baseDao;
	}

}
