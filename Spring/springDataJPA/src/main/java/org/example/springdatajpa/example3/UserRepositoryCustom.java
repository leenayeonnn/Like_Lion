package org.example.springdatajpa.example3;

import java.util.List;

public interface UserRepositoryCustom {
    public List<User> findUsersByName(String name);
    public List<User> findUsersDynamically(String name, String email);
}
