DROP TABLE IF EXISTS orderline;
DROP TABLE IF EXISTS invoice;
DROP TABLE IF EXISTS customer;
DROP TABLE IF EXISTS tops;
DROP TABLE IF EXISTS bottoms;

CREATE TABLE `customer` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `phone` int(8) NOT NULL,
  `email` varchar(100) NOT NULL,
  `password` varchar(20) NOT NULL,
  `balance` double,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `invoice` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `customerID` int(11) NOT NULL,
  `pris` double,
  `tid` DATETIME NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `customer_ref_idx` (`customerID`),
  CONSTRAINT `customer_ref` FOREIGN KEY (`customerID`) REFERENCES `customer` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `tops` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `pris` int(11),
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `bottoms` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `pris` int(11),
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `orderline` (
  `invoiceID` int(11) NOT NULL,
  `topID` int(11) NOT NULL,
  `bottomID` int(11) NOT NULL,
  `qty` int(11) NOT NULL,
  KEY `tops_ref_idx` (`topID`),
  KEY `bottoms_ref_idx` (`bottomID`),
  KEY `invoice_ref_idx` (`invoiceID`),
  CONSTRAINT `tops_ref` FOREIGN KEY (`topID`) REFERENCES `tops` (`ID`),
  CONSTRAINT `bottoms_ref` FOREIGN KEY (`bottomID`) REFERENCES `bottoms` (`ID`),
  CONSTRAINT `invoice_ref` FOREIGN KEY (`invoiceID`) REFERENCES `invoice` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


INSERT INTO customer (name, phone, email, password, balance) VALUES ("Casper Bo Woschek", 12345678, "enellerandenemail@gmail.com", "etrigtigsvagtkodeord", 420.5);
INSERT INTO `cupcakes`.`customer` (`ID`, `name`, `phone`, `email`, `password`, `balance`) VALUES ('2', 'Jette Pallesen', '63945273', 'mrstealyoboy@hotmail.dk', 'jegerfaktiskenmand', '0.00');
INSERT INTO `cupcakes`.`customer` (`ID`, `name`, `phone`, `email`, `password`, `balance`) VALUES ('3', 'Sarah Buch', '87654321', 'buch@gmail.com', 'hardulæstminbuch', '0.00');
INSERT INTO `cupcakes`.`customer` (`ID`, `name`, `phone`, `email`, `password`, `balance`) VALUES ('4', 'Frederik Brink', '67854321', 'dontbrink@yahoo.dk', 'minhundhedderper', '0.00');
INSERT INTO `cupcakes`.`customer` (`ID`, `name`, `phone`, `email`, `password`, `balance`) VALUES ('5', 'Yvonne Frederiksen', '31257468', 'yfreder@hotmail.com', 'yvoerforpsyko', '69.75');
INSERT INTO `cupcakes`.`customer` (`ID`, `name`, `phone`, `email`, `password`, `balance`) VALUES ('6', 'Arnold Ipsen', '08976543', 'arnolips@gmail.com', '0talformig', '921.25');
INSERT INTO `cupcakes`.`customer` (`ID`, `name`, `phone`, `email`, `password`, `balance`) VALUES ('7', 'Tina Ottesen', '73248903', 'jegelskercupcakes@yahoo.dk', 'cupcakes11111', '1490.00');
INSERT INTO `cupcakes`.`customer` (`ID`, `name`, `phone`, `email`, `password`, `balance`) VALUES ('8', 'Josefine Davidsen', '33557711', 'davidsen.jose@icloud.com', 'jose4321', '20.00');
INSERT INTO `cupcakes`.`customer` (`ID`, `name`, `phone`, `email`, `password`, `balance`) VALUES ('9', 'Anny Duus', '90122109', 'duussommankanhusk@gmail.dk', 'duusenmusen', '0.00');
INSERT INTO `cupcakes`.`customer` (`ID`, `name`, `phone`, `email`, `password`, `balance`) VALUES ('10', 'Ingrid Marcussen', '78905634', 'marcussen78@icloud.com', 'kbh1988', '0.00');

INSERT INTO `cupcakes`.`invoice` (`ID`, `customerID`, `pris`, `tid`) VALUES ('1', '1', '170.00', '2019-10-07 20:10:00');
INSERT INTO `cupcakes`.`invoice` (`ID`, `customerID`, `pris`, `tid`) VALUES ('2', '5', '70.00', '2019-10-04 12:30:00');
INSERT INTO `cupcakes`.`invoice` (`ID`, `customerID`, `pris`, `tid`) VALUES ('3', '7', '515.00', '2019-10-19 15:10:00');
INSERT INTO `cupcakes`.`invoice` (`ID`, `customerID`, `pris`, `tid`) VALUES ('4', '6', '10.00', '2019-10-07 20:10:00');
INSERT INTO `cupcakes`.`invoice` (`ID`, `customerID`, `pris`, `tid`) VALUES ('5', '8', '45.00', '2019-10-07 18:48:23');

INSERT INTO `cupcakes`.`tops` (`ID`, `name`, `pris`) VALUES ('1', 'Chocolate', '5.00');
INSERT INTO `cupcakes`.`tops` (`ID`, `name`, `pris`) VALUES ('2', 'Vanilla', '5.00');
INSERT INTO `cupcakes`.`tops` (`ID`, `name`, `pris`) VALUES ('3', 'Nutmeg', '5.00');
INSERT INTO `cupcakes`.`tops` (`ID`, `name`, `pris`) VALUES ('4', 'Pistacio', '6.00');
INSERT INTO `cupcakes`.`tops` (`ID`, `name`, `pris`) VALUES ('5', 'Almond', '7.00');

INSERT INTO `cupcakes`.`bottoms` (`ID`, `name`, `pris`) VALUES ('1', 'Chocolate', '5.00');
INSERT INTO `cupcakes`.`bottoms` (`ID`, `name`, `pris`) VALUES ('2', 'Blueberry', '5.00');
INSERT INTO `cupcakes`.`bottoms` (`ID`, `name`, `pris`) VALUES ('3', 'Raspberry', '5.00');
INSERT INTO `cupcakes`.`bottoms` (`ID`, `name`, `pris`) VALUES ('4', 'Crispy', '6.00');
INSERT INTO `cupcakes`.`bottoms` (`ID`, `name`, `pris`) VALUES ('5', 'Strawberry', '6.00');
INSERT INTO `cupcakes`.`bottoms` (`ID`, `name`, `pris`) VALUES ('6', 'Rum/Raisin', '7.00');
INSERT INTO `cupcakes`.`bottoms` (`ID`, `name`, `pris`) VALUES ('7', 'Orange', '8.00');
INSERT INTO `cupcakes`.`bottoms` (`ID`, `name`, `pris`) VALUES ('8', 'Lemon', '8.00');
INSERT INTO `cupcakes`.`bottoms` (`ID`, `name`, `pris`) VALUES ('9', 'Blue Cheese', '9.00');

INSERT INTO orderline (invoiceID, topID, bottomID, qty) VALUES (3, 2, 3, 2);
INSERT INTO orderline (invoiceID, topID, bottomID, qty) VALUES (3, 4, 9, 1);
INSERT INTO orderline (invoiceID, topID, bottomID, qty) VALUES (3, 3, 1, 3);
INSERT INTO orderline (invoiceID, topID, bottomID, qty) VALUES (1, 1, 2, 5);
INSERT INTO orderline (invoiceID, topID, bottomID, qty) VALUES (1, 4, 3, 1);
INSERT INTO orderline (invoiceID, topID, bottomID, qty) VALUES (5, 5, 8, 2);
INSERT INTO orderline (invoiceID, topID, bottomID, qty) VALUES (5, 1, 5, 1);
INSERT INTO orderline (invoiceID, topID, bottomID, qty) VALUES (4, 2, 7, 1);
INSERT INTO orderline (invoiceID, topID, bottomID, qty) VALUES (2, 3, 6, 12);
