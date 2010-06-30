<%@taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <title>Salary Class</title>
        <link href="http://localhost:8084/employees/css/style.css" rel="stylesheet" type="text/css" media="screen" />
    </head>
    <f:view>
        <body>

            <div id="wrapper">
                <div id="header">
                    <div id="logo">
                        <h1><a href="#">Employees</a></h1>
                    </div>

                    <%@include file="../../header.jsp" %>
                </div>
                <div id="page">
                    <div id="page-bgtop">
                        <div id="page-bgbtm">
                            <div id="content">
                                <div class="post">
                                    <h2 class="title"><a href="#">Salary Class</a></h2>
                                    <p class="meta">
                                        <%@include file="../../currentDate.jsp" %>
                                        <%@include file="../../userRole.jsp" %>
                                    </p>
                                    <div style="clear: both;">&nbsp;</div>
                                    <div class="entry">

                                        <h:form id="salaryForm">
                                            <h:outputText value="Please insert a number"></h:outputText><br>
                                            <h:outputText value="New salary class"/>&nbsp;&nbsp;
                                            <h:inputText id="salaryClass" value="#{clasaSalariuBean.nrClasa}"  required="true" requiredMessage="Fill salary class texbox!"/>&nbsp;&nbsp

                                            <h:commandButton action="#{clasaSalariuController.insertClasaSalariu}" value="Insert"/>
                                            <h:message for="salaryClass" styleClass="messages"/>
                                        </h:form>

                                        <p class="links"><a href="http://localhost:8084/employees/about.jsp">About</a></p>
                                    </div>
                                </div>
                                <div style="clear: both;">&nbsp;</div>
                            </div>

                            <%@include file="../../menu.jsp" %>

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


