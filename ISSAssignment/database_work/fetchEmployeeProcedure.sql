USE [project]
GO

--  =============================================
--Author:   Karina Karira
--create date: 19/06/24
--Description: gets details of the employee given an id
--parameters:
--@e_id: id of the employee whose details are to be needed
--returns:
--e_name,salary,d_name,m_name
--Example: EXEC company.sp_fetchEmployee 1
--change history: 
CREATE PROCEDURE [company].[sp_fetchEmployee]
@e_id int
AS
BEGIN
SELECT e_name,salary,d_name,m_name
FROM [company].[employee] e
INNER JOIN [company].[department] d
ON e.d_id=d.d_id
INNER JOIN [company].[manager] m
ON e.m_id=m.m_id
WHERE e_id=@e_id
END
GO


