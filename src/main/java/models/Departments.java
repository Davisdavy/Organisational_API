package models;

import java.util.Objects;

public class Departments {
    private String dpt_name;
    private String dpt_description;
    private String dpt_empNo;
    private String dpt_id;


    //Constructor
    public Departments(String dpt_name,String dpt_description,String dpt_empNo){
        this.dpt_description=dpt_description;
        this.dpt_empNo = dpt_empNo;
        this.dpt_name = dpt_name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Departments that = (Departments) o;
        return Objects.equals(dpt_name, that.dpt_name) &&
                Objects.equals(dpt_description, that.dpt_description) &&
                Objects.equals(dpt_empNo, that.dpt_empNo) &&
                Objects.equals(dpt_id, that.dpt_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dpt_name, dpt_description, dpt_empNo, dpt_id);
    }
}
