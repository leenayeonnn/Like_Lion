package org.example.iocexam.iocexam.dao;

import java.util.List;
import org.example.iocexam.iocexam.domain.User;
import org.springframework.stereotype.Component;

@Component
public class UserTestDAOImple implements UserDAO {
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
        System.out.println(user + "의 정보를 testDAO 를 통해 저장했습니다.");
    }
}
