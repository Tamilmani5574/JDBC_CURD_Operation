package com.emp.curd_operation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Employee_data {
	static Scanner s = new Scanner(System.in);
	public static void insert(Connection c) throws SQLException {
		System.out.println("enter your id");
		int id=s.nextInt();
		System.out.println("enter your name");
		String name = s.next();
		System.out.println("enter your phoneno");
		long phoneno = s.nextLong();
		System.out.println("enter your email");
		String email =s.next();
		System.out.println("enter your job");
		String job = s.next();
		System.out.println("enter your lco");
		String lco = s.next();
		String sql = "insert into employee_data  values(?,?,?,?,?,?)";
		PreparedStatement s = c.prepareStatement(sql);
		s.setInt(1, id);
		s.setString(2, name);
		s.setLong(3, phoneno);
		s.setString(4, email);
		s.setString(5, job);
		s.setString(6, lco);
		s.executeUpdate();
		System.out.println("insert success");
	}
	public static void delete(Connection c) throws SQLException {
		
		System.out.println("enter yor name");
		String name=s.next();
		String sql = "delete from employee_data where name=?";
		PreparedStatement s = c.prepareStatement(sql);
		s.setString(1, name);
		s.executeUpdate();
		System.out.println("delete success");
	}
	public static void update(Connection c) throws SQLException {
		System.out.println("enter the id");
		int id=s.nextInt();
		System.out.println("enter the name");
		String name = s.next();
		System.out.println("enter the phoneno");
		long phoneno = s.nextLong();
		System.out.println("enter your email");
		String email =s.next();
		System.out.println("enter the job");
		String job = s.next();
		System.out.println("enter the lco");
		String lco = s.next();
		String sql = "update employee_data set name=? where id=? ";
		PreparedStatement s = c.prepareStatement(sql);
		s.setInt(1, id);
		s.setString(2, name);
		s.setLong(3, phoneno);
		s.setString(4, email);
		s.setString(5, job);
		s.setString(6, lco);
		s.executeUpdate();
		System.out.println("update success");
	}

	public static void select(Connection c) throws SQLException {
		String sql = "select id,name from employee_data";
	    Statement s = c.createStatement();
	    ResultSet rs=s.executeQuery(sql);
		while(rs.next()){ 
			System.out.println(rs.getInt(1)+ "  "+ rs.getString(2)+"  "+rs.getLong(3)+"  "+rs.getString(4)+"  "+rs.getString(5)+"  "+rs.getString(6));
		}
	}
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection c= DriverManager.getConnection("jdbc:mysql://localhost:3306/employee_data","root","root");
			boolean b=true;
            while(b) {
			System.out.println("1.insert\n2.delete\n3.update\n4.select\n5.exit");
			switch (s.nextInt()){
			   case 1: {insert(c); break;}  // used for switch condition mandatary use break 
			   case 2: {delete(c); break;}
			   case 3: {update(c); break;}
			   case 4: {select(c); break;}
			   case 5: {b=false; break;}
		    }
		  }	
		} catch (ClassNotFoundException |SQLException e) {
			e.printStackTrace();
		}
	}
}
