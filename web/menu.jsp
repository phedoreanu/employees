<%@taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
            if (request.getUserPrincipal() != null) {
                String name = request.getUserPrincipal().getName();
            }
            boolean isAdmin = request.isUserInRole("administrator");
%>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="http://localhost:8084/employees/css/cssverticalmenu.css"/>
        <script type="text/javascript" src="http://localhost:8084/employees/javascript/cssverticalmenu.js"></script>
    </head>

    <body onload="createcssmenu();">
        <ul>
            <li><%= request.getRemoteUser() %></li>
            <li><a href="http://localhost:8084/employees/logout.jsf">logout</a></li>
        </ul>
        <ul id="verticalmenu" class="glossymenu">
            <li><a href="#">Employees</a>
                <ul>
                    <li><a href="http://localhost:8084/employees/admin/abilitate/abilitiesList.jsf">Abilities</a></li>
                    <li><a href="http://localhost:8084/employees/admin/previousWorkPlace/workPlaceList.jsf">Previous work places</a></li>
                    <li><a href="http://localhost:8084/employees/admin/position/positionList.jsf">Posititions</a></li>
                    <li><a href="http://localhost:8084/employees/admin/salaryClass/salaryClassList.jsf">Salary class</a></li>
                    <li><a href="http://localhost:8084/employees/admin/holidayClass/holidayClassList.jsf">Holiday class</a></li>
                    <li><a href="http://localhost:8084/employees/admin/employeeAccount/usersList.jsf">Create employee account</a></li>
                    <li><a href="">Employee management</a></li>
                </ul>
            </li>
            <li><a href="#">View Reports</a>
                
            </li>
            <li><a href="">View Diagrams</a></li>
            <li><a href="changePassword.jsf" >Change password</a></li>
            <%
                        if (isAdmin) {
            %>
            <li><a href="#" >Test admin</a></li>
            <%}%>
        </ul>
    </body>
</html>
