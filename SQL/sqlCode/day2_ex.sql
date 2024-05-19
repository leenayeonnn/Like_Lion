USE hr;

SELECT first_name
     , last_name
FROM employees;

SELECT department_name
     , location_id
FROM departments;

SELECT job_id
     , job_title
FROM jobs;

SELECT street_address
     , postal_code
FROM locations;

SELECT country_id
     , country_name
FROM countries;

SELECT region_id
     , region_name
FROM regions;

SELECT employee_id
     , job_id
FROM employees;

SELECT department_id
     , department_name
FROM departments
GROUP BY department_id;

SELECT employee_id
     , department_id
FROM job_history;

SELECT employee_id
     , first_name
     , last_name
FROM employees;

-- ///////////////
SELECT first_name
     , last_name
     , salary
FROM employees
WHERE salary >= 10000;

SELECT department_name
FROM departments
WHERE location_id = 1700;

SELECT *
FROM employees
WHERE job_id = 'IT_PROG';

SELECT first_name
     , last_name
     , salary
FROM employees
WHERE department_id = 90;

SELECT job_title
FROM jobs
WHERE min_salary >= 5000;

SELECT *
FROM employees
WHERE last_name = 'King';

SELECT *
FROM locations
WHERE country_id = 'US';

SELECT *
FROM job_history
WHERE start_date < '2001-01-01';

SELECT first_name
     , last_name
     , email
FROM employees
WHERE last_name LIKE '%a%';

SELECT *
FROM departments d
LEFT JOIN employees e on d.department_id = e.department_id
WHERE department_name = 'Sales';
