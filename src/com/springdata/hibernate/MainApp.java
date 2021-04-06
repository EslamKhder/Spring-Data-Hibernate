package com.springdata.hibernate;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.mysql.cj.jdbc.Driver;
import com.springdata.hibernate.model.Client;

public class MainApp {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")			
				.addAnnotatedClass(Client.class)		
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
	
		
		int id = 1;
		try {
			session.beginTransaction();
			Criteria c = session.createCriteria(Client.class);
			//c.setProjection(Projections.min("id"));
			//c.setProjection(Projections.max("id"));
			//c.setProjection(Projections.avg("id"));
			//c.setProjection(Projections.count("address"));
			c.setProjection(Projections.countDistinct("address"));
			List<Client> clients = c.list();
			System.out.println("Min : " + clients.get(0));
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

/*Query q = session
.createQuery("from Client where id = ?0 or fullName = ?1");
//q.setFirstResult(0);  //  0 1 2 3 
//q.setMaxResults(4);
q.setInteger(0, id);
q.setString(1, "karim");


Query q = session
.createQuery("from Client where id =:v1 or fullName =:v2");
//q.setFirstResult(0);  //  0 1 2 3 
//q.setMaxResults(4);
q.setInteger("v1", id);
q.setString("v2", "karim");
* */

/*
 * Query q1 = session.createQuery("select Max(id) from Client");
			Query q2 = session.createQuery("select Min(id) from Client");
			Query q3 = session.createQuery("select sum(id) from Client");
			Query q4 = session.createQuery("select avg(age) from Client");
			Query q5 = session.createQuery("select count(address) from Client");
			Query q6 = session.createQuery("select count(distinct address) from Client");

			System.out.println("Max : " + q1.list().get(0));
			System.out.println("Min : " + q2.list().get(0));
			System.out.println("sum : " + q3.list().get(0));
			System.out.println("avg : " + q4.list().get(0));
			System.out.println("count : " + q5.list().get(0));
			System.out.println("count : " + q6.list().get(0));
 * */
/*
//c.setFirstResult(0);  //  0 1 2 3
//c.setMaxResults(3);

//c.add(Restrictions.in("id", ids)); // 2 3 4   [1,4,5]
//c.add(Restrictions.isNotNull("address"));
//c.add(Restrictions.isEmpty("id"));
//c.add(Restrictions.eq("fullName", "yasser"));
//c.add(Restrictions.like("fullName", "m" ,MatchMode.ANYWHERE)); // Like s% Like %s  Like %s% 
Criterion c1 =  Restrictions.eq("address", "alex");
Criterion c2 =  Restrictions.eq("fullName", "solom");
LogicalExpression or = Restrictions.and(c1, c2);
c.add(or);
*/