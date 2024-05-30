package com.example.jpa.exampleDB.passport;

import com.example.jpa.JPAUtil;
import jakarta.persistence.EntityManager;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PassportExamMain {
    private static void find() {
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        em.getTransaction().begin();
        try {
            Passport passport = em.find(Passport.class, 1L);
            log.info("Found Passport : {}", passport.getPassportNumber());
            log.info("Passport Owner : {}", passport.getPerson().getName());

            Person person = em.find(Person.class, 2L);
            log.info("Found Person : {}", person.getName());
            log.info("Person's Passport : {}", person.getPassport().getPassportNumber());

            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw e;
        } finally {
            em.close();
        }
    }

    private static void create() {
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        em.getTransaction().begin();
        try {

            Person person = new Person("jack");
            Passport passport = new Passport("C12344567");
            passport.setPerson(person);
            person.setPassport(passport);

            em.persist(person);

            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw e;
        } finally {
            em.close();
        }
    }

    private static void update() {
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        em.getTransaction().begin();
        try {
            Person person = em.find(Person.class, 3L);
            person.setName("new Jack");
            person.getPassport().setPassportNumber("N1230948712983");

            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw e;
        } finally {
            em.close();
        }
    }

    private static void delete() {
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        em.getTransaction().begin();
        try {
            Person person = em.find(Person.class, 3L);
            em.remove(person);

            Passport passport = em.find(Passport.class, 1L);
            if (passport != null) {
                passport.getPerson().setPassport(null);
            }
            em.remove(passport);

            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw e;
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
