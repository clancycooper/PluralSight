USE northwind;

/* Q1
How many Suppliers are there?
Answer: 29
*/
SELECT 
    COUNT(*) AS total_suppliers
FROM
    suppliers;

/* Q2
What is the sum of all of the employees salaries?
Answer: 20,362.93
*/
SELECT SUM(salary) AS total_salary
FROM employees;

/* Q3
What is the price of the cheapest item sold at Northwind?
Answer: 2.50
*/
SELECT MIN(UnitPrice) AS lowest_price
FROM products;

/* Q4
What is the avg price of products sold at Northwind?
Answer: 28.87
*/
SELECT AVG(UnitPrice) AS avg_price
FROM products;

/* Q5
What is the most expensive price of products sold at Northwind?
Answer: 263.50
*/
SELECT MAX(UnitPrice) AS highest_price
FROM products;

/* Q6
What is the Supplier ID and # of items each supplier supplies?
*/
SELECT SupplierID, COUNT(*) AS items_supplied
FROM products
GROUP BY SupplierID;

/* Q7
What is the category ID of each category and avg price of each item in the category?
*/
SELECT DISTINCT CategoryID, AVG(UnitPrice) AS avg_category_price
FROM products
GROUP BY CategoryID;

/* Q8
For suppliers that supply at least 5 items, what is the supplierID and # of items supplied?
*/
SELECT 
    SupplierID, COUNT(*) AS items_supplied
FROM
    products
GROUP BY SupplierID
HAVING COUNT(*) >= 5;

/* Q9
List productID, productname, and inventory value (unit price * number of units in stock) 
Sort in DESC, if not distinct, order by product name
*/
SELECT ProductID, ProductName, UnitPrice * UnitsInStock AS inventory_value
FROM products
ORDER BY inventory_value DESC, ProductName; 