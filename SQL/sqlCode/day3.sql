USE exampledb;

SELECT ename
     , job
     , sal
FROM emp
WHERE sal BETWEEN 2000 AND 3000;

DESC emp;
DESC dept;

SELECT emp.ename
     , dept.dname
FROM emp
   , dept;

SELECT ename
     , dname
     , e.deptno
FROM emp e
   , dept d;

-- ////////////////////////

-- equi join
SELECT e.ename
     , d.dname
FROM emp e
   , dept d
WHERE e.deptno = d.deptno;

SELECT e.ename
     , d.dname
     , e.sal
FROM emp e
   , dept d
WHERE e.deptno = d.deptno
  AND sal >= 2500;

SELECT e.ename
     , d.dname
     , e.sal
FROM emp e
   , dept d
WHERE e.deptno = d.deptno
  AND e.sal >= 2500
  AND d.dname = 'RESEARCH';

-- theta join
SELECT e.ename
     , e.sal
     , s.grade
FROM emp e
   , salgrade s
WHERE e.sal BETWEEN s.losal AND s.hisal;

-- natural join
SELECT e.ename
     , d.dname
FROM emp e
     NATURAL JOIN dept d;

-- inner join
SELECT e.ename
     , d.dname
FROM emp e
     JOIN dept d USING (deptno);

SELECT e.ename
     , d.dname
FROM emp e
     JOIN dept d ON (e.deptno = d.deptno);

INSERT INTO emp
VALUES (8000, 'KANG', 'CLERK', 7902, STR_TO_DATE('17-12-1980', '%d-%m-%Y'), 6000, NULL, NULL);

-- outer join
SELECT e.ename
     , d.dname
FROM emp e
     LEFT JOIN dept d ON e.deptno = d.deptno;

SELECT e.ename
     , d.dname
FROM emp e
     RIGHT JOIN dept d USING (deptno);

SELECT e.ename
     , d.dname
FROM emp e
     JOIN dept d USING (deptno);

SELECT e.ename -- mySQL 은 full 제공 X => Union 사용
     , d.dname
FROM emp e
     LEFT JOIN dept d ON e.deptno = d.deptno
UNION
SELECT e.ename
     , d.dname
FROM emp e
     RIGHT JOIN dept d USING (deptno);

-- self join
SELECT e.ename
     , m.ename
FROM emp e
   , emp m
WHERE e.mgr = m.empno;

SELECT e.ename 사원명
     , m.ename 매니저이름
FROM emp e
     LEFT JOIN emp m ON (e.mgr = m.empno);

-- /////////////////////////

-- single row sub query
SELECT AVG(sal)
FROM emp
WHERE deptno = (SELECT deptno
                FROM emp
                WHERE ename = 'SMITH');

SELECT ename
FROM emp
WHERE sal > (SELECT sal
             FROM emp
             WHERE ename = 'SCOTT');

SELECT ename
     , sal
FROM emp
WHERE sal < (SELECT AVG(sal)
             FROM emp);

SELECT ename
     , deptno
FROM emp
WHERE deptno = (SELECT deptno
                FROM dept
                WHERE dname = 'SALES');

-- multi row sub query
SELECT ename
     , sal
     , deptno
FROM emp
WHERE ename IN (SELECT MIN(ename)
                FROM emp
                GROUP BY deptno);

SELECT *
FROM emp
WHERE sal > ANY (SELECT AVG(sal)
                 FROM emp
                 GROUP BY deptno);

SELECT *
FROM emp
WHERE sal > ALL (SELECT AVG(sal)
                 FROM emp
                 GROUP BY deptno);

SELECT *
FROM emp
WHERE sal < ALL (SELECT AVG(sal)
                 FROM emp
                 GROUP BY deptno);

-- correlated query
SELECT *
FROM emp e1
WHERE sal > (SELECT AVG(sal)
             FROM emp e2
             WHERE e1.deptno = e2.deptno);

SELECT ename
     , deptno
     , sal
FROM emp
WHERE (deptno, sal) IN (SELECT deptno
                             , MAX(sal)
                        FROM emp
                        GROUP BY deptno);

SELECT e1.ename
     , e1.deptno
     , e1.sal
FROM emp e1
   , (SELECT e2.deptno
           , MAX(e2.sal) max_sal
      FROM emp e2
      GROUP BY deptno) m
WHERE e1.deptno = m.deptno
  AND e1.sal = m.max_sal;

-- /////////////////////////
CREATE TABLE a
(
    name INT
);

CREATE TABLE b
(
    name INT
);

INSERT INTO a
    VALUE (1);
INSERT INTO a
    VALUE (2);
INSERT INTO a
    VALUE (3);

INSERT INTO b
    VALUE (2);
INSERT INTO b
    VALUE (3);
INSERT INTO b
    VALUE (4);

-- union
SELECT *
FROM a
UNION
SELECT *
FROM b;

SELECT *
FROM a
UNION ALL
SELECT *
FROM b;

-- intersect
SELECT a.name
FROM a
   , b
WHERE a.name = b.name;

-- minus
SELECT a.name
FROM a
WHERE a.name NOT IN (SELECT name
                     FROM b);

DROP TABLE a;
DROP TABLE b;

-- /////////////////////////
-- rank
SELECT sal
     , ename
     , RANK() OVER (ORDER BY sal DESC) AS ranking
FROM emp;