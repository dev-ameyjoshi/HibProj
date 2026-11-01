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
            l1.setModel("Rog");
            l1.setRam(16);

            Laptop l2 = new Laptop();
            l2.setLid(2);
            l2.setBrand("Lenovo");
            l2.setModel("Legion");
            l2.setRam(32);

            Alien a1 = new Alien();
            a1.setAid(101);
            a1.setaName("Amey");
            a1.setTech("Java");
            a1.setLaptops(Arrays.asList(l1,l2));

            l1.setAlien(a1);
            l2.setAlien(a1);


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
            session.persist(a1);

            // to update or create data (if data does not exsist)
            //session.merge(s1);

            // first you find the object then you remove the object.
            //session.remove(s1);


            transaction.commit();

            Alien a2 = session.find(Alien.class,101);
            System.out.println(a2);


            session.close();

            sf.close();


        }
    }
