package com.rka.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.rka.data.User;
import com.rka.service.UserService;
import com.rka.service.implement.UserServiceImplement;
import com.rka.util.SchoolTradeMail;

/**
 * Servlet implementation class ForgetPasswordServlet
 */
@WebServlet("/ForgetPasswordServlet")
public class ForgetPasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ForgetPasswordServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		ApplicationContext context=new ClassPathXmlApplicationContext("bean.xml");
//		User tempuser=new User();
		User tempuser=(User)context.getBean("user");
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String account=request.getParameter("account");
		tempuser.setAccount(account);
		tempuser.setEmail(email);
		tempuser.setName(name);
//		UserService userService=new UserServiceImplement();
		UserService userService=(UserServiceImplement)context.getBean("userserviceimp");
		String password=userService.getPassword(tempuser);
		SchoolTradeMail schoolTradeMail=new SchoolTradeMail();
		String[] mail=new String[]{tempuser.getEmail()};
		schoolTradeMail.sendGMail(password,mail);
		request.getRequestDispatcher("/mailSuccess.jsp").forward(request, response);
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
