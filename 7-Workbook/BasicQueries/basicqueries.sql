USE northwind;

/* Q1
What is the table name that holds Northwind's items?
Answer: Products
*/

SELECT
*
FROM
Products;

/* Q2
List Product ID, Name & Price of every product
*/
SELECT 
ProductID, ProductName, UnitPrice
FROM 
Products;

/* Q3
Same as above, but order them by ascending order
*/
SELECT 
ProductID, ProductName, UnitPrice
FROM 
Products 
ORDER BY 
UnitPrice;

/* Q4
List products that cost $7.50 or less
*/
SELECT
ProductID, ProductName, UnitPrice
FROM
Products
WHERE
UnitPrice <= 7.50;

/* Q5
In descending order (price), what are the products we have where there are at least 100 units in stock?
*/
SELECT
ProductID, ProductName, UnitPrice, UnitsInStock
FROM
Products
WHERE
UnitsInStock >= 100
ORDER BY
UnitPrice DESC;

/* Q6
Same as above, except if 2 or more have the same price, list those in ascending order (name)
*/
SELECT
ProductID, ProductName, UnitPrice, UnitsInStock
FROM
Products
WHERE
UnitsInStock >= 100
ORDER BY
UnitPrice DESC, ProductName ASC;

/* Q7
Products we carry with no units in stock, but 1 or more in backorder. Order asc by ProductName
*/
SELECT
ProductID, ProductName, UnitPrice, UnitsInStock, UnitsOnOrder
FROM
Products
WHERE
UnitsInStock = 0 AND UnitsOnOrder >= 1
ORDER BY
ProductName;

/* Q8
What is the name of the table that hold the categories of products that Northwind sells?
Answer: Categories
*/
SELECT
*
FROM
Categories;

/* Q9
Write a query that lists all of the columns and rows of the Categories
What is the ID of Seafood?
Answer: 8
*/
SELECT
*
FROM
Categories
ORDER BY 
CategoryID DESC;

/* Q10
Examine Products table, how does it ID the Category of each product sold?
Write a query to list all seafood items
*/
SELECT
ProductID, ProductName, CategoryID
FROM
Products
WHERE
CategoryID = 8;

/* Q11
What are all the first and last names of Northwind Employees?
*/
SELECT
FirstName, LastName
FROM
Employees;

/* Q12
What employees have manager in their title?
*/
SELECT
FirstName, LastName, Title
FROM
Employees
WHERE
Title LIKE '%manager%';

/* Q13
List the distinct job titles in employees
*/
SELECT DISTINCT
Title
FROM
Employees;

/* Q14
What employees have salaries between 2000 and 2500?
*/
SELECT
FirstName, LastName, Salary
FROM
Employees
WHERE Salary BETWEEN 2000 AND 2500;

/* Q15
List all information about Northwind's suppliers
*/
SELECT
*
FROM
Suppliers;

/* Q16
Examine Products table, list all products supplied by 'Tokyo Traders'
*/
SELECT
SupplierID, ProductName
FROM
Products
WHERE
SupplierID = 4;