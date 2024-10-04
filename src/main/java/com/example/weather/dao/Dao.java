package com.example.weather.dao;

import com.example.weather.commons.exception.EntitiesException;
import com.example.weather.commons.util.HibernateSessionFactoryUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public abstract class Dao<T> {

    public T add(T entity) {
        Transaction transaction = null;

        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().getCurrentSession()) {
            transaction = session.beginTransaction();
            session.persist(entity);
            transaction.commit();
        } catch (HibernateException exception) {
            if (transaction != null) {
                transaction.rollback();
                throw new EntitiesException("User already exists");
            }
        }
        return entity;
    }


    public void delete(T entity) {
        Transaction transaction = null;
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().getCurrentSession()) {
            transaction = session.beginTransaction();

            session.remove(entity);
            session.flush();
            session.clear();

            transaction.commit();
        } catch (HibernateException exception) {
            if (transaction != null) {
                transaction.rollback();
                throw new EntitiesException("Deletion error");
            }
        }
    }
}
