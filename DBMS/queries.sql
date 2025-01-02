-- 1. Create Tables
CREATE TABLE Departments (
    id INT AUTO_INCREMENT PRIMARY KEY,
    department_name VARCHAR(50) NOT NULL
);

CREATE TABLE Employees (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    department_id INT,
    salary DECIMAL(10, 2) NOT NULL,
    hire_date DATE,
    email VARCHAR(100),
    FOREIGN KEY (department_id) REFERENCES Departments(id)
);

-- 2. Insert Data into Tables
INSERT INTO Departments (department_name) VALUES ('HR'), ('IT'), ('Sales');

INSERT INTO Employees (name, department_id, salary, email) VALUES
('Alice', 1, 4500, 'alice@example.com'),
('Bob', 2, 6000, NULL),
('Charlie', 3, 3500, 'charlie@example.com');

-- 3. Select, Distinct
SELECT * FROM Employees;
SELECT DISTINCT department_id FROM Employees;

-- 4. Where, And & Or
SELECT * FROM Employees WHERE salary > 5000 AND department_id = 2;
SELECT * FROM Employees WHERE department_id = 1 OR salary < 4000;

-- 5. Order By
SELECT * FROM Employees ORDER BY salary DESC;

-- 6. Update
UPDATE Employees SET salary = 5000 WHERE name = 'Alice';

-- 7. Delete
DELETE FROM Employees WHERE name = 'Charlie';

-- 8. Select Top
SELECT * FROM Employees LIMIT 2; -- Adjust for MySQL/PostgreSQL

-- 9. Like, Wildcards
SELECT * FROM Employees WHERE name LIKE 'A%';

-- 10. In, Between
SELECT * FROM Employees WHERE department_id IN (1, 2);
SELECT * FROM Employees WHERE salary BETWEEN 4000 AND 7000;

-- 11. Aliases
SELECT name AS EmployeeName, salary AS EmployeeSalary FROM Employees;

-- 12. Joins
-- Inner Join
SELECT e.name, d.department_name FROM Employees e 
INNER JOIN Departments d ON e.department_id = d.id;

-- Left Join
SELECT e.name, d.department_name FROM Employees e 
LEFT JOIN Departments d ON e.department_id = d.id;

-- Right Join
SELECT e.name, d.department_name FROM Employees e 
RIGHT JOIN Departments d ON e.department_id = d.id;

-- Full Join
SELECT e.name, d.department_name FROM Employees e 
FULL OUTER JOIN Departments d ON e.department_id = d.id;

-- 13. Union
SELECT name FROM Employees UNION SELECT department_name FROM Departments;

-- 14. Select Into
CREATE TABLE BackupEmployees AS SELECT * FROM Employees;

-- 15. Insert into Select
INSERT INTO Employees (name, department_id, salary, email)
SELECT 'Derek', department_id, 4000, 'derek@example.com' FROM Departments WHERE department_name = 'Sales';

-- 16. Constraints
ALTER TABLE Employees ADD CONSTRAINT chk_salary CHECK (salary > 0);
ALTER TABLE Employees ADD CONSTRAINT unq_name UNIQUE (name);

-- 17. Default
ALTER TABLE Employees MODIFY hire_date DATE DEFAULT CURRENT_DATE;

-- 18. Drop, Alter
DROP TABLE IF EXISTS OldEmployees;
ALTER TABLE Employees ADD COLUMN phone VARCHAR(15);

-- 19. Auto Increment
CREATE TABLE TestAutoInc (
    id INT AUTO_INCREMENT PRIMARY KEY,
    description VARCHAR(100)
);

-- 20. Views
CREATE VIEW EmployeeView AS
SELECT name, department_id, salary FROM Employees WHERE salary > 4000;

-- 21. Null Values
SELECT * FROM Employees WHERE email IS NULL;

-- 22. Group By, Having
SELECT department_id, AVG(salary) AS AvgSalary FROM Employees 
GROUP BY department_id HAVING AVG(salary) > 4500;

-- 23. Functions
SELECT UPPER(name) AS UpperName, CHAR_LENGTH(name) AS NameLength FROM Employees;

-- 24. Null Functions
SELECT COALESCE(email, 'No Email') AS EmailAddress FROM Employees;

-- 25. Callable Statement (Stored Procedure)
DELIMITER $$
CREATE PROCEDURE GetEmployeeCount()
BEGIN
    SELECT COUNT(*) AS TotalEmployees FROM Employees;
END $$
DELIMITER ;

-- 26. Prepared Statement
PREPARE stmt FROM 'SELECT * FROM Employees WHERE department_id = ?';
SET @department_id = 2;
EXECUTE stmt USING @department_id;

-- 27. Stored Procedure Execution
CALL GetEmployeeCount();
