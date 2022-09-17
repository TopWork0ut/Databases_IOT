# Databases_IOT

## Lab 2

Task:

Write 10 selectors to your laboratory mysql table and 10 to default variant


## Variant 60 :

1. Database "Comp. firm". Find printer manufacturers. Output: maker,
type. Sort the output in descending order by the maker column.

2. DB "Airport". From the Trip table, display information about flights that
depart between 12:00 and 17:00 inclusive.

3. Database "Comp. firm". Display the manufacturer, type, model and frequency of pro-
cessor for notebooks, the frequency of processors of which exceeds 600 MHz.

Output: maker, type, model, speed.

4. Database "Comp. firm". Find manufacturers that release at the same time
PCs and laptops (use keyword ANY). Display maker.

5. Database "Ships". According to the Washington International Treaty of
at the beginning of 1922, it was forbidden to build ships of the line
with a displacement of over 35,000 tons. Name the offending ships
this contract (take into account only ships with a known year of descent on
water, i.e. from the Ships table). Output: name, launched, displacement.

6. Database "Comp. firm". For the PC table, display all information from the
mentaries in each cell, for example 'model: 1121', 'price: 600.00'.

7. DB "Airport". Determine the number of flights to the city 'Moscow' for
of each date of the Pass_in_trip table. Output: date, number of flights.

8. Database "Comp. firm". For each value of PC speed, which is
is higher than 600 MHz, determine the average price of a PC with the same speed.

Output: speed, average price. (Hint: use subqueries in
quality of calculated columns)

9. Database "Comp. firm". Get the summary set for the Product table

in the form of a table with columns maker, printer, in which for each
the producer must indicate whether he produces ('yes') or not ('no')

appropriate type of products. In the first case ('yes') additionally
indicate next to it in round brackets the total amount available (that is, what
located in the Printer table) of products, for example 'yes(2)'. (Hint:
use subqueries as calculated columns and
CASE operator)

10. DB "Ships". For each class, count the number of ships,
what is included in it (also consider the ships in the Outcomes table,
which are not in the Ships table). Output: class, the number of ships in the class.
(Hint: use the UNION operator and the EXISTS operation)


