package com.springdata.hibernate;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
import com.springdata.hibernate.model.Car;
import com.springdata.hibernate.model.Client;
import com.springdata.hibernate.model.Color;
import com.springdata.hibernate.model.Data;
import com.springdata.hibernate.model.Info;
import com.springdata.hibernate.model.Person;
import com.springdata.hibernate.model.Student;

public class MainApp {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")			
				.addAnnotatedClass(Car.class)
				.addAnnotatedClass(Color.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
	
		int id = 4;
		try {
			session.beginTransaction();
			Car c = session.get(Car.class, id);		
			
			session.delete(c);
			
			session.getTransaction().commit();
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.toString());
		} finally {
			//session.close();
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
/*Criteria c = session.createCriteria(Client.class);
//c.setProjection(Projections.min("id"));
//c.setProjection(Projections.max("id"));
//c.setProjection(Projections.avg("id"));
//c.setProjection(Projections.count("address"));
//c.setProjection(Projections.countDistinct("address"));
List<Client> clients = c.list();
System.out.println("Min : " + clients.get(0));
/*for(int i=0;i<clients.size();i++) {
	System.out.println(clients.get(i).getFullName() + " " + clients.get(i).getAge());
}*/

//System.out.println(c.getFullName() + " " + c.getAddress());
/*Person p = new Person();
p.setName("Eslam Khder");

Data data = new Data();
data.setAge("20");
session.save(data);
*/
/*
Person p = new Person();
p.setId(1);

Person res = session.get(Person.class, p.getId());

System.out.println("Name: " + res.getName());
System.out.println("Age: " + res.getData().getAge());

res.setName("Karim");
res.getData().setAge("50");
*/
/*
Data d = new Data();
d.setId(1);

Data res = session.get(Data.class,d.getId());

System.out.println("Name: " + res.getAge());
System.out.println("Age: " + res.getPerson().getName());
*/
//session.delete(res);
/*
int id = 10;

Student student = new Student();
student = session.get(Student.class, id);


session.close();
System.out.println(student.getName());
System.out.println(student.getInfos().get(0).getPhone());


student.setName("Yaser");

student.getInfos().get(0).setPhone("015");
student.getInfos().get(1).setPhone("012");

session.update(student);

System.out.println(student.getName());

for(Info i : student.getInfos()) {
	System.out.println(i.getPhone());
}*/
/*Student student = new Student();
student.setName("Ahmed");

Info info1 = new Info();
info1.setPhone("01245889955");

Info info2 = new Info();
info2.setPhone("01145898875");

student.getInfos().add(info1);
student.getInfos().add(info2);

info1.setStudent(student);
info2.setStudent(student);

session.delete(student);
*/
//session.save(student);
/*Car c1 = new Car("Car1");
Car c2 = new Car("Car2");
Car c3 = new Car("Car3");
////////////////////////////////////////
Color co1 = new Color("red");
Color co2 = new Color("blue");
Color co3 = new Color("yellow");
////////////////////////////////////////
co1.getCars().add(c1);
co1.getCars().add(c2);
co1.getCars().add(c3);
////////////////////////////////////////
co2.getCars().add(c1);
co2.getCars().add(c2);
co2.getCars().add(c3);
////////////////////////////////////////
co3.getCars().add(c1);
co3.getCars().add(c2);
co3.getCars().add(c3);

session.save(co1);
session.save(co2);
session.save(co3);
*/
