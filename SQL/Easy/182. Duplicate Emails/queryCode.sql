# Write your MySQL query statement below
Select email As Email From Person
Group by(email) Having count(email) > 1;
