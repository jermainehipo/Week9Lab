<%-- 
    Document   : users
    Created on : 27-Oct-2022, 11:17:15 PM
    Author     : jerma
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Users</title>
    </head>
    <body>
        <h1>Manager Users</h1>
        <table>
            <tr>
                <th>Email</th>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Role</th>
                <th></th>
                <th></th>
            </tr>
            <c:forEach items="${users}" var="user">
                <tr>
                    <td>${user.email}</td>
                    <td>${user.firstName}</td>
                    <td>${user.lastName}</td>
                    <td>${user.role}</td>
                    <td><a href="users?action=edit&amp;${user}">Edit</a></td>
                    <td><a href="users?action=delete&amp;email=${user.email}">Delete</a></td>
                </tr>
            </c:forEach>
        </table>
        <c:if test="${(action eq null) || (action ne 'edit')}">
            <h2>Add User</h2>
            <form method="post" action="users">
                Email: <input type="users" name="email"><br>
                First name: <input type="text" name="firstname"><br>
                Last name: <input type="text" name="lastname"><br>
                Password: <input type="password" name="password"><br>
                Role: <select name="roleid">
                    <c:forEach items="${roles}" var="role">
                        <option value="${role.roleId}">${role.roleName}</option>
                    </c:forEach>
                </select><br>
                <input type="hidden" name="action" value="insert">
                <input type="submit" value="Add user">
            </form>
        </c:if>
        <c:if test="${(action eq 'edit')}">
            <h2>Edit User</h2>
            <form method="post" action="users">
                <input type="hidden" name="email" value="${email}">
                Email: ${email}<br>
                First name: <input type="text" name="firstname" value="${firstName}"><br>
                Last name: <input type="text" name="lastname" value="${lastName}"><br>
                Password: <input type="password" name="password"><br>
                Role: <select name="roleid">
                    <c:forEach items="${roles}" var="role">
                        <option value="${role.roleId}"
                        <c:if test="${role.roleName eq roleName}">
                            selected
                        </c:if>
                            >${role.roleName}
                        </option>
                    </c:forEach>
                </select><br>
                <input type="hidden" name="action" value="update">
                <input type="submit" value="Update">
                <input type="hidden" name="action" value="cancel">
                <input type="submit" value="Cancel" onclick=" ">
            </form>
        </c:if>
    </body>
</html>
