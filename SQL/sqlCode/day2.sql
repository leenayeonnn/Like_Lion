use exampleDB;

desc dept;

SELECT grade,
       losal,
       hisal
FROM salgrade;

SELECT *
FROM salgrade;

SELECT DISTINCT mgr
              , empno
FROM emp;

SELECT empno 사번
     , ename 사원이름
FROM emp;

SELECT CURRENT_DATE;

-- concat : 문자열을 붙여서 데이터 결과를 가져옴
SELECT CONCAT('test' 'hello', empno)
from emp;

SELECT CONCAT(ename, '사원의 매니저는 ', mgr, '입니다.')
FROM emp;

-- ORDER BY : 정렬 / ASC = 기본, 오름차순 / DESC = 내림차순
SELECT ename
     , sal
     , mgr
FROM emp
ORDER BY sal DESC, mgr, ename ASC;

SELECT dname
FROM dept
ORDER BY dname;

-- WHERE : 조건
SELECT *
FROM emp
WHERE ename = 'king';

SELECT *
FROM emp
WHERE sal > 2000;

SELECT *
FROM emp
WHERE sal > 2000
   OR deptno = 20;

SELECT *
FROM emp
WHERE sal > 2000
  AND deptno = 20;

SELECT *
FROM emp
WHERE deptno != 20;

-- NULL 비교
SELECT *
FROM emp
WHERE comm IS NULL;

SELECT *
FROM emp
WHERE comm IS NOT NULL;

-- IN, ANY, ALL : 비교 연산자
SELECT *
FROM emp
WHERE deptno = 10
   OR deptno = 20;

SELECT *
FROM emp
WHERE deptno IN (10, 20);

-- mySQL 특 :  DB내 값의 대소문자 구분을 하지 않음
SELECT *
FROM emp
WHERE job = 'MANAGER';

SELECT *
FROM emp
WHERE job = 'manager';

-- LIKE 와일드 카드
-- _ : 문자 하나 / % : 0 ~ 여러개
SELECT *
FROM emp
WHERE job LIKE '_ANAGER';

SELECT *
FROM emp
WHERE job LIKE '%S%';

SELECT *
FROM emp
WHERE ename LIKE '__A%';

SELECT *
FROM emp
WHERE hiredate LIKE '__81%';

-- 문자형 함수
SELECT UPPER('SEoul')
     , LOWER('SEoul');

SELECT UPPER(ename)
FROM emp;

SELECT *
FROM emp
WHERE UPPER(ename) = 'SMITH';

SELECT SUBSTR('HAPPY DAY', 3, 2);

SELECT TRIM('     test       ')
     , RTRIM('    test    ')
     , LTRIM('       test         ');

SELECT LPAD('hi', 5, '*')
     , RPAD('hi', 5, '#');

SELECT LPAD(ename, 10, '*')
FROM emp;

-- 숫자형 함수
SELECT ABS(2)
     , ABS(-2);

SELECT MOD(34, 10)
     , 34 % 4 나눈나머지값;

SELECT FLOOR(1.23)
     , CEILING(1.23)
     , ROUND(1.4)
     , ROUND(1.6);

SELECT ROUND(1.244, 2);

SELECT POW(2, 2);

SELECT SIGN(-32)
     , SIGN(32)
     , SIGN(0);

SELECT GREATEST(4, 2, 6, 3, 7, 5)
     , LEAST(4, 26, 3, 7, 523);

SELECT SIGN(ename)
FROM emp;

SELECT UPPER(sal)
FROM emp;

-- 날짜형 함수
SELECT CURRENT_DATE
     , CURDATE();

SELECT CURRENT_TIME
     , CURRENT_TIMESTAMP;

SELECT NOW()
     , SYSDATE()
     , CURRENT_TIMESTAMP;

SELECT DATE_FORMAT(CURDATE(), '%w %M %y');
SELECT DATE_FORMAT(CURDATE(), '%Y.%m.%d');

SELECT ename
     , PERIOD_DIFF(DATE_FORMAT(CURDATE(), '%Y%m'),
                   DATE_FORMAT(hiredate, '%Y%m'))
FROM emp;

-- 형변환 함수
SELECT NOW();
SELECT CAST(NOW() AS DATE);
SELECT CAST('234' AS SIGNED);
SELECT CAST(123 AS CHAR);
SELECT CAST(NOW() AS CHAR);

-- 그룹함수 : 여러 행에 대해서 결과값이 1개
SELECT SUM(sal)
FROM emp;

# SELECT ename  -- GROUPING에 사용되지 않는 컬럼 같이 사용 불가
#      , SUM(sal)
# FROM emp;

SELECT deptno -- GROUPING 시 해당 컬럼 사용 가능
     , SUM(sal)
FROM emp
GROUP BY deptno;

SELECT COUNT(ename) -- NULL 값이 아닌 레코드만 COUNT
FROM emp;

SELECT COUNT(*) -- 모든것이 NULL 인것 제외하고 COUNT
FROM emp;

SELECT deptno
     , COUNT(*)
FROM emp
GROUP BY deptno;

SELECT deptno
     , MAX(sal) 최대
     , MIN(sal) 최소
     , AVG(sal) 평균
     , SUM(sal) 합
FROM emp
GROUP BY deptno;

-- HAVING : GROUPING 된 것에 조건 넣기
SELECT deptno
     , AVG(sal) 평균
FROM emp
GROUP BY deptno
HAVING AVG(sal) > 2000;

SELECT deptno
     , AVG(sal) 평균
FROM emp
WHERE sal < 4500
  AND sal > 1000
GROUP BY deptno
HAVING AVG(sal) > 2000;