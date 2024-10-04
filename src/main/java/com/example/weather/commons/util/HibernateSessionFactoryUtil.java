package com.example.weather.commons.util;

import com.example.weather.entity.Session;
import com.example.weather.entity.User;
import com.example.weather.entity.Location;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class HibernateSessionFactoryUtil {
    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            Configuration configuration = new Configuration().configure();

            configuration.addAnnotatedClass(User.class);
            configuration.addAnnotatedClass(Location.class);
            configuration.addAnnotatedClass(Session.class);

            sessionFactory = configuration.buildSessionFactory();
        }
        return sessionFactory;
    }
}
