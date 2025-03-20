package com.zhsaidk;

import com.zhsaidk.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDate;

public class HibernateRunner {
    public static void main(String[] args) throws SQLException {

        Configuration configuration = new Configuration();
        configuration.configure();
        configuration.addAnnotatedClass(User.class);

        try(SessionFactory sessionFactory = configuration.buildSessionFactory();
            Session session = sessionFactory.openSession()){
            session.beginTransaction();
            User user = User.builder()
                    .firstname("Zhavokhir")
                    .lastname("Saitkulov")
                    .username("zhavokhir@gmail.com")
                    .birthDate(LocalDate.of(2002, 4, 30))
                    .build();

            session.persist(user);
            session.getTransaction().commit();
        }
    }
}
