CREATE SCHEMA IF NOT EXISTS point;

CREATE TABLE IF NOT EXISTS point.point_policy (
    point_policy_no BIGINT PRIMARY KEY AUTO_INCREMENT ,
    amount BIGINT NOT NULL CHECK (amount >= 0) ,
    amount_type ENUM('FIXED', 'FLEXIBLE') DEFAULT 'FIXED' ,
    point_type ENUM('FREE', 'CASH') DEFAULT 'FREE' ,
    issue_method ENUM('MANUAL', 'SYSTEM') DEFAULT 'MANUAL' ,
    start_date DATETIME NOT NULL ,
    life_span SMALLINT DEFAULT 365 CHECK (life_span >= 1) ,
    point_name VARCHAR NOT NULL ,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS point.user_point (
    user_point_no BIGINT PRIMARY KEY AUTO_INCREMENT ,
    user_no BIGINT COMMENT '회원 번호' ,
    point_policy_no BIGINT COMMENT 'point_policy 테이블의 PK',
    amount BIGINT NOT NULL CHECK (amount >= 0) COMMENT '지급 금액',
    balance BIGINT NOT NULL DEFAULT 0 CHECK (balance >= 0) COMMENT '잔액',
    start_date DATETIME NOT NULL ,
    expiration_date DATETIME NOT NULL ,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS point.user_point_history (
    user_point_history_no BIGINT PRIMARY KEY AUTO_INCREMENT ,
    user_point_no BIGINT COMMENT 'user_point 테이블의 PK' ,
    order_no VARCHAR DEFAULT NULL ,
    amount BIGINT NOT NULL CHECK (amount >= 0) ,
    action_type ENUM('GIVE', 'RETRIEVE', 'BUY', 'CANCEL') NOT NULL ,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP ,
    updated_by VARCHAR DEFAULT NULL ,
    comment VARCHAR DEFAULT NULL
);


