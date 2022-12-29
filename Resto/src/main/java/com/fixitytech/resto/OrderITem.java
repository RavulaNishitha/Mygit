package com.fixitytech.resto;
	public class OrderITem extends CartItem {
	    
	    int sid;
	    int orderId;
	    
	public OrderITem() {
	    // TODO Auto-generated constructor stub
	}


	public OrderITem(CartItem cartItem)
	{
	     this.id=cartItem.getId();
	     this.name=cartItem.getName();
	     this.price=cartItem.getPrice();
	     this.quantity=cartItem.getQuantity();
	}




	public int getSid() {
	    return sid;
	}




	public void setSid(int sid) {
	    this.sid = sid;
	}




	public int getOrderId() {
	    return orderId;
	}




	public void setOrderId(int orderId) {
	    this.orderId = orderId;
	}





	}
