package com.fixitytech.resto;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fixitytech.DAO.userDAO;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       userDAO dao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        dao = new userDAO();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		RequestDispatcher rs = request.getRequestDispatcher("registerr.jsp");
		rs.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String userName = request.getParameter("username");
		String password = request.getParameter("password");
		String fullName  = request.getParameter("fullname");
		String emailId  = request.getParameter("email");
		String mobile = request.getParameter("mobile");
	
		User user = new User();
	
		user.setUserName(userName);
		user.setPassword(password);
		user.setFullName(fullName);
		user.setEmailId(emailId);
		user.setMobile(mobile);
		boolean b =userDAO.save(user);
		if(b) {
			HttpSession hs = request.getSession();
			hs.setAttribute("uid", userName);
			response.sendRedirect("home");
			//out.println("Successfully inserted ");
		}
		else {
			request.setAttribute("err", "Please try again later ");
		doGet(request, response);
		}
	}

}
