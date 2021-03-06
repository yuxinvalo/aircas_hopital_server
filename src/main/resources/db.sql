CREATE DATABASE IF NOT EXISTS db_infusion_manager DEFAULT CHARSET utf8 COLLATE utf8_general_ci;
use db_infusion_manager;

DROP TABLE IF EXISTS t_user_device;
DROP TABLE IF EXISTS t_user;
DROP TABLE IF EXISTS t_device;
CREATE TABLE t_user (
	id INT(11) UNSIGNED AUTO_INCREMENT,
	login VARCHAR(25) NOT NULL,
	name VARCHAR(25) NOT NULL,
	password VARCHAR(25) DEFAULT NULL, 
	last_login_time datetime DEFAULT NULL,
	phone VARCHAR(15) DEFAULT NULL,
--	is_delete BOOLEAN DEFAULT FALSE,
	PRIMARY KEY ( id )
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE t_device (
	id VARCHAR(12) NOT NULL,
	frequency INT DEFAULT 20,
	progress INT DEFAULT 0,
	power INT DEFAULT 100,
	ip_device VARCHAR(20) DEFAULT NULL,
	ip_router VARCHAR(20) DEFAULT NULL,
	alarm BOOLEAN DEFAULT 0,
	PRIMARY KEY ( id )
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE t_user_device (
	id INT UNSIGNED AUTO_INCREMENT,
	id_user INT(11) UNSIGNED NOT NULL,
	id_device VARCHAR(12) NOT NULL,
	bed_num VARCHAR(10),
	room VARCHAR(10),
	PRIMARY KEY( id ),
	FOREIGN KEY (id_user) REFERENCES t_user( id ),
	FOREIGN KEY (id_device) REFERENCES t_device( id )
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE t_user_device_audit (
	id INT UNSIGNED AUTO_INCREMENT,
	id_user INT(11) UNSIGNED NOT NULL,
	id_device VARCHAR(12) NOT NULL,
	bed_num VARCHAR(10),
	room VARCHAR(10),
	start_time datetime,
	end_time datetime,
	PRIMARY KEY( id ),
	FOREIGN KEY (id_user) REFERENCES t_user( id ),
	FOREIGN KEY (id_device) REFERENCES t_device( id )
)ENGINE=InnoDB DEFAULT CHARSET=utf8;
	