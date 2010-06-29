<%@taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <link rel="stylesheet" type="text/css" href="http://localhost:8084/employees/css/style.css"/>
    </head>
    <body>
        <% boolean whichUser = request.isUserInRole("administrator");
                    if (whichUser) {
        %>
        <span class="posted">Logged on as <a href="#">  Administrator </a></span>
        <%} else {
                                whichUser = request.isUserInRole("employee");
                                if (whichUser) {
        %>
        <span class="posted">Logged on as <a href="#">  Employee </a> </span>
        <% } else {%>
        %>
        <span class="posted">Logged on as <a href="#">  Manager </a> </span>
        <% }
                    }%>
    </body>
</html>

