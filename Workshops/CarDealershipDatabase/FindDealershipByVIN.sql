USE cardealership;

-- Find the dealership that sells VIN 456
SELECT
	d.name, v.VIN, v.make, v.model, v.color, v.price
FROM
	dealerships d
INNER JOIN vehicles v
	ON d.dealership_id = v.dealership_id
WHERE
	v.VIN = 456;
    
-- Find the dealership that sells VIN 789
SELECT
	d.name, v.VIN, v.make, v.model, v.color, v.price
FROM
	dealerships d
INNER JOIN vehicles v
	ON d.dealership_id = v.dealership_id
WHERE
	v.VIN = 789;