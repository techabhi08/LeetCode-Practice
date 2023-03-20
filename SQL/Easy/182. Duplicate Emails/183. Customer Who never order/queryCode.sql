# Write your MySQL query statement below
Select name As Customers From Customers
LEFT JOIN Orders ON
Customers.id = Orders.customerId
WHERE customerId IS NULL;
