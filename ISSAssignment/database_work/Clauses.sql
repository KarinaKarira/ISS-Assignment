
USE project
SELECT * FROM [company].[department]
SELECT * FROM [company].[employee]
SELECT * FROM [company].[manager]

SELECT m_id 
FROM [company].[employee]

--DISTINCT CLAUSE
SELECT DISTINCT m_id 
FROM [company].[employee]

INSERT INTO [company].[employee]
VALUES ('Sahil',90000,3,3)

INSERT INTO [company].[employee]
VALUES ('Varsha',30000,1,1)

INSERT INTO [company].[employee]
VALUES ('Riya',45000,2,2)

INSERT INTO [company].[employee]
VALUES ('Hitesh',70000,4,4)

INSERT INTO [company].[employee]
VALUES ('Raj',60000,2,2)

INSERT INTO [company].[employee]
VALUES ('Amit',50000,1,1)

SELECT *
FROM [company].[employee]

--WHERE clause
SELECT * 
FROM [company].[employee]
WHERE salary>50000;

--AND clause
SELECT *
FROM [company].[employee]
WHERE salary>=50000 AND
salary<=70000

--OR clause
SELECT *
FROM [company].[employee]
WHERE salary<50000 OR
salary>70000

--ORDER BY clause
--descending order
SELECT *
FROM [company].[employee]
ORDER BY salary DESC

--by default orders in ascending order
SELECT *
FROM [company].[employee]
ORDER BY salary 

--SELECT TOP
SELECT TOP 5 *
FROM [company].[employee]
ORDER BY salary DESC

--LIKE clause
--selecting names of employees whose names start from K
SELECT e_name
FROM [company].[employee]
WHERE e_name LIKE 'K%'

--selecting names of employees whose name ends with a
SELECT e_name
FROM [company].[employee]
WHERE e_name LIKE '%a'

--WILDCARDS
--% represents 0 or more characters
--selecting names of employees whose names start from R
SELECT e_name
FROM [company].[employee]
WHERE e_name LIKE 'R%'

--_ underscore is used to represent a single character
--selecting names of employees whose name contains a as the second character
SELECT e_name
FROM [company].[employee]
WHERE e_name LIKE '_a%'

--selecting names of employees whose name starts with K and end with a
SELECT e_name
FROM [company].[employee]
WHERE e_name LIKE 'K%a'

--selecting names of employees whose name contains phrase 'sh'
SELECT e_name
FROM [company].[employee]
WHERE e_name LIKE '%sh%'

--IN clause
SELECT *
FROM [company].[manager]
WHERE m_address IN ('Ulhasnagar','Mumbai')

--selecting employees whose salary=40000 or salary=80000
SELECT *
FROM [company].[employee]
WHERE salary IN (40000,80000)

--BETWEEN clause
SELECT *
FROM [company].[employee]
WHERE salary BETWEEN 50000 AND 90000

--ALIASES
SELECT e_name AS high_paid_employees,salary  
FROM [company].[employee]
WHERE salary>50000


