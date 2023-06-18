# Write your MySQL query statement below
SELECT contest_id, ROUND(COUNT(u.user_id) / (SELECT COUNT(*) FROM Users) * 100, 2) AS percentage 
FROM Register r INNER JOIN Users u ON u.user_id = r.user_id 
GROUP BY contest_id ORDER BY percentage DESC, contest_id ASC;