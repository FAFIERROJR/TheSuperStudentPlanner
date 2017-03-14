CREATE TABLE Appointments (
SID char (9) NOT NULL,
TITLE varchar (30) NOT NULL,
"DAY" varchar (10) NOT NULL,
STARTTIME varchar (4) NOT NULL, 
ENDTIME varchar (4) NOT NULL,
CONSTRAINT Appointments_pk PRIMARY KEY (SID, "DAY",STARTTIME)
);

CREATE TABLE Students (
SID char (9) NOT NULL,
FIRSTNAME varchar (10),
LASTNAME varchar (10),
CONSTRAINT Students_pk PRIMARY KEY (SID)
);

CREATE TABLE Professor (
SID char (9) NOT NULL,
FIRSTNAME varchar (10),
LASTNAME varchar (10),
CONSTRAINT Professor_pk PRIMARY KEY (SID)
);

SELECT * from Appointments;

