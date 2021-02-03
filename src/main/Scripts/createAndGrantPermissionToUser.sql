select host, user from mysql.user;
drop user test_user;

CREATE USER 'test_user'@'%' IDENTIFIED BY 'test';

GRANT SELECT ON testDB.* to 'test_user'@'%';
GRANT INSERT ON testDB.* to 'test_user'@'%';
GRANT DELETE ON testDB.* to 'test_user'@'%';
GRANT UPDATE ON testDB.* to 'test_user'@'%';
