package br.com.tdv.prj_app.model;

import java.util.Calendar;

public class User {

    private int id;
    private String name;
    private String email;
    private String password;
    private Calendar dateResgistration;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Calendar getDateResgistration() {
        return dateResgistration;
    }

    public void setDateResgistration(Calendar dateResgistration) {
        this.dateResgistration = dateResgistration;
    }

    @Override
    public String toString() {
        return "ID: " + id + 
               ", Name: " + name + 
               ", Email: " + email + 
               ", Password: " + password +
               ", Date: " + dateResgistration.getTime();
    }
    
}
