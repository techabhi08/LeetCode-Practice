# Write your MySQL query statement below
Select Employee.name as Employee from Employee
Inner Join Employee e2 
On Employee.managerId = e2.id 
WHERE Employee.salary > e2.salary;
