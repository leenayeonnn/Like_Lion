USE hr;

SELECT e.employee_id
     , e.first_name
     , e.email
     , d.department_name
     , l.city
FROM employees e
   , departments d
   , locations l
WHERE e.department_id = d.department_id
  AND d.location_id = l.location_id;

-- ex
-- 1. 각 직원의 이름과, 그들이 속한 부서 이름을 조회하세요.
SELECT e.first_name
     , e.last_name
     , d.department_name
FROM employees e
     JOIN departments d USING (department_id);

-- 2. 모든 직원의 이름과 그들의 job_title 을 조회하세요.
SELECT e.first_name
     , e.last_name
     , j.job_title
FROM employees e
     LEFT JOIN jobs j USING (job_id);

-- 3. 모든 직원의 이름, 부서이름, 근무하는 국가이름(country_name) 을 조회하세요.
SELECT e.first_name
     , e.last_name
     , d.department_name
     , c.country_name
FROM employees e
     LEFT JOIN departments d USING (department_id)
     LEFT JOIN locations l USING (location_id)
     LEFT JOIN countries c USING (country_id);

-- 4. 1999년 이후에 입사한 직원들과 그들의 job-title을 조회하세요.
SELECT e.*
     , j.job_title
FROM employees e
     LEFT JOIN jobs j USING (job_id)
WHERE EXTRACT(YEAR FROM e.hire_date) >= 1999;

-- 5. 모든 직원의 이름과 그들이 근무한 지역 이름(region_name)을 조회하세요.
SELECT e.first_name
     , e.last_name
     , r.region_name
FROM employees e
     LEFT JOIN departments d USING (department_id)
     LEFT JOIN locations l USING (location_id)
     LEFT JOIN countries c USING (country_id)
     LEFT JOIN regions r USING (region_id);

-- 6. 각 부서에서 근무하는 직원 수를 부서 이름과 함께 조회하세요. (join, group by)
SELECT d.department_name
     , COUNT(*)
FROM employees e
     JOIN departments d USING (department_id)
GROUP BY e.department_id;

-- 7. 모든 지역(region)과 해당 지역에 위치한 국가들을 조회하세요.
SELECT r.region_id
     , c.country_name
FROM regions r
     LEFT JOIN countries c USING (region_id);

-- 8. 각 부서의 위치 정보와 해당 위치의 도시 이름을 조회하세요.
SELECT d.department_name
     , l.city
FROM departments d
     LEFT JOIN locations l USING (location_id);

-- 9. 각 부서에서 근무하는 모든 직원의 이름과 부서 이름, 그리고 직무를 조회하세요.
SELECT d.department_name
     , e.first_name
     , e.last_name
     , j.job_title
FROM departments d
     JOIN employees e USING (department_id)
     LEFT JOIN jobs j USING (job_id);

-- 10. 각 직원의 이름과 그들의 입사 날짜, 그리고 그들이 근무한 모든 부서의 이름을 조회하세요.
SELECT e.first_name
     , e.last_name
     , e.hire_date
     , d.department_name
FROM employees e
     LEFT JOIN job_history jh ON e.employee_id = jh.employee_id
     LEFT JOIN departments d ON jh.department_id = d.department_id;