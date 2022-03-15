DROP DATABASE IF EXISTS Program_2;
CREATE DATABASE Program_2;

USE Program_2;

CREATE TABLE UserInfo (
	
	email VARCHAR(25) PRIMARY KEY NOT NULL,
    name_ VARCHAR(25) NOT NULL,
    pass_ VARCHAR(25) NOT NULL
);

-- SQL runs top down, so put created tables before when we use them

CREATE TABLE Restaurant_details (
	details_id VARCHAR(25) PRIMARY KEY NOT NULL,
    image VARCHAR(25) NOT NULL,
    address VARCHAR(25) NOT NULL,
    price VARCHAR(25) NOT NULL,
    phone_no VARCHAR(25) NOT NULL,
    yelp_url VARCHAR(25) NOT NULL
);

CREATE TABLE Rating_details (
	ratings_id VARCHAR(25) PRIMARY KEY NOT NULL ,
    reviewcount INT NOT NULL,
    rating DOUBLE NOT NULL
);


CREATE TABLE Restaurant (
	restaurant_id VARCHAR(25) PRIMARY KEY NOT NULL ,
    restaurant_name VARCHAR(25) NOT NULL,
    details_id VARCHAR(25) NOT NULL,
	ratings_id VARCHAR(25) NOT NULL,
    FOREIGN KEY (ratings_id) REFERENCES Rating_details(ratings_id),
    FOREIGN KEY (details_id) REFERENCES Restaurant_details(details_id)
);



CREATE TABLE Category (
	category_id VARCHAR(25) PRIMARY KEY NOT NULL,
    category_name VARCHAR(25) NOT NULL,
	restaurant_id VARCHAR(25) NOT NULL,
     FOREIGN KEY (restaurant_id) REFERENCES Restaurant(restaurant_id)
);

-- DROP PROCEDURE if exists GetUserName;
-- DELIMITER $$
-- CREATE PROCEDURE GetUserName (IN username varchar(50))
-- BEGIN
-- SELECT u.email, u.name_, u.pass_
-- FROM UserInfo s;
-- END $$
-- DELIMITER ;

