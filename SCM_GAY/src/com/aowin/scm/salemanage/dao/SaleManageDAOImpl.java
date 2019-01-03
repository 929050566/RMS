/**
 * 
 */
package com.aowin.scm.salemanage.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.aowin.scm.purchasemanager.pojo.PurchaseAllInfo;
import com.aowin.scm.purchasemanager.pojo.PurchaseDet;
import com.aowin.scm.salemanage.pojo.FinanceSaleModel;
import com.aowin.scm.salemanage.pojo.OutstorageSaleModel;
import com.aowin.scm.salemanage.pojo.SaleAllInfo;
import com.aowin.scm.salemanage.pojo.SaleManageDetModel;
import com.aowin.scm.salemanage.pojo.SaleMangeModel;
import com.aowin.scm.utils.DBUtil;

/**
 * @author �����
 *
 *         date:2018��11��19�� ����9:30:06
 */
public class SaleManageDAOImpl implements SaleManageDAO {

	private Logger log = Logger.getLogger(this.getClass());

	/**
	 * 
	 */
	public SaleManageDAOImpl() {
		// TODO �Զ����ɵĹ��캯�����
	}

	/*
	 * ���� Javadoc��
	 * 
	 * @see com.aowin.scm.salemanage.dao.SaleManageDAO#getsaleByid(int)
	 */
	@Override
	public SaleMangeModel getsaleByid(int saleid) {
		DBUtil db = new DBUtil();
		PreparedStatement ps = db.getPreparedStatement(GET_SALEDET_ALLMANAGE);

		return null;
	}

	/*
	 * ���� Javadoc��
	 * 
	 * @see com.aowin.scm.salemanage.dao.SaleManageDAO#insertsale(com.aowin.scm.
	 * salemanage.pojo.SaleMangeModel)
	 */
	@Override
	public boolean insertsale(SaleMangeModel sale) {
		DBUtil db = new DBUtil();
		PreparedStatement ps = db.getPreparedStatement(INSERT_SALE_SQL);
		try {
			ps.setString(1, sale.getSaleid());
			ps.setString(2, sale.getCustomername());
			ps.setString(3, sale.getCreatename());
			ps.setDouble(4, sale.getExtramoney());
			ps.setDouble(5, sale.getTotalproprices());
			ps.setString(6, sale.getPaystate());
			ps.setDouble(7, sale.getAdvanceprice());
			ps.setDouble(8, sale.getTotalprices());
			ps.setString(9, sale.getComment());
			int re = ps.executeUpdate();
			if (re != 0) {
				return true;
			}
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		} finally {
			db.psClose(ps);
			db.connClose();
		}
		return false;
	}

	@Override
	public ArrayList<SaleManageDetModel> getsale_det(String salebillid) {
		log.info("��ʼִ��getsale_det(String salebillid)��ͨ�����۵���ŵõ����е�������ϸ");
		DBUtil db = new DBUtil();
		PreparedStatement ps = db.getPreparedStatement(SALEDET_SELECT_SALEID);
		ArrayList<SaleManageDetModel> list = new ArrayList<>();
		ResultSet rs = null;
		try {
			ps.setString(1, salebillid);
			rs = ps.executeQuery();
			while (rs.next()) {
				SaleManageDetModel saleDet = new SaleManageDetModel();
				saleDet.setProduct_id(rs.getInt("proid"));
				saleDet.setProduct_name(rs.getString("proname"));
				saleDet.setProduct_quantity(rs.getInt("pronum"));
				saleDet.setProduct_unit(rs.getString("prounit"));
				saleDet.setProduct_unitprice(rs.getFloat("unitprice"));
				saleDet.setProduct_dettotalprice(rs.getFloat("totalprice"));
				saleDet.setSaleid(salebillid);
				saleDet.setDetid(rs.getInt("detid"));
				list.add(saleDet);
			}
			log.info("�ɹ���ѯ��"+list.size()+"��������ϸ��Ϣ");
		} catch (SQLException e) {
			log.warn("��ѯʧ�ܣ�");
		} finally {
			db.connClose();
			db.psClose(ps);
			db.rsClose(rs);
		}
		db = null;
		return list;
	}
	
	
	/*
	 * ���� Javadoc��
	 * 
	 * @see com.aowin.scm.salemanage.dao.SaleManageDAO#getsale(int, int)
	 */
	@Override
	public ArrayList<SaleMangeModel> getsale(int page, int pa) {
		DBUtil db = new DBUtil();
		PreparedStatement ps = db.getPreparedStatement(GET_SALE_FOREND_SQL);
		ArrayList<SaleMangeModel> ar = new ArrayList<>();
		ResultSet rs = null;
		try {
			ps.setInt(1, page);
			ps.setInt(2, pa);
			rs = ps.executeQuery();
			while (rs.next()) {
				SaleMangeModel sale = new SaleMangeModel();
				sale.setSaleid(rs.getString("salebillid"));
				sale.setCreatetime(rs.getString("createtime"));
				sale.setCustomername(rs.getString("customername"));
				sale.setCreatename(rs.getString("createname"));
				sale.setExtramoney(rs.getFloat("extramoney"));
				sale.setTotalproprices(rs.getFloat("totalproprices"));
				sale.setAdvanceprice(rs.getFloat("advanceprice"));
				sale.setTotalprices(rs.getFloat("totalprices"));
				sale.setPaystate(rs.getString("paystate"));
				sale.setDisposestate(rs.getString("disposestate"));
				ar.add(sale);
			}
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		} finally {
			db.connClose();
			db.psClose(ps);
			db.rsClose(rs);
		}
		db = null;
		return ar;
	}

	/*
	 * ���� Javadoc��
	 * 
	 * @see com.aowin.scm.salemanage.dao.SaleManageDAO#getCustomer(int)
	 */
	@Override
	public String getCustomer(int customerid) {
		// TODO �Զ����ɵķ������
		return null;
	}

	/*
	 * ���� Javadoc��
	 * 
	 * @see com.aowin.scm.salemanage.dao.SaleManageDAO#getOutstorageForSale(int)
	 */
	@Override
	public OutstorageSaleModel getOutstorageForSale(int saleid) {
		// TODO �Զ����ɵķ������
		return null;
	}

	/*
	 * ���� Javadoc��
	 * 
	 * @see com.aowin.scm.salemanage.dao.SaleManageDAO#getFinaceSale(int)
	 */
	@Override
	public FinanceSaleModel getFinaceSale(int saleid) {
		// TODO �Զ����ɵķ������
		return null;
	}

	@Override
	public boolean insertsaledel(SaleManageDetModel saledel) {
		DBUtil db = new DBUtil();
		// insert into sale_det
		// (proid,proname,pronum,prounit,unitprice,totalprice,salebillid) values
		// (?,?,?,?,?,?,?)";
		PreparedStatement ps = db.getPreparedStatement(INSERT_SALEDEL_BYSALEID_SQL);
		try {
			ps.setInt(1, saledel.getProduct_id());
			ps.setString(2, saledel.getProduct_name());
			ps.setInt(3, saledel.getProduct_quantity());
			ps.setString(4, saledel.getProduct_unit());
			ps.setDouble(5, saledel.getProduct_unitprice());
			ps.setDouble(6, saledel.getProduct_dettotalprice());
			ps.setString(7, saledel.getSaleid());
			int i = ps.executeUpdate();
			if (i != 0) {
				return true;
			}
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		} finally {
			db.psClose(ps);
			db.connClose();
		}
		return false;
	}

	/**
	 * �����������۵���Ʒ����
	 * 
	 */
	public boolean insert_stroagenum(SaleManageDetModel saledel) {
		DBUtil db = new DBUtil();
		PreparedStatement ps = db.getPreparedStatement("update storage set onPresaleNum = onPresaleNum + "
				+ saledel.getProduct_quantity() + " where proID = " + saledel.getProduct_id());
		try {
			int re = ps.executeUpdate();
			if (re != 0) {
				return true;
			}
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		return false;
	}

	// ========================�ź�:�����˽���//========================�ź�:�����˽���//========================�ź�:�����˽���
	@Override
	public int getCountByConditionSale() {
		log.info("��ʼִ�� getCountByConditionSale(,��ÿ��տ�Ǽǵ��������۵�����");
		DBUtil db = new DBUtil();
		int count = 0;
		PreparedStatement ps = db.getPreparedStatement(SALE_SELECT_COUNT_CONDITION);
		ResultSet rs = null;
		try {
			rs = ps.executeQuery();
			if (rs.next()) {
				count = rs.getInt("total");
			}
			log.info("�ɹ���ѯ��������Ϊ:" + count);
		} catch (SQLException e) {
			log.warn("��ѯʧ��" + e);
		} finally {
			db.rsClose(rs);
			db.psClose(ps);
			db.connClose();
		}
		db = null;
		return count;
	}

	@Override
	public List<SaleMangeModel> getListByConditionSale(int start, int size) {
		log.info("��ʼִ��getListByConditionSale(int start, int size) ����ѯ�����տ��Ԥ�տ�����۵�");
		DBUtil db = new DBUtil();
		ArrayList<SaleMangeModel> list = new ArrayList<SaleMangeModel>();
		PreparedStatement ps = db.getPreparedStatement(SALE_SELECT_LIST_CONDITION);
		ResultSet rs = null;
		try {
			ps.setInt(1, start);
			ps.setInt(2, size);
			rs = ps.executeQuery();
			while (rs.next()) {
				SaleMangeModel sale = new SaleMangeModel();
				sale.setSaleid(rs.getString("salebillid"));
				sale.setCreatetime(rs.getString("createtime"));
				sale.setCustomername(rs.getString("customername"));
				sale.setCreatename(rs.getString("createname"));
				sale.setExtramoney(rs.getFloat("extramoney"));
				sale.setTotalproprices(rs.getFloat("totalproprices"));
				sale.setAdvanceprice(rs.getFloat("advanceprice"));
				sale.setTotalprices(rs.getFloat("totalprices"));
				sale.setPaystate(rs.getString("paystate"));
				sale.setCloseDate(rs.getString("closeDate"));
				sale.setCloseUser(rs.getString("closeUser"));
				sale.setDisposestate(rs.getString("disposestate"));
				sale.setUserid(rs.getInt("userid"));
				list.add(sale);
			}
			log.info("�ɹ���ѯ��" + list.size() + "���ɹ�������");
		} catch (SQLException e) {
			log.warn("��ѯʧ��" + e);
		} finally {
			db.rsClose(rs);
			db.psClose(ps);
			db.connClose();
		}
		db = null;
		return list;
	}

	@Override
	public int getCountByConditionAndPaystateSale(String paystate) {
		log.info("��ʼִ�� getCountByConditionAndPaystateSale(String paystate)ͨ�����ʽ����ÿ��տ�Ǽǵ��������۵�����");
		DBUtil db = new DBUtil();
		int count = 0;
		PreparedStatement ps = db.getPreparedStatement(SALE_SELECT_COUNT_CONDITION_PAYSTATE);
		ResultSet rs = null;
		try {
			ps.setString(1, paystate);
			rs = ps.executeQuery();
			if (rs.next()) {
				count = rs.getInt("total");
			}
			log.info("�ɹ���ѯ��������Ϊ:" + count);
		} catch (SQLException e) {
			log.warn("��ѯʧ��" + e);
		} finally {
			db.rsClose(rs);
			db.psClose(ps);
			db.connClose();
		}
		db = null;
		return count;
	}

	@Override
	public List<SaleMangeModel> getListByConditionAndPaystateSale(int start, int size, String paystate) {
		log.info("��ʼִ��getListByConditionAndPaystateSale(int start, int size, String paystate)��ͨ������״̬,��ѯ�����տ��Ԥ�տ�����۵�");
		DBUtil db = new DBUtil();
		ArrayList<SaleMangeModel> list = new ArrayList<SaleMangeModel>();
		PreparedStatement ps = db.getPreparedStatement(SALE_SELECT_LIST_CONDITION_PAYSTATE);
		ResultSet rs = null;
		try {
			ps.setString(1, paystate);
			ps.setInt(2, start);
			ps.setInt(3, size);
			rs = ps.executeQuery();
			while (rs.next()) {
				SaleMangeModel sale = new SaleMangeModel();
				sale.setSaleid(rs.getString("salebillid"));
				sale.setCreatetime(rs.getString("createtime"));
				sale.setCustomername(rs.getString("customername"));
				sale.setCreatename(rs.getString("createname"));
				sale.setExtramoney(rs.getFloat("extramoney"));
				sale.setTotalproprices(rs.getFloat("totalproprices"));
				sale.setAdvanceprice(rs.getFloat("advanceprice"));
				sale.setTotalprices(rs.getFloat("totalprices"));
				sale.setPaystate(rs.getString("paystate"));
				sale.setCloseDate(rs.getString("closeDate"));
				sale.setCloseUser(rs.getString("closeUser"));
				sale.setDisposestate(rs.getString("disposestate"));
				sale.setUserid(rs.getInt("userid"));
				list.add(sale);
			}
			log.info("�ɹ���ѯ��" + list.size() + "���ɹ�������");
		} catch (SQLException e) {
			log.warn("��ѯʧ��" + e);
		} finally {
			db.rsClose(rs);
			db.psClose(ps);
			db.connClose();
		}
		db = null;
		return list;
	}

	@Override
	public boolean updateDisposestate(String salebillid, String disposestate,String username) {
		log.info("��ʼִ��updateDisposestate(String salebillid, String disposestate,String username)�޸����۵��ŵ�״̬");
		boolean flag = false;
		DBUtil db = new DBUtil();
		PreparedStatement ps = db.getPreparedStatement(SALE_UPDATE_DISPOSESTATE);
		try {
			ps.setString(1, disposestate);
			ps.setString(2, username);
			ps.setString(3, salebillid);
			int re = ps.executeUpdate();
			if (re != 0) {
				flag = true;
				log.info("�ɹ��޸����۵��Ĵ���״̬");
			} else {
				log.info("���۵��Ŵ���״̬�޸�ʧ��");
			}
		} catch (SQLException e) {
			log.warn("�޸����۵�����״̬�����쳣��" + e);
		}
		return flag;
	}

	@Override
	public int getCountBySql(String sql) {
		log.info("��ʼִ��getCountBySql(String sql)ͨ�����ʽ����ÿ��տ�Ǽǵ��������۵�����");
		DBUtil db = new DBUtil();
		int count = 0;
		PreparedStatement ps = db.getPreparedStatement(sql);
		ResultSet rs = null;
		try {
			rs = ps.executeQuery();
			if (rs.next()) {
				count = rs.getInt(1);
			}
			log.info("�ɹ���ѯ��������Ϊ:" + count);
		} catch (SQLException e) {
			log.warn("��ѯʧ��" + e);
		} finally {
			db.rsClose(rs);
			db.psClose(ps);
			db.connClose();
		}
		db = null;
		return count;
	}

	@Override
	public List<SaleMangeModel> getListBySql(String sql) {
		log.info("��ʼִ��getListBySql(String sql),sql���õ���ѯ�������۵�����");
		DBUtil db = new DBUtil();
		ArrayList<SaleMangeModel> list = new ArrayList<SaleMangeModel>();
		PreparedStatement ps = db.getPreparedStatement(sql);
		ResultSet rs = null;
		try {
			rs = ps.executeQuery();
			while (rs.next()) {
				SaleMangeModel sale = new SaleMangeModel();
				sale.setSaleid(rs.getString("salebillid"));
				sale.setCreatetime(rs.getString("createtime"));
				sale.setCustomername(rs.getString("customername"));
				sale.setCreatename(rs.getString("createname"));
				sale.setExtramoney(rs.getFloat("extramoney"));
				sale.setTotalproprices(rs.getFloat("totalproprices"));
				sale.setAdvanceprice(rs.getFloat("advanceprice"));
				sale.setTotalprices(rs.getFloat("totalprices"));
				sale.setPaystate(rs.getString("paystate"));
				sale.setCloseDate(rs.getString("closeDate"));
				sale.setCloseUser(rs.getString("closeUser"));
				sale.setDisposestate(rs.getString("disposestate"));
				sale.setUserid(rs.getInt("userid"));
				list.add(sale);
			}
			log.info("�ɹ���ѯ��" + list.size() + "�����۵�����");
		} catch (SQLException e) {
			log.warn("��ѯʧ��" + e);
		} finally {
			db.rsClose(rs);
			db.psClose(ps);
			db.connClose();
		}
		db = null;
		return list;
	}

	@Override
	public List<String> getAllCustomerName() {
		log.info("��ʼִ��getAllCustomerName(),�õ����пͻ�����");
		DBUtil db = new DBUtil();
		ArrayList<String> list = new ArrayList<String>();
		PreparedStatement ps = db.getPreparedStatement(SALE_SELECT_CUSTOMERNAME);
		ResultSet rs = null;
		try {
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(rs.getString("customername"));
			}
			log.info("�ɹ���ѯ��" + list.size() + "���ͻ�����");
		} catch (SQLException e) {
			log.warn("��ѯʧ��" + e);
		} finally {
			db.rsClose(rs);
			db.psClose(ps);
			db.connClose();
		}
		db = null;
		return list;
	}

	@Override
	public boolean deleteSale(String salebillid) {
		log.info("��ʼִ��deleteSale(String salebillid),ͨ�����۵����ɾ�����۵�");
		DBUtil db = new DBUtil();
		boolean flag = false;
		PreparedStatement ps = db.getPreparedStatement(SALE_DELETE_SALEBILLID);
		try {
			ps.setString(1, salebillid);
			int i  = ps.executeUpdate();
			if(i > 0 ) {
				flag = true;
				log.info("�ɹ�ɾ���˸����۵�");
			}else {
				log.info("ɾ��ʧ��");
			}
		} catch (SQLException e) {
			log.warn("ɾ��ʧ��" + e);
		} finally {
			db.psClose(ps);
			db.connClose();
		}
		db = null;
		return flag;
	}

	/* (non-Javadoc)
	 * @see com.aowin.scm.salemanage.dao.SaleManageDAO#deleteSaleDet(java.lang.String)
	 */
	@Override
	public boolean deleteSaleDet(String salebillid) {
		log.info("��ʼִ��deleteSaleDet(String salebillid),ͨ�����۵����ɾ��������ϸ");
		DBUtil db = new DBUtil();
		boolean flag = false;
		PreparedStatement ps = db.getPreparedStatement(SALEDET_DELETE_SALEBILLID);
		try {
			ps.setString(1, salebillid);
			int i  = ps.executeUpdate();
			if(i > 0 ) {
				flag = true;
				log.info("�ɹ�ɾ����"+i+"��������ϸ��Ϣ");
			}else {
				log.info("ɾ��ʧ�ܣ�δ�ҵ�������ϸ��Ϣ");
			}
		} catch (SQLException e) {
			log.warn("ɾ��ʧ��" + e);
		} finally {
			db.psClose(ps);
			db.connClose();
		}
		db = null;
		return flag;
	}

	@Override
	public SaleAllInfo getSaleAllInfoBySaleid(String salebillid) {
		log.info("��ʼִ��getSaleAllInfoBySaleid(String salebillid)��ͨ�����۵���ŵĵ����۵������Ϣ");
		SaleAllInfo saleAllInfo = new SaleAllInfo();
		DBUtil db = new DBUtil();
		PreparedStatement ps = db.getPreparedStatement("select * from sale left join outstorage on sale.salebillid = outstorage.salebillid left join finance on sale.salebillid = finance.salebillid where sale.salebillid = ?");
		ResultSet rs = null;
		try {
			ps.setString(1, salebillid);
			System.out.println("salebillid="+salebillid);
			rs = ps.executeQuery();
			if(rs.next()) {
				saleAllInfo.setSaleid(rs.getString("salebillid"));
				saleAllInfo.setCreatetime(rs.getString("createtime"));
				saleAllInfo.setCustomername(rs.getString("customername"));
				saleAllInfo.setCreatename(rs.getString("createname"));
				saleAllInfo.setExtramoney(rs.getFloat("extramoney"));
				saleAllInfo.setTotalproprices(rs.getFloat("totalproprices"));
				saleAllInfo.setAdvanceprice(rs.getFloat("advanceprice"));
				saleAllInfo.setTotalprices(rs.getFloat("totalprices"));
				saleAllInfo.setPaystate(rs.getString("paystate"));
				saleAllInfo.setComment(rs.getString("comment"));
				saleAllInfo.setDisposestate(rs.getString("disposestate"));
				saleAllInfo.setCloseDate(rs.getString("closeDate"));
				saleAllInfo.setCloseUser(rs.getString("closeUser"));
				saleAllInfo.setUserid(rs.getInt("userid"));
				String theway = rs.getString("theway");
				if("1".equals(theway)) {
					saleAllInfo.setPayDate(rs.getString("date"));
					saleAllInfo.setPayHandle(rs.getString("handle"));
				}else if("3".equals(theway)){
					saleAllInfo.setAdvanceDate(rs.getString("date"));
					saleAllInfo.setAdvanceHandle(rs.getString("handle"));
				}
				saleAllInfo.setOutStorageDate(rs.getString("outStorageDate"));
				saleAllInfo.setOutHandle(rs.getString("outHandle"));
				log.info("�ɹ���ѯ�����۵������Ϣ");
			}
		} catch (SQLException e) {
			log.warn("��ѯʧ��"+e);
		}finally {
			db.rsClose(rs);
			db.psClose(ps);;
			db.connClose();
		}
		db = null;
		return saleAllInfo;
	}

	@Override
	public boolean updateSale(SaleMangeModel sale) {
		log.info("����ҵ���߼����� updateSale(SaleMangeModel sale)�޸����۵���Ϣ");
		boolean result = false;
		DBUtil db = new DBUtil();
		PreparedStatement ps = db.getPreparedStatement(SALE_UPDATE_SALEMODEL);
		try {
			ps.setString(1, sale.getPaystate());
			ps.setFloat(2, sale.getExtramoney());
			ps.setFloat(3, sale.getTotalproprices());
			ps.setFloat(4, sale.getAdvanceprice());
			ps.setFloat(5, sale.getTotalprices());
			ps.setString(6, sale.getComment());
			ps.setString(7, sale.getDisposestate());
			ps.setString(8, sale.getSaleid());
			int i = ps.executeUpdate();
			if(i != 0) {
				result = true;
				log.info("�޸����۵��ɹ�");
			}
		} catch (SQLException e) {
			log.warn("�޸����۵�ʧ��: " + e);
		//	e.printStackTrace();
		} finally {
			db.psClose(ps);
			db.connClose();
		}
		db = null;
		return result;
	}

	@Override
	public boolean updateSaleDet(SaleManageDetModel saleDet) {
		log.info("��ʼִ��updateSaleDet(SaleManageDetModel saleDet),ͨ����Ʒ��ϸ�����޸Ĳ�Ʒ��ϸ��");
		DBUtil db = new DBUtil();
		boolean flag = false;
		String PURDET_UPDATE = "update purchase_det set pronum = ?,unitprice= ?,totalprice=? where detid = ?";
		PreparedStatement ps = db.getPreparedStatement(SALEDET_UPDATE_SALEDETMODEL);
		try {
			ps.setInt(1, saleDet.getProduct_quantity());
			ps.setDouble(2, saleDet.getProduct_unitprice());
			ps.setDouble(3, saleDet.getProduct_dettotalprice());
			ps.setInt(4, saleDet.getDetid());
			int i = ps.executeUpdate();
			if(i > 0) {
				flag = true;
				log.info("�޸���ϸ��ɹ���");
			}else {
				log.info("�޸���ϸ��ʧ��");
			}
		} catch (SQLException e) {
			log.warn("�޸���ϸ��ʧ��"+e);
		}finally {
			db.psClose(ps);
			db.connClose();
		}
		db = null;
		return flag;
	}

	/* (non-Javadoc)
	 * @see com.aowin.scm.salemanage.dao.SaleManageDAO#deleteSaleDetByDetid(int)
	 */
	@Override
	public boolean deleteSaleDetByDetid(int detid) {
		log.info("��ʼִ�� deleteSaleDetByDetid(int detid)��ͨ��detidɾ�����۵���ϸ");
		DBUtil db = new DBUtil();
		boolean  flag = false;
		PreparedStatement ps = db.getPreparedStatement(SALEDET_DELETE_DETID);
		try {
			ps.setInt(1, detid);
			int i  = ps.executeUpdate();
			if(i > 0) {
				flag = true;
				log.info("������ϸɾ���ɹ�");
			}
			log.info("ɾ����"+i+"��������ϸ��Ϣ");
		} catch (SQLException e) {
			log.warn("������ϸɾ��ʧ��"+e);
		}finally {
			db.psClose(ps);
			db.connClose();
		}
		db = null;
		return flag;
	}

	

	

}
