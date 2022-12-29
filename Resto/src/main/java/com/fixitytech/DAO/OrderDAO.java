package com.fixitytech.DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import com.fixitytech.resto.OrderITem;
import com.fixitytech.resto.Orders;

public class OrderDAO {
    
    public static int saveOrder(Orders o)
    {
        
        Connection con=DbConnection.getConnection();
        
        try
        {    
            con.setAutoCommit(false);
            PreparedStatement ps=con.prepareStatement("insert into ecartOrders(customerid,totalamount)values (?,?)",PreparedStatement.RETURN_GENERATED_KEYS);
                ps.setString(1,o.getCustomerId());
                ps.setDouble(2,o.getTotalamount());
        int n=ps.executeUpdate();
            if(n>0)
            {
            ResultSet rs=ps.getGeneratedKeys();
            rs.next();
            
            int orderId=rs.getInt(1);
            PreparedStatement pst=con.prepareStatement("insert into orderitem(itemId,itemName,itemPrice,itemQuantity,orderId)values (?,?,?,?,?)");
            
            for(OrderITem orderITem:o.getOrderItems())
            {
                pst.setInt(1, orderITem.getId());
                pst.setString(2, orderITem.getName());
                pst.setDouble(3, orderITem.getPrice());
                pst.setInt(4, orderITem.getQuantity());
                pst.setInt(5, orderId);
                
                pst.executeUpdate();
            }
            
            con.commit();
            return orderId;
            }    
            }
        catch(Exception e)
        {



           try {
                con.rollback();
            } catch (SQLException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
            
            e.printStackTrace();
        }
        return  -1;
    }

    
    
	public List<Orders> getAllOrders() {
		// TODO Auto-generated method stub
		List<Orders> orderList = new ArrayList<Orders>();
		
		Connection con = DbConnection.getConnection();
		try {
			
			PreparedStatement ps  = con.prepareStatement("select * from orders");
			
			ResultSet rs = ps.executeQuery();
			
			
			while(rs.next()) {
				
				Orders order = new Orders();

				order.setOrderid(rs.getInt("orderid"));
				order.setTotalamount(rs.getDouble("totalamount"));
				order.setCustomerId(rs.getString("customerId"));
				orderList.add(order);

			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
		
		return orderList;
	}
    
	

	
	
	public static List<Orders> getMyOrderss(){
    	{
    		List<Orders> orders=new Vector<Orders>();
    		try
    		{
    			
    			Connection con=DbConnection.getConnection();
    			
    			PreparedStatement pst=con.prepareStatement("select * from ecartOrders ");
    			PreparedStatement pst1=con.prepareStatement("select * from orderitem where orderid=? ");
    			ResultSet rs=pst.executeQuery();
    					while(rs.next())
    					{
    						
    						Orders or=new Orders();
    						or.setOrderid(rs.getInt(1));
    						or.setCustomerId(rs.getString(2));
    						or.setTotalamount(rs.getDouble(3));
    						pst1.setInt(1, or.getOrderid());
    						
    						ResultSet rs1=pst1.executeQuery();
    						List<OrderITem> oitems=new Vector<OrderITem>();
    						while(rs1.next())
    						{
    							OrderITem orderItem=new OrderITem();
    							orderItem.setId(rs1.getInt(2));

    							orderItem.setName(rs1.getString(3));

    							orderItem.setPrice(rs1.getDouble(4));

    							orderItem.setQuantity(rs1.getInt(5));
    							
    							oitems.add(orderItem);
    							
    						}
    						
    						
    						or.setOrderItems(oitems);
    						
    						orders.add(or);
    						
    					}
    			
    		}
    		catch (Exception e) {
				// TODO: handle exception
    			e.printStackTrace();
			}
    		
    		
    		return orders;
	}
}
	
	public  void getStatus(int orderid,int status)  {
		
		
		Connection con = DbConnection.getConnection();
		try {
		PreparedStatement ps = con.prepareStatement("update ecartOrders set status=? where orderid=?");
	
		ps.setInt(1, status);
		ps.setInt(2, orderid);
		ps.executeUpdate();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
		
	}
	

	
	
}



















/*import java.io.IOException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fixitytech.resto.Order;

@WebServlet("/order")
public class OrderDAO extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public OrderDAO() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	
	public static boolean save(Order order) {
		try {
		Connection con = DbConnection.getConnection();

		PreparedStatement ps = con.prepareStatement("insert into orders values(?,?)");
		
		ps.setString(1,order.getCustomerid());
		ps.setString(2,order.getTotalAmount());
		
		int n = ps.executeUpdate();
		if(n>0)
//		System.out.println("Hello");
			return true;
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return false;
}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		String customerid = request.getParameter("uid");
		String totalAmount = request.getParameter("total");
		Order order = new Order();
		
		order.setCustomerid(customerid);
		order.setTotalAmount(totalAmount);
		System.out.println("helllo");
		boolean b =OrderDAO.save(order);
		if(b) {
			HttpSession hs = request.getSession();
			hs.setAttribute("uu",customerid );
			response.sendRedirect("order.jsp");
		}
		else {
			request.setAttribute("er", "Something went wrong..!");
		doGet(request, response);
		}
	}
		
		

}


*/