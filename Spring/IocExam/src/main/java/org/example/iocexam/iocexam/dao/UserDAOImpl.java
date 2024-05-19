package org.example.iocexam.iocexam.dao;

import java.util.List;
import org.example.iocexam.iocexam.domain.User;
import org.springframework.stereotype.Component;

@Component
public class UserDAOImpl implements UserDAO {

    @Override
    public User getUser(String email) {
        return null;
    }

    @Override
    public List<User> getUser() {
        return null;
    }

    @Override
    public void addUser(User user) {
        System.out.println(user + "의 정보가 저장되었습니다.");
    }
}
