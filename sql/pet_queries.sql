CREATE SCHEMA IF NOT EXISTS Pets;

CREATE TABLE IF NOT EXISTS pet(
    pet_id INT NOT NULL,
    pet_name VARCHAR(20) NOT NULL,
    species VARCHAR(20) NOT NULL,
    owner_id INT,

    CONSTRAINT pet_pkey PRIMARY KEY  (pet_id)

);

CREATE TABLE IF NOT EXISTS pet_customer(
    customer_id INT NOT NULL,
    first_name VARCHAR(20) NOT NULL,
    last_name VARCHAR(20) NOT NULL,
    
    CONSTRAINT pet_customer_pkey PRIMARY KEY  (customer_id)

);

INSERT INTO pet (pet_id, pet_name, species, owner_id) VALUES
    (5, 'bim', 'dog', '1'),
    (6, 'tim', 'cat', '2'),
    (7, 'jim', 'dog', '3');

INSERT INTO pet_customer (customer_id, first_name, last_name) VALUES
    (1, 'jon', 'asasas'),
    (2, 'don', 'naniana'),
    (3, 'ron', 'plaoala');

SELECT * FROM pet;
SELECT * FROM pet_customer;

