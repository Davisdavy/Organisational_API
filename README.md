# Organisational Api.

#### An API Application that enables access to news and employees to a department of an organisation.  , Monday August 2019
##### By **Davis Wafula**;
## Description

Organisational Api gives you the ability to query for all the users and the departments associated with them.


## Project setup instructions
* installations such as JUnit, intellij, SDK, JDK.

* Clone the project into your machine.

* Gradle run javac Organisational_API.java to compile and ru the program

### Postman Test points
1. Post a department -> localhost:4567/departments/new
2. Get all departments -> localhost:4567/departments
3. Get a department by id -> localhost:4567/departments/:id
4. Post news into a department -> localhost:4567/departments/:id/news/new
5. Get a department -> localhost:4567/departments/:id/dptNews
6. Post employees to into a department -> localhost:4567/departments/:dpt_id/employees/new
7. Post new employee -> localhost:4567/employees/new
8. Get all employees-> localhost:4567/employees
9. Assign a department to an employee-> localhost:4567//employees/emp_id/departments/:dpt_id
10. Get department id of an employee ->localhost:4567/employees/:emp_id/departments
11. Post news->localhost:4567/news/new
12.Get all news ->localhost:4567/news

## Technologies used
* Java.
* Gradle(for unit testing).
* Postman testing
* Spark.


### Installation
1. Clone the repo `https://github.com/Davisdavy/Organisational_API.git`
2. CD into the folder `cd Organisational_API`



## Support and contact details
contact me @ davisdavy96@gmail.com

### License
The project is under[MIT license](https://github.com/Davisdavy/Organisational_API/blob/master/LICENSE)
Copyright &copy; 2019.All right reserved