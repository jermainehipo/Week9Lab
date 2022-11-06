/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.*;
import services.*;

/**
 *
 * @author jerma
 */
public class UserServlet extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        UserService us = new UserService();
        RoleService rs = new RoleService();
        
        String action = request.getParameter("action");
        request.setAttribute("action", action);
        
        if (action != null) {
            if (action.equals("edit")) {
                String email = request.getParameter("email");
                String firstName = request.getParameter("firstName");
                String lastName = request.getParameter("lastName");
                String roleName = request.getParameter("role");

                request.setAttribute("email", email);
                request.setAttribute("firstName", firstName);
                request.setAttribute("lastName", lastName);
                request.setAttribute("roleName", roleName);
            }
        }
        
        if (action != null) {
            if (action.equals("delete")) {
                String email = request.getParameter("email");
                System.out.println("");
                try {
                    us.delete(email);
                } catch (Exception e){
                    System.out.println(e);
                }
            }
        }
        
        try {
            
            List<User> users = us.getAll();
            List<Role> roles = rs.getAll();
            
            request.setAttribute("users", users);
            request.setAttribute("roles", roles);
        } catch (Exception e) {
            System.out.println(e);
        }
        
        getServletContext().getRequestDispatcher("/WEB-INF/users.jsp").forward(request, response);
        
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        UserService us = new UserService();
        RoleService rs = new RoleService();
        
        String email = request.getParameter("email");
        String firstName = request.getParameter("firstname");
        String lastName = request.getParameter("lastname");
        String password = request.getParameter("password");
        int roleId = Integer.parseInt(request.getParameter("roleid"));
        
        String action = request.getParameter("action");
        try {
            switch (action) {
                case "insert": 
                    us.insert(email, firstName, lastName, password, rs.get(roleId));
                    break;
                case "update":
                     us.update(email, firstName, lastName, password, rs.get(roleId));
                    break;
                default: break;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        
        try {
            
            List<User> users = us.getAll();
            List<Role> roles = rs.getAll();
            
            request.setAttribute("users", users);
            request.setAttribute("roles", roles);
        } catch (Exception e) {
            System.out.println(e);
        }
        
        getServletContext().getRequestDispatcher("/WEB-INF/users.jsp").forward(request, response);
    }


}
