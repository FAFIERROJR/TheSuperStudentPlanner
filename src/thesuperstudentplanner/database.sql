

CREATE TABLE students
  (
  studentusername VARCHAR (20) NOT NULL,
  firstName VARCHAR(20) NOT NULL,
  lastName VARCHAR(20) NOT NULL,
  CONSTRAINT pk_students PRIMARY KEY (studentusername)
  );


CREATE TABLE professors
  (
  profusername VARCHAR (20) NOT NULL,
  firstName VARCHAR(20) NOT NULL,
  lastName VARCHAR(20) NOT NULL,
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
    VALUES ('anncook','Ann','Cook'),
    ('ralphvasquez', 'Ralph', 'Vasquez'),
    ('willieallen', 'Willie', 'Allen'),
    ('juliepeters','Julie','Peters'),
    ('robertcohen', 'Robert', 'Cohen'),
    ('ericaaustin', 'Erica','Austin'),
    ('anglowong','Angelo', 'Wong'),
    ('irvinmiller', 'Irvin', 'Miller'),
    ('lindsayparsons', 'Lindsay', 'Parsons'),
    ('jamiereed', 'Jamie', 'Reed');

INSERT INTO professors
    VALUES ('feihoffman', 'Fei', 'Hoffman');

    
INSERT INTO appointments
    VALUES ('CECS 341', '2017-03-27', '9:00', '10:00','anncook');

