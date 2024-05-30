package com.example.jpa.exampleDB.user;

import com.example.jpa.JPAUtil;
import jakarta.persistence.EntityManager;

public class UserDAO {
    public User findUser(Long id) {
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        try {
            User user = em.find(User.class, id);
            em.close();
            return user;
        } finally {
            em.close();
        }
    }

    public void create(User user) {
        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
        try {
            entityManager.getTransaction().begin();

            entityManager.persist(user);

            entityManager.getTransaction().commit();
        } finally {
            entityManager.close();
        }
    }

    public void updateUser(User user) {
        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();

        try {
            entityManager.getTransaction().begin();

            // 영속성 컨텍스트에 없는 유저를 컨텍스트에 연동시키기
            // 이때, DB에 적용시
            // 없으면 새롭게 등록
            // 있으면 id가 맞는걸 찾아서 수정
            entityManager.merge(user);

            entityManager.getTransaction().commit();
        } finally {
            entityManager.close();
        }
    }

    public void deleteUser(User user) {
        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();

        try{
            entityManager.getTransaction().begin();

            // 컨텍스트에 없으면 일단 컨텍스트에 연동하는 작업이 필요함
            entityManager.remove(entityManager.contains(user) ? user : entityManager.merge(user));

            entityManager.getTransaction().commit();
        } finally {
            entityManager.close();
        }
    }

//    private EntityManagerFactory entityManagerFactory;

//    public UserDAO() {
//        entityManagerFactory = Persistence.createEntityManagerFactory("UserPU");
//    }

//    public void close() {
//        if (entityManagerFactory != null) {
//            entityManagerFactory.close();
//        }
//    }
}
