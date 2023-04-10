DROP USER if exists 'springstudent'@'localhost' ;
CREATE USER 'springstudent'@'localhost' IDENTIFIED BY 'Springstudent@123';
GRANT ALL PRIVILEGES ON * . * TO 'springstudent'@'localhost';