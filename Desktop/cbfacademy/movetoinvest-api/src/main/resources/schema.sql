-- Instructors Table
CREATE TABLE instructor (
    id BIGINT PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

-- Portfolios Table
CREATE TABLE portfolio (
    id BIGINT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    risk_level VARCHAR(50)
);

-- Contribution Rules Table
CREATE TABLE contribution_rule (
    id BIGINT PRIMARY KEY,
    percentage_of_fee DOUBLE,
    flat_amount DOUBLE,
    cap DOUBLE,
    active BOOLEAN
);

-- Group Class Sessions Table
CREATE TABLE group_class_session (
    id BIGINT PRIMARY KEY,
    instructor_id BIGINT,
    date_time DATETIME,
    duration_minutes INT,
    fee DOUBLE,
    number_of_participants INT
);

-- Private Sessions Table
CREATE TABLE private_session (
    id BIGINT PRIMARY KEY,
    instructor_id BIGINT,
    date_time DATETIME,
    duration_minutes INT,
    fee DOUBLE
);

-- Contributions Table
CREATE TABLE contribution (
    id BIGINT PRIMARY KEY,
    session_id BIGINT,
    portfolio_id BIGINT,
    amount DOUBLE,
    status VARCHAR(50)
);
