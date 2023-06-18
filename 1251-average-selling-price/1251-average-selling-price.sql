# Write your MySQL query statement below
SELECT p.product_id, ROUND(SUM(u.units * p.price) / SUM(u.units), 2) as average_price FROM Prices p
INNER JOIN UnitsSold u ON p.product_id = u.product_id AND purchase_date BETWEEN start_date AND end_date
GROUP BY product_id;