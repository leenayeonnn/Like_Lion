USE exampledb;

-- books
-- book_id : 책번호 (PK)
-- title : 제목
-- author : 저자
-- published_year : 출판연도

CREATE TABLE books
(
    book_id        INT PRIMARY KEY AUTO_INCREMENT,
    title          VARCHAR(100),
    author         VARCHAR(50),
    published_year DATE
);

INSERT
INTO books
VALUES (1, '모두의자바', '강경미', '2020-09-09');

INSERT
INTO books (title)
VALUES ('재밌는 SQL');

INSERT
INTO books(author, title)
VALUES ('강경미', 'test');

-- 튜플 수정
UPDATE books
SET author = 'kang'
WHERE book_id = 1;

-- 튜플 삭제
DELETE
FROM books
WHERE book_id = 1;

-- ////////////////////////////
CREATE TABLE owners
(
    id    INT PRIMARY KEY AUTO_INCREMENT,
    name  VARCHAR(50) NOT NULL,
    rrn   CHAR(14) CHECK (rrn LIKE '______-_______') NOT NULL UNIQUE,
    phone CHAR(13) CHECK (phone LIKE '___-____-____')
);

CREATE TABLE banks
(
    id   INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50) NOT NULL UNIQUE
);

CREATE TABLE accounts
(
    id             INT PRIMARY KEY AUTO_INCREMENT,
    account_number VARCHAR(50) NOT NULL UNIQUE,
    bank_id        INT NOT NULL,
    owner_id       INT NOT NULL,
    balance        INT DEFAULT 0,
    password       VARCHAR(6) NOT NULL,
    FOREIGN KEY (bank_id) REFERENCES banks (id) ON DELETE CASCADE,
    FOREIGN KEY (owner_id) REFERENCES owners (id) ON DELETE CASCADE
);

INSERT
INTO banks(name)
VALUES ('우리은행')
     , ('국민은행')
     , ('기업은행')
     , ('신한은행');

INSERT
INTO owners (name, rrn, phone)
VALUES ('kim', '000000-0000000', '010-0000-0000')
     , ('park', '111111-1111111', '011-1111-1111');

INSERT
INTO accounts (account_number, bank_id, owner_id, balance, password)
VALUES ('1234567890', 1, 1, 5000, '123456')
     , ('0987654321', 2, 1, DEFAULT, '123456');

DELETE
FROM banks
WHERE id = 2;

-- ///////////////////////////
CREATE TABLE menu
(
    item_id   INT PRIMARY KEY,
    item_name VARCHAR(50),
    price     INT,
    category  VARCHAR(50) CHECK ( category IN ('음료', '디저트') )
);

DESC menu;

INSERT
INTO menu
VALUES (1, '아메리카노', 2000, '음료')
     , (2, '카페모카', 3900, '음료')
     , (3, '복숭아 아이스티', 3000, '음료')
     , (4, '소금빵', 3200, '디저트')
     , (5, '초코케익', 3500, '디저트');

UPDATE menu
SET price = 2500
WHERE item_id = 1;

DELETE
FROM menu
WHERE category = '디저트';

-- /////////////////
CREATE TABLE majors
(
    id   INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL
);

INSERT
INTO majors(name)
VALUES ('컴퓨터과학');

INSERT
INTO majors(name)
VALUES ('수학');

-- /////////////////////////

CREATE TABLE students
(
    id       INT PRIMARY KEY AUTO_INCREMENT,
    name     VARCHAR(50) NOT NULL,
    email    VARCHAR(100) UNIQUE,
    reg_date DATE DEFAULT (CURRENT_DATE),
    major_id INT,
    FOREIGN KEY (major_id) REFERENCES majors (id)
);

INSERT
INTO students(name, email, major_id)
VALUES ('lee', 'lee@gmail.com', 1)
     , ('park', 'park@gmail.com', 2)
     , ('kim', NULL, 1);

-- //////////////////////////