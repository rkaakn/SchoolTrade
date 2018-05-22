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

import com.rka.data.Administrator;
import com.rka.data.User;
import com.rka.service.AdministratorService;
import com.rka.service.UserService;
import com.rka.service.implement.AdministratorServiceImplement;
import com.rka.service.implement.UserServiceImplement;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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
		request.setCharacterEncoding("utf-8");
		String account=request.getParameter("account");
		String password=request.getParameter("password");
		ApplicationContext context=new ClassPathXmlApplicationContext("bean.xml");
//		Administrator administrator=new Administrator();
		Administrator administrator=(Administrator)context.getBean("administrator");
//		User user=new User();
		User user=(User)context.getBean("user");
		administrator.setAccount(account);
		administrator.setPassword(password);
		user.setAccount(account);
		user.setPassword(password);
//		UserService userService=new UserServiceImplement();
		UserService userService=(UserServiceImplement)context.getBean("userserviceimp");
		User qUser=userService.loginUser(user);
//		AdministratorService administratorService=new AdministratorServiceImplement();
		AdministratorService administratorService=(AdministratorServiceImplement)context.getBean("adminserviceimp");
		if(qUser!=null){
			HttpSession session=request.getSession();
			session.setAttribute("user", qUser);
			request.getRequestDispatcher("/searchItem.jsp").forward(request, response);
			return ;
		}else if(administratorService.login(administrator)!=null){
				System.out.println("跳转到管理员页面");
				request.getRequestDispatcher("/admin.jsp").forward(request, response);
				return ;
		}else{
			request.getRequestDispatcher("/loginError.jsp").forward(request, response);
		}
		return ;
		
	}

}
