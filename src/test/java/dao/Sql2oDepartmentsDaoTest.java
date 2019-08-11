package dao;

import org.junit.After;
import org.junit.Before;
import org.sql2o.Sql2o;
import org.junit.*;
import org.sql2o.Connection;
import models.Departments;
import models.Employees;

import java.util.Arrays;

import static org.junit.Assert.*;

public class Sql2oDepartmentsDaoTest {
    private static Connection conn;
    private Sql2oDepartmentsDao departmentsDao;
    private static Sql2oEmployeesDao employeesDao;

    @Before
    public void setUp() throws Exception {
        String connectionString = "jdbc:h2:mem:testing;INIT=RUNSCRIPT from 'classpath:db/create.sql'";
        Sql2o sql2o = new Sql2o(connectionString, "davis", "vegas2017");
        //employeesDao = new Sql2oEmployeesDao(sql2o);
        departmentsDao = new Sql2oDepartmentsDao(sql2o);

        conn = sql2o.open();
    }

    @After
    public void tearDown() throws Exception {
//        employeesDao.clearAll();
        departmentsDao.clearAll();
        conn.close();
    }

    @Test
    public void addingDepartmentsSetsId() throws Exception {
        Departments testDepartments = setupDepartments();
        assertEquals(0, testDepartments.getId());
    }

    @Test
    public void getAll() throws Exception {
        Departments departments = setupDepartments();
        departmentsDao.add(departments);
        Departments department2 = setupDepartments();
        departmentsDao.add(department2);
        assertTrue(departmentsDao.getAllDepartments().contains(departments));
        assertTrue(departmentsDao.getAllDepartments().contains(department2));
    }

    @Test
    public void findById() {
        Departments departments = setupDepartments();
        departmentsDao.add(departments);
        Departments department2 = departmentsDao.findById(departments.getId());
        assertEquals(departments,department2);
    }

//    @Test
//    public void addDepartment() {
//        Departments departments = se();
//        departmentsDao.add(departments);
//        int departId = departments.getId();
//        assertEquals(departId,departments.getId());
//    }

    @Test
    public void  addDptToEmployees() {
        Departments departments = setupDepartments();
        departmentsDao.add(departments);
        Employees employees = new Employees("Davis", "MD", "directs","North Arizona");
        employeesDao.add(employees);
        Employees employees2 = new Employees("Davis", "MD", "directs","North Arizona");
        employeesDao.add(employees2);
        departmentsDao.addDptToEmployees(departments,employees);
        departmentsDao.addDptToEmployees(departments,employees2);
        Employees[] addDeptToEmployee = {employees,employees2};
        assertEquals(Arrays.asList(addDeptToEmployee),departmentsDao.getAllEmployeesBelongingToDepartment(departments.getId()));
    }
    @Test
    public void clearAll() {
        Departments departments = setupDepartments();
        departmentsDao.add(departments);
        departmentsDao.clearAll();
        assertEquals(0,departmentsDao.getAllDepartments().size());
    }
    public Departments setupDepartments(){
        return new Departments("Power Department", "Deals with power issues", 10);
    }

}