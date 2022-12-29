package com.fixitytech.resto;

import java.io.IOException;
import java.util.List;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fixitytech.DAO.ItemDAO;

/**
 * Servlet implementation class AddCartServlet
 */
@WebServlet("/addcart")
public class AddCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 ItemDAO itemDao;
    public AddCartServlet() {
        super();
        // TODO Auto-generated constructor stub
        itemDao = new ItemDAO();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		HttpSession ss = request.getSession();
	
		
		List<CartItem> cart = (List) ss.getAttribute("cart");
		if(cart==null)
			cart= new Vector<CartItem>();
		
		
		String itemId =request.getParameter("id");
		boolean isAdded = false;
		for(CartItem cItem:cart)
		{	
			if(cItem.getId()==Integer.parseInt(itemId)) 
			{
				cItem.setQuantity(cItem.getQuantity()+1);
		        isAdded = true;
		        break;
		}
		}
		
		if(!isAdded) {
		Item item = ItemDAO.getItem(itemId);
	if(item!=null) 
	{
		CartItem cItem = new CartItem();
		cItem.setId(item.getId());
		cItem.setName(item.getName());
		cItem.setPrice(item.getPrice());
		cItem.setQuantity(1);
		cart.add(cItem);
	}
		}		
		ss.setAttribute("cart", cart);
		response.sendRedirect("index");
	}	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
