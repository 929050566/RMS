package com.aowin.scm.storagemanage.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.aowin.scm.adminmanage.pojo.Admins;
import com.aowin.scm.purchasemanager.dao.PurchaseDao;
import com.aowin.scm.purchasemanager.pojo.Purchase;
import com.aowin.scm.purchasemanager.pojo.PurchaseDet;
import com.aowin.scm.storagemanage.dao.IntoStorageDAO;
import com.aowin.scm.storagemanage.dao.StorageDAO;
import com.aowin.scm.storagemanage.pojo.IntoStorage;
import com.aowin.scm.utils.DaoFactory;


/**
 * Servlet implementation class IntoStorageServlet
 */
@WebServlet("/storage/into")
public class IntoStorageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Logger log = Logger.getLogger(IntoStorageServlet.class);   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IntoStorageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//�������ò���
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String option = request.getParameter("option");
		String page = request.getParameter("pages");
		
		HttpSession session = request.getSession();
		int pages = 1;
		int pagesize = 5;
		if("instock".equals(option)) {
			//��òɹ����б�
			String state = request.getParameter("state");
			PurchaseDao pro = (PurchaseDao)DaoFactory.getInstance("PurchaseDAO");
			Purchase p = new Purchase();
			System.out.println(state+"2".equals(state));
			if("0".equals(state)) {
				log.info("paystate=all");
				Integer totalpages = (Integer) session.getAttribute("totalpages");
				if(totalpages == null) {
					totalpages = pro.getPurchaseAllTotalPages(pagesize);
					session.setAttribute("totalpages", totalpages);
				}
				
				try {
					pages = Integer.parseInt(page);
				} catch (NumberFormatException e) {
					pages = 1;
					log.warn("pages���ܽ���ת��, pages=1");
				}
				if(pages < 1) {
					pages = 1;
				}
				if(pages > totalpages) {
					pages = totalpages;
				}
				log.info("��ǰҳpages="+ pages);
				List<Purchase> list = pro.getPurchaseBYDisposestate(pages, pagesize);
				int num = pro.getALL(pagesize);
				request.setAttribute("n", num);
				request.setAttribute("counts", list);
				request.setAttribute("pages", pages);
				
				
			}else if("1".equals(state)) {
				log.info("paystate=1");
				Integer totalpages = (Integer) session.getAttribute("totalpages");
				if(totalpages == null) {
					totalpages = pro.getPurchasePaystate1TotalPages(pagesize);
					session.setAttribute("totalpages", totalpages);
				}
				
				try {
					pages = Integer.parseInt(page);
				} catch (NumberFormatException e) {
					pages = 1;
					log.warn("pages���ܽ���ת��, pages=1");
				}
				if(pages < 1) {
					pages = 1;
				}
				if(pages > totalpages) {
					pages = totalpages;
				}
				log.info("��ǰҳpages="+ pages);
				List<Purchase> list = pro.getPurchaseBYPaystate1(pages, pagesize);
				int num = pro.getPaystate1ALL(pagesize);
				request.setAttribute("n", num);
				request.setAttribute("counts", list);
				request.setAttribute("pages", pages);
			}else if("2".equals(state)) {
				log.info("paystate=2");
				Integer totalpages = (Integer) session.getAttribute("totalpages");
				if(totalpages == null) {
					totalpages = pro.getPurchasePaystate2TotalPages(pagesize);
					session.setAttribute("totalpages", totalpages);
				}
				
				try {
					pages = Integer.parseInt(page);
				} catch (NumberFormatException e) {
					pages = 1;
					log.warn("pages���ܽ���ת��, pages=1");
				}
				if(pages < 1) {
					pages = 1;
				}
				if(pages > totalpages) {
					pages = totalpages;
				}
				log.info("��ǰҳpages="+ pages);
				List<Purchase> list = pro.getPurchaseBYPaystate2(pages, pagesize);
				int num = pro.getPaystate2ALL(pagesize);
				request.setAttribute("n", num);
				request.setAttribute("counts", list);
				request.setAttribute("pages", pages);
			}else if("3".equals(state)) {
				log.info("paystate=3");
				Integer totalpages = (Integer) session.getAttribute("totalpages");
				if(totalpages == null) {
					totalpages = pro.getPurchasePaystate3TotalPages(pagesize);
					session.setAttribute("totalpages", totalpages);
				}
				
				try {
					pages = Integer.parseInt(page);
				} catch (NumberFormatException e) {
					pages = 1;
					log.warn("pages���ܽ���ת��, pages=1");
				}
				if(pages < 1) {
					pages = 1;
				}
				if(pages > totalpages) {
					pages = totalpages;
				}
				log.info("��ǰҳpages="+ pages);
				List<Purchase> list = pro.getPurchaseBYPaystate3(pages, pagesize);
				int num = pro.getPaystate3ALL(pagesize);
				request.setAttribute("n", num);
				request.setAttribute("counts", list);
				request.setAttribute("pages", pages);
			}
			
			request.getRequestDispatcher("instock.jsp").forward(request, response);

		}else if("proidlink".equals(option)) {
			//��òɹ����б�
			//PurchaseDAO pro = (PurchaseDAO)DaoFactory
			//Purchase p = new Purchase();
			//List(Purchase) list = pro.get~
			//request.setAttribute("list",list);
		}else if("prow".equals(option)) {
			log.info("option=prow");
			IntoStorage in = new IntoStorage();
			PurchaseDao pro = (PurchaseDao)DaoFactory.getInstance("PurchaseDAO");
			String disposestate = request.getParameter("di");//δ���ǰ����״̬
			//String inStorageDate = request.getParameter("time");//���ʱ��mysqlд��
			String purchaseid =request.getParameter("id");//�ɹ�����
			String inoHandle = request.getParameter("han");//��⾭����  ????
			String inState = request.getParameter("instate");//������� 
			
			IntoStorageDAO into = (IntoStorageDAO)DaoFactory.getInstance("IntoStorageDAO");
			//�����һ��
			List<PurchaseDet> det =pro.getproid(purchaseid);
			System.out.println("purchaseid:"+purchaseid );
			System.out.println(det);
			for(PurchaseDet d:det) {
				in.setInoHandle(((Admins)session.getAttribute("admins")).getRealname());
				//in.setInStorageDate("2018-11");//inStorageDate
				in.setPurchase_detid(d.getDetid());
				in.setPurchaseid(purchaseid);
				in.setInState("1");
				into.insertIntoStorage(in);
			}
			
			//����仯
			StorageDAO sto = (StorageDAO)DaoFactory.getInstance("StorageDAO");
			for(PurchaseDet d:det) {
				int outnum =d.getPronum();//�������۵��Ż��Ԥ������
				int prooid =d.getProid();
				
				sto.updaRKBID(prooid,outnum,outnum);
			}
			
			//�ɹ���״̬�ı�
			pro.updaBYID(purchaseid,"2");
		
			request.getRequestDispatcher("into?option=instock&state="+disposestate).forward(request, response);
		}
    }
}
