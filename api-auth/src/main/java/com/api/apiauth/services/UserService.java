package com.api.apiauth.services;

import com.api.apiauth.models.User;

import java.util.List;

public interface UserService {
    User save(User user);
    List<User> findAll(int page, int size);
    void delete(long id);
    User findOne(String username);

    User findById(Long id);
}
