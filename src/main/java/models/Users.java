package models;

import java.util.Objects;

public class Users {

    private String user_name;
    private String user_details;
    private String user_role;
    private String user_id;
    private String user_position;

    public Users(String user_name, String user_details, String user_role, String user_position) {
        this.user_name = user_name;
        this.user_details = user_details;
        this.user_role = user_role;
        this.user_position = user_position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Users users = (Users) o;
        return Objects.equals(user_name, users.user_name) &&
                Objects.equals(user_details, users.user_details) &&
                Objects.equals(user_role, users.user_role) &&
                Objects.equals(user_id, users.user_id) &&
                Objects.equals(user_position, users.user_position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user_name, user_details, user_role, user_id, user_position);
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public String getUser_details() {
        return user_details;
    }

    public String getUser_role() {
        return user_role;
    }

    public String getUser_position() {
        return user_position;
    }

    public void setUser_position(String user_position) {
        this.user_position = user_position;
    }

    public void setUser_role(String user_role) {
        this.user_role = user_role;
    }

    public void setUser_details(String user_details) {
        this.user_details = user_details;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

}
