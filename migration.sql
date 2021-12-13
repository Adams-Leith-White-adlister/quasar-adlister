
CREATE DATABASE IF NOT EXISTS carlister_db;
USE carlister_db;

# TRUNCATE users;
# TRUNCATE cars;
# DROP TABLE users;
# DROP TABLE cars;

# DROP TABLE IF EXISTS cars;
# DROP TABLE IF EXISTS users;

CREATE TABLE IF NOT EXISTS users (
    id INT UNSIGNED NOT NULL AUTO_INCREMENT,
    username VARCHAR(240) UNIQUE NOT NULL,
    email VARCHAR(240) NOT NULL,
    password VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS cars (
    id INT UNSIGNED NOT NULL AUTO_INCREMENT,
    user_id INT UNSIGNED NOT NULL,
    year INT(4) UNSIGNED NOT NULL,
    make VARCHAR(50) NOT NULL,
    model VARCHAR(50) NOT NULL,
    price DOUBLE NOT NULL,
    description VARCHAR(400),
    creation_date DATETIME NOT NULL default CURRENT_TIMESTAMP,
    PRIMARY KEY (id),
    FOREIGN KEY (user_id) REFERENCES users(id)
        ON DELETE CASCADE
);
