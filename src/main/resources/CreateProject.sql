CREATE TABLE kpi.Project (
	Id INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
	Name VARCHAR(100),
	Code VARCHAR(15),
	Status VARCHAR(20),
	DateStarted DATE NOT NULL,
	DateFinished DATE,
	
	PRIMARY KEY (Id)
);