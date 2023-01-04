CREATE TABLE student (
  studentId SERIAL PRIMARY KEY,
  studentName varchar(45) DEFAULT NULL,
  studentAge varchar(45) DEFAULT NULL
);
INSERT INTO student VALUES
    (1,'Student 1','18'),
    (2,'Student 2','17'),
    (3,'Student 3','16');

CREATE TABLE college (
  collegeId SERIAL PRIMARY KEY,
  collegeName varchar(45) DEFAULT NULL,
  collegeLocation varchar(45) DEFAULT NULL
);
INSERT INTO college VALUES
    (1,'College 1','College 1 Desc'),
    (2,'College 2','College 2 Desc'),
    (3,'College 3','College 3 Desc');