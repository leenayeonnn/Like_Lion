package org.example.springdatajpa.example2;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    List<Customer> findByName(String name);
    Customer findByEmail(String email);
    List<Customer> findByEmailContaining(String str);

    @Query("SELECT c, COUNT(o) FROM Customer c LEFT JOIN c.orders o GROUP BY c")
    List<Object[]> findCustomerOrderCount();

    @Query("SELECT c, o FROM Customer c LEFT JOIN c.orders o WHERE o.date = (SELECT MAX(o2.date) FROM Order o2 WHERE o2.customer = c)")
    List<Object[]> findCustomerLatestOrder();

    @Query("SELECT c FROM Customer c WHERE c.age > (SELECT AVG(c2.age) FROM Customer c2)")
    List<Customer> findCustomerAgeOverAvg();
}
