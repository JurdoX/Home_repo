CREATE DATABASE spring_db;

CREATE TABLE offers (
	id INT NOT NULL auto_increment,
    name VARCHAR(50) NOT NULL,
    email VARCHAR(100) NOT NULL,
    text VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
);