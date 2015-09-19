package com.vr.useractivity.dao;


import com.vr.useractivity.domain.User;

import java.util.Collection;
import java.util.Date;

public interface UserDao {
    Collection<User> getAll();
}
