/**
 * 
 */
package com.aowin.scm.salemanage.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.aowin.scm.salemanage.pojo.ProductManageModle;
import com.aowin.scm.salemanage.pojo.ProductTypeManageModel;
import com.aowin.scm.salemanage.pojo.SalePrices;
import com.aowin.scm.utils.DBUtil;

/**
 * @author 葛金铭
 *
 * date:2018年11月15日 下午4:00:56
 */
public class ProManageDAOImpl implements ProManageDAO {
	
	private Logger log = Logger.getLogger(this.getClass());
	/**
	 * ProManageDAO的实现类
	 */
	public ProManageDAOImpl() {
		// TODO 自动生成的构造函数存根
	}

	@Override
	public ProductManageModle getProduct(int productid) {
		DBUtil db = new DBUtil();
		PreparedStatement ps = db.getPreparedStatement(GET_PRODUCT_BYID_SQL);
		ResultSet rs = null;
		ProductManageModle product= new ProductManageModle();
		try {
			ps.setInt(1, productid);
			rs = ps.executeQuery();
			//proID,proName,proUnit,presentNum,onPurchaseNum,onPresaleNum,protypeid
			if(rs.next()) {
				product.setProduct_id(rs.getInt("proID"));
				product.setProduct_name(rs.getString("proName"));
				//通过类别id获得类别信息
				ProductTypeManageModel pt = getprotype(rs.getInt("protypeid"));
				product.setProduct_type(pt.getProduct_typename());
				product.setProduct_unit(rs.getString("proUnit"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			db.psClose(ps);
			db.connClose();
			db.rsClose(rs);
		}
		db = null;
		return product;
	}

	@Override
	public ArrayList<ProductManageModle> getallproduct(int start, int pa) {
		DBUtil db = new DBUtil();
		PreparedStatement ps = db.getPreparedStatement(GET_ALL_PRODUCT_SQL);
		ArrayList<ProductManageModle> pm = new ArrayList<>();
		ResultSet rs = null;
		try {
			ps.setInt(1, start);
			ps.setInt(2, pa);
			rs = ps.executeQuery();
			while(rs.next()) {
//proID,proName,proUnit,presentNum,onPurchaseNum,onPresaleNum,protypeid
				ProductManageModle pmm = new ProductManageModle();
				ProductTypeManageModel type = new ProductTypeManageModel();
				pmm.setProduct_id(rs.getInt("proID"));
				pmm.setProduct_name(rs.getString("proName"));
				pmm.setProduct_unit(rs.getString("proUnit"));
				type = getprotype(rs.getInt("protypeid"));
				pmm.setProduct_type(type.getProduct_typename());
				pm.add(pmm);
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return pm;
	}

	@Override
	public boolean update_pro(int proid) {
		// TODO 自动生成的方法存根
		return false;
	}

	@Override
	public boolean insert_pro(ProductManageModle pro) {
		DBUtil db = new DBUtil();
		PreparedStatement ps =db.getPreparedStatement(INSERT_PRODUCT_SQL);
		//(proName,proUnit,presentNum) values(?,?,?)
		try {
			ps.setString(1, pro.getProduct_name());
			ps.setString(2, pro.getProduct_unit());
			ps.setInt(3, 0);
			ps.setInt(4, getTypeIdByName(pro.getProduct_type()));
			int i = ps.executeUpdate();
			if(i!=0) {
				return true;
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}finally {
			db.connClose();
			db.psClose(ps);
		}
		return false;
	}
	//通过产品类型名字得到类型id
	public int getTypeIdByName(String name) {
		log.info("开始执行 getTypeIdByName(String name)方法,通过分类名称得到分类id");
		DBUtil db = new DBUtil();
		String PROTYPE_SELECT_NAME = "select typeid from producttype where typename = ?";
		PreparedStatement ps =db.getPreparedStatement(PROTYPE_SELECT_NAME);
		int count = 0;
		ResultSet rs = null;
		try {
			ps.setString(1, name);
			rs = ps.executeQuery();
			if(rs.next()) {
				count = rs.getInt(1);
				log.info("成功找到该分类id");
			}else {
				log.info("未找到该分类id");
			}
		} catch (SQLException e) {
			log.info("查询失败");
		}finally {
			db.rsClose(rs);
			db.connClose();
			db.psClose(ps);
		}
		return count;
	}
	@Override
	public ProductTypeManageModel getprotype(int typeid) {
		DBUtil db = new DBUtil();
		PreparedStatement ps = db.getPreparedStatement(GET_PRODUCT_TYPEID_SQL);
		ProductTypeManageModel pt = new ProductTypeManageModel();
		ResultSet rs = null;
		try {
			ps.setInt(1, typeid);
			rs= ps.executeQuery();
			if(rs.next()) {
				pt.setProduct_id(rs.getInt("typeid"));
				pt.setProduct_typename(rs.getString("typename"));
				pt.setProduct_typecomment(rs.getString("comment"));
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}finally {
			db.psClose(ps);
			db.connClose();
			db.rsClose(rs);
		}
		db = null;
		return pt;
	}

	@Override
	public ArrayList<ProductTypeManageModel> getalltype() {
		DBUtil db = new DBUtil();
		PreparedStatement ps = db.getPreparedStatement(GET_ALLTYPE_SQL);
		ArrayList<ProductTypeManageModel> allpt = new ArrayList<>();
		ResultSet rs = null;
		try {
			rs = ps.executeQuery();
			while(rs.next()) {
				ProductTypeManageModel pt = new ProductTypeManageModel();
				pt.setProduct_id(rs.getInt("typeid"));
				pt.setProduct_typename(rs.getString("typename"));
				pt.setProduct_typecomment(rs.getString("comment"));
				allpt.add(pt);
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}finally{
			db.connClose();
			db.psClose(ps);
			db.rsClose(rs);
		}
		return allpt;
	}

	@Override
	public boolean updatetype(ProductTypeManageModel type) {
		DBUtil db = new DBUtil();
		PreparedStatement ps = db.getPreparedStatement(UPDATE_TYPE_SQL);
		try {
			ps.setString(1, type.getProduct_typecomment());
			ps.setString(2, type.getProduct_typename());
			ps.setInt(3, type.getProduct_id());
			int i = ps.executeUpdate();
			if(i!=0) {
				return true;
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}finally {
			db.connClose();
			db.psClose(ps);
		}
		db=null;
		return false;
	}

	@Override
	public boolean deletetype(int typeid) {
		DBUtil db = new DBUtil();
		PreparedStatement ps = db.getPreparedStatement(DELETE_TYPE_SQL);
		try {
			ps.setInt(1, typeid);
			int i = ps.executeUpdate();
			if(i!=0) {
				return true;
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean insertType(ProductTypeManageModel type) {
		DBUtil db = new DBUtil();
		PreparedStatement ps = db.getPreparedStatement(INSERT_PROTYPE_SQL);
		try {
			ps.setString(1, type.getProduct_typename());
			ps.setString(2, type.getProduct_typecomment());
			int i = ps.executeUpdate();
			if(i!=0) {
				return true;
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}finally {
			db.connClose();
			db.psClose(ps);
			
		}
		db = null;
		return false;
		
	}

	@Override
	public int getProPages(int size) {
		DBUtil db = new DBUtil();
		int totalpages = 1;
		PreparedStatement ps =db.getPreparedStatement(GET_PRODUCT_SHOWPAGES_SQL);
		ResultSet rs = null;
		try {
			rs=ps.executeQuery();
			rs.next();
			int totalrecords = rs.getInt(1);
			totalpages = totalrecords;
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}finally {
			db.connClose();
			db.psClose(ps);
			db.rsClose(rs);
		}
		if(totalpages == 0) {
			totalpages = 1;
		}
		db = null;
		return totalpages;
	}
/***
 * 增加产品价格的信息
 */
	@Override
	public boolean insertPrice(SalePrices sale) {
		DBUtil db = new DBUtil();
		PreparedStatement ps = db.getPreparedStatement(INSERT_PRO_PRICEMO_SQL);
		try {
			ps.setInt(1, sale.getProid());
			ps.setDouble(2, sale.getProsaleprices());
			ps.setString(3, sale.getProcommnet());
			int i = ps.executeUpdate();
			if(i!=0) {
				return true;
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}finally {
			db.connClose();
			db.psClose(ps);
		}
		return false;
	}
	
	/**
	 * 获得产品价格
	 */
	public SalePrices getproprice(int proid) {
		SalePrices price = new SalePrices();
		DBUtil db = new DBUtil();
		ResultSet rs =null;
		PreparedStatement ps =db.getPreparedStatement("select proid,saleprice,procomd from sale_price where proid = ?");
		try {
			ps.setInt(1, proid);
			rs = ps.executeQuery();
			if(rs.next()) {
				price.setProid(rs.getInt("proid"));
				price.setProsaleprices(rs.getDouble("saleprice"));
				price.setProcommnet(rs.getString("procomd"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			db.connClose();
			db.psClose(ps);
		}
		return price;
	}
	/**
	 * 获得所有产品
	 * @return 所有产品
	 */
	public ArrayList<ProductManageModle> getallproduct(){
		ArrayList<ProductManageModle> pm = new ArrayList<>();
		DBUtil db = new DBUtil();
		PreparedStatement ps = db.getPreparedStatement("select proID,proName,proUnit,presentNum,onPurchaseNum,onPresaleNum,protypeid from storage");
		ResultSet rs = null;
		try {
			rs = ps.executeQuery();
			while(rs.next()){
				ProductManageModle pmm = new ProductManageModle();
				ProductTypeManageModel type = new ProductTypeManageModel();
				pmm.setProduct_id(rs.getInt("proID"));
				pmm.setProduct_name(rs.getString("proName"));
				pmm.setProduct_unit(rs.getString("proUnit"));
				type = getprotype(rs.getInt("protypeid"));
				pmm.setProduct_type(type.getProduct_typename());
				pm.add(pmm);
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return pm;
		
	}
	
	/**
	 * 删除产品价格信息
	 */
	public boolean deleteproprice(int proid) {
		DBUtil db = new DBUtil();
		PreparedStatement ps = db.getPreparedStatement("delete from sale_price where proid = ?");
		try {
			ps.setInt(1, proid);
			int re =ps.executeUpdate();
			if(re!=0) {
				return true;
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}finally {
			db.connClose();
			db.psClose(ps);
		}
		db=null;
		return false;
	}

	@Override
	public boolean deletepro(int proid) {
		DBUtil db = new DBUtil();
		PreparedStatement ps =db.getPreparedStatement(DELETE_PRODUCT_SQL);
		try {
			ps.setInt(1, proid);
			int i = ps.executeUpdate();
			if(i!=0) {
				return true;
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return false;
	}
	
//	public static void main(String[] args) {
//		ProManageDAOimp im = new ProManageDAOimp();
//		ProductTypeManageModel tyepe = im.getprotype(1);
//		//ArrayList<ProductManageModle>  pro = im.getallproduct(0, 3);
//		System.out.println(tyepe.toString());
//	}

}
