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

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
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
		
		request.setCharacterEncoding("UTF-8");
		String name=request.getParameter("name");
		String account=request.getParameter("account");
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		int flag=0;
//		User user=new User();
		ApplicationContext context=new ClassPathXmlApplicationContext("bean.xml");
		User user=(User)context.getBean("user");
		user.setAccount(account);
		user.setEmail(email);
		user.setName(name);
		user.setPassword(password);
//		UserService userService=new UserServiceImplement();
		UserService userService=(UserServiceImplement)context.getBean("userserviceimp");
		flag=userService.checkRegister(user);
		if(flag==1){
			request.getRequestDispatcher("registerFail.jsp").forward(request, response);
		}else{
			userService.registerUser(user);
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
		
	}

}
