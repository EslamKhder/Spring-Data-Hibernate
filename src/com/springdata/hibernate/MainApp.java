package com.springdata.hibernate;

import java.sql.Connection;
import java.sql.DriverManager;

import com.mysql.cj.jdbc.Driver;

public class MainApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String url = "jdbc:mysql://localhost:3306/employee?useSSL=false";
		String username = "eslam";
		String password = "eslam";
		
		try {
			Connection connection = DriverManager.getConnection(
					url, username ,password
					);
			System.out.println("Connected !");
			System.out.println(connection);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.toString());
		}
		

	}

}
