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
import com.aowin.scm.salemanage.dao.SaleDAO;
import com.aowin.scm.salemanage.pojo.Sale;
import com.aowin.scm.salemanage.pojo.SaleDet;
import com.aowin.scm.storagemanage.dao.OutStorageDAO;
import com.aowin.scm.storagemanage.dao.StorageDAO;
import com.aowin.scm.storagemanage.pojo.OutStorage;
import com.aowin.scm.utils.DaoFactory;


/**
 * Servlet implementation class OutStorageServlet
 */
@WebServlet("/storage/out")
public class OutStorageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Logger log = Logger.getLogger(IntoStorageServlet.class);   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OutStorageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//�������ò���
				request.setCharacterEncoding("utf-8");
				response.setCharacterEncoding("utf-8");
				response.setContentType("text/html; charset=UTF-8");
				
				String option = request.getParameter("option");
				
				HttpSession session = request.getSession();
				
				if("outstock".equals(option)) {
					//��òɹ����б�
					log.info("option=outstock");
					SaleDAO sa = (SaleDAO)DaoFactory.getInstance("SaleDAO");
					Sale p = new Sale();
					
					
					String pageString = request.getParameter("page");
					int page = 1;
					int size = 10;
					if(pageString != null) {
						page = Integer.parseInt(pageString);
					}
					if(page <= 1 ) {
						page = 1;
					}
					String paystate = request.getParameter("state");
					System.out.println("paystate:"+paystate);
					List<Sale> list = null;
					int totalPage = 0;
					int totalLines = 0;
					
					if("1".equals(paystate) || "2".equals(paystate) || "3".equals(paystate)) {
						log.info("option="+paystate);
						totalLines = sa.getSaleStateCount(paystate);
						totalPage =  (totalLines%size == 0)? 0 : 1 + totalLines/size;
						if(page > totalPage && totalPage != 0) {
							page = totalPage;
						}
						request.setAttribute("page", page);
						page = (page-1)*size ;
						list  = sa.getSaleByState(page, size, paystate);
					}else {
						log.info("option=all");
						totalLines = sa.getSaleCount();
						totalPage =  (totalLines%size == 0)? 0 : 1 + totalLines/size;//ҳ������
						if(page > totalPage && totalPage != 0) {
							page = totalPage;
						}
						System.out.println("page:"+page);
						request.setAttribute("page", page);//ҳ������
						page = (page-1)*size ;//
						list  = sa.getSaleByCondition(page,size);
						
						System.out.println("totalPage:"+totalPage);
						System.out.println("linesNum:"+totalLines);
						
					}
					request.setAttribute("List", list);
					request.setAttribute("totalPage", totalPage);
					request.setAttribute("linesNum", totalLines);
					request.setAttribute("paystate", paystate);
					request.getRequestDispatcher("outstock.jsp").forward(request, response);
				}else if("saleidlink".equals(option)) {
					
				}else if("outw".equals(option)) {
					log.info("option=outw");
					OutStorage o = new OutStorage();
					SaleDAO sa = (SaleDAO)DaoFactory.getInstance("SaleDAO");
					String disposestate = request.getParameter("di");//δ����ǰ����״̬
					//String inStorageDate = request.getParameter("time");//����ʱ��
					String purchaseid =request.getParameter("id");//���۵���
					String inoHandle = request.getParameter("han");//���⾭����  ????
					String outState = request.getParameter("instate");//��������
					List<SaleDet> det =sa.getproid(purchaseid);//������۵��Ŷ�Ӧ�Ĳ�Ʒ����
					OutStorageDAO t = (OutStorageDAO)DaoFactory.getInstance("OutStorageDAO");
					//������һ��
					for(SaleDet d:det) {
						o.setOutHandle(((Admins)session.getAttribute("admins")).getRealname());//??
						o.setOutStorageDate("2018-11");//inStorageDate
						o.setSale_detid(d.getDetid());
						System.err.println("sale_detid:"+d.getDetid());
						o.setSalebillid(purchaseid);
						o.setOutState(outState);
						t.insertOutStorage(o);
					}
					StorageDAO sto = (StorageDAO)DaoFactory.getInstance("StorageDAO");
					//����ʱ�����ȼ��ٿ����Ԥ������
					for(SaleDet d:det) {
						int outnum =d.getPronum();//�������۵��Ż��Ԥ������
						int prooid =d.getProid();
						
						sto.updaCKBYID(prooid,outnum,outnum);
					}
					
					
					//�޸����۱�Ĵ���״̬
					sa.updaid(purchaseid,"2");
					request.getRequestDispatcher("out?option=outstock&state="+disposestate).forward(request, response);
				}
	}
}
