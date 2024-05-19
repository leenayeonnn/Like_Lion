CREATE SCHEMA liondb COLLATE = utf8_general_ci;

CREATE USER 'lion'@'%' IDENTIFIED BY 'like';
CREATE USER 'lion'@'localhost' IDENTIFIED BY 'like';

GRANT ALL PRIVILEGES ON liondb.* TO 'lion'@'%';
GRANT ALL PRIVILEGES ON liondb.* TO 'lion'@'localhost';

-- /////////
USE liondb;

CREATE TABLE users
(
    id       INT PRIMARY KEY AUTO_INCREMENT,
    name     VARCHAR(50) NOT NULL,
    email    VARCHAR(255) NOT NULL UNIQUE CHECK ( email LIKE '%@%' ),
    password VARCHAR(20) NOT NULL,
    reg_date DATE DEFAULT (CURRENT_DATE)
);

CREATE TABLE rolls
(
    id   INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(20) NOT NULL
);

ALTER TABLE rolls
    MODIFY name VARCHAR(20) NOT NULL UNIQUE;


CREATE TABLE user_roles
(
    user_id INT,
    roll_id INT,
    FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE,
    FOREIGN KEY (roll_id) REFERENCES rolls (id) ON DELETE CASCADE
);

CREATE TABLE board
(
    id       INT PRIMARY KEY AUTO_INCREMENT,
    title    VARCHAR(100) NOT NULL,
    content  TEXT,
    user_id  INT NOT NULL,
    reg_date DATE DEFAULT (CURRENT_DATE),
    view_cnt INT  DEFAULT 0,
    FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE
);

-- /////////////////////
INSERT
INTO rolls(name)
VALUES ('일반')
     , ('관리자');

INSERT
INTO users(name, email, password)
VALUES ('lee', 'lee@gmail.com', '1234')
     , ('kim', 'kim@gmail.com', '5678')
     , ('park', 'park@gmail.com', '9012')
     , ('kang', 'kang@gmail.com', '3456');

INSERT
INTO user_roles(user_id, roll_id)
VALUES (1, 1)
     , (2, 1)
     , (3, 1)
     , (4, 2);

INSERT
INTO board(title, content, user_id)
VALUES ('공지사항1', '다음 사항을 꼭 지켜주세요 ...', 4)
     , ('안녕하세요', '*@#&(%*&@(*!&', 1)
     , ('저메추', '!*@#&$*!@%&*!@#', 2)
     , ('맛집 추천하고 갑니다', '!*@#$&*!@&#*', 3);

-- /////////////////
SELECT *
FROM board b
WHERE b.user_id IN (SELECT user_id
                    FROM user_roles
                    WHERE roll_id = 2);