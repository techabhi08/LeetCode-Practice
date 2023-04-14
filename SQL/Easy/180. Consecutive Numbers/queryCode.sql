# Write your MySQL query statement below
SELECT DISTINCT l1.num as ConsecutiveNums FROM Logs l1
INNER JOIN Logs l2 ON l2.id = l1.id + 1 AND l2.num = l1.num
INNER JOIN Logs l3 ON l3.id = l1.id + 2 AND l3.num = l1.num
