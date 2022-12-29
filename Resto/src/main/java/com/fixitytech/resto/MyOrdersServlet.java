package com.fixitytech.resto;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fixitytech.DAO.OrderDAO;

@WebServlet("/myorders")
public class MyOrdersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	OrderDAO orderdao;
    public MyOrdersServlet() {
        super();
        orderdao = new OrderDAO();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		List<Orders> ordersdetails=orderdao.getMyOrderss();
		request.setAttribute("ords", ordersdetails);
		RequestDispatcher rd = request.getRequestDispatcher("myorders.jsp");
		rd.forward(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
