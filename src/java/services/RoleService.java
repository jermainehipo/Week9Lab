/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import dataaccess.RoleDB;
import java.util.List;
import models.Role;

/**
 *
 * @author jerma
 */
public class RoleService {
    
    public List<Role> getAll() throws Exception {
        RoleDB roleDB = new RoleDB();
        return roleDB.getAll();
    }
    
    public Role get(int roleId) throws Exception{
        RoleDB roleDB = new RoleDB();
        return roleDB.get(roleId);
    }
    
    /*public void update(Role role) {
        RoleDB roleDB = new RoleDB();
        roleDB.update(role);
    }*/
}
