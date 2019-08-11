package models;

import java.util.Objects;

public class Employees {

    private String emp_name;
    private String emp_details;
    private String emp_role;
    private int id;
    private String emp_position;

    public Employees(String emp_name, String emp_details, String emp_role, String emp_position) {
        this.emp_name = emp_name;
        this.emp_details = emp_details;
        this.emp_role = emp_role;
        this.emp_position = emp_position;
    }

    public String getEmp_name() {
        return emp_name;
    }

    public void setEmp_name(String emp_name) {
        this.emp_name = emp_name;
    }

    public String getEmp_details() {
        return emp_details;
    }

    public void setEmp_details(String emp_details) {
        this.emp_details = emp_details;
    }

    public String getEmp_role() {
        return emp_role;
    }

    public void setEmp_role(String emp_role) {
        this.emp_role = emp_role;
    }

    public int getEmp_id() {
        return id;
    }

    public void setEmp_id(int emp_id) {
        this.id = emp_id;
    }

    public String getEmp_position() {
        return emp_position;
    }

    public void setEmp_position(String emp_position) {
        this.emp_position = emp_position;
    }
}
