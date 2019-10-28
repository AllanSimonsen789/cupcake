DROP TABLE IF EXISTS orderlines;
DROP TABLE IF EXISTS invoices;
DROP TABLE IF EXISTS accounts;
DROP TABLE IF EXISTS tops;
DROP TABLE IF EXISTS bottoms;

CREATE TABLE `accounts` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `phone` int(8) NOT NULL,
  `email` varchar(100) NOT NULL unique,
  `password` varchar(20) NOT NULL,
  `role` varchar(10) NOT NULL DEFAULT "customer",
  `balance` double,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `invoices` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `customerID` int(11) NOT NULL,
  `price` double,
  `time` DATETIME NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `customer_ref_idx` (`customerID`),
  CONSTRAINT `customer_ref` FOREIGN KEY (`customerID`) REFERENCES `accounts` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `tops` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `price` int(11),
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `bottoms` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `price` int(11),
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `orderlines` (
  `invoiceID` int(11) NOT NULL,
  `topID` int(11) NOT NULL,
  `bottomID` int(11) NOT NULL,
  `qty` int(11) NOT NULL,
  PRIMARY KEY (`invoiceID`,`topID`,`bottomID`),
  KEY `tops_ref_idx` (`topID`),
  KEY `bottoms_ref_idx` (`bottomID`),
  KEY `invoice_ref_idx` (`invoiceID`),
  CONSTRAINT `bottoms_ref` FOREIGN KEY (`bottomID`) REFERENCES `bottoms` (`ID`),
  CONSTRAINT `invoice_ref` FOREIGN KEY (`invoiceID`) REFERENCES `invoices` (`ID`),
  CONSTRAINT `tops_ref` FOREIGN KEY (`topID`) REFERENCES `tops` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;



INSERT INTO accounts (name, phone, email, password, role, balance) VALUES ("Casper Bo Woschek", 12345678, "admin@cupcake.dk", "admin123", "Admin", 0.00);
INSERT INTO accounts (name, phone, email, password, balance) VALUES ('Tine Marbjerg', '87654321', 'tm@cph.dk', 'tm123', 42.0);
INSERT INTO accounts (name, phone, email, password, balance) VALUES ('Sarah Buch', '87654321', 'buch@gmail.com', 'hardulæstminbuch', 0.00);
INSERT INTO accounts (name, phone, email, password, balance) VALUES ('Frederik Brink', '67854321', 'dontbrink@yahoo.dk', 'minhundhedderper', 0.00);
INSERT INTO accounts (name, phone, email, password, balance) VALUES ('Yvonne Frederiksen', '31257468', 'yfreder@hotmail.com', 'Yver321', 69.75);
INSERT INTO accounts (name, phone, email, password, balance) VALUES ('Arnold Ipsen', '08976543', 'arnolips@gmail.com', '123password', 921.25);
INSERT INTO accounts (name, phone, email, password, balance) VALUES ('Tina Ottesen', '73248903', 'jegelskercupcakes@yahoo.dk', 'cupcakes11111', 1490.00);
INSERT INTO accounts (name, phone, email, password, balance) VALUES ('Josefine Davidsen', '33557711', 'davidsen.jose@icloud.com', 'jose4321', 20.00);
INSERT INTO accounts (name, phone, email, password, balance) VALUES ('Anny Duus', '90122109', 'duussommankanhusk@gmail.dk', 'duusenmusen', 0.00);
INSERT INTO accounts (name, phone, email, password, balance) VALUES ('Ingrid Marcussen', '78905634', 'marcussen78@icloud.com', 'kbh1988', 0.00);

INSERT INTO invoices (customerID, price, time) VALUES (2, 61.00, '2019-10-07 20:10:00');
INSERT INTO invoices (customerID, price, time) VALUES (5, 144.00, '2019-10-04 12:30:00');
INSERT INTO invoices (customerID, price, time) VALUES (7, 515.00, '2019-10-19 15:10:00');
INSERT INTO invoices (customerID, price, time) VALUES (6, 65.00, '2019-10-07 20:10:00');
INSERT INTO invoices (customerID, price, time) VALUES (8, 41.00, '2019-10-07 18:48:23');

INSERT INTO tops (name, price) VALUES ('Chocolate', 5.00);
INSERT INTO tops (name, price) VALUES ('Vanilla', 5.00);
INSERT INTO tops (name, price) VALUES ('Nutmeg', 5.00);
INSERT INTO tops (name, price) VALUES ('Pistacio', 6.00);
INSERT INTO tops (name, price) VALUES ('Almond', 7.00);

INSERT INTO bottoms (name, price) VALUES ('Chocolate', 5.00);
INSERT INTO bottoms (name, price) VALUES ('Blueberry', 5.00);
INSERT INTO bottoms (name, price) VALUES ('Raspberry', 5.00);
INSERT INTO bottoms (name, price) VALUES ('Crispy', 6.00);
INSERT INTO bottoms (name, price) VALUES ('Strawberry', 6.00);
INSERT INTO bottoms (name, price) VALUES ('Rum/Raisin', 7.00);
INSERT INTO bottoms (name, price) VALUES ('Orange', 8.00);
INSERT INTO bottoms (name, price) VALUES ('Lemon', 8.00);
INSERT INTO bottoms (name, price) VALUES ('Blue Cheese', 9.00);

INSERT INTO orderlines (invoiceID, topID, bottomID, qty) VALUES (1, 1, 2, 5);
INSERT INTO orderlines (invoiceID, topID, bottomID, qty) VALUES (1, 4, 3, 1);
INSERT INTO orderlines (invoiceID, topID, bottomID, qty) VALUES (2, 3, 6, 12);
INSERT INTO orderlines (invoiceID, topID, bottomID, qty) VALUES (3, 2, 3, 2);
INSERT INTO orderlines (invoiceID, topID, bottomID, qty) VALUES (3, 4, 9, 1);
INSERT INTO orderlines (invoiceID, topID, bottomID, qty) VALUES (3, 3, 1, 3);
INSERT INTO orderlines (invoiceID, topID, bottomID, qty) VALUES (4, 2, 7, 1);
INSERT INTO orderlines (invoiceID, topID, bottomID, qty) VALUES (5, 5, 8, 2);
INSERT INTO orderlines (invoiceID, topID, bottomID, qty) VALUES (5, 1, 5, 1);

select * from accounts;