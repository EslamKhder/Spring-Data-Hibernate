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
		
		// client one
		Client client1 = new Client("Eslam Khder",20,"eslamKhder81@gmail,com");
		//client1.setId((long)1);
		
		// client one
		Client client2 = new Client("Eslam Khder",20,"eslamKhder81@gmail,com");
		//client2.setId((long)2);
		
		// client one
		Client client3 = new Client("Eslam Khder",20,"eslamKhder81@gmail,com");
		//client3.setId((long)3);
		
		try {
			session.beginTransaction();
			
			session.save(client1);
			session.save(client2);
			session.save(client3);
			
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