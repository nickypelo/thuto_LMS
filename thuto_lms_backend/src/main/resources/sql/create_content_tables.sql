-- Connect to your database
USE thuto;

--- content
CREATE TABLE subject (
    id INT PRIMARY KEY,
    name VARCHAR(50) NOT NULL
);

CREATE TABLE topic (
    id INT PRIMARY KEY,
    subject_id INT,
    name VARCHAR(50) NOT NULL,
    FOREIGN KEY (subject_id) REFERENCES subject(id)
);

CREATE TABLE quiz (
    id INT PRIMARY KEY,
    subject_id INT,
    FOREIGN KEY (subject_id) REFERENCES subject(id)
);

CREATE TABLE question (
    id INT PRIMARY KEY,
    quiz_id INT,
    question TEXT NOT NULL,
    answer TEXT NOT NULL,
    FOREIGN KEY (quiz_id) REFERENCES quiz(id)
);

CREATE TABLE student (
    id INT PRIMARY KEY,
    firstname VARCHAR(50) NOT NULL,
    lastname VARCHAR(50) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE
);

CREATE TABLE student_subject (
    student_id INT,
    subject_id INT,
    PRIMARY KEY (student_id, subject_id),
    FOREIGN KEY (student_id) REFERENCES student(id),
    FOREIGN KEY (subject_id) REFERENCES subject(id)
);

