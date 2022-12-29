package com.fixitytech.resto;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fixitytech.DAO.OrderDAO;
import com.fixitytech.DAO.userDAO;

@WebServlet("/login")
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
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		RequestDispatcher rs = request.getRequestDispatcher("login.jsp");
		rs.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String cont = request.getParameter("c");
		boolean b = new userDAO().validate(username, password);
		if(b) {
			HttpSession hs = request.getSession();
			hs.setAttribute("uid", username);
			if(cont !=null &&cont.length()>0)
			response.sendRedirect(cont);
			else
				response.sendRedirect("index");
			
		}
		
		else if(username.equals("admin") && password.equals("admin"))
		{
			RequestDispatcher rs = request.getRequestDispatcher("admin.jsp");
			rs.forward(request, response);
		}
		
		else {
			request.setAttribute("err", "Invaild username and password ");
		doGet(request, response);
		}
	}

}


