USE [project]
GO

--  =============================================
--Author:   Karina Karira
--create date: 19/06/24
--Description: adds new employee
--parameters:
--@e_name:name of the employee
--@salary:salary of the employee
--@m_id:id of the employee's manager
--@d_id:id of the employee's department

--Example: EXEC company.sp_addEmployee 'Sachin',50000,1,1
--change history: -
CREATE PROCEDURE [company].[sp_addEmployee]
@e_name varchar(100),
@salary float,
@m_id int,
@d_id int
AS
BEGIN
INSERT INTO [company].[employee]
           ([e_name]
           ,[salary]
           ,[m_id]
           ,[d_id])
     VALUES
           (@e_name,
		   @salary,
		   @m_id,
		   @d_id)
END
GO


EXEC [company].sp_addEmployee 'Sachin',50000,1,1
SELECT *
FROM [company].[employee]