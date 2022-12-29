 package com.fixitytech.daoo;

import java.io.ByteArrayOutputStream;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Base64;
import java.util.List;
import java.util.Vector;

import com.fixitytech.DAO.DbConnection;
import com.fixitytech.resto.Item;

public class ItemDAO {
public List<Item> getItems() 
{
	List<Item> items = new Vector<Item>();
	
	try {
		Connection con = DbConnection.getConnection();
		PreparedStatement st;
		st = con.prepareStatement("select * from item");
	 
	ResultSet rs = st.executeQuery();
	while(rs.next())
	{
		Item it = new Item();
		it.setId(rs.getInt(1));
		it.setName(rs.getString(2));
		it.setPrice(rs.getDouble(3));
		Blob blob = rs.getBlob("photo");
        
		if(blob!=null)
		{
        InputStream inputStream = blob.getBinaryStream();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        byte[] buffer = new byte[4096];
        int bytesRead = -1;
         
        try {
			while ((bytesRead = inputStream.read(buffer)) != -1) {
			    outputStream.write(buffer, 0, bytesRead);                  
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
         
        byte[] imageBytes = outputStream.toByteArray();
        String base64Image = Base64.getEncoder().encodeToString(imageBytes);
        it.setBase64Image(base64Image);
  
         
        try {
			inputStream.close();
			outputStream.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
		}
       
		items.add(it);
	}
	}
	catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return items;
	
}




public static boolean addItem(int itemId,String itemName,double itemPrice,byte[] file) 
{
	int row=0;
	try {
	Connection con = DbConnection.getConnection();
	PreparedStatement st1;
	st1=con.prepareStatement("insert into item values(?,?,?,?)");
	st1.setInt(1,itemId);
	st1.setString(2,itemName);
	st1.setDouble(3,itemPrice);
	st1.setBytes(4,file);
    row = st1.executeUpdate();
	return true;
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	
	return false;
}




public Item get(int id) throws SQLException, IOException {
    Item itm = null;
     
    String sql = "SELECT * FROM item WHERE id = ?";
     
   
    	Connection connection =  DbConnection.getConnection();
    
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, id);
        ResultSet result = statement.executeQuery();
         
        if (result.next()) {
            itm = new Item();
             int id1 = result.getInt("id");
            String name = result.getString("name");
            Double price = result.getDouble("price");
            Blob blob = result.getBlob("photo");
             
            InputStream inputStream = blob.getBinaryStream();
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            byte[] buffer = new byte[4096];
            int bytesRead = -1;
             
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);                  
            }
             
            byte[] imageBytes = outputStream.toByteArray();
            String base64Image = Base64.getEncoder().encodeToString(imageBytes);
             
             
            inputStream.close();
            outputStream.close();
             
           itm.setId(id1);
            itm.setName(name);
            itm.setPrice(price);
            itm.setBase64Image(base64Image);
        }
		return itm;          
         
    
    }

public static void addImage(int id, byte[] photo) throws SQLException {
	Connection con = DbConnection.getConnection();
	PreparedStatement st1;
	st1=con.prepareStatement("insert into item values(?,?)");
	st1.setInt(1,id);
	st1.setBytes(2,photo);
}
    
}
