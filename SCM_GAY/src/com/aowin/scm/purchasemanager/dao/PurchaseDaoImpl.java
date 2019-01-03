package com.aowin.scm.purchasemanager.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.aowin.scm.purchasemanager.pojo.Purchase;
import com.aowin.scm.purchasemanager.pojo.PurchaseAllInfo;
import com.aowin.scm.purchasemanager.pojo.PurchaseDet;
import com.aowin.scm.utils.DBUtil;

public class PurchaseDaoImpl implements PurchaseDao {
	
	private Logger log = Logger.getLogger(this.getClass());
	public PurchaseDaoImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean insertPurchase(Purchase purchase) {
		log.info("����ҵ���߼�������insertPurchase(Purchase purchase)");
		boolean result = false;
		DBUtil db = new DBUtil();
		PreparedStatement ps = db.getPreparedStatement(PURCHASE_INSERT_SQL);
		try {
			ps.setString(1, purchase.getPurchaseid());
			ps.setString(2, purchase.getCreatetime());
			ps.setString(3, purchase.getSuppliername());
			ps.setString(4, purchase.getCreatename());
			ps.setFloat(5, purchase.getExtramoney());
			ps.setFloat(6, purchase.getTotalproprices());
			ps.setFloat(7, purchase.getAdvanceprice());
			ps.setFloat(8, purchase.getTotalprices());
			
		
			ps.setString(9, purchase.getPaystate());
			ps.setString(10, purchase.getComment());
			ps.setString(11,"1");
			int i = ps.executeUpdate();
			if(i != 0) {
				result = true;
				log.info("�ɹ�����ӳɹ�");
			}
		} catch (SQLException e) {
			log.warn("�ɹ������ʧ��: " + e);
		//	e.printStackTrace();
		} finally {
			db.psClose(ps);
			db.connClose();
		}
		db = null;
		return result;
	}
	@Override
	public boolean deletePurchaseid(String purchaseid) {
		log.info("��ʼִ��deletePurchaseid(int purchaseid) ��ͨ���ɹ�����ɾ���ɹ���");
		DBUtil db = new DBUtil();
		boolean  flag = false;
		PreparedStatement ps = db.getPreparedStatement(PURCHASE_DELETE_SQL);
		try {
			ps.setString(1, purchaseid);
			int i  = ps.executeUpdate();
			if(i > 0) {
				flag = true;
				log.info("�ɹ���ɾ���ɹ�");
			}else {
				log.info("�ɹ���ɾ��ʧ��");
			}
		} catch (SQLException e) {
			log.warn("�ɹ���ɾ��ʧ��"+e);
		}finally {
			db.psClose(ps);
			db.connClose();
		}
		db = null;
		return flag;
	}

	@Override
	public boolean updatePurchase(Purchase purchase) {
		log.info("����ҵ���߼�������updatePurchase(Purchase purchase)�޸Ĳɹ���");
		boolean result = false;
		DBUtil db = new DBUtil();
		PreparedStatement ps = db.getPreparedStatement(PURCHASE_UPDATE);
		try {
			ps.setString(1, purchase.getPaystate());
			ps.setFloat(2, purchase.getExtramoney());
			ps.setFloat(3, purchase.getTotalproprices());
			ps.setFloat(4, purchase.getAdvanceprice());
			ps.setFloat(5, purchase.getTotalprices());
			ps.setString(6, purchase.getComment());
			ps.setString(7, purchase.getDisposestate());
			ps.setString(8, purchase.getPurchaseid());
			int i = ps.executeUpdate();
			if(i != 0) {
				result = true;
				log.info("�ɹ����޸ĳɹ�");
			}
		} catch (SQLException e) {
			log.warn("�ɹ����޸�ʧ��: " + e);
		//	e.printStackTrace();
		} finally {
			db.psClose(ps);
			db.connClose();
		}
		db = null;
		return result;
	}

	@Override
	public boolean updateDisposestate(String purchaseid, String disposestate,String closeUser) {
		log.info("��ʼִ�� updateDisposestate(String purchaseid, String disposestate) ���޸Ĳɹ�������״̬");
		DBUtil db = new DBUtil();
		boolean  flag = false;
		PreparedStatement ps = db.getPreparedStatement(PURCHASE_UPDATE_DISPOSESTATE);
		try {
			ps.setString(1, disposestate);
			ps.setString(2, closeUser);
			ps.setString(3, purchaseid);
			int i  = ps.executeUpdate();
			if(i > 0) {
				flag = true;
				log.info("����״̬�޸ĳɹ�");
			}else {
				log.info("����״̬�޸�ʧ��");
			}
		} catch (SQLException e) {
			log.warn("����״̬�޸�ʧ��"+e);
		}finally {
			db.psClose(ps);
			db.connClose();
		}
		db = null;
		return flag;
	}

	@Override
	public List<Purchase> getSupplier(int pages, int pagesize) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public int getTotalLines() {
		log.info("��ʼִ��getTotalLines()��������purchase���в�ѯ������");
		DBUtil db = new DBUtil();
		int count = 0;
		PreparedStatement ps = db.getPreparedStatement(PURCHASE_SELECT_COUNT_SQL);
		ResultSet rs = null;
		try {
			rs = ps.executeQuery();
			if(rs.next()) {
				count = rs.getInt("total");
				log.info("�ɹ���ѯ����������");
			}
		} catch (SQLException e) {
			log.warn("��ѯʧ��"+e);
		}finally {
			db.rsClose(rs);
			db.psClose(ps);
			db.connClose();
		}
		db = null;
		return count;
	}

	/* (non-Javadoc)
	 * @see com.aowin.scm.purchasemanager.dao.PurchaseDao#getTotalLinesBySql()
	 */
	@Override
	public int getTotalLinesBySql(String sql) {
		log.info("��ʼִ��getTotalLines()��������purchase���в�ѯ������");
		DBUtil db = new DBUtil();
		int count = 0;
		PreparedStatement ps = db.getPreparedStatement(sql);
		ResultSet rs = null;
		try {
			rs = ps.executeQuery();
			if(rs.next()) {
				count = rs.getInt("total");
				log.info("�ɹ���ѯ����������");
			}
		} catch (SQLException e) {
			log.warn("��ѯʧ��"+e);
		}finally {
			db.rsClose(rs);
			db.psClose(ps);
			db.connClose();
		}
		db = null;
		return count;
	}

	@Override
	public List<Purchase> getPurchaseBySql(String sql) {
		log.info("��ʼִ��getPurchaseBySql(String sql)��ͨ��sql����ѯ�ɹ�������");
		DBUtil db = new DBUtil();
		ArrayList<Purchase> list = new ArrayList<Purchase>(); 
		PreparedStatement ps = db.getPreparedStatement(sql);
		ResultSet rs = null;
		try {
			rs = ps.executeQuery();
			while(rs.next()) {
				Purchase purchase = new Purchase();
				purchase.setPurchaseid(rs.getString("purchaseid"));
				purchase.setCreatetime(rs.getString("createtime"));
				purchase.setSuppliername(rs.getString("suppliername"));
				purchase.setCreatename(rs.getString("createname"));
				purchase.setExtramoney(rs.getFloat("extramoney"));
				purchase.setTotalproprices(rs.getFloat("totalproprices"));
				purchase.setAdvanceprice(rs.getFloat("advanceprice"));
				purchase.setTotalprices(rs.getFloat("totalprices"));
				purchase.setPaystate(rs.getString("paystate"));
				purchase.setComment(rs.getString("comment"));
				purchase.setDisposestate(rs.getString("disposestate"));
				purchase.setCloseDate(rs.getString("closeDate"));
				purchase.setCloseUser(rs.getString("closeUser"));
				purchase.setUserid(rs.getInt("userid"));
				list.add(purchase);
			}
			log.info("�ɹ���ѯ��"+list.size()+"���ɹ�������");
		} catch (SQLException e) {
			log.warn("��ѯʧ��"+e);
			log.warn("�����sql���:"+sql);
		}finally {
			db.rsClose(rs);
			db.psClose(ps);
			db.connClose();
		}
		db = null;
		return list;
	}

	@Override
	public List<Purchase> getPurchaseByCondition(int page ,int size) {
		log.info("��ʼִ��getPurchaseByCondition()����ѯ�����˽�Ĳɹ���");
		DBUtil db = new DBUtil();
		ArrayList<Purchase> list = new ArrayList<Purchase>(); 
		PreparedStatement ps = db.getPreparedStatement(PURCHASE_SELECT_FRO_FINISH);
		ResultSet rs = null;
		try {
			ps.setInt(1, page);
			ps.setInt(2, size);
			rs = ps.executeQuery();
			while(rs.next()) {
				Purchase purchase = new Purchase();
				purchase.setPurchaseid(rs.getString("purchaseid"));
				purchase.setCreatetime(rs.getString("createtime"));
				purchase.setSuppliername(rs.getString("suppliername"));
				purchase.setCreatename(rs.getString("createname"));
				purchase.setExtramoney(rs.getFloat("extramoney"));
				purchase.setTotalproprices(rs.getFloat("totalproprices"));
				purchase.setAdvanceprice(rs.getFloat("advanceprice"));
				purchase.setTotalprices(rs.getFloat("totalprices"));
				purchase.setPaystate(rs.getString("paystate"));
				purchase.setComment(rs.getString("comment"));
				purchase.setDisposestate(rs.getString("disposestate"));
				purchase.setCloseDate(rs.getString("closeDate"));
				purchase.setCloseUser(rs.getString("closeUser"));
				purchase.setUserid(rs.getInt("userid"));
				list.add(purchase);
			}
			log.info("�ɹ���ѯ��"+list.size()+"���ɹ�������");
		} catch (SQLException e) {
			log.warn("��ѯʧ��"+e);
		}finally {
			db.rsClose(rs);
			db.psClose(ps);
			db.connClose();
		}
		db = null;
		return list;
	}

	@Override
	public int getPurchaseCount() {
		log.info("��ʼִ��getPurchaseCount()����ѯ�����˽�Ĳɹ�����������");
		DBUtil db = new DBUtil();
		PreparedStatement ps = db.getPreparedStatement(PURCHASE_SELECT_FRO_FINISH_ACCOUNT);
		ResultSet rs = null;
		int count = 0;
		try {
			rs = ps.executeQuery();
			if(rs.next()) {
				count = rs.getInt("total");
			}
			log.info("�ɹ���ѯ��"+count+"���˽�ɹ�������");
		} catch (SQLException e) {
			log.warn("��ѯʧ��"+e);
		}finally {
			db.rsClose(rs);
			db.psClose(ps);
			db.connClose();
		}
		db = null;
		return count;
	}

	@Override
	public  List<Purchase> getPurchaseConditionByPaystate(int page,int size ,String paystate) {
		log.info("��ʼִ��getPurchaseConditionByPaystate(int page,int size ,String paystate)��ͨ�����ʽ��ѯ�����˽�Ĳɹ���");
		DBUtil db = new DBUtil();
		ArrayList<Purchase> list = new ArrayList<Purchase>(); 
		PreparedStatement ps = db.getPreparedStatement(PURCHASE_SELECT_FRO_FINISH_BY_PAYSTATE);
		ResultSet rs = null;
		try {
			ps.setString(1, paystate);
			ps.setInt(2, page);
			ps.setInt(3, size);
			rs = ps.executeQuery();
			while(rs.next()) {
				Purchase purchase = new Purchase();
				purchase.setPurchaseid(rs.getString("purchaseid"));
				purchase.setCreatetime(rs.getString("createtime"));
				purchase.setSuppliername(rs.getString("suppliername"));
				purchase.setCreatename(rs.getString("createname"));
				purchase.setExtramoney(rs.getFloat("extramoney"));
				purchase.setTotalproprices(rs.getFloat("totalproprices"));
				purchase.setAdvanceprice(rs.getFloat("advanceprice"));
				purchase.setTotalprices(rs.getFloat("totalprices"));
				purchase.setPaystate(rs.getString("paystate"));
				purchase.setComment(rs.getString("comment"));
				purchase.setDisposestate(rs.getString("disposestate"));
				purchase.setCloseDate(rs.getString("closeDate"));
				purchase.setCloseUser(rs.getString("closeUser"));
				purchase.setUserid(rs.getInt("userid"));
				list.add(purchase);
			}
			log.info("�ɹ���ѯ��"+list.size()+"���ɹ�������");
		} catch (SQLException e) {
			log.warn("��ѯʧ��"+e);
		}finally {
			db.rsClose(rs);
			db.psClose(ps);
			db.connClose();
		}
		db = null;
		return list;
	}
	
	
	@Override
	public int getPurchaseConditionCountByPaystate(String paystate) {
		log.info("��ʼִ��  getPurchaseConditionCountByPaystate(String paystate)��ͨ������״̬��ѯ�����˽�Ĳɹ���������������");
		DBUtil db = new DBUtil();
		PreparedStatement ps = db.getPreparedStatement(PURCHASE_SELECT_FOR_FINISH_ACCOUNT_PAYSTATE);
		ResultSet rs = null;
		int count = 0;
		try {
			ps.setString(1, paystate);
			rs = ps.executeQuery();
			if(rs.next()) {
				count = rs.getInt("total");
			}
			log.info("�ɹ���ѯ��"+count+"���˽�ɹ�������");
		} catch (SQLException e) {
			log.warn("��ѯʧ��"+e);
		}finally {
			db.rsClose(rs);
			db.psClose(ps);
			db.connClose();
		}
		db = null;
		return count;
	}

	@Override
	public PurchaseAllInfo getPurPurchaseAllInfoByPurchaseid(String purchaseid) {
		log.info("��ʼִ��getPurPurchaseAllInfoByPurchaseid(String purchaseid) ��ͨ��������ţ��õ��òɹ���������������Ϣ");
		PurchaseAllInfo purAllInfo = new PurchaseAllInfo();
		DBUtil db = new DBUtil();
		String sql = "select * from purchase where purchaseid = ?";
		PreparedStatement ps1 = db.getPreparedStatement(sql);
		ResultSet rs1 = null;
		sql = "select date,handle from finance where purchaseid = ? and theway = '2' ";
		PreparedStatement ps2 = db.getPreparedStatement(sql);
		ResultSet rs2 = null;
		sql = "select date,handle from finance where purchaseid = ? and theway = '4' ";
		PreparedStatement ps3 = db.getPreparedStatement(sql);
		ResultSet rs3 = null;
		sql = "select inStorageDate,inoHandle from intostorage where purchaseid = ?  ";
		PreparedStatement ps4 = db.getPreparedStatement(sql);
		ResultSet rs4 = null;
		try {
			ps1.setString(1, purchaseid);
			rs1 = ps1.executeQuery();
			if(rs1.next()) {
				purAllInfo.setPurchaseid(rs1.getString("purchaseid"));
				purAllInfo.setCreatetime(rs1.getString("createtime"));
				purAllInfo.setSuppliername(rs1.getString("suppliername"));
				purAllInfo.setCreatename(rs1.getString("createname"));
				purAllInfo.setExtramoney(rs1.getFloat("extramoney"));
				purAllInfo.setTotalproprices(rs1.getFloat("totalproprices"));
				purAllInfo.setAdvanceprice(rs1.getFloat("advanceprice"));
				purAllInfo.setTotalprices(rs1.getFloat("totalprices"));
				purAllInfo.setPaystate(rs1.getString("paystate"));
				purAllInfo.setComment(rs1.getString("comment"));
				purAllInfo.setDisposestate(rs1.getString("disposestate"));
				purAllInfo.setCloseDate(rs1.getString("closeDate"));
				purAllInfo.setCloseUser(rs1.getString("closeUser"));
				purAllInfo.setUserid(rs1.getInt("userid"));
				log.info("�ɹ���ѯ�ɹ�����Ϣ");
			}
			ps2.setString(1,purchaseid);
			rs2 = ps2.executeQuery();
			if(rs2.next()) {
				purAllInfo.setPayDate(rs2.getString("date"));
				purAllInfo.setPayHandle(rs2.getString("handle"));
				log.info("�ɹ���ѯ������Ϣ��Ϣ");
			}
			ps3.setString(1,purchaseid);
			rs3 = ps3.executeQuery();
			if(rs3.next()) {
				purAllInfo.setAdvanceDate(rs2.getString("date"));
				purAllInfo.setAdvanceHandle(rs2.getString("handle"));
				log.info("�ɹ���ѯԤ������Ϣ��Ϣ");
			}
			ps4.setString(1,purchaseid);
			rs4 = ps4.executeQuery();
			if(rs4.next()) {
				purAllInfo.setInStorageDate(rs4.getString("inStorageDate"));
				purAllInfo.setInoHandle(rs4.getString("inoHandle"));
				log.info("�ɹ���ѯ�����Ϣ");
			}
		} catch (SQLException e) {
			log.warn("��ѯʧ��"+e);
		}finally {
			db.rsClose(rs1);db.rsClose(rs2);db.rsClose(rs3);db.rsClose(rs4);
			db.psClose(ps1);db.psClose(ps2);db.psClose(ps3);db.psClose(ps4);
			db.connClose();
		}
		db = null;
		return purAllInfo;
	}
	//======С��======С��======С��======С��======С��======С��======С��======С��======С��
	
	/* (non-Javadoc)
	 * @see com.aowin.scm.purchasemanage.dao.PurchaseDAO#getPurchaseBYDisposestate(int, int)
	 */
	@Override
	public List<Purchase> getPurchaseBYDisposestate(int pages, int pagesize) {
		log.info("����ҵ���߼�������getPurchaseBYDisposestate(int pages, int pagesize)");
		List<Purchase> list = new ArrayList<>();
		DBUtil db = new DBUtil();
		PreparedStatement ps = db.getPreparedStatement(PURCHASE_RK_ALL_SQL);
		ResultSet rs = null;
		try {
			ps.setInt(1, (pages-1)*pagesize);
			ps.setInt(2, pagesize);
			rs = ps.executeQuery();
			while(rs.next()) {
				Purchase p = new  Purchase();
				p.setPurchaseid(rs.getString("purchaseid"));
				p.setCreatetime(rs.getString("createtime"));
				p.setSuppliername(rs.getString("suppliername"));
				p.setCreatename(rs.getString("createname"));
				p.setExtramoney(rs.getFloat("extramoney"));
				p.setTotalprices(rs.getFloat("totalprices"));
				p.setTotalproprices(rs.getFloat("totalproprices"));
				p.setPaystate(rs.getString("paystate"));
				p.setAdvanceprice(rs.getFloat("advanceprice"));
				p.setDisposestate(rs.getString("disposestate"));
				list.add(p);
			}
		} catch (SQLException e) {
			log.warn("���ݲ�ѯʧ��: " + e);
		} finally {
			db.rsClose(rs);
			db.psClose(ps);
			db.connClose();
		}
		db = null; 
		return list;
	}

	/* (non-Javadoc)
	 * @see com.aowin.scm.purchasemanage.dao.PurchaseDAO#getPurchaseAllTotalPages(int)
	 */
	@Override
	public int getPurchaseAllTotalPages(int pagesize) {
		log.info("����ҵ���߼�������getPurchaseAllTotalPages(int pagesize) ");
		int totalpages = 1;
		
		DBUtil db = new DBUtil();
		PreparedStatement ps = db.getPreparedStatement(PURCHASE_RK_ALL_SQL);
		ResultSet rs = null;
		try {
			rs = ps.executeQuery();
			//rs.next();
			int t = 0;
			while(rs.next()) {
				t++; }
			int totalrecords = t;
		
			totalpages = (totalrecords%pagesize==0?0:1) + totalrecords/pagesize;   
		} catch (SQLException e) {
			log.warn("���ݲ�ѯʧ��: " + e);
		} finally {
			db.rsClose(rs);
			db.psClose(ps);
			db.connClose();
		}		
		if(totalpages == 0) {
			totalpages = 1;
		}
		db = null;
		return totalpages;
	}
	public int getALL(int pagesize) {
		log.info("����ҵ���߼�������getALL(int pagesize) ");
		int totalpages = 0;
	
		DBUtil db = new DBUtil();
		PreparedStatement ps = db.getPreparedStatement("select purchaseid,createtime,suppliername,createname,extramoney,totalproprices,totalprices,paystate,advanceprice,disposestate from Purchase where (disposestate=1 and paystate=1) or (disposestate=3 and paystate=2) or (disposestate=5 and paystate=3)");
		ResultSet rs = null;
		try {
			rs = ps.executeQuery();
			int t = 0;
			while(rs.next()) {
				t++; }
			totalpages = t;
		} catch (SQLException e) {
			log.warn("���ݲ�ѯʧ��: " + e);
		} finally {
			db.rsClose(rs);
			db.psClose(ps);
			db.connClose();
		}		
			db = null;
			return totalpages;
	} 
	/* (non-Javadoc)
	 * @see com.aowin.scm.purchasemanage.dao.PurchaseDAO#getPurchaseBYPaystate1(int, int)
	 */
	@Override
	public List<Purchase> getPurchaseBYPaystate1(int pages, int pagesize) {
		log.info("����ҵ���߼�������getPurchaseBYPaystate1(int pages, int pagesize)");
		List<Purchase> list = new ArrayList<>();
		DBUtil db = new DBUtil();
		PreparedStatement ps = db.getPreparedStatement(PURCHASE_HD_ALL_SQL);
		ResultSet rs = null;
		try {
			ps.setInt(1, (pages-1)*pagesize);
			ps.setInt(2, pagesize);
			rs = ps.executeQuery();
			while(rs.next()) {
				Purchase p = new  Purchase();
				p.setPurchaseid(rs.getString("purchaseid"));
				p.setCreatetime(rs.getString("createtime"));
				p.setSuppliername(rs.getString("suppliername"));
				p.setCreatename(rs.getString("createname"));
				p.setExtramoney(rs.getFloat("extramoney"));
				p.setTotalprices(rs.getFloat("totalprices"));
				p.setTotalproprices(rs.getFloat("totalproprices"));
				p.setPaystate(rs.getString("paystate"));
				p.setAdvanceprice(rs.getFloat("advanceprice"));
				p.setDisposestate(rs.getString("disposestate"));
				list.add(p);
			}
		} catch (SQLException e) {
			log.warn("���ݲ�ѯʧ��: " + e);
		} finally {
			db.rsClose(rs);
			db.psClose(ps);
			db.connClose();
		}
		db = null; 
		return list;
	}

	/* (non-Javadoc)
	 * @see com.aowin.scm.purchasemanage.dao.PurchaseDAO#getPurchasePaystate1TotalPages(int)
	 */
	@Override
	public int getPurchasePaystate1TotalPages(int pagesize) {
		log.info("����ҵ���߼�������getPurchasePaystate1TotalPages(int pagesize) ");
		int totalpages = 1;
		
		DBUtil db = new DBUtil();
		PreparedStatement ps = db.getPreparedStatement(PURCHASE_HD_ALL_SQL);
		ResultSet rs = null;
		try {
			rs = ps.executeQuery();
			//rs.next();
			int t = 0;
			while(rs.next()) {
				t++; }
			int totalrecords = t;
		
			totalpages = (totalrecords%pagesize==0?0:1) + totalrecords/pagesize;   
		} catch (SQLException e) {
			log.warn("���ݲ�ѯʧ��: " + e);
		} finally {
			db.rsClose(rs);
			db.psClose(ps);
			db.connClose();
		}		
		if(totalpages == 0) {
			totalpages = 1;
		}
		db = null;
		return totalpages;
	}
	public int getPaystate1ALL(int pagesize) {
		log.info("����ҵ���߼�������getPaystate1ALL(int pagesize) ");
		int totalpages = 0;
	
		DBUtil db = new DBUtil();
		PreparedStatement ps = db.getPreparedStatement("select purchaseid,createtime,suppliername,createname,extramoney,totalproprices,totalprices,paystate,advanceprice,disposestate from Purchase where disposestate=1 and paystate=1");
		ResultSet rs = null;
		try {
			rs = ps.executeQuery();
			int t = 0;
			while(rs.next()) {
				t++; }
			totalpages = t;
		} catch (SQLException e) {
			log.warn("���ݲ�ѯʧ��: " + e);
		} finally {
			db.rsClose(rs);
			db.psClose(ps);
			db.connClose();
		}		
			db = null;
			return totalpages;
	} 
	/* (non-Javadoc)
	 * @see com.aowin.scm.purchasemanage.dao.PurchaseDAO#getPurchaseBYPaystate2(int, int)
	 */
	@Override
	public List<Purchase> getPurchaseBYPaystate2(int pages, int pagesize) {
		log.info("����ҵ���߼�������getPurchaseBYPaystate2(int pages, int pagesize)");
		List<Purchase> list = new ArrayList<>();
		DBUtil db = new DBUtil();
		PreparedStatement ps = db.getPreparedStatement(PURCHASE_KD_ALL_SQL);
		ResultSet rs = null;
		try {
			ps.setInt(1, (pages-1)*pagesize);
			ps.setInt(2, pagesize);
			rs = ps.executeQuery();
			while(rs.next()) {
				Purchase p = new  Purchase();
				p.setPurchaseid(rs.getString("purchaseid"));
				p.setCreatetime(rs.getString("createtime"));
				p.setSuppliername(rs.getString("suppliername"));
				p.setCreatename(rs.getString("createname"));
				p.setExtramoney(rs.getFloat("extramoney"));
				p.setTotalprices(rs.getFloat("totalprices"));
				p.setTotalproprices(rs.getFloat("totalproprices"));
				p.setPaystate(rs.getString("paystate"));
				p.setAdvanceprice(rs.getFloat("advanceprice"));
				p.setDisposestate(rs.getString("disposestate"));
				list.add(p);
			}
		} catch (SQLException e) {
			log.warn("���ݲ�ѯʧ��: " + e);
		} finally {
			db.rsClose(rs);
			db.psClose(ps);
			db.connClose();
		}
		db = null; 
		return list;
	}

	/* (non-Javadoc)
	 * @see com.aowin.scm.purchasemanage.dao.PurchaseDAO#getPurchasePaystate2TotalPages(int)
	 */
	@Override
	public int getPurchasePaystate2TotalPages(int pagesize) {
		log.info("����ҵ���߼�������getPurchasePaystate2TotalPages(int pagesize) ");
		int totalpages = 1;
		
		DBUtil db = new DBUtil();
		PreparedStatement ps = db.getPreparedStatement(PURCHASE_KD_ALL_SQL);
		ResultSet rs = null;
		try {
			rs = ps.executeQuery();
			//rs.next();
			int t = 0;
			while(rs.next()) {
				t++; }
			int totalrecords = t;
		
			totalpages = (totalrecords%pagesize==0?0:1) + totalrecords/pagesize;   
		} catch (SQLException e) {
			log.warn("���ݲ�ѯʧ��: " + e);
		} finally {
			db.rsClose(rs);
			db.psClose(ps);
			db.connClose();
		}		
		if(totalpages == 0) {
			totalpages = 1;
		}
		db = null;
		return totalpages;
	}
	public int getPaystate2ALL(int pagesize) {
		log.info("����ҵ���߼�������getPaystate2ALL(int pagesize) ");
		int totalpages = 0;
	
		DBUtil db = new DBUtil();
		PreparedStatement ps = db.getPreparedStatement("select purchaseid,createtime,suppliername,createname,extramoney,totalproprices,totalprices,paystate,advanceprice,disposestate from Purchase where disposestate=3 and paystate=2");
		ResultSet rs = null;
		try {
			rs = ps.executeQuery();
			int t = 0;
			while(rs.next()) {
				t++; }
			totalpages = t;
		} catch (SQLException e) {
			log.warn("���ݲ�ѯʧ��: " + e);
		} finally {
			db.rsClose(rs);
			db.psClose(ps);
			db.connClose();
		}		
			db = null;
			return totalpages;
	} 

	/* (non-Javadoc)
	 * @see com.aowin.scm.purchasemanage.dao.PurchaseDAO#getPurchaseBYPaystate3(int, int)
	 */
	@Override
	public List<Purchase> getPurchaseBYPaystate3(int pages, int pagesize) {
		log.info("����ҵ���߼�������getPurchaseBYPaystate3(int pages, int pagesize)");
		List<Purchase> list = new ArrayList<>();
		DBUtil db = new DBUtil();
		PreparedStatement ps = db.getPreparedStatement(PURCHASE_YF_ALL_SQL);
		ResultSet rs = null;
		try {
			ps.setInt(1, (pages-1)*pagesize);
			ps.setInt(2, pagesize);
			rs = ps.executeQuery();
			while(rs.next()) {
				Purchase p = new  Purchase();
				p.setPurchaseid(rs.getString("purchaseid"));
				p.setCreatetime(rs.getString("createtime"));
				p.setSuppliername(rs.getString("suppliername"));
				p.setCreatename(rs.getString("createname"));
				p.setExtramoney(rs.getFloat("extramoney"));
				p.setTotalprices(rs.getFloat("totalprices"));
				p.setTotalproprices(rs.getFloat("totalproprices"));
				p.setPaystate(rs.getString("paystate"));
				p.setAdvanceprice(rs.getFloat("advanceprice"));
				p.setDisposestate(rs.getString("disposestate"));
				list.add(p);
			}
		} catch (SQLException e) {
			log.warn("���ݲ�ѯʧ��: " + e);
		} finally {
			db.rsClose(rs);
			db.psClose(ps);
			db.connClose();
		}
		db = null; 
		return list;
	}

	/* (non-Javadoc)
	 * @see com.aowin.scm.purchasemanage.dao.PurchaseDAO#getPurchasePaystate3TotalPages(int)
	 */
	@Override
	public int getPurchasePaystate3TotalPages(int pagesize) {
		log.info("����ҵ���߼�������getPurchasePaystate3TotalPages(int pagesize) ");
		int totalpages = 1;
		
		DBUtil db = new DBUtil();
		PreparedStatement ps = db.getPreparedStatement(PURCHASE_YF_ALL_SQL);
		ResultSet rs = null;
		try {
			rs = ps.executeQuery();
			//rs.next();
			int t = 0;
			while(rs.next()) {
				t++; }
			int totalrecords = t;
		
			totalpages = (totalrecords%pagesize==0?0:1) + totalrecords/pagesize;   
		} catch (SQLException e) {
			log.warn("���ݲ�ѯʧ��: " + e);
		} finally {
			db.rsClose(rs);
			db.psClose(ps);
			db.connClose();
		}		
		if(totalpages == 0) {
			totalpages = 1;
		}
		db = null;
		return totalpages;
	}
	/**
	 * ��ѯԤ����ʽ��������
	 * @param pagesize
	 * @return
	 */
	public int getPaystate3ALL(int pagesize) {
		log.info("����ҵ���߼�������getPaystate2ALL(int pagesize) ");
		int totalpages = 0;
		DBUtil db = new DBUtil();
		PreparedStatement ps = db.getPreparedStatement(PURCHASE_SELECT);
		ResultSet rs = null;
		try {
			rs = ps.executeQuery();
			int t = 0;
			while(rs.next()) {
				t++; }
			totalpages = t;
		} catch (SQLException e) {
			log.warn("���ݲ�ѯʧ��: " + e);
		} finally {
			db.rsClose(rs);
			db.psClose(ps);
			db.connClose();
		}		
			db = null;
			return totalpages;
	}

	/* (non-Javadoc)
	 * @see com.aowin.scm.purchasemanage.dao.PurchaseDAO#updaBYID(java.lang.String)
	 */
	@Override
	public boolean updaBYID(String purchaseid,String disposestate) {
		log.info("����ҵ���߼�������updaBYID(String purchaseid)");
		boolean result = false;
		DBUtil db = new DBUtil();
		PreparedStatement ps = db.getPreparedStatement(PURCHASE_UPDA_SQL);
		try {
			ps.setString(1, disposestate);
			ps.setString(2, purchaseid);
			int i = ps.executeUpdate();
			if(i != 0) {
				result = true;
			}
		} catch (SQLException e) {
			log.info("����ҵ���߼�������updaBYID(String purchaseid)ʧ��"+e);
		} finally {
			db.psClose(ps);
			db.connClose();
		}
		db =  null;
		return result;
	}

	/* (non-Javadoc)
	 * @see com.aowin.scm.purchasemanage.dao.PurchaseDAO#getDet(int, java.lang.String)
	 */
	@Override
	public int getDet(int proid, String purchaseid) {
		int result = 0;
		log.info("����ҵ����false��������getDet(int proid, String purchaseid)");
		DBUtil db = new DBUtil();
		PreparedStatement ps = db.getPreparedStatement(PURCHAASEDET_SELECT_BYTWOID_SQL);
		ResultSet rs = null;
		try {
			ps.setInt(1, proid);
			ps.setString(2, purchaseid);
			rs = ps.executeQuery();
			result=rs.getInt("pronum");
			
		} catch (SQLException e) {
			log.warn("��Ʒ�������ݲ�ѯʧ��: " + e);
		} finally {
			db.rsClose(rs);
			db.psClose(ps);
			db.connClose();
		}
		db = null; 
		
		
		return result;
	}

	/* (non-Javadoc)
	 * @see com.aowin.scm.purchasemanage.dao.PurchaseDAO#getDet(java.lang.String)
	 */
	@Override
	public int getDet(String purchaseid) {
		int result = 0;
		log.info("����ҵ����false��������getDet(String purchaseid)");
		DBUtil db = new DBUtil();
		PreparedStatement ps = db.getPreparedStatement(PURCHAASEDET_SELECTPROID_BYID_SQL);
		ResultSet rs = null;
		try {
			ps.setString(1, purchaseid);
			rs = ps.executeQuery();
			result=rs.getInt("proid");
			
		} catch (SQLException e) {
			log.warn("��Ʒid���ݲ�ѯʧ��: " + e);
		} finally {
			db.rsClose(rs);
			db.psClose(ps);
			db.connClose();
		}
		db = null; 
		
		
		return result;
	}

	/* (non-Javadoc)
	 * @see com.aowin.scm.purchasemanage.dao.PurchaseDAO#getproid(java.lang.String)
	 */
	@Override
	public List<PurchaseDet> getproid(String saleid) {
		log.info("��ʼִ��getproid(String saleid)");
		DBUtil db = new DBUtil();
		ArrayList<PurchaseDet> list = new ArrayList<PurchaseDet>(); 
		PreparedStatement ps = db.getPreparedStatement(PUREDET_PROIDSELECT_SQL);
		ResultSet rs = null;
		try {
			ps.setString(1, saleid);
			rs = ps.executeQuery();
			while(rs.next()) {
				PurchaseDet S = new PurchaseDet();
				S.setPronum(rs.getInt("pronum"));
				S.setProid(rs.getInt("proid"));
				S.setDetid(rs.getInt("detid"));
				list.add(S);
			}
			log.info("�ɹ���ѯ��"+list.size()+"������ϸ������");
		} catch (SQLException e) {
			log.warn("��ѯʧ��"+e);
		}finally {
			db.rsClose(rs);
			db.psClose(ps);
			db.connClose();
		}
		db = null;
		return list;
	} 
	
	
}
