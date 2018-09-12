USE test;

DROP TABLE IF EXISTS part;
CREATE TABLE part(
	id INT(11) NOT NULL AUTO_INCREMENT,
	detail VARCHAR(50) NOT NULL,
	need TINYINT NOT NULL,
	amount TINYINT NOT NULL,
	PRIMARY KEY(id))
	ENGINE = InnoDB
	DEFAULT CHARACTER SET = utf8;
	
	INSERT INTO part (detail, need, amount) VALUES ('MotherBoard ASUS', '1', '26'),
	('MotherBoard ROCKSTAR', '1', '10'),
	('MotherBoard STOCK', '1', '0'),
	('Processor INTELL', '1', '123'),
	('Processor ATHLON', '1', '51'),
	('Processor CELERON', '1', '0'),
	('DIMM DDR4', '1', '23'),
	('DIMM DDR3', '1', '53'),
	('DIMM DDR2', '1', '0'),
	('HDD SEAGATE', '1', '43'),
	('HDD MAXTOR', '1', '0'),
	('SSD MAXTOR', '1', '13'),
	('CDD Genius', '0', '8'),
	('CDD NO NAME', '0', '15'),
	('CDD NEC', '0', '0'),
	('FDD 1.4', '0', '0'),
	('FDD 5.25', '0', '1'),
	('Case', '1', '43'),
	('VideoCard Nvidia', '0', '37'),
	('VideoCard Radeon', '0', '0'),
	('VideoCard ATI', '0', '4'),
	('SoundCard HiTech', '0', '33'),
	('SoundCard Genius', '0', '27'),
	('CaseLight NO NAME', '0', '0'),
	('CaseLight Genius', '0', '15'),
	('CaseLight NO NAME', '0', '43'),
	('USB Genius', '0', '14'),
	('USB HiTech', '0', '0');
	
	
	