DROP DATABASE shoppingApp;

CREATE DATABASE shoppingApp;

USE shoppingApp;

CREATE TABLE category (
			CategoryId int NOT NULL AUTO_INCREMENT,
			CategoryName varchar(50) NOT NULL,  
			PRIMARY KEY (CategoryId)
);

CREATE TABLE product (
			ProductId int NOT NULL AUTO_INCREMENT,
			ProductName varchar(50) NOT NULL,
			Price double NOT NULL,
			CategoryId int NOT NULL,
			ImageUrl varchar(500) NOT NULL,
			PRIMARY KEY (Productid),
			FOREIGN KEY (CategoryId) REFERENCES category (CategoryId)
);