package com.rka.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.rka.data.User;
import com.rka.service.UserService;
import com.rka.service.implement.UserServiceImplement;

/**
 * Servlet implementation class updateUserInfoServlet
 */
@WebServlet("/updateUserInfoServlet")
public class updateUserInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updateUserInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		User user=new User();
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		String name=request.getParameter("name");
		System.out.println(email+password+name);
		user.setEmail(email);
		user.setName(name);
		user.setPassword(password);
		HttpSession session=request.getSession();
		User currentUser=(User)session.getAttribute("user");
		UserService userService=new UserServiceImplement();
		int flag=userService.updateUser(user, currentUser.getAccount());
		if(flag>0){
			session.setAttribute("user", user);
			request.getRequestDispatcher("/searchItem.jsp").forward(request, response);
		}else{
			request.getRequestDispatcher("/changeFail.jsp").forward(request, response);
		}
	}

}
