DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
 `id` int NOT NULL AUTO_INCREMENT,
 `login` varchar(100) NOT NULL,
 `name` varchar(100) NOT NULL,
 `last_name` varchar(100) NOT NULL,
 PRIMARY KEY (`id`)
);

INSERT INTO `user` (`login`, `name`, `last_name`)
VALUES ('thaisc98', 'Thais', 'Contreras');

INSERT INTO `user` (`login`, `name`, `last_name`)
VALUES ('eladioH', 'Eladio', 'Carrion');

INSERT INTO `user` (`login`, `name`, `last_name`)
VALUES ('mbappe', 'Kylian', 'Mbappe');

DROP TABLE IF EXISTS country;

CREATE TABLE `country` (
    `key` varchar(100) NOT NULL,
    `name` varchar(250) NOT NULL,
    PRIMARY KEY (`key`)
);

INSERT INTO `country` (`key`, `name`)
VALUES ('BR', 'Brazil');

INSERT INTO `country` (`key`, `name`)
VALUES ('DR', 'Dominican Republic');

INSERT INTO `country` (`key`, `name`)
VALUES ('PR', 'Puerto Rico');

DROP TABLE IF EXISTS hotel;

CREATE TABLE `hotel` (
       `id` int NOT NULL AUTO_INCREMENT,
       `name` varchar(400) NOT NULL,
       `key_country` varchar(100) NOT NULL,
       `available_rooms` int default 20 NOT NULL,
       PRIMARY KEY (`id`),
       foreign key (`key_country`) references `country`(`key`)
);

INSERT INTO `hotel` (`name`,`key_country`)
VALUES ('Hotel Punta Cana', 'DR');

INSERT INTO `hotel` (`name`,`key_country`)
VALUES ('Cap Cana', 'DR');

INSERT INTO `hotel` (`name`,`key_country`)
VALUES ('Royal Destiny', 'PR');

INSERT INTO `hotel` (`name`,`key_country`)
VALUES ('Rio Dreams Hotel', 'BR');

INSERT INTO `hotel` (`name`,`key_country`)
VALUES ('Janeiro Luxury Hotel', 'BR');

DROP TABLE IF EXISTS room;

CREATE TABLE `room` (
     `id` int NOT NULL AUTO_INCREMENT,
     `hotel_id` int NOT NULL,
     `status` varchar(50) NOT NULL default 'AVAILABLE',
     PRIMARY KEY (`id`),
     foreign key (`hotel_id`) references `hotel`(`id`)
);

INSERT INTO `room` (`hotel_id`)
VALUES (1);
INSERT INTO `room` (`hotel_id`)
VALUES (1);
INSERT INTO `room` (`hotel_id`)
VALUES (1);
INSERT INTO `room` (`hotel_id`)
VALUES (1);
INSERT INTO `room` (`hotel_id`)
VALUES (1);
INSERT INTO `room` (`hotel_id`)
VALUES (1);
INSERT INTO `room` (`hotel_id`)
VALUES (1);
INSERT INTO `room` (`hotel_id`)
VALUES (1);
INSERT INTO `room` (`hotel_id`)
VALUES (1);
INSERT INTO `room` (`hotel_id`)
VALUES (1);
INSERT INTO `room` (`hotel_id`)
VALUES (1);
INSERT INTO `room` (`hotel_id`)
VALUES (1);
INSERT INTO `room` (`hotel_id`)
VALUES (1);
INSERT INTO `room` (`hotel_id`)
VALUES (1);
INSERT INTO `room` (`hotel_id`)
VALUES (1);
INSERT INTO `room` (`hotel_id`)
VALUES (1);
INSERT INTO `room` (`hotel_id`)
VALUES (1);
INSERT INTO `room` (`hotel_id`)
VALUES (1);
INSERT INTO `room` (`hotel_id`)
VALUES (1);
INSERT INTO `room` (`hotel_id`)
VALUES (1);

-- hotel id 2
INSERT INTO `room` (`hotel_id`)
VALUES (2);
INSERT INTO `room` (`hotel_id`)
VALUES (2);
INSERT INTO `room` (`hotel_id`)
VALUES (2);
INSERT INTO `room` (`hotel_id`)
VALUES (2);
INSERT INTO `room` (`hotel_id`)
VALUES (2);
INSERT INTO `room` (`hotel_id`)
VALUES (2);
INSERT INTO `room` (`hotel_id`)
VALUES (2);
INSERT INTO `room` (`hotel_id`)
VALUES (2);
INSERT INTO `room` (`hotel_id`)
VALUES (2);
INSERT INTO `room` (`hotel_id`)
VALUES (2);
INSERT INTO `room` (`hotel_id`)
VALUES (2);
INSERT INTO `room` (`hotel_id`)
VALUES (2);
INSERT INTO `room` (`hotel_id`)
VALUES (2);
INSERT INTO `room` (`hotel_id`)
VALUES (2);
INSERT INTO `room` (`hotel_id`)
VALUES (2);
INSERT INTO `room` (`hotel_id`)
VALUES (2);
INSERT INTO `room` (`hotel_id`)
VALUES (2);
INSERT INTO `room` (`hotel_id`)
VALUES (2);
INSERT INTO `room` (`hotel_id`)
VALUES (2);
INSERT INTO `room` (`hotel_id`)
VALUES (2);

-- hotel 3
INSERT INTO `room` (`hotel_id`)
VALUES (3);
INSERT INTO `room` (`hotel_id`)
VALUES (3);
INSERT INTO `room` (`hotel_id`)
VALUES (3);
INSERT INTO `room` (`hotel_id`)
VALUES (3);
INSERT INTO `room` (`hotel_id`)
VALUES (3);
INSERT INTO `room` (`hotel_id`)
VALUES (3);
INSERT INTO `room` (`hotel_id`)
VALUES (3);
INSERT INTO `room` (`hotel_id`)
VALUES (3);
INSERT INTO `room` (`hotel_id`)
VALUES (3);
INSERT INTO `room` (`hotel_id`)
VALUES (3);
INSERT INTO `room` (`hotel_id`)
VALUES (3);
INSERT INTO `room` (`hotel_id`)
VALUES (3);
INSERT INTO `room` (`hotel_id`)
VALUES (3);
INSERT INTO `room` (`hotel_id`)
VALUES (3);
INSERT INTO `room` (`hotel_id`)
VALUES (3);
INSERT INTO `room` (`hotel_id`)
VALUES (3);
INSERT INTO `room` (`hotel_id`)
VALUES (3);
INSERT INTO `room` (`hotel_id`)
VALUES (3);
INSERT INTO `room` (`hotel_id`)
VALUES (3);
INSERT INTO `room` (`hotel_id`)
VALUES (3);

-- hotel 4

INSERT INTO `room` (`hotel_id`)
VALUES (4);
INSERT INTO `room` (`hotel_id`)
VALUES (4);
INSERT INTO `room` (`hotel_id`)
VALUES (4);
INSERT INTO `room` (`hotel_id`)
VALUES (4);
INSERT INTO `room` (`hotel_id`)
VALUES (4);
INSERT INTO `room` (`hotel_id`)
VALUES (4);
INSERT INTO `room` (`hotel_id`)
VALUES (4);
INSERT INTO `room` (`hotel_id`)
VALUES (4);
INSERT INTO `room` (`hotel_id`)
VALUES (4);
INSERT INTO `room` (`hotel_id`)
VALUES (4);
INSERT INTO `room` (`hotel_id`)
VALUES (4);
INSERT INTO `room` (`hotel_id`)
VALUES (4);
INSERT INTO `room` (`hotel_id`)
VALUES (4);
INSERT INTO `room` (`hotel_id`)
VALUES (4);
INSERT INTO `room` (`hotel_id`)
VALUES (4);
INSERT INTO `room` (`hotel_id`)
VALUES (4);
INSERT INTO `room` (`hotel_id`)
VALUES (4);
INSERT INTO `room` (`hotel_id`)
VALUES (4);
INSERT INTO `room` (`hotel_id`)
VALUES (4);
INSERT INTO `room` (`hotel_id`)
VALUES (4);


-- hotel 5

INSERT INTO `room` (`hotel_id`)
VALUES (5);
INSERT INTO `room` (`hotel_id`)
VALUES (5);
INSERT INTO `room` (`hotel_id`)
VALUES (5);
INSERT INTO `room` (`hotel_id`)
VALUES (5);
INSERT INTO `room` (`hotel_id`)
VALUES (5);
INSERT INTO `room` (`hotel_id`)
VALUES (5);
INSERT INTO `room` (`hotel_id`)
VALUES (5);
INSERT INTO `room` (`hotel_id`)
VALUES (5);
INSERT INTO `room` (`hotel_id`)
VALUES (5);
INSERT INTO `room` (`hotel_id`)
VALUES (5);
INSERT INTO `room` (`hotel_id`)
VALUES (5);
INSERT INTO `room` (`hotel_id`)
VALUES (5);
INSERT INTO `room` (`hotel_id`)
VALUES (5);
INSERT INTO `room` (`hotel_id`)
VALUES (5);
INSERT INTO `room` (`hotel_id`)
VALUES (5);
INSERT INTO `room` (`hotel_id`)
VALUES (5);
INSERT INTO `room` (`hotel_id`)
VALUES (5);
INSERT INTO `room` (`hotel_id`)
VALUES (5);
INSERT INTO `room` (`hotel_id`)
VALUES (5);
INSERT INTO `room` (`hotel_id`)
VALUES (5);

DROP TABLE IF EXISTS reservation;

CREATE TABLE `reservation` (
     `id` int NOT NULL AUTO_INCREMENT,
     `reserved_by` int NOT NULL,
     `hotel_id` int NOT NULL,
     `room_id` int NOT NULL,
     `check_in` date NOT NULL,
     `check_out` date NOT NULL,
     `status` varchar(50) NOT NULL default 'ACTIVE',
     PRIMARY KEY (`id`)
);