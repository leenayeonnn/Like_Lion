package com.example.jpa.hr;

import com.example.jpa.JPAUtil;
import jakarta.persistence.EntityManager;

public class Run {
    public static void main(String[] args) {
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();

        em.getTransaction().begin();

        try{
            Country country = em.find(Country.class, "JP");
            System.out.println(country.getName());
            System.out.println(country.getRegion().getName());
        } finally{
            em.close();
        }
    }
}
