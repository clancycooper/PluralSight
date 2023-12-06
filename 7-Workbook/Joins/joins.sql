USE northwind;

/* Q1
	List the product id, product name, unit price and category of all products.
	Order by Category and Product Name
*/
SELECT 
    ProductID, ProductName, UnitPrice, CategoryName
FROM
    Products
        INNER JOIN
    Categories ON products.categoryID = categories.categoryID
ORDER BY CategoryName , ProductName;
    
/* Q2
    ProductID, ProductName, UnitPrice, SupplierName of all products > .75
    Order by ProductName
*/
SELECT 
    ProductID, ProductName, UnitPrice, CompanyName
FROM
    Products
        INNER JOIN
    Suppliers ON products.SupplierID = suppliers.SupplierID
WHERE
    UnitPrice > 75
ORDER BY ProductName;
    
/* Q3
    ProductID, ProductName, UnitPrice, CategoryName, CompanyName of every product
    Order by ProductName
*/
SELECT 
    ProductID, ProductName, UnitPrice, CategoryName, CompanyName
FROM
    Products
        INNER JOIN
    categories ON products.CategoryID = categories.CategoryID
        INNER JOIN
    suppliers ON products.SupplierID = suppliers.SupplierID
ORDER BY ProductName;

/* Q4
	What is the ProductName and CategoryName of the most expensive products?
*/
SELECT 
    ProductName, CategoryName
FROM
    products
        INNER JOIN
    categories ON products.CategoryID = categories.CategoryID
WHERE
    UnitPrice IN (SELECT 
            MAX(UnitPrice)
			FROM
            Products);
            
/* Q5
	List OrderID, ShipName, ShipAddress and CompanyName of every order that shipped to Germany
*/
SELECT 
    OrderID, ShipName, ShipAddress, CompanyName
FROM
    orders
        INNER JOIN
    shippers ON orders.ShipVia = shippers.ShipperID
WHERE
    ShipCountry = 'Germany';
    
/* Q6
	OrderID, OrderDate, ShipName, ShipAddress of every order for "Sasquatch Ale"
*/
SELECT 
    orders.OrderID, OrderDate, ShipName, ShipAddress
FROM
    orders
        INNER JOIN
    `order details` ON orders.OrderID = `order details`.OrderId
        INNER JOIN
    products ON `order details`.ProductID = products.ProductID
WHERE
    products.ProductName = "Sasquatch Ale";