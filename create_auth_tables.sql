
-- Create User table
CREATE TABLE _user (
    id INT NOT NULL AUTO_INCREMENT,
    firstname VARCHAR(255),
    lastname VARCHAR(255),
    date_of_birth DATE,
    email VARCHAR(255) UNIQUE,
    `password` VARCHAR(255),
    account_locked BOOLEAN,
    enabled BOOLEAN,
    created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    last_modified_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (id)
);

-- Create Role table
CREATE TABLE role (
    id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(255) UNIQUE,
    created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    last_modified_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (id)
);

CREATE TABLE token (
    id INT NOT NULL AUTO_INCREMENT,
    token VARCHAR(255),
    created_at TIMESTAMP,
    expires_at TIMESTAMP,
    validated_at TIMESTAMP,
    user_id INT NOT NULL,
    PRIMARY KEY (id),
    CONSTRAINT fk_user_token FOREIGN KEY (user_id) REFERENCES _user(id)
);

CREATE TABLE _user_role (
    user_id INT NOT NULL,
    role_id INT NOT NULL,
    PRIMARY KEY (user_id, role_id),
    CONSTRAINT fk_user_roles_user FOREIGN KEY (user_id) REFERENCES _user(id),
    fCONSTRAINT fk_user_roles_role FOREIGN KEY (role_id) REFERENCES role(id)
);

CREATE TABLE teacher (
    id INT NOT NULL,
    firstname VARCHAR(255),
    lastname VARCHAR(255),
    email VARCHAR(255) UNIQUE,
    PRIMARY KEY (id),
    CONSTRAINT fk_teacher_user FOREIGN KEY (id) REFERENCES _user(id)
);

CREATE TABLE student (
    id INT NOT NULL,
    firstname VARCHAR(255),
    lastname VARCHAR(255),
    email VARCHAR(255) UNIQUE,
    PRIMARY KEY (id),
    CONSTRAINT fk_student_user FOREIGN KEY (id) REFERENCES _user(id)
);


