SELECT d.name AS Department,
       e.name AS Employee,
       e.salary AS Salary
FROM Employee e
JOIN Department d
ON e.departmentId = d.id
WHERE e.salary IN (
    SELECT salary
    FROM (
        SELECT departmentId,
               salary,
               DENSE_RANK() OVER (
                   PARTITION BY departmentId
                   ORDER BY salary DESC
               ) AS rnk
        FROM Employee
    ) ranked
    WHERE ranked.departmentId = e.departmentId
      AND ranked.rnk <= 3
)
ORDER BY Department, Salary DESC;