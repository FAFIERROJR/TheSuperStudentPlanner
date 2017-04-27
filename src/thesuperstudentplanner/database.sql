

CREATE TABLE students
  (
  studentusername VARCHAR (20) NOT NULL,
  firstName VARCHAR(20) NOT NULL,
  lastName VARCHAR(20) NOT NULL,
  password VARCHAR(20) NOT NULL,
  CONSTRAINT pk_students PRIMARY KEY (studentusername)
  );


CREATE TABLE professors
  (
  profusername VARCHAR (20) NOT NULL,
  firstName VARCHAR(20) NOT NULL,
  lastName VARCHAR(20) NOT NULL,
  password VARCHAR(20) NOT NULL,
  CONSTRAINT pk_professors PRIMARY KEY (profusername)
  );

CREATE TABLE appointments
 (
  title VARCHAR(20) NOT NULL,
  "DATE" DATE NOT NULL,
  starttime TIME NOT NULL,
  endtime TIME NOT NULL,
  studentusername VARCHAR (20) NOT NULL REFERENCES students(studentusername),
  CONSTRAINT pk_appointments PRIMARY KEY ("DATE",title,starttime, endtime),
  CONSTRAINT fk1_appointments FOREIGN KEY (studentusername) REFERENCES students(studentusername)
  );


INSERT INTO students 
    VALUES ('anncook','Ann','Cook', 'password'),
    ('ralphvasquez', 'Ralph', 'Vasquez', 'password'),
    ('willieallen', 'Willie', 'Allen', 'password'),
    ('juliepeters','Julie','Peters', 'password'),
    ('robertcohen', 'Robert', 'Cohen', 'password'),
    ('ericaaustin', 'Erica','Austin', 'password'),
    ('anglowong','Angelo', 'Wong', 'password'),
    ('irvinmiller', 'Irvin', 'Miller', 'password'),
    ('lindsayparsons', 'Lindsay', 'Parsons', 'password'),
    ('jamiereed', 'Jamie', 'Reed', 'password');
 

INSERT INTO professors
    VALUES ('feihoffman', 'Fei', 'Hoffman', 'password');

    
INSERT INTO appointments
    VALUES ('CECS 341', '2017-04-01', '9:00', '10:00','anncook');

