package com.fixitytech.resto;


public class Item {
int id;
String name;
double price;

String base64Image;

public String getBase64Image() {
	return base64Image;
}
public void setBase64Image(String base64Image) {
	this.base64Image = base64Image;
}


public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public double getPrice() {
	return price;
}
public void setPrice(double price) {
	this.price = price;
}

}
