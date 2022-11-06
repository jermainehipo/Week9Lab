/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import dataaccess.UserDB;
import java.util.List;
import models.Role;
import models.User;

/**
 *
 * @author jerma
 */
public class UserService {
     
    public List<User> getAll() throws Exception {
        UserDB userDB = new UserDB();
        List<User> users = userDB.getAll();
        return users;
    }
    
    public User get(String email) throws Exception {
        UserDB userDB = new UserDB();
        return userDB.get(email);
    }
    
    public void update(String email, String firstName, String lastName, String password, Role role) throws Exception {
        UserDB userDB = new UserDB();
        User user = new User(email, firstName, lastName, password, role);
        userDB.update(user);
    }
    
    public void insert(String email, String firstName, String lastName, String password, Role role) throws Exception {
        UserDB userDB = new UserDB();
        User user = new User(email, firstName, lastName, password, role);
        userDB.insert(user);
    }
    
    public void delete(String email) throws Exception {
        UserDB userDB = new UserDB();
        User user = new User();
        user.setEmail(email);
        userDB.delete(user);
    }

}
