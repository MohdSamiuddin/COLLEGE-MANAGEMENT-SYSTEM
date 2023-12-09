package CollegeManagement;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Management {
	public void add() {
		System.out.println("Enter id of Student ");
		Scanner sc = new Scanner(System.in);
		int id = sc.nextInt();
		System.out.println("Enter name of Student ");
		sc.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
		String name = sc.nextLine();
		
		System.out.println("Enter adress of Student ");
		String address = sc.nextLine();

		Configuration cfg = new Configuration();
		cfg.configure("CollegeManagement/hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();

		Session session = factory.openSession();
		Student s1 = new Student();
		s1.setId(id);
		s1.setName(name);
		s1.setAdd(address);

		Transaction tx = session.beginTransaction();
		session.persist(s1);
		tx.commit();
		factory.close();
		session.close();
	}

	public void update() {
		Configuration cfg = new Configuration();
		cfg.configure("CollegeManagement/hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();

		System.out.println("Enter id of Student ");
		Scanner sc = new Scanner(System.in);
		int id = sc.nextInt();
		System.out.println("Enter name of Student ");
		sc.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
		String name = sc.nextLine();

		Student s1 = (Student) session.get(Student.class, id);
		s1.setName(name);
		session.update(s1);
		tx.commit();
		session.close();
		factory.close();

	}

	public void delete() {
		Configuration cfg = new Configuration();
		cfg.configure("CollegeManagement/hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();

		System.out.println("Enter id of Student ");
		Scanner sc = new Scanner(System.in);
		int id = sc.nextInt();
		Student s1 = (Student) session.get(Student.class, id);
		session.delete(s1);
		tx.commit();
		session.close();
		factory.close();
	}

	public void show() {

		System.out.println("project is starting..");

		Configuration cfg = new Configuration();
		cfg.configure("CollegeManagement/hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		System.out.println("Enter id of Student ");
		Scanner sc = new Scanner(System.in);
		int id = sc.nextInt();
		Student s1 = (Student) session.get(Student.class, id);

		System.out.println(s1);
		factory.close();
		session.close();

	}
	

}
