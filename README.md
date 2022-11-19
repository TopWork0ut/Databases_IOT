# Databases_IOT

## Lab 6

Task:

Stored programs in MySQL

Based on previous work (back-end with Spring Boot) you should
write a number of program constructs for the existing database (triggers,
procedures, functions, cursors). For stored procedures
provide their call using backend controllers.

1. Add an additional arbitrary table to database 1 and link it with
another existing table with a 1:M relationship. However, to
ensure the integrity of values, use triggers instead of
physical foreign key.

2. Stored procedures:

a. Provide parameterized insertion of new values into
an arbitrary table.

b. Provide implementation of M:M relationship between 2 tables,
i.e. insert a corresponding row into the joining table
for real-existing values (e.g. surname, name)
in these main tables.

c. Create a package that inserts 10 tapes into an arbitrary
database table in the format &lt; Noname+#&gt; , e.g:
Noname5, Noname6, Noname7, etc.

d. Write a custom function that will search for
Max, Min, Sum or Avg for a column of an arbitrary table in the database.
Write a procedure that will call this function in SELECT
function in SELECT.

e. Write 1 procedure with a cursor to perform one
of the following tasks:

e1. Using the cursor, provide dynamic
creation of 2 tables with names containing the stamp
time, the structure of the tables is identical to any structure
of the database table. Then randomly line by line
copy the ribbons from the parent table to either one,
or to other additional tables. Re-run
the procedure again creates new similar tables, in
which the data from the parent table will be randomly scattered again.
the parent table.

e2. Using the cursor, provide dynamic
creation of tables with names + time stamp taken from
column from an arbitrary database table, with a random
number of columns (from 1 to 9). Names and type of columns
are arbitrary.

e3. Using the cursor, provide dynamic
creation of databases with names taken from a column from
an arbitrary table of the current database, with a random
number of tables for each database (from 1 to 9).
The structure of the tables is arbitrary. The names of the tables
correspond to the name of the database with a serial number from 1 to


3. Write 3 arbitrary triggers for the tables of the current database, as
example, you can take the following:

a. The value of a certain column cannot end with two
zeros

b. Prohibit any modification of data in the table

c. Prohibit deleting ribbons from the table

d. Provide a minimum cardinality of 6 tapes for
a certain database table

e. Provide cardinality (min=2, max=6) of rows for
a certain database table

f. Create a log table in which to keep logs with
time stamp when deleting data for a certain
table

g. Create a log table in which to keep logs with a time stamp
time stamp when modifying data for a table

h. For a certain column provide the input format:

2 random letters except M and R + ;-; + 3 digits + ;-; + 2 digits
i. For a certain column provide the input format:
1 letter: A, M or Z + 5 digits + 2 random letters
j. For a certain column, only the following names are allowed:
;Svitlana; ;Petro; ;Olha; ;Taras;.
k. For a certain column, provide the input format:
the first letter in the value must correspond to the first
letter of the value of the neighboring field in the row


