# TV series Database

## Story

You are working for the next big TV series streaming company.
Your boss gives you a new task. You need to implement a code that executes operations
on the company's database of accessible TV series.

## What are you going to learn?

- JDBC (Java Database Connectivity) API basics
- CRUD operations from Java
- table creation and deletion from Java


## Tasks

1. Implement a constructor which sets all fields of `Series` class. Implement getters for all fields of `Series` class.
    - In `SeriesTest` class all tests pass when student runs them.

2. Create a database for this project.
    - Student can connect to the new database with DBeaver.

3. Modify `getConnection` method so it provides connection to your db.
    - The `getConnection` method returns a connection to the new database. The `testGetConnectionNotNull` test passes when student runs it.

4. Implement methods in `TVSeriesDao` class
    - All methods are implemented in `TVSeriesDao` class. All tests pass when student runs them.

## General requirements

None

## Hints

- You can use _prepared statements_ for this task.
- DB connections should be closed if not needed anymore.


## Background materials

- <i class="far fa-exclamation"></i> [select](https://www.w3schools.com/sql/sql_select.asp)
- <i class="far fa-exclamation"></i> [where](https://www.w3schools.com/sql/sql_where.asp)
- <i class="far fa-exclamation"></i> [insert into](https://www.w3schools.com/sql/sql_insert.asp)
- <i class="far fa-exclamation"></i> [update](https://www.w3schools.com/sql/sql_update.asp)
- <i class="far fa-exclamation"></i> [delete](https://www.w3schools.com/sql/sql_delete.asp)
- <i class="far fa-exclamation"></i> [create table](https://www.w3schools.com/sql/sql_create_table.asp)
- <i class="far fa-exclamation"></i> [drop table](https://www.w3schools.com/sql/sql_drop_table.asp)
- <i class="far fa-exclamation"></i> [prepared statement](https://www.javatpoint.com/PreparedStatement-interface)
- <i class="far fa-exclamation"></i> [avoid sql injection](https://stackoverflow.com/questions/4333015/does-the-preparedstatement-avoid-sql-injection)
- <i class="far fa-exclamation"></i> [about dao pattern](https://www.tutorialspoint.com/design_pattern/data_access_object_pattern.htm)

