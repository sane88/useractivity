package com.vr.useractivity.dao;


import com.vr.useractivity.entity.User;

import java.util.Collection;

public interface UserDao {
    Collection<User> getAll();
}
