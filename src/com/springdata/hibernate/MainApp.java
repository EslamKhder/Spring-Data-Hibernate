package com.springdata.hibernate;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;

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
		
		
		/*
		 * start with    s%
		 * end with      %s
		 * any           %s%
		 * 
		 * */
		
		long id = 1;
		try {
			session.beginTransaction();
			//List<Client> clients = 
					session
					.createQuery("delete from Client where fullName = 'kmal'")
					.executeUpdate();
			/*for(int i=0;i<clients.size();i++) {
				System.out.println(clients.get(i).getFullName() + " " + clients.get(i).getAge());
			}*/
			
			//System.out.println(c.getFullName() + " " + c.getAddress());
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.toString());
		} finally {
			session.close();
		}
		
	}

}
/*
 * 
 * // client one
		Client client1 = new Client("Eslam Khder",20,"eslamKhder81@gmail,com");
		//client1.setId((long)1);
		
		// client one
		Client client2 = new Client("Eslam Khder",20,"eslamKhder81@gmail,com");
		//client2.setId((long)2);
		
		// client one
		Client client3 = new Client("Eslam Khder",20,"eslamKhder81@gmail,com");
		//client3.setId((long)3);
 * */
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

/*
Client client = session.get(Client.class, id);

client.setFullName("Yasser");
client.setAge(19);
client.setAddress("alex");
Client c = new Client("Karim",19,"cairo");
c.setId((long)1);
session.update(c);

Client c = new Client();
c.setId(id);
session.delete(c);
session.getTransaction().commit();
*/