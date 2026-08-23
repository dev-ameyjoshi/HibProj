package com.amey;

//import jdk.jfr.Configuration;
//import jdk.vm.ci.meta.Assumptions;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {
            //post using the configuration from hibernate we will need to define our dbms such as the connection and database credentials.





            SessionFactory sf = new Configuration()
                                .addAnnotatedClass(com.amey.student.class)
                                .configure()
                                .buildSessionFactory();


            //SessionFactory sf = cfg.buildSessionFactory(); // to be used once per database in the application.
            Session session = sf.openSession();
            //s1 = session.find(student.class,102); // to read data
            Transaction transaction = session.beginTransaction(); //required only when we are making changes in the database.


            //session.persist(s1); // to create data
            //session.merge(s1); // to update or create data (if data does not exsist)

            session.remove(s1); // first you find the object then you remove the object.
            transaction.commit();
            session.close();
            sf.close();

            System.out.println(s1);
        }
    }
