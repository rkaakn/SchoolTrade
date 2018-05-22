package com.rka.controller;

import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.rka.data.Item;
import com.rka.data.Record;
import com.rka.data.User;
import com.rka.service.RecordService;
import com.rka.service.implement.RecordServiceImplement;

/**
 * Servlet implementation class buyItemServlet
 */
@WebServlet("/buyItemServlet")
public class buyItemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public buyItemServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		HttpSession session=request.getSession();
		User user=(User)session.getAttribute("user");
		Item item=(Item)session.getAttribute("item");
		ApplicationContext context=new ClassPathXmlApplicationContext("bean.xml");
//		Record record=new Record();
		Record record=(Record)context.getBean("record");
		
//	       java.util.Date d = new java.util.Date();  
//	        System.out.println(d);  
//	        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");  
//	        String dateNowStr = sdf.format(d);  
//	        System.out.println("格式化后的日期：" + dateNowStr); 
        Date checkinDate=new Date(new java.util.Date().getTime());
        System.out.println(checkinDate);
        record.setCheckinDate(checkinDate);
		record.setName(item.getName());
		record.setBuyerName(user.getName());
		record.setOwnerName(item.getOwnerName());
		record.setItemId(item.getItemId());
		RecordService recordService=new RecordServiceImplement();
		recordService.insertRecord(record);
		session.removeAttribute("item");
		request.getRequestDispatcher("/searchItem.jsp").forward(request, response);
	}

}
