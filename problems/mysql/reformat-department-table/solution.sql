DROP table if exists Department;

Create table If Not Exists Department
(
    id      int,
    revenue int,
    month   varchar(5)
);
Truncate table Department;
insert into Department (id, revenue, month)
values ('1', '8000', 'Jan');
insert into Department (id, revenue, month)
values ('2', '9000', 'Jan');
insert into Department (id, revenue, month)
values ('3', '10000', 'Feb');
insert into Department (id, revenue, month)
values ('1', '7000', 'Feb');
insert into Department (id, revenue, month)
values ('1', '6000', 'Mar');

# Write your MySQL query statement below

select id,
       SUM(CASE WHEN month = 'Jan' THEN Revenue END) as Jan_Revenue,
       SUM(CASE WHEN month = 'Feb' THEN revenue END) as Feb_Revenue,
       SUM(CASE WHEN month = 'Mar' THEN revenue END) as Mar_Revenue,
       SUM(CASE WHEN month = 'Apr' THEN revenue END) as Apr_Revenue,
       SUM(CASE WHEN month = 'May' THEN revenue END) as May_Revenue,
       SUM(CASE WHEN month = 'Jun' THEN revenue END) as Jun_Revenue,
       SUM(CASE WHEN month = 'Jul' THEN revenue END) as Jul_Revenue,
       SUM(CASE WHEN month = 'Aug' THEN revenue END) as Aug_Revenue,
       SUM(CASE WHEN month = 'Sep' THEN revenue END) as Sep_Revenue,
       SUM(CASE WHEN month = 'Oct' THEN revenue END) as Oct_Revenue,
       SUM(CASE WHEN month = 'Nov' THEN revenue END) as Nov_Revenue,
       SUM(CASE WHEN month = 'Dec' THEN revenue END) as Dec_Revenue
from Department
GROUP BY id;
