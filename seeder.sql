USE carlister_db;

INSERT INTO users (username, email, password) VALUES ('Mary', 'mary@email.com', 'password'),
                                                     ('Nick', 'nick@email.com', 'password'),
                                                     ('Bosch', 'bosch@email.com', 'password');

INSERT INTO cars (user_id, year, make, model, price, description) VALUES('1', '2021', 'Chevrolet', 'Corvette', 78000, 'brand new 2021 C8 blue');

# mysql> SELECT username, email, B.year, B.make, B.model, B.price, B.description, B.creation_date FROM users AS A JOIN cars as B ON A.id = B.user_id;

