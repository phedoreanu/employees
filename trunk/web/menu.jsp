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
                    <li><a href="">Posititions</a></li>
                    <li><a href="">Salary class</a></li>
                    <li><a href="">Holiday class</a></li>
                    <li><a href="">Create employee account</a></li>
                    <li><a href="">Employee management</a></li>
                </ul>
            </li>
            <li><a href="#">View Reports</a>
                <ul>
                    <li><a href="http://www.dynamicdrive.com">Dynamic HTML</a></li>
                    <li><a href="http://www.codingforums.com">Coding Forums</a></li>
                    <li><a href="http://www.cssdrive.com">CSS Drive</a></li>
                    <li><a href="http://www.dynamicdrive.com/style/">CSS Library</a></li>
                    <li><a href="http://tools.dynamicdrive.com/imageoptimizer/">Image Optimizer</a></li>
                    <li><a href="http://tools.dynamicdrive.com/favicon/">Favicon Generator</a></li>
                </ul>
            </li>
            <li><a href="">View Diagrams</a></li>
            <li><a href="changePassword.jsf" >Change password</a></li>
            <%
                        if (isAdmin) {
            %>
            <li><a href="#" >Test admmin</a></li>
            <%}%>
        </ul>
    </body>
</html>
