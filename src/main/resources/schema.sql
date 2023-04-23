CREATE TABLE IF NOT EXISTS universities
(
    id    BIGSERIAL PRIMARY KEY ,
    name  VARCHAR(200) NOT NULL ,
    creation_date VARCHAR(200) NOT NULL
);
CREATE SEQUENCE IF NOT EXISTS universities_seq START WITH 1 INCREMENT BY 1;
CREATE TABLE IF NOT EXISTS students
(
    id    BIGSERIAL PRIMARY KEY ,
    university_id BIGSERIAL ,
    first_name  VARCHAR(200) NOT NULL ,
    last_name VARCHAR(200) NOT NULL ,
    middle_name VARCHAR(200),
    FOREIGN KEY (university_id) REFERENCES universities (id)
);
CREATE SEQUENCE IF NOT EXISTS students_seq START WITH 1 INCREMENT BY 1;