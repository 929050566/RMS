package com.aowin.scm.salemanage.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.aowin.scm.salemanage.dao.ProManageDAOImpl;
import com.aowin.scm.salemanage.pojo.ProductManageModle;
import com.aowin.scm.salemanage.pojo.ProductTypeManageModel;
import com.aowin.scm.salemanage.pojo.SalePrices;
import com.aowin.scm.utils.DaoFactory;

/**
 * Servlet implementation class ProductManageServlet
 */
@WebServlet("/salsehtml/ProductServlet")
public class ProductManageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductManageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProManageDAOImpl pmo = (ProManageDAOImpl) DaoFactory.getInstance("ProManageDAO");
		String page = request.getParameter("pages");
		int pages = 1;//默认第一页
		int size = 10;
		String option = request.getParameter("option");
		HttpSession session = request.getSession();
		if("alltype".equals(option)) {
			ArrayList<ProductTypeManageModel>  pt =  pmo.getalltype();
			session.removeAttribute("alltypes");
			session.setAttribute("alltypes", pt);
			request.getRequestDispatcher("/salsehtml/product_type.jsp").forward(request, response);
		}else if("addtypeone".equals(option)) {
			String typename = request.getParameter("typename");
			String typecom = request.getParameter("typecom");
			ProductTypeManageModel type = new ProductTypeManageModel();
			type.setProduct_typename(typename);
			type.setProduct_typecomment(typecom);
			if(pmo.insertType(type)) {
				System.out.println("添加成功");
			}else {
				System.out.println("添加失败");
			}
		}else if("showproduct".equals(option)) {
			//产品的分页与显示
			session.removeAttribute("allproduct");
			int totalrecords = pmo.getProPages(size);
			int totalpages = (totalrecords%size==0?0:1) + totalrecords/size;   
			session.setAttribute("totalpages", totalpages);
			System.out.println("totalpages="+totalpages);
			try {
				pages = Integer.parseInt(page);
			} catch (NumberFormatException e) {
				pages = 1;
			}
			if(pages > totalpages) {
				pages = totalpages;
			}
			if(pages <= 1) {
				pages = 1;
			}
			ArrayList<ProductManageModle> pro = pmo.getallproduct((pages-1)*size, size);
			session.setAttribute("allproduct", pro);
			session.setAttribute("pages", pages);
			session.setAttribute("lines", totalrecords);
			request.getRequestDispatcher("/salsehtml/product_show.jsp").forward(request, response);
		}else if("deletetype".equals(option)) {
			int id =Integer.parseInt(request.getParameter("typeid"));
			pmo.deletetype(id);
			//会出现MySQLIntegrityConstraintViolationException
			//原因是由于有外键链接的类别是无法删除的
			//还没有做处理 2018/11/17
			request.getRequestDispatcher("/salsehtml/ProductServlet?option=alltype").forward(request, response);
		}else if("updatetype".equals(option)) {
			session.removeAttribute("protype");
			String tyid = request.getParameter("uptypeid");
			int typeid = Integer.parseInt(tyid);
			ProductTypeManageModel  protype = pmo.getprotype(typeid);
			session.setAttribute("protype", protype);
			request.getRequestDispatcher("/salsehtml/UpdateProType.jsp").forward(request, response);
		}else if("updatetypedel".equals(option)) {
			String id = request.getParameter("id");
			String name = request.getParameter("name");
			String typecom = request.getParameter("typecom");
			ProductTypeManageModel  updateprotype = new ProductTypeManageModel();
			updateprotype.setProduct_id(Integer.parseInt(id));
			updateprotype.setProduct_typename(name);
			updateprotype.setProduct_typecomment(typecom);
			pmo.updatetype(updateprotype);
			request.getRequestDispatcher("/salsehtml/ProductServlet?option=alltype").forward(request, response);
		}else if("gettypeforadd".equals(option)) {
			session.removeAttribute("alltypesforaddpro");
			ArrayList<ProductTypeManageModel>  ptl =  pmo.getalltype();
			session.setAttribute("alltypesforaddpro", ptl);
			request.getRequestDispatcher("/salsehtml/product_add.jsp").forward(request, response);

		}else if("addproduct".equals(option)){
			String proname = request.getParameter("proname");
			String productType = request.getParameter("productType");
			String prounit = request.getParameter("prounit");
			String procom = request.getParameter("procom");
			String sa = request.getParameter("sale");
			double price = Double.parseDouble(sa);
					
			SalePrices sale= new SalePrices();
			ProductManageModle pro = new ProductManageModle();
			pro.setProduct_name(proname);
			pro.setProduct_type(productType);
			pro.setProduct_unit(prounit);
			pmo.insert_pro(pro);
			ArrayList<ProductManageModle>  pm = pmo.getallproduct();
			for(int i=0;i<pm.size();i++) {
				if((pm.get(i).getProduct_name()).equals(proname) ) {
					int id = pm.get(i).getProduct_id();
					sale.setProid(id);
					sale.setProsaleprices(price);
					sale.setProcommnet(procom);
				}
			}
			pmo.insertPrice(sale);
			
		}else if("deletepro".equals(option)) {
			String proid = request.getParameter("proid");
			int id = Integer.parseInt(proid);
			pmo.deletepro(id);
			pmo.deleteproprice(id);
			request.getRequestDispatcher("/salsehtml/ProductServlet?option=showproduct").forward(request, response);

		}
	}

}
