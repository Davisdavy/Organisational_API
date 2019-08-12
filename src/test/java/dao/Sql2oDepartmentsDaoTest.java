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
    private  static Sql2oDepartmentsDao departmentsDao;
    private static Sql2oEmployeesDao employeesDao;
    private static Sql2oNewsDao newsDao;

    @BeforeClass
    public static void setUp() throws Exception {
        String connectionString = "jdbc:postgresql://localhost:5432/org_test";
        Sql2o sql2o = new Sql2o(connectionString, "davis", "vegas2017");
        employeesDao = new Sql2oEmployeesDao(sql2o);
        departmentsDao = new Sql2oDepartmentsDao(sql2o);

        conn = sql2o.open();
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("clearing database");
        employeesDao.clearAll();
        departmentsDao.clearAll();
        newsDao.clearAll();
    }

    @AfterClass //changed to @AfterClass (run once after all tests in this file completed)
    public static void shutDown() throws Exception{ //changed to static
        conn.close(); // close connection once after this entire test file is finished
        System.out.println("connection closed");
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

    @Test
    public void addDepartment() {
        Departments departments = setupDepartments();
        departmentsDao.add(departments);
        int departId = departments.getId();
        assertEquals(departId,departments.getId());
    }

    @Test
    public void deletingDepartmentsAlsoUpdatesJoinTable() throws Exception {
        Employees testEmployees = setupEmployees();
        employeesDao.add(testEmployees);

        Departments testDepartments = setupDepartments();
        departmentsDao.add(testDepartments);

        Departments testDepartments2 = setupDepartments2();
        departmentsDao.add(testDepartments2);

        departmentsDao.addDptToEmployees(testDepartments,testEmployees);
        departmentsDao.addDptToEmployees(testDepartments2,testEmployees);

        departmentsDao.deleteById(testDepartments.getId());
        assertEquals(0, departmentsDao.getAllEmployeesBelongingToDepartment(testDepartments.getId()).size());
    }

    @Test
    public void  addDptToEmployees() {
        Employees employees = new Employees("Margaret", "Senior Chef", "Cooks","North Dakota");
        employeesDao.add(employees);
        Employees employees2 = new Employees("Margaret", "Senior Chef", "Cooks","North Dakota");
        employeesDao.add(employees2);

        Departments departments = setupDepartments();
        departmentsDao.add(departments);
        departmentsDao.addDptToEmployees(departments,employees);
        departmentsDao.addDptToEmployees(departments,employees2);
        Employees[] addDptToEmployee = {employees,employees2};
        assertEquals(Arrays.asList(addDptToEmployee),departmentsDao.getAllEmployeesBelongingToDepartment(departments.getId()));
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
    public Employees setupEmployees(){
        return new Employees("Davis", "Badge 1234", "Directs","MD");
    }
    public Departments setupDepartments2(){ return new Departments("accounts", "Check balances", 20);}

}