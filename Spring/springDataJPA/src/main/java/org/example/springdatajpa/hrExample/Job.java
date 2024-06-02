package org.example.springdatajpa.hrExample;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import java.util.Set;

@Entity
@Table(name = "jobs")
public class Job {
    @Id
    @Column(name = "job_id")
    private String id;

    @Column(name = "job_title")
    private String title;

    @Column(name = "min_salary")
    private BigDecimal minSalary;

    @Column(name = "max_salary")
    private BigDecimal maxSalary;

//    @OneToMany(mappedBy = "job")
//    private Set<Employee> employees;
//
//    @OneToMany(mappedBy = "job")
//    private Set<JobHistory> jobHistories;
}