# Write your MySQL query statement below
Select w1.id as Id from Weather w1 Inner Join Weather w2 On
w1.temperature > w2.temperature AND DATEDIFF(w1.recordDate, w2.recordDate) = 1;
