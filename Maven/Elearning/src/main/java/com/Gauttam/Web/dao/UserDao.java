package com.Gauttam.Web.dao;

import java.sql.*;
import com.Gauttam.Web.model.User;

public class UserDao 
{
	public User getUser(int uid)
	{
		User u = new User();
		
		u.setUid(101);
		u.setUname("Robert");
		u.setTech("Java");
		
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/elearning","root","root");
			
			Statement st = con.createStatement();
			
			ResultSet rs =st.executeQuery("select * from user where uid="+uid);
			
			if(rs.next())
			{
				u.setUid(rs.getInt("uid"));
				u.setUname(rs.getString("uname"));
				u.setTech(rs.getString("tech"));
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		return u;
		
	}

}
