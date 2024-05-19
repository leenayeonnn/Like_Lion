package org.example.iocexam.iocexam.dao;

import java.util.List;
import org.example.iocexam.iocexam.domain.User;

public interface UserDAO {
    public User getUser(String email);
    public List<User> getUser();
    public void addUser(User user);
}
