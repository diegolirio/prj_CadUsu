package br.com.tdv.prj_app.dao;

import br.com.tdv.prj_app.db.UserDB;
import br.com.tdv.prj_app.model.User;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class UserDao implements UserDB {

    private Connection conn;
    
    public UserDao(Connection conn) {
        this.conn = conn;
    }
    
    public void insert(User user) {
        int result = -1;
        Statement stmt = null;
        String sql = "Insert into USERS_USERS (name, email, password) " +
                     "values ('" + user.getName() + "','" + user.getEmail() + "', '" + user.getPassword() + "')";
        try {
            stmt = this.conn.createStatement();
            result = stmt.executeUpdate(sql);
            System.out.println(user.getEmail() + " gravado com sucesso!!! = ");
        } catch (SQLException ex) {
            System.out.println(sql);
            throw new  RuntimeException(ex.getMessage());
        }
    }

    public void update(User user) {
        int result = -1;
        Statement stmt = null;
        String sql = "Update USERS_USERS set name = '" + user.getName() + "', email = '" + user.getEmail() + "' where id = " + user.getId();
        try {
            stmt = this.conn.createStatement();
            result = stmt.executeUpdate(sql);
            System.out.println(user.getEmail() + " alterado com sucesso!!! = ");
        } catch (SQLException ex) {
            System.out.println(sql);
            throw new  RuntimeException(ex.getMessage());
        }
    }

    public User getUser(int id) {
        User user = null;
        Statement stmt = null;
        ResultSet rs = null;
        String sql = "Select * from users_users where id = " + id;
        try {
            stmt = this.conn.createStatement();
            rs = stmt.executeQuery(sql);
            if(rs.next()) {
                user = new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setEmail(rs.getString("email"));
                user.setDateResgistration(Calendar.getInstance());
            }
        } catch (SQLException ex) {
            System.out.println(sql);
            throw new  RuntimeException(ex.getMessage());
        }  
        return user;
    }

    public List<User> getAllUsers() {
        List<User> list = null;
        Statement stmt = null;
        ResultSet rs = null;
        String sql = "Select * from users_users";
        try {
            stmt = this.conn.createStatement();
            rs = stmt.executeQuery(sql);
            list = new ArrayList<User>();
            while(rs.next()) {
                User u = new User();
                u.setId(rs.getInt("id"));
                u.setName(rs.getString("name"));
                u.setEmail(rs.getString("email"));
                u.setDateResgistration(Calendar.getInstance());
                boolean add = list.add(u);
            }
        } catch (SQLException ex) {
            System.out.println(sql);
            throw new RuntimeException(ex.getMessage());
        }  
        return list;
    }

    public void delete(User user) {
        int result = -1;
        Statement stmt = null;
        String sql = "delete from USERS_USERS where id = " + user.getId();
        try {
            stmt = this.conn.createStatement();
            result = stmt.executeUpdate(sql);
            System.out.println(user.getEmail() + " Excluido com sucesso!!! = ");
        } catch (SQLException ex) {
            System.out.println(sql);
            throw new  RuntimeException(ex.getMessage());
        }
    }
    
    
    
}
