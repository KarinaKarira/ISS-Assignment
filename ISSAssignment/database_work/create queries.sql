USE project;
create schema company;

--creating tables for different entities 
CREATE TABLE company.department
(
	d_id int IDENTITY(1,1) PRIMARY KEY,
	d_name varchar(100),
);

CREATE TABLE company.manager
(
	m_id int IDENTITY(1,1) PRIMARY KEY,
	m_name varchar(100),
	m_address varchar(500),
	d_id int FOREIGN KEY REFERENCES company.department(d_id),
)

CREATE TABLE company.project
(
	p_id int IDENTITY(1,1) PRIMARY KEY,
	p_name varchar(500),
	start_date datetime DEFAULT GETDATE(),
	end_date datetime
)

CREATE TABLE company.employee
(
	e_id int IDENTITY(1,1) PRIMARY KEY,
	e_name varchar(100),
	salary float,
	m_id int,
	d_id int,
	FOREIGN KEY(d_id) REFERENCES company.department(d_id),
	FOREIGN KEY(m_id) REFERENCES company.manager(m_id)
)

CREATE TABLE company.employee_contact
(
	e_id int,
	contact_no int,
	FOREIGN KEY(e_id) REFERENCES company.employee,
	PRIMARY KEY(e_id,contact_no)
)

CREATE TABLE company.works_for
(
	e_id int,
	p_id int,
	PRIMARY KEY(e_id,p_id),
	FOREIGN KEY(e_id) REFERENCES company.employee(e_id),
	FOREIGN KEY(p_id) REFERENCES company.project(p_id),
)
