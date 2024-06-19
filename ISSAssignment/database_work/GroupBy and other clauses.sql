--GROUP BY clause
USE project;
SELECT d_id,MAX(salary) as max_salary_per_dept
FROM company.employee
WHERE d_id IS NOT NULL
GROUP BY d_id

--HAVING CLAUSE
SELECT d_id,COUNT(d_id) AS count_of_employees
FROM company.employee
GROUP BY d_id
HAVING COUNT(d_id)>2

--NULL functions
SELECT e_id,e_name,ISNULL(d_id,0)
FROM [company].[employee]

SELECT e_id,e_name,	COALESCE(d_id,0)
FROM [company].[employee]
