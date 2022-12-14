-- 1
use Labor_SQL;
SELECT maker, Product.type FROM Product WHERE Product.type = "Printer" ORDER BY model DESC;

-- 2
SELECT * FROM Trip WHERE HOUR(time_in) >= 12 AND HOUR(time_in) <= 17;

-- 3
SELECT Product.maker,Product.model, Product.type, Laptop.speed
FROM Product 
INNER JOIN Laptop ON (Product.model = Laptop.model) 
WHERE Laptop.speed >= 600;

-- 4 
SELECT DISTINCT maker FROM Product 
WHERE maker = ANY(SELECT maker FROM Product WHERE type = "PC")
AND maker = ANY(SELECT maker FROM Product WHERE type = "Laptop");

-- 5
SELECT Ships.name, Ships.launched, Classes.displacement FROM Ships 
INNER JOIN Classes ON Ships.class = Classes.class 
WHERE ( Ships.launched >= 1922 AND Classes.displacement > 35000 );

-- 6
SELECT  CONCAT('code: ', code) AS code, CONCAT('model: ', model) AS model, 
CONCAT('speed: ', speed) AS speed, CONCAT('ram: ', ram) AS ram, CONCAT('hd: ', hd) AS hd,
CONCAT('cd: ', cd) AS cd, CONCAT('price: ', price) AS price FROM PC;

-- 7
SELECT date, COUNT(*) AS count_trips FROM Pass_in_trip AS p JOIN Trip ON Trip.trip_no = p.trip_no 
WHERE Trip.town_to = "Moscow" GROUP BY p.date;

-- 8
SELECT speed, AVG(price) AS avg_price FROM PC WHERE speed >= 600 GROUP BY speed;

-- 9
SELECT maker,
CASE WHEN
( SELECT COUNT(*)
FROM Product WHERE type='printer' GROUP BY maker HAVING maker=P.maker )IS NOT NULL THEN 
concat('yes(', 
(SELECT COUNT(*)
FROM Product WHERE type='printer' GROUP BY maker HAVING maker=P.maker ), ')') ELSE 'no'
END AS printers FROM Product P GROUP BY maker;

-- 10
SELECT class, SUM(ships_count) AS ships_count
FROM
(
	SELECT class, COUNT(class) AS ships_count FROM Ships GROUP BY class 
	UNION 
	SELECT class, COUNT(class) AS ships_count FROM Classes GROUP BY class 
    UNION
    SELECT class, COUNT(class) AS ships_count FROM Classes GROUP BY class 
) T
GROUP BY class;









