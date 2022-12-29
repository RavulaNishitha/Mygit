package com.fixitytech.resto;

public class CartItem extends Item {
int quantity;

public int getQuantity() {
	return quantity;
}

public void setQuantity(int quantity) {
	this.quantity = quantity;
}
public double getTotalamount() {
	return getQuantity()*getPrice();
}


}
