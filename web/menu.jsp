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
        <script type="">
            function openWindow(url, name, width, height, params)
            {
                var topWin = (screen.height - height)/2;
                var leftWin = (screen.width - width)/2;
                if(params && params.length != 0) params = ','+params;
                return window.open(url, name,'width='+width+',height='+height+',top='+topWin+',left='+leftWin+',resizable=yes'+params);
            }
        </script>
    </head>

    <body onload="createcssmenu();">
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
                <ul>
                    <li><a href="#" onclick="openWindow('http://localhost:8084/employees/admin/abilitate/ability_report.jsf?reportTitle=raportAbility&reportName=ability', 'ability_repport', '1000', '800', 'scrollbars=yes,menubar=yes,resizable=yes');">
                            Ability Report
                        </a>
                </ul>
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
