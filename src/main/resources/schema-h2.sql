CREATE SCHEMA IF NOT EXISTS point;

CREATE TABLE IF NOT EXISTS point.point_policy (
    policy_id BIGINT PRIMARY KEY AUTO_INCREMENT ,
    amount INT CHECK (amount >= 1) ,
    amount_type VARCHAR NOT NULL , -- FIXED or FLEXIBLE
    min_amount INT CHECK (min_amount >= 1) ,
    max_amount INT CHECK (max_amount <= 100000) ,
    point_type VARCHAR DEFAULT 'FREE', -- FREE or CASH
    issue_method VARCHAR DEFAULT 'MANUAL', -- MANUAL or SYSTEM
    is_active CHAR DEFAULT 'Y', -- Y or N
    start_date DATETIME NOT NULL ,
    life_span SMALLINT DEFAULT 365 CHECK (life_span >= 1) ,
    point_name VARCHAR NOT NULL ,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS point.point_usage_policy (
    usage_policy_id BIGINT PRIMARY KEY AUTO_INCREMENT ,
    policy_id BIGINT NOT NULL  ,
    usage_type VARCHAR NOT NULL , -- REGRANT_FOR_EXPIRATION
    is_active CHAR DEFAULT 'Y',
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    description VARCHAR DEFAULT NULL
);

CREATE TABLE IF NOT EXISTS point.point_type_policy (
    type_policy_id BIGINT PRIMARY KEY AUTO_INCREMENT ,
    point_type VARCHAR DEFAULT 'FREE', -- FREE or CASH
    max_cumulative_amount INT,
    cumulative_period VARCHAR DEFAULT 'TOTAL' , -- YEAR, MONTH
    is_active CHAR DEFAULT 'Y',
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS point.user_point (
    user_point_id BIGINT PRIMARY KEY AUTO_INCREMENT ,
    user_id BIGINT COMMENT '회원 번호' ,
    policy_id BIGINT COMMENT 'point_policy 테이블의 PK',
    amount INT NOT NULL CHECK (amount >= 0) COMMENT '지급 금액',
    balance INT NOT NULL DEFAULT 0 CHECK (balance >= 0) COMMENT '잔액',
    start_date DATETIME NOT NULL ,
    expire_date DATETIME NOT NULL ,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS point.point_transaction (
    transaction_id BIGINT PRIMARY KEY AUTO_INCREMENT ,
    user_point_id BIGINT COMMENT 'user_point 테이블의 PK' ,
    reference_id VARCHAR DEFAULT NULL ,
    amount BIGINT NOT NULL CHECK (amount >= 0) ,
    transaction_type VARCHAR NOT NULL , -- GRANT, RETRIEVE, EXPIRE, BUY, CANCEL
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP ,
    failure_reason VARCHAR DEFAULT NULL
);

CREATE TABLE IF NOT EXISTS point.point_issue_history (
    issue_id BIGINT PRIMARY KEY AUTO_INCREMENT ,
    user_point_id BIGINT COMMENT 'user_point 테이블의 PK' ,
    user_id BIGINT NOT NULL,
    point_type VARCHAR DEFAULT 'FREE', -- FREE or CASH
    amount BIGINT NOT NULL CHECK (amount >= 1) ,
    status VARCHAR DEFAULT NULL , -- SUCCESS, FAILED
    issue_reason VARCHAR DEFAULT NULL ,
    failure_reason VARCHAR DEFAULT NULL ,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP ,
    issue_by VARCHAR DEFAULT NULL
);


