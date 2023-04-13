CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
SET n = N - 1;
  RETURN (
      # Write your MySQL query statement below.
      SELECT DISTINCT salary FROM Employee
      ORDER BY salary DESC LIMIT 1 OFFSET n
  );
END
