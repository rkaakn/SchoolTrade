package com.rka.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.rka.data.Item;
import com.rka.service.ItemService;
import com.rka.service.implement.ItemServiceImplement;

/**
 * Servlet implementation class AdminFinditemServlet
 */
@WebServlet("/AdminFinditemServlet")
public class AdminFinditemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminFinditemServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		ApplicationContext context=new ClassPathXmlApplicationContext("bean.xml");
		ItemService itemService=(ItemServiceImplement)context.getBean("itemserviceimp");
		String name=request.getParameter("name");
//		ItemService itemService=new ItemServiceImplement();
		List<Item> itemList=itemService.listItembyName(name);
		if(itemList!=null){
			request.setAttribute("hasResult", 1);
			request.setAttribute("itemList", itemList);
			request.getRequestDispatcher("/admin.jsp").forward(request, response);
		}else{
			request.getRequestDispatcher("/admin.jsp").forward(request, response);
		}
	}

}
