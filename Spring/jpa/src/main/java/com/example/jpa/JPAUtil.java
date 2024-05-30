package com.example.jpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JPAUtil {
    private JPAUtil() {
    }

    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("UserPU");

    public static EntityManagerFactory getEntityManagerFactory() {
        return emf;
    }

    // 어플리케이션 종료 시 자동으로 close 메스드 호출되게 구성
    static {
        Runtime.getRuntime().addShutdownHook(new Thread((() -> {
            if (emf != null) {
                System.out.println("--------- emf close ----------");
                emf.close();
            }
        })));
    }
}
