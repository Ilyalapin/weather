package com.example.weather.dao;

import com.example.weather.entity.User;
import com.example.weather.commons.util.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.Optional;

public class UserDao extends Dao<User> {


    public Optional<User> findByName(String login) {
        Optional<User> user;
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().getCurrentSession()) {
            session.beginTransaction();

            Query<User> query = session.createQuery("from User u where u.login= :login", User.class);
            query.setParameter("login", login);

            user = Optional.ofNullable(query.getSingleResult());

            session.getTransaction().commit();
        }
        return user;
    }
}
