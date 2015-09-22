package com.vr.useractivity.dao;

import com.vr.useractivity.entity.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    public Collection<User> getAll() {
        return sessionFactory.getCurrentSession().createCriteria(User.class).list();
    }

}
