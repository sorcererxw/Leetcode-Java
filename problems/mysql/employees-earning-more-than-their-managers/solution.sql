Create table If Not Exists Employee
(
    Id        int,
    Name      varchar(255),
    Salary    int,
    ManagerId int
);
Truncate table Employee;
insert into Employee (Id, Name, Salary, ManagerId)
values ('1', 'Joe', '70000', '3');
insert into Employee (Id, Name, Salary, ManagerId)
values ('2', 'Henry', '80000', '4');
insert into Employee (Id, Name, Salary, ManagerId)
values ('3', 'Sam', '60000', null);
insert into Employee (Id, Name, Salary, ManagerId)
values ('4', 'Max', '90000', null);

SELECT e1.Name as Employee
FROM Employee e1
         JOIN Employee e2
WHERE e1.ManagerId = e2.Id
  AND e1.Salary > e2.Salary
