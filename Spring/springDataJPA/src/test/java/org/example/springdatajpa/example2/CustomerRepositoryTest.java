package org.example.springdatajpa.example2;

import static org.assertj.core.api.Assertions.*;
//import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.context.jdbc.SqlGroup;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
class CustomerRepositoryTest {
    private static final Logger log = LoggerFactory.getLogger(CustomerRepositoryTest.class);
    @Autowired
    private CustomerRepository customerRepository;

    @BeforeEach
    void beforeEach(){
        log.info("-----> beforeEach");
    }

    @Test
    @DisplayName("저장 테스트")
    void save() {
        Customer customer = new Customer("lee", "lee@email.com");
        customerRepository.save(customer);

        assertThat(customerRepository.findByName("lee").size()).isEqualTo(1);
    }

    @Test
    @DisplayName("삭제 테스트")
    void delete() {
        customerRepository.deleteById(13L);
        assertThat(customerRepository.findById(13L)).isEmpty();
    }

    @Test
    @DisplayName("이름으로 찾기 테스트")
    void findByName() {
        List<Customer> customers = customerRepository.findByName("홍길동");
        assertThat(customers).hasSize(1);
    }

    @Test
    @DisplayName("이메일로 찾기 테스트")
    void findByEmail() {
        Customer customer = customerRepository.findByEmail("hong@example.com");
        assertThat(customer.getId()).isEqualTo(1L);
    }

    @Test
    @DisplayName("이메일에 특정 문자열 포함된 것 찾기 테스트")
    void findByEmailContaining() {
        List<Customer> customers = customerRepository.findByEmailContaining("example");
        assertThat(customers).hasSize(10);
    }

    @Test
    @DisplayName("각 고객별 주문 수 테스트")
    void findCustomerOderCount() {
        List<Object[]> countOrderByCustomer = customerRepository.findCustomerOrderCount();
        countOrderByCustomer.forEach(result -> {
           Customer customer = (Customer) result[0];
           Long count = (Long) result[1];

            log.info("customer {} :: order count {}", customer.getName(), count);
        });
    }

    @Test
    @DisplayName("각 고객별 가장 최근 주문 테스트")
    @SqlGroup({
            @Sql(value = "classpath:db/test.sql",
                    config = @SqlConfig(encoding = "utf-8", separator = ";", commentPrefix = "--"),
                    executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
    })
    void findCustomerLatestOrder() {
        List<Object[]> customerLatestOrder = customerRepository.findCustomerLatestOrder();
        customerLatestOrder.forEach(result -> {
            Customer customer = (Customer) result[0];
            Order order = (Order) result[1];

            log.info("customer {} :: order {}", customer.getName(), order.getDate());
        });
    }

    @Test
    @DisplayName("나이가 평균보다 높은 고객 테스트")
    void findCustomerAgeOverAvg() {
        List<Customer> customers = customerRepository.findCustomerAgeOverAvg();
        assertThat(customers)
                .extracting(Customer::getName)
                .containsExactlyInAnyOrder("박민수", "최지현", "윤서준", "임도연");

        customers.forEach(customer -> {
            customer.getOrders().forEach(order -> log.info(order.getProduct()));
        });
    }
}