package com.example.jpa.exampleDB.user;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class UserRun {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("UserPU");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

//        // 엔티티 생성 -- 아직 영속성 컨텍스트가 관리 X
//        User user = new User();
////        user.setId(1L);
//        user.setName("lee");
//        user.setEmail("lee@email.com");
//
//        entityManager.getTransaction().begin();
//
//        // 영속성 컨텍스트에게 관리 넘김
//        entityManager.persist(user);
//
//        // commit 통해 DB에 저장
//        entityManager.getTransaction().commit();

        /////////////////////////////

        // Update

//        entityManager.getTransaction().begin();
//        User user1 = entityManager.find(User.class, 1L);
//
//        // 영속성 컨테이너에 저장된 객체 수정
//        // 스냅샷의 객체와 현재 수정된 객체가 다름
//        // => 업데이트 자동 진행
//        // 이때, 매번 변경될때 마다 비교하는 것이 아닌
//        // 마지막 작업이 끝날때 (ex commit 수행) 비교가 진행이 됨
//        user1.setEmail("new@email.com");
//        entityManager.getTransaction().commit();


        /////////////////////////////////

        // Delete

        entityManager.getTransaction().begin();

        User user1 = entityManager.find(User.class, 1L);
        entityManager.remove(user1);

        entityManager.getTransaction().commit();
    }
}
