package com.example.jpa.exampleDB.book;

import com.example.jpa.JPAUtil;
import jakarta.persistence.EntityManager;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BookExamRun {
    private static void find() {
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        em.getTransaction().begin();
        try {
            Author author = em.find(Author.class, 1L);
            log.info("Author name : {}", author.getName());

            for (Book book : author.getBooks()) {
                log.info("Book Name : {}", book.getTitle());
            }
        } finally {
            em.close();
        }
    }

    private static void create() {
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        em.getTransaction().begin();
        try {
            Author author = new Author("author1");

            List<Book> books = new ArrayList<Book>(Arrays.asList(
                    new Book("book1", author),
                    new Book("book2", author),
                    new Book("book3", author)
            ));

            author.setBooks(books);

            em.persist(author);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    private static void update() {
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        em.getTransaction().begin();
        try {
            Author author = em.find(Author.class, 3L);
            author.setName("new name");
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    private static void delete() {
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        em.getTransaction().begin();
        try {
            Author author = em.find(Author.class, 3L);
            em.remove(author);
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
