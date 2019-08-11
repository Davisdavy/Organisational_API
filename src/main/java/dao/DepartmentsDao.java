package dao;

import models.Departments;
import models.Employees;
import models.News;

import java.util.List;

public interface DepartmentsDao {
    //create
    void add(Departments departments);

    //list and read all departments
    List<Departments>getAllDepartments();

    //find and get news of a department
    Departments findById();
    List<News>getAllNews(int dpt_id);

    //M:M r-ship
    void addDptToEmployees(Departments departments, Employees employees);
    List<Employees> getAllEmployeesBelongingToDepartment(int emp_id);

    //Delete
    void deleteById(int dpt_id);
    void clearAll();
}
