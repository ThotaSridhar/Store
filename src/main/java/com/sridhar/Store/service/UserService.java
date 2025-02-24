package com.sridhar.Store.service;

import com.sridhar.Store.domain.Users;

public interface UserService {
    public String register(Users user);

    public String login(Users user);
}
