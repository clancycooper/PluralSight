USE cardealership;

-- Vehicles for the Dealership 'Clancys Coopers'
SELECT
	v.*, d.name
FROM
	vehicles v
INNER JOIN dealerships d
	ON v.dealership_id = d.dealership_id
WHERE
	d.name = 'Clancys Coopers';

-- Vehicles for the Dealership 'Scout Used Cars'
SELECT
	v.*, d.name
FROM
	vehicles v
INNER JOIN dealerships d
	ON v.dealership_id = d.dealership_id
WHERE
	d.name = 'Scout Used Cars';