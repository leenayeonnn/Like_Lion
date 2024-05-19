package org.example.iocexam.iocexam.service;

import org.example.iocexam.iocexam.dao.UserDAO;
import org.example.iocexam.iocexam.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class UserServiceImple implements UserService {
    private UserDAO userDAO;

    @Autowired
    @Qualifier("userTestDAOImple")
    public void setUserDAO(UserDAO userDAO){
        this.userDAO = userDAO;
    }

//    public UserServiceImple(UserDAO userDAO) {
//        this.userDAO = userDAO;
//    }

    @Override
    public void joinUser(User user) {
        // 회원 가입 위한 비즈니스 코드

        // 수행 후 해당 데이터 저장하는 코드 실행
        userDAO.addUser(user);
    }
}
