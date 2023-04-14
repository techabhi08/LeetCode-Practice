# Write your MySQL query statement below
SELECT s1.score, COUNT(DISTINCT s2.score) AS 'rank'
FROM Scores s1 INNER JOIN Scores s2 ON
s1.score <= s2.score
GROUP BY s1.score, s1.id
Order BY s1.score DESC;
