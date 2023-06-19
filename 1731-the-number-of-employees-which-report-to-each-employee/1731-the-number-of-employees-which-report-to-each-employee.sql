# Write your MySQL query statement below
SELECT e.employee_id, e.name, COUNT(e.employee_id) as reports_count, ROUND(AVG(m.age)) as average_age
FROM Employees e JOIN Employees m
WHERE e.employee_id = m.reports_to
GROUP BY e.employee_id
ORDER BY e.employee_id;