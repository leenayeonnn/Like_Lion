package com.example.jpa.exampleDB.school;

import com.example.jpa.JPAUtil;
import jakarta.persistence.EntityManager;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SchoolExamMain {
    private static void find() {
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        em.getTransaction().begin();

        try {
//            School school = em.find(School.class, 1L);
//            log.info("school Name : {}", school.getName());
//
//            for (Student student : school.getStudents()) {
//                log.info("Student name : {}", student.getName());
//            }

            Student student = em.find(Student.class, 5L);
            log.info("Student name : {}", student.getName());
            log.info("Student school : {}", student.getSchool());

        } finally {
            em.close();
        }
    }

    private static void create() {
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        em.getTransaction().begin();

        try {
            School school = new School("Lion school");

            Student student1 = new Student("lee", school);
            Student student2 = new Student("jack", school);
            Student student3 = new Student("james", school);

            school.getStudents().add(student1);
            school.getStudents().add(student2);
            school.getStudents().add(student3);

            em.persist(school);

            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    private static void update() {
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        em.getTransaction().begin();

        try {
            School school = em.find(School.class, 3L);
            school.setName("new Lion School");

            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    private static void delete() {
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        em.getTransaction().begin();

        try {
            School school = em.find(School.class, 3L);
            em.remove(school);

            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public static void main(String[] args) {
//        find();
//        create();
//        update();
        delete();
    }
}
