/*
SQLyog Enterprise - MySQL GUI v7.02 
MySQL - 5.0.67-community-nt : Database - libdbms
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

CREATE DATABASE /*!32312 IF NOT EXISTS*/`libdbms` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `libdbms`;

/*Table structure for table `author` */

DROP TABLE IF EXISTS `author`;

CREATE TABLE `author` (
  `id` int(11) NOT NULL auto_increment,
  `name` varchar(50) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=latin1;

/*Data for the table `author` */

insert  into `author`(`id`,`name`) values (1,'kathy sierra'),(3,'balaguru swamy'),(4,'james gasling'),(5,'G.R.R. Martin'),(6,'Herbert Schildt'),(7,'Rudyard Kipling'),(16,'JR RAWAT');

/*Table structure for table `book` */

DROP TABLE IF EXISTS `book`;

CREATE TABLE `book` (
  `id` varchar(10) default NULL,
  `title` varchar(50) default NULL,
  `author` varchar(50) default NULL,
  `subject` varchar(50) default NULL,
  `category` varchar(50) default NULL,
  `publisher` varchar(50) default NULL,
  `isbn` varchar(50) default NULL,
  `edition` int(11) default NULL,
  `price` int(11) default NULL,
  `quantity` int(11) default NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `book` */

insert  into `book`(`id`,`title`,`author`,`subject`,`category`,`publisher`,`isbn`,`edition`,`price`,`quantity`) values ('3627521','The complete reference','HERBERT SCHILDT','Java','Programming lang','TATA MCRAW HILL','ab12122g213',7,550,20),('3423331','DMS genious','IDK','Dms','Maths','Genious','12gg12gh111',5,665,11),('2119891','Advanced mathematics','JR RAWAT','MATHS','IT','GENIOUS PUBLICATION','ab1234gg565',5,500,5);

/*Table structure for table `category` */

DROP TABLE IF EXISTS `category`;

CREATE TABLE `category` (
  `id` int(11) NOT NULL auto_increment,
  `name` varchar(50) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

/*Data for the table `category` */

insert  into `category`(`id`,`name`) values (1,'Programming lang'),(3,'IT');

/*Table structure for table `issue` */

DROP TABLE IF EXISTS `issue`;

CREATE TABLE `issue` (
  `studentid` varchar(10) default NULL,
  `name` varchar(50) default NULL,
  `bookid` varchar(10) default NULL,
  `book` varchar(50) default NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `issue` */

insert  into `issue`(`studentid`,`name`,`bookid`,`book`) values ('1234566','tus','3627521','The complete reference');

/*Table structure for table `publisher` */

DROP TABLE IF EXISTS `publisher`;

CREATE TABLE `publisher` (
  `id` int(11) NOT NULL auto_increment,
  `name` varchar(50) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

/*Data for the table `publisher` */

insert  into `publisher`(`id`,`name`) values (1,'tmh'),(2,'TATA MCRAW HILL'),(3,'GENIOUS PUBLICATION');

/*Table structure for table `registration` */

DROP TABLE IF EXISTS `registration`;

CREATE TABLE `registration` (
  `id` int(10) NOT NULL,
  `name` varchar(50) default NULL,
  `email` varchar(100) default NULL,
  `password` varchar(50) default NULL,
  `usertype` varchar(20) default NULL,
  `mobile` varchar(20) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `registration` */

insert  into `registration`(`id`,`name`,`email`,`password`,`usertype`,`mobile`) values (1234566,'johnny','hardrock@hahah.com','jon','student','67676767'),(1234567,'tushar','utugjhgj','tushar','admin','765765');

/*Table structure for table `subject` */

DROP TABLE IF EXISTS `subject`;

CREATE TABLE `subject` (
  `id` int(11) NOT NULL auto_increment,
  `name` varchar(50) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

/*Data for the table `subject` */

insert  into `subject`(`id`,`name`) values (1,'Java'),(2,'MATHS');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
