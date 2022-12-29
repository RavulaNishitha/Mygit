package com.fixitytech.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.Vector;

import com.fixitytech.resto.User;

public class userDAO {
	public boolean validate(String uname, String password) {
		try {
			Connection con = DbConnection.getConnection();
			PreparedStatement st = con.prepareStatement("select * from users where uid=? and password=? ");
			st.setString(1,uname);
			st.setString(2,password);
			ResultSet rs = st.executeQuery();
			if(rs.next()) {
				return true;
			}
		}
		catch (Exception e){
			e.printStackTrace();
		}
		return false;
	}
	
public static boolean save(User user) {
	try {
	Connection con = DbConnection.getConnection();

	PreparedStatement ps = con.prepareStatement("insert into users values(?,?,?,?,?)");
	ps.setString(1,user.getUserName());
	ps.setString(2, user.getFullName());
	ps.setString(3, user.getEmailId());
	ps.setString(4, user.getMobile());
	ps.setString(5, user.getPassword());
	
	int n = ps.executeUpdate();
	if(n>0)
		return true;
	}catch(Exception e)
	{
		e.printStackTrace();
	}
	
	return false;
}

public User getUser(String uname) {
	try {
		Connection con = DbConnection.getConnection();
		PreparedStatement st = con.prepareStatement("select * from users where uid=? ");
		st.setString(1,uname);
		ResultSet rs = st.executeQuery();
		if(rs.next()) {
	User user = new User();
	user.setUserName(rs.getString(1));
	user.setEmailId(rs.getString(3));
	user.setFullName(rs.getString(2));
	user.setMobile(rs.getString(4));
	user.setPassword(rs.getString(5));
	return user;
	}
	}
	catch (Exception e){
		e.printStackTrace();
	}
	return null;	
}

public static List<User> getUsers() {
	List<User> users = new Vector<User>();

	try {
		Connection con = DbConnection.getConnection();
		PreparedStatement st = con.prepareStatement("select * from users ");
		ResultSet rs = st.executeQuery();
		while(rs.next()) {
	User user = new User();
	user.setUserName(rs.getString(1));
	user.setEmailId(rs.getString(3));
	user.setFullName(rs.getString(2));
	user.setMobile(rs.getString(4));
	user.setPassword(rs.getString(5));
	users.add(user);
	}
	}
	catch (Exception e){
		e.printStackTrace();
	}
	return users;
}


}
