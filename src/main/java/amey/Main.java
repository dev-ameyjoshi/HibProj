package amey;

//import jdk.jfr.Configuration;
//import jdk.vm.ci.meta.Assumptions;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
            //post using the configuration from hibernate we will need to define our dbms such as the connection and database credentials.

            Laptop l1 = new Laptop();
            l1.setLid(1);
            l1.setBrand("Asus");
            l1.setModel("Ultrabook");
            l1.setRam(32);

            Laptop l2 = new Laptop();
            l2.setLid(2);
            l2.setBrand("Asus");
            l2.setModel("Rog");
            l2.setRam(16);

            Laptop l3 = new Laptop();
            l3.setLid(3);
            l3.setBrand("Apple");
            l3.setModel("Mac");
            l3.setRam(12);

            Alien a1 = new Alien();
            a1.setAid(101);
            a1.setaName("Amey");
            a1.setTech("Java");


            Alien a2 = new Alien();
            a2.setAid(102);
            a2.setaName("Harsh");
            a2.setTech("JavaScript");


            Alien a3 = new Alien();
            a3.setAid(103);
            a3.setaName("Sam");
            a3.setTech("TypeScript");


            a1.setLaptops(Arrays.asList(l1,l2));
            a2.setLaptops(Arrays.asList(l2,l3));
            a3.setLaptops(Arrays.asList(l1));

            l1.setAliens(Arrays.asList(a1,a2));
            l2.setAliens(Arrays.asList(a2,a3));
            l3.setAliens(Arrays.asList(a2));


            SessionFactory sf = new Configuration()
                                .addAnnotatedClass(Alien.class)
                                .addAnnotatedClass(Laptop.class)
                                .configure()
                                .buildSessionFactory();

            // to be used once per database in the application.
            //SessionFactory sf = cfg.buildSessionFactory();

            Session session = sf.openSession();

            // to read data
            //s1 = session.find(student.class,102);

            //required only when we are making changes in the database.
            Transaction transaction = session.beginTransaction();

            // to create data
            session.persist(l1);
            session.persist(l2);
            session.persist(l3);

            session.persist(a1);
            session.persist(a2);
            session.persist(a3);

            // to update or create data (if data does not exsist)
            //session.merge(s1);

            // first you find the object then you remove the object.
            //session.remove(s1);


            transaction.commit();

            Alien a5 = session.find(Alien.class,102);
            System.out.println(a5);


            session.close();

            sf.close();


        }
    }
