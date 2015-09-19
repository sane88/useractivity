package com.vr.useractivity.dao;


import com.vr.useractivity.domain.UserActivity;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Date;

@Repository
public class UserActivityDaoImpl implements UserActivityDao{

    @Autowired
    private SessionFactory sessionFactory;


    public Collection<UserActivity> getAll() {
        return sessionFactory.getCurrentSession().createCriteria(UserActivity.class).list();
    }

    public Collection<UserActivity> getForPeriodAndForUsers(Date from, Date to, Collection<Integer> userIds) {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(UserActivity.class);
        criteria.add(Restrictions.in("id.user.userId", userIds));
        criteria.add(Restrictions.between("id.activityDate", from, to));
        return criteria.list();
    }


}
