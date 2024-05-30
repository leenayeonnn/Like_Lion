package com.example.jpa.exampleDB.user;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class UserMain {
//    private static final Logger log = LoggerFactory.getLogger(UserMain.class);

    public static void main(String[] args) {
        UserDAO userDAO = new UserDAO();

        // create user
//        User user = new User("log", "log@email.com");
//
//        userDAO.create(user);
//
//        log.info("Created user: " + user.getName());
//        log.info("user email : {}", user.getEmail());

        ///////////////////////

//        // find user
//        log.info("+++ find user method test +++");
//        User user = userDAO.findUser(1L);
//        log.info("found user : {}, {}", user.getName(), user.getEmail());
//
//        User user2 = userDAO.findUser(1L);
//
//        if (user == user2) {
//            log.info("user == user2");
//        } else {
//            log.info("user != user2");
//        }

        /////////////////////

//        // update
//        User user = new User();
//        user.setId(6L);
//        user.setName("update");
//        user.setEmail("update@example.com");
//
//        userDAO.updateUser(user);

        /////////////////////

        // Delete
        User user = new User();
        user.setId(2L);
        userDAO.deleteUser(user);
    }
}
