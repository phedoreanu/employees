<%@taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@taglib uri="http://myfaces.apache.org/tomahawk" prefix="t" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<%
            if (request.getUserPrincipal() != null) {
                String name = request.getUserPrincipal().getName();
            }
%>

<html>
    <head>
        <title>Admin</title>
        <link href="http://localhost:8084/employees/css/style.css" rel="stylesheet" type="text/css" media="screen" />
    </head>
    <f:view>
        <body>

            <div id="wrapper">
                <div id="header">
                    <div id="logo">
                        <h1><a href="#">Employees</a></h1>
                    </div>

                    <%@include file="../header.jsp" %>
                </div>
                <div id="page">
                    <div id="page-bgtop">
                        <div id="page-bgbtm">
                            <div id="content">
                                <div class="post">
                                    <h2 class="title"><a href="#">Administrator Account</a></h2>
                                    <p class="meta">
                                        <%@include file="../currentDate.jsp" %>
                                        <%@include file="../userRole.jsp" %>
                                    </p>
                                    <div style="clear: both;">&nbsp;</div>
                                    <div class="entry">

                                        <h1>Change the password of your acount!</h1>
                                        <h:outputText value="New password"></h:outputText>&nbsp
                                        <h:inputSecret value="#{userBean.password}"/>
                                        <h:commandButton value="Change password" action="#{userController.updateAdminPassw}">
                                            <f:param name="userName" value=""></f:param>
                                        </h:commandButton>

                                        <p class="links"><a href="http://localhost:8084/employees/about.jsp">About</a></p>
                                    </div>
                                </div>
                                <div style="clear: both;">&nbsp;</div>
                            </div>

                            <%@include file="../menu.jsp" %>

                            <div style="clear: both;">&nbsp;</div>
                        </div>
                    </div>
                </div>
            </div>
            <div id="footer">
                <p>Copyright &copy;  2010  All rights reserved.</p>
            </div>

        </f:view>
    </body>
</html>


