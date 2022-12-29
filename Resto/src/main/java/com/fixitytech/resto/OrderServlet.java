package com.fixitytech.resto;

import java.io.IOException;
import java.util.List;
import java.util.Vector;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fixitytech.DAO.OrderDAO;

@WebServlet("/order")
public class OrderServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderServlet() {
        super();
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {   
        HttpSession hp=request.getSession();
        //List<CartITem> cart=(List) hp.getAttribute("uid");
            //cart=new Vector<CartITem>();
        List<CartItem> cart=(List) hp.getAttribute("cart");
                   
        String uid=(String)hp.getAttribute("uid");
        
        Orders order=new Orders();
        
        double payment=0;
        
        List<OrderITem> orderItems=new Vector<OrderITem>();
        for(CartItem cartItem:cart)
        {    
            orderItems.add(new OrderITem(cartItem));
        payment+=cartItem.getTotalamount();
            
        }
        
        order.setOrderItems(orderItems);
        order.setTotalamount(payment);
        order.setCustomerId(uid);
        int orderId =OrderDAO.saveOrder(order);
                   
        if(orderId!=-1)
        {
            
            request.setAttribute("message", "Order placed Successfully With order id "+orderId);
        }
        else
            request.setAttribute("message", "Order failed");
        
        RequestDispatcher rd=request.getRequestDispatcher("orderStatus.jsp");
        rd.forward(request, response);
        
                   /*<c:out value="${uid}"></c:out>&nbsp;*/
            }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        doGet(request, response);
    }



}