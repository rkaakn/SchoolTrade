package com.rka.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.rka.data.Item;
import com.rka.service.ItemService;
import com.rka.service.implement.ItemServiceImplement;

/**
 * Servlet implementation class showItemServlet
 */
@WebServlet("/showItemServlet")
public class showItemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public showItemServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		String id=request.getParameter("itemId");
		ApplicationContext context=new ClassPathXmlApplicationContext("bean.xml");
//		ItemService itemService=new ItemServiceImplement();
		ItemService itemService=(ItemServiceImplement)context.getBean("itemserviceimp");
		Item item=itemService.getItem(id);
		HttpSession session=request.getSession();
		session.setAttribute("item",item);
		request.getRequestDispatcher("/showItem.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
