package models;

import java.util.Objects;

public class Users {

    private String user_name;
    private String user_details;
    private String user_department;
    private String user_position;

    public Users (String user_name,String user_details,String user_department,String user_position){
        this.user_department=user_department;
        this.user_details = user_details;
        this.user_position = user_position;
        this.user_name = user_name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Users users = (Users) o;
        return Objects.equals(user_name, users.user_name) &&
                Objects.equals(user_details, users.user_details) &&
                Objects.equals(user_department, users.user_department) &&
                Objects.equals(user_position, users.user_position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user_name, user_details, user_department, user_position);
    }
}
