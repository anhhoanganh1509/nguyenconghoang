CREATE SCHEMA `crawler` ;
CREATE TABLE IF NOT EXISTS `Crawl` (

  `CrawlID` INT(11) NOT NULL AUTO_INCREMENT,

  `CrawlURL` VARCHAR (300) not null,
  PRIMARY KEY (`CrawlID`)

) ;

CREATE TABLE IF NOT EXISTS `Users`(
	`username` VARCHAR(45) NOT NULL ,
    `password` VARCHAR(45) NOT NULL ,
    `enabled` TINYINT NOT NULL DEFAULT 1 ,
    PRIMARY KEY (`username`)
);

CREATE TABLE IF NOT EXISTS `user_roles`(
	`user_role_id` int(11) NOT NULL AUTO_INCREMENT,
	`username` varchar(45) NOT NULL,
	`role` varchar(45) NOT NULL,
    PRIMARY KEY (`user_role_id`),
    FOREIGN KEY (`username`) references Users(`username`)
);

INSERT INTO users(username,password,enabled)
VALUES ('admin','1111', true);
INSERT INTO users(username,password,enabled)
VALUES ('hoang','7777', true);


INSERT INTO user_roles (username, role)
VALUES ('admin', 'ROLE_ADMIN');
INSERT INTO user_roles (username, role)
VALUES ('hoang', 'ROLE_USER');