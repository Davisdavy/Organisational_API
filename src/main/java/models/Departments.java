package models;

import java.util.Objects;

public class Departments {
    private String dpt_name;
    private String dpt_description;
    private String dpt_empNo;
    private String dpt_id;


    //Constructor


    public String getDpt_name() {
        return dpt_name;
    }

    public void setDpt_name(String dpt_name) {
        this.dpt_name = dpt_name;
    }

    public String getDpt_description() {
        return dpt_description;
    }

    public void setDpt_description(String dpt_description) {
        this.dpt_description = dpt_description;
    }

    public String getDpt_empNo() {
        return dpt_empNo;
    }

    public void setDpt_empNo(String dpt_empNo) {
        this.dpt_empNo = dpt_empNo;
    }

    //Override


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
