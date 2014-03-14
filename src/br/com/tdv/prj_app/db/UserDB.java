package br.com.tdv.prj_app.db;

import br.com.tdv.prj_app.model.User;
import java.util.List;

public interface UserDB {
    
    public void insert(User user);
    public void update(User user);
    public void delete(User user);
    public User getUser(int id);
    public List<User> getAllUsers();
    
}
