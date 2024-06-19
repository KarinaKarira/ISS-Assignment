--constraints

--creating a dummy table
--CHECK and DEFAULT constraint
CREATE TABLE voters
(
	name varchar(100),
	age int CHECK (age>18),
	city varchar(50) ,
	no_of_times_voted int DEFAULT 0
)

--INDEX

CREATE INDEX idx_name_salary
ON [company].[employee] (e_name,salary)

EXEC sys.sp_helpindex @objname = N'company.employee';

--ALTER command to change the constraint
ALTER TABLE [dbo].[voters] 
DROP CONSTRAINT [CK__voters__age__60A75C0F]

ALTER TABLE [dbo].[voters] 
ADD CONSTRAINT min_age CHECK (age>=18)

--CREATE VIEW clause
CREATE VIEW technology_dept_employees AS
SELECT e_id,e_name,salary,m_id
FROM [company].[employee] 
WHERE d_id = (SELECT d_id FROM [company].[department] WHERE d_name='TECHNOLOGY')



