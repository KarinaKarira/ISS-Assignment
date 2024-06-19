--JOINS
USE project
SELECT * FROM 
[company].[employee]

SELECT * FROM 
[company].[manager]

SELECT * FROM 
[company].[department]

--INNER JOIN
SELECT e_id,e_name AS employee_name,salary,d_name AS department_name,m_name AS manager_name
FROM [company].[employee] e
INNER JOIN [company].[department] d
ON e.d_id=d.d_id
INNER JOIN [company].[manager] m
ON e.m_id=m.m_id

--for left and right joins, we will have to insert more values in employee table and department table
INSERT INTO [company].[employee](e_name)
VALUES ('Karina')

INSERT INTO [company].[employee](e_name)
VALUES ('Harsha')

INSERT INTO [company].[department]
VALUES ('Sales');

INSERT INTO [company].[department]
VALUES ('Marketing');

--left join
SELECT e_id,e_name AS employee_name,m_name as manager_name
FROM [company].[employee] e
LEFT JOIN [company].[manager] m
ON e.m_id=m.m_id

SELECT e_id,e_name AS employee_name,d_name as department_name
FROM [company].[employee] e
LEFT JOIN [company].[department] d
ON e.d_id=d.d_id

--RIGHT JOIN
SELECT e_id,e_name AS employee_name,d_name as department_name
FROM [company].[employee] e
RIGHT JOIN [company].[department] d
ON e.d_id=d.d_id

--FULL JOIN
SELECT e_id,e_name AS employee_name,d_name as department_name
FROM [company].[employee] e
FULL JOIN [company].[department] d
ON e.d_id=d.d_id

--UNION operator
SELECT d_id 
FROM [company].[employee]
UNION
SELECT d_id
FROM [company].[department]

--SELECT INTO clause (table need not be existing)
SELECT e.e_id,e.e_name,e.salary,e.m_id INTO tech_employees
FROM [company].[employee] e
INNER JOIN [company].[department] d
ON e.d_id=d.d_id
WHERE d.d_name='TECHNOLOGY'

SELECT *
FROM tech_employees

--INSERT INTO SELECT clause (table must be existing)
--inserting d_ids that are not in employee table 
--The below query will not work because NOT IN does not work with NULL values
--INSERT INTO [company].[employee](d_id)
--SELECT d_id
--FROM [company].[department]
--WHERE d_id 
--NOT IN (SELECT d_id FROM [company].[employee])

--alternative
INSERT INTO [company].[employee](d_id)
SELECT d.d_id
FROM [company].[employee] e
right JOIN [company].[department] d
ON e.d_id=d.d_id
WHERE e.d_id IS NULL

--checking the additional department ids added
SELECT *
FROM [company].[employee]


