-- Dumping database structure for db
DROP DATABASE IF EXISTS db;
CREATE DATABASE db; 
USE db;


-- Dumping structure for table db.customer
DROP TABLE IF EXISTS customer;
CREATE TABLE IF NOT EXISTS customer (
  custid int(11) unsigned NOT NULL AUTO_INCREMENT,
  custname varchar(20) DEFAULT NULL,
  billingdate datetime DEFAULT NULL,
  bill double DEFAULT NULL,
  PRIMARY KEY (custid)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;

INSERT INTO customer (custid, custname,  billingdate, bill) VALUES
	(1001, 'MSD', '2016-01-28 00:00:00', 100000),
	(1002, 'James', '2016-01-28 00:00:00', 0),
	(1003, 'Rocky', '2016-01-28 00:00:00', 100000);
commit;

