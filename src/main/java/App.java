import com.google.gson.Gson;
import dao.Sql2oNewsDao;
import dao.Sql2oEmployeesDao;
import dao.Sql2oDepartmentsDao;
import models.Departments;
import exceptions.ApiException;
import models.Employees;
import models.News;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import static spark.Spark.*;

public class App {

    public static void main(String[] args) {
        Sql2oDepartmentsDao departmentsDao;
        Sql2oNewsDao newsDao;
        Sql2oEmployeesDao employeesDao;
        Connection conn;
        Gson gson = new Gson();

        String connectionString = "jdbc:h2:~/jadle.db;INIT=RUNSCRIPT from 'classpath:db/create.sql'";
        Sql2o sql2o = new Sql2o(connectionString, "", "");

        departmentsDao = new Sql2oDepartmentsDao(sql2o);
        employeesDao = new Sql2oEmployeesDao(sql2o);
        newsDao = new Sql2oNewsDao(sql2o);
        conn = sql2o.open();

        //create

        post("/departments/new", "application/json", (req, res) -> {
            Departments departments = gson.fromJson(req.body(), Departments.class);
            departmentsDao.add(departments);
            res.status(201);
            res.type("application/json");
            return gson.toJson(departments);
        });

        //read all

        get("/departments", "application/json", (req, res) -> { //accept a request in format JSON from an app
            res.type("application/json");
            return gson.toJson(departmentsDao.getAllDepartments());//send it back to be displayed
        });
        get("/departments/:id", "application/json", (req, res) -> { //accept a request in format JSON from an app
            res.type("application/json");
            int dpt_id = Integer.parseInt(req.params("id"));
            res.type("application/json");
            return gson.toJson(departmentsDao.findById(dpt_id));
        });

        //news : dpt

        //Add news 2 department
        post("/departments/:id/news/new","application/json",(request, response) -> {
            int id = Integer.parseInt(request.params("id"));
            News news = gson.fromJson(request.body(),News.class);
            news.setNews_id(id);
            newsDao.add(news);
            response.type("application/json");
            response.status(201);
            return gson.toJson(news);
        });
        //access news for a certain department
        get("/departments/:id/dptNews", "application/json", (request, response) -> {
            int id = Integer.parseInt(request.params("id"));
            return gson.toJson(newsDao.getAllNews());
        });


        //Add an employee
        post("/employees/new", "application/json", (request, response) -> {
            Employees employees = gson.fromJson(request.body(), Employees.class);
            employeesDao.add(employees);
            response.type("application/json");
            response.status(201);
            return gson.toJson(employees);
        });
        //Assign a department to an employee
        post("employees/emp_id/departments/:dpt_id","application/json",(request, response) -> {
            int emp_id = Integer.parseInt(request.params("emp_id"));
            int dpt_id = Integer.parseInt(request.params("dpt_id"));
            Employees empFound = employeesDao.findById(emp_id);
            Departments dptFound = departmentsDao.findById(dpt_id);

            if (dptFound != null && empFound!= null){
                departmentsDao.addDptToEmployees(dptFound,empFound);
                response.type("application/json");
                response.status(201);
                return gson.toJson("Employees and Department successfully created");
            }
            else {
                throw new ApiException(404, String.format("Employee or Department not found"));
            }
        });


        get("/employees/:emp_id/departments","application/json",(request, response) -> {
            int emp_id = Integer.parseInt(request.params("emp_id"));
            Employees employees = employeesDao.findById(emp_id);

            if (employees == null){
                throw new Exception("Employee with that id does not exist");
            }else if(employeesDao.getAllDptBelongingToEmployees(emp_id).size() == 0){
                return "{\"message\":\"Employee not associated with any department\"}";
            }else {
                return gson.toJson(employeesDao.getAllDptBelongingToEmployees(emp_id));
            }
        });

        //access all employees
        get("/employees", "application/json", (request, response) -> {
            return gson.toJson(employeesDao.getAllEmployees());
        });

        //Read all news
        get("/news","application/json",(request, response) -> {
            int dpt_id = Integer.parseInt(request.params("dpt_id"));
            return gson.toJson(newsDao.getAllNews());
        });

        //Add news
        post("/news/new","application/json",(request, response) -> {
            News news = gson.fromJson(request.body(),News.class);
            newsDao.add(news);
            response.type("application/json");
            response.status(201);
            return gson.toJson(news);
        });

        //FILTERS
        after((req, res) ->{
            res.type("application/json");
        });

    }
}
