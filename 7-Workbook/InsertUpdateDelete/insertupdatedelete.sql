USE northwind;

/* Q1
Add a new Supplier
*/
INSERT INTO suppliers (SupplierID, CompanyName, ContactName, ContactTitle)
VALUES (DEFAULT, "Clancy's Supply", "Clancy Cooper", "Brand Manager");

/* Q2
Add a new product provided by that supplier
*/
INSERT INTO products (ProductID, ProductName, SupplierID)
VALUES (DEFAULT, "Werewolf Rat", 30);

/* Q3
List all products and their suppliers
*/
SELECT 
    p.ProductName, s.CompanyName
FROM
    products p
        INNER JOIN
    suppliers s ON p.SupplierID = s.SupplierID;

/* Q4
Raise the price of your new product by 15%
*/
-- Using UPDATE to add a starting price
UPDATE products 
SET 
    UnitPrice = 100
WHERE
    ProductID = 78;

-- Using UPDATE to raise by 15%
UPDATE products 
SET 
    UnitPrice = 115
WHERE
    ProductID = 78;

/* Q5
List the products and prices of the new supplier
*/
SELECT 
    p.ProductName, p.UnitPrice, s.CompanyName
FROM
    products p
        INNER JOIN
    suppliers s ON p.SupplierID = s.SupplierID
WHERE
    s.SupplierID = 30;

/* Q6
Delete the new product
*/
DELETE FROM products p
WHERE p.ProductID = 78;

/* Q7
Delete the new supplier
*/
DELETE FROM suppliers s
WHERE s.SupplierID = 30;

/* Q8
List all Products
*/
SELECT 
    *
FROM
    products;

/* Q9
List all suppliers
*/
SELECT 
    *
FROM
    suppliers;