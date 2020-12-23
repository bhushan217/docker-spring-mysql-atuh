DROP DATABASE IF EXISTS dockerdemo;
CREATE DATABASE dockerdemo;
GRANT ALL PRIVILEGES ON dockerdemo.* TO 'demo'@'%' IDENTIFIED BY 'demo';
GRANT ALL PRIVILEGES ON dockerdemo.* TO 'demo'@'localhost' IDENTIFIED BY 'demo';
#use dockerdemo;
create table dockerdemo.B2K_EMPLOYEE (
    ID INT NOT NULL identity ,
    firstName VARCHAR (20) NOT NULL,
    lastName VARCHAR (20) NOT NULL,
    emailId VARCHAR (20) NOT NULL,
    CONSTRAINT PK_B2K_EMPLOYEE_ID PRIMARY KEY (ID)
);
