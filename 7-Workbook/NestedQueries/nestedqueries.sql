USE northwind;

/* Q1
What is the name of the most expensive products?
*/
SELECT 
    ProductName, UnitPrice
FROM
    products
WHERE
    UnitPrice = (SELECT 
            MAX(UnitPrice)
        FROM
            products);

/* Q2
What is the orderID, shippingname, and shipping address of all orders shipped by Federal Shipping?
*/
SELECT 
    OrderID, ShipName, ShipAddress
FROM
    orders
WHERE
    orders.ShipVia IN (SELECT 
            ShipVia
        FROM
            orders
        WHERE
            ShipVia = 3);
            
/* Q3
What are the order ids of the orders that ordered Sasquatch Ale?
*/
SELECT 
    OrderID, ProductID
FROM
    `order details`
WHERE
    ProductID IN (SELECT 
            ProductID
        FROM
            `order details`
        WHERE
            ProductID = 34);
            
/* Q4
What is the name of the employee that sold 10266?
*/
SELECT 
    FirstName, LastName
FROM
    employees
WHERE
    EmployeeID IN (SELECT 
            EmployeeID
        FROM
            employees
        WHERE
            EmployeeID = 3);
            
/* Q5
What is the name of the customer who bought 10266?
*/
SELECT 
    CompanyName
FROM
    Customers
WHERE
    CustomerID IN (SELECT 
            CustomerID
        FROM
            Customers
        WHERE
            CustomerID LIKE '%WARTH%');