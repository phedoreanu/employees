<%@taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <title></title>
        <link rel="stylesheet" type="text/css" href="../css/cssverticalmenu.css"/>
        <script type="text/javascript" src="../javascript/cssverticalmenu.js"></script>
    </head>

    <body onload="createcssmenu();">
        <ul id="verticalmenu" class="glossymenu">
            <li><a href="#">Employees</a>
                <ul>
                    <li><a href="abilitate/abilitiesList.jsf">Abilities</a></li>
                    <li><a href="previousWorkPlace/workPlaceList.jsf">Previous work places</a></li>
                    <li><a href="">Posititions</a></li>
                    <li><a href="">Salary class</a></li>
                    <li><a href="">Holiday class</a></li>
                    <li><a href="">Create employee account</a></li>
                    <li><a href="">Employee management</a></li>
                </ul>
            </li>
            <li><a href="#" >View Reports</a>
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
        </ul>
    </body>
</html>
