package com.springdata.hibernate;

import java.sql.Connection;
import java.sql.DriverManager;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.mysql.cj.jdbc.Driver;
import com.springdata.hibernate.model.Client;

public class MainApp {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")			
				.addAnnotatedClass(Client.class)		
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		Client client = new Client();
		client.setId((long) 1);
		client.setFullName("Eslam Khder");
		client.setAge(20);
		client.setAddress("eslamKhder81@gmail,com");
		
		try {
			session.beginTransaction();
			
			session.save(client);
			
			session.getTransaction().commit();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.toString());
		} finally {
			session.close();
		}
		
	}

}
/*String url = "jdbc:mysql://localhost:3306/employee?useSSL=false";
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
*/