--insert,select
USE project;
INSERT INTO company.department VALUES('HR');
INSERT INTO company.department VALUES('FINANCE')
INSERT INTO company.department VALUES('TECHNOLOGY')

SELECT * 
FROM company.department;


INSERT INTO 
company.manager 
VALUES ('ROHIT','Ulhasnagar',1)

INSERT INTO 
company.manager 
VALUES ('MOHIT','Ulhasnagar',2)

INSERT INTO 
company.manager 
VALUES ('Pratham','Mumbai',3)

SELECT *
FROM company.manager;

UPDATE company.manager
SET m_address='Pune'
WHERE m_id=2


INSERT INTO company.department VALUES('	HEALTH')

SELECT * FROM 
[company].[department];

INSERT INTO [company].[manager]
VALUES ('Pratham','Mumbai',4)

INSERT INTO company.employee
VALUES ('Soham',50000,1,1)

INSERT INTO company.employee
VALUES ('Monisha',40000,3,3)

INSERT INTO company.employee
VALUES ('Karan',80000,2,2)

INSERT INTO company.employee
VALUES ('Kritika',70000,2,2)

INSERT INTO company.employee
VALUES ('Shristi',40000,3,3)

