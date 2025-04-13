create database manager;
use manager;
CREATE TABLE accounts
(
    id       INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50)  NOT NULL UNIQUE,
    password VARCHAR(100) NOT NULL,
    status   ENUM ('ACTIVE', 'INACTIVE') DEFAULT 'ACTIVE'
);

CREATE TABLE departments
(
    id          INT AUTO_INCREMENT PRIMARY KEY,
    name        VARCHAR(100) NOT NULL UNIQUE,
    description VARCHAR(255),
    status      ENUM ('ACTIVE', 'INACTIVE') DEFAULT 'ACTIVE',
    CHECK (CHAR_LENGTH(name) BETWEEN 10 AND 100)
);
CREATE TABLE employees
(
    employee_id   CHAR(5) PRIMARY KEY,
    name          VARCHAR(150)                                          NOT NULL,
    email         VARCHAR(100)                                          NOT NULL UNIQUE,
    phone         VARCHAR(15)                                           NOT NULL UNIQUE,
    gender        ENUM ('MALE', 'FEMALE', 'OTHER')                      NOT NULL,
    level         INT                                                   NOT NULL CHECK (level > 0),
    salary        DECIMAL(15, 2)                                        NOT NULL CHECK (salary > 0),
    birthdate     DATE                                                  NOT NULL,
    address       VARCHAR(255)                                          NOT NULL,
    status        ENUM ('ACTIVE', 'INACTIVE', 'ONLEAVE', 'POLICYLEAVE') NOT NULL,
    department_id INT                                                   NOT NULL,
    FOREIGN KEY (department_id) REFERENCES departments (id),
    CHECK (CHAR_LENGTH(name) BETWEEN 15 AND 150)
);
INSERT INTO accounts (username, password)
VALUES ('admin1', 'adminpass1'),
       ('user2', 'pass2'),
       ('john_doe', '123456');

INSERT INTO departments (name, description, status)
VALUES ('Human Resources', 'Handles recruitment and employee management', 'ACTIVE'),
       ('Research & Development', 'Handles product innovation and research', 'ACTIVE'),
       ('Finance Department', 'Manages company finances and accounting', 'ACTIVE'),
       ('Marketing Team', 'Handles advertising and promotions', 'INACTIVE');


INSERT INTO employees (employee_id, name, email, phone, gender, level, salary, birthdate, address, status,
                       department_id)
VALUES ('E0001', 'Nguyen Van A', 'a@company.com', '0901234567', 'MALE', 2, 1000.00, '1995-01-10', 'Hanoi', 'ACTIVE', 1),
       ('E0002', 'Tran Thi B', 'b@company.com', '0902345678', 'FEMALE', 3, 1500.00, '1990-05-20', 'Da Nang', 'ACTIVE',
        1),
       ('E0003', 'Le Van C', 'c@company.com', '0903456789', 'MALE', 1, 800.00, '1998-07-12', 'HCMC', 'ONLEAVE', 2),
       ('E0004', 'Pham Thi D', 'd@company.com', '0904567890', 'FEMALE', 4, 2000.00, '1988-03-05', 'Hanoi',
        'POLICYLEAVE', 2),
       ('E0005', 'Do Van E', 'e@company.com', '0905678901', 'OTHER', 2, 1100.00, '1992-12-25', 'Can Tho', 'ACTIVE', 3),
       ('E0006', 'Nguyen Thi F', 'f@company.com', '0906789012', 'FEMALE', 5, 2200.00, '1985-09-15', 'Hue', 'INACTIVE',
        3),
       ('E0007', 'Hoang Van G', 'g@company.com', '0907890123', 'MALE', 3, 1800.00, '1993-11-30', 'Hai Phong', 'ACTIVE',
        1),
       ('E0008', 'Vo Thi H', 'h@company.com', '0908901234', 'FEMALE', 4, 1700.00, '1996-06-18', 'Vinh', 'ACTIVE', 4);

delimiter //
create procedure login_acc(
    username_in varchar(50),
    password_in varchar(100)
)
begin
    select * from accounts where username = username_in and password = password_in;
end;
create procedure get_all()
begin
    select * from departments;
end //
create procedure get_total_department_pages()
begin
    SELECT CEIL(COUNT(*) / 5) AS total_pages FROM departments;
end;
create procedure list_department(
    page int
)
begin
    declare offset_department int;
    set offset_department = (page - 1) * 5;
    select *
    from departments
    limit 5 offset offset_department;
end;
create procedure save_department(
    name_in varchar(100),
    description_in varchar(255)
)
begin
    insert into departments (name, description, status)
        value (name_in, description_in, 'active');
end;
create procedure update_department(
    id_in int,
    name_in varchar(100),
    status_in ENUM ('ACTIVE', 'INACTIVE')
)
begin
    update departments
    set name   = name_in,
        status =status_in
    where id = id_in;
end;
create procedure delete_department(id_in int)
begin
    delete from departments where id = id_in;
end;
create procedure search_department(name_in varchar(100))
begin
    select * from departments where name like name_in;
end;

CREATE PROCEDURE get_department_by_id(dep_id INT)
BEGIN
    SELECT *
    FROM departments
    WHERE id = dep_id;
END;

create procedure search_emp_from_dept(
    id_in int,
    out count_emp int
)
begin
    select count(employee_id) into count_emp from employees where department_id = id_in;
end;
create procedure get_total_empl_pages()
begin
    SELECT CEIL(COUNT(*) / 5) AS total_pages FROM employees;
end;
create procedure list_empl(page int)
begin

    declare offset_empl int;
    set offset_empl = (page - 1) * 5;
    select *
    from employees
    limit 5 offset offset_empl;
end;

CREATE PROCEDURE save_employee(
    IN p_name VARCHAR(150),
    IN p_email VARCHAR(100),
    IN p_phone VARCHAR(15),
    IN p_gender ENUM ('MALE', 'FEMALE', 'OTHER'),
    IN p_salary_level INT,
    IN p_salary DECIMAL(15, 2),
    IN p_dob DATE,
    IN p_address VARCHAR(255),
    IN p_status ENUM ('ACTIVE', 'INACTIVE', 'ONLEAVE', 'POLICYLEAVE'),
    IN p_department_id INT
)
begin
    INSERT INTO employees (name, email, phone, gender, level, salary, birthdate, address, status, department_id)
    VALUES (p_name, p_email, p_phone, p_gender,
            p_salary_level, p_salary, p_dob, p_address, p_status, p_department_id);
end;

create procedure find_department_status(id_in int)
begin
    select * from departments where id = id_in and status like 'active';
end;

CREATE PROCEDURE UpdateEmployee(
    IN p_emp_id CHAR(5),
    IN p_emp_name VARCHAR(150),
    IN p_emp_email VARCHAR(255),
    IN p_emp_phoneNumber VARCHAR(25),
    IN p_emp_gender ENUM ('MALE', 'FEMALE', 'OTHER'),
    IN p_emp_salary DECIMAL(10, 2),
    IN p_emp_salaryLevel INT,
    IN p_emp_dateOfBirth DATE,
    IN p_emp_address VARCHAR(255),
    IN p_emp_status ENUM ('active', 'inactive', 'onleave', 'policyleave')
)
BEGIN
    UPDATE employees
    SET name      = p_emp_name,
        email     = p_emp_email,
        phone     = p_emp_phoneNumber,
        gender    = p_emp_gender,
        salary    = p_emp_salary,
        Level     = p_emp_salaryLevel,
        birthdate = p_emp_dateOfBirth,
        address   = p_emp_address,
        status    = p_emp_status
    WHERE employee_id = p_emp_id;

    IF ROW_COUNT() = 0 THEN
        SIGNAL SQLSTATE '45000'
            SET MESSAGE_TEXT = 'Không tìm thấy nhân viên với emp_id được cung cấp.';
    END IF;
END;
create procedure delete_empl(id_in int)
begin
    update employees
    set status = 'INACTIVE'
    where employee_id = id_in;
end;
create procedure search_empl_by_age(
    min_age int,
    max_age int
)
begin
    SELECT *
    FROM employees
    WHERE TIMESTAMPDIFF(YEAR, birthdate, CURDATE()) BETWEEN min_age AND max_age;

end;

create procedure search_empl_by_name(name_in varchar(100))
begin
    SELECT *
    FROM employees
    WHERE name like name_in;
end //
create procedure find_emp_by_id(id_in char(5))
begin
    select * from employees where employee_id = id_in;
end //

create procedure sort_empl_by_salary()
begin
    select * from employees order by salary desc;
end;
create procedure sort_empl_by_name()
begin
    select * from employees order by name asc;
end;
create procedure goupby_department()
begin
    select * from employees group by department_id;
end;
create procedure sum_empl()
begin
    select sum(employee_id) from employees;
end;
create procedure department_max_empl()
begin
    select department_id, count(employee_id)
    from employees
    group by department_id
    having count(employee_id) = (select max(depmt)
                                 from (select count(employee_id) as depmt from employees)
                                          as temp);
end;
CREATE PROCEDURE sum_max_salary()
BEGIN
    SELECT department_id, SUM(salary)
    FROM employees
    GROUP BY department_id
    HAVING SUM(salary) = (SELECT MAX(sum_salary)
                          FROM (SELECT SUM(salary) AS sum_salary
                                FROM employees
                                GROUP BY department_id) AS temp);
END;
// delimiter ;