package com.testtask.my.util;

import com.testtask.my.entity.Part;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository
public class HibernateUtil {

    @Autowired
    private SessionFactory sessionFactory;

    public Serializable createPart(Part part) {
        return sessionFactory.getCurrentSession().save(part);
    }

    public Part updatePart(Part part) {
        sessionFactory.getCurrentSession().update(part);
        return part;
    }

    public Query getQuery(String query) {
        return sessionFactory.getCurrentSession().createQuery(query);
    }

    @SuppressWarnings("unchecked")
    public <T> T searchById(Serializable id, Class<T> partClass) {
        return sessionFactory.getCurrentSession().get(partClass, id);
    }

    public void deletePart(Part part) {
        sessionFactory.getCurrentSession().delete(part);
    }
}
