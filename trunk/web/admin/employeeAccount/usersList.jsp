<%@taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <title>Users</title>
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
                                    <h2 class="title"><a href="#">Users</a></h2>
                                    <p class="meta">
                                        <%@include file="../../currentDate.jsp" %>
                                        <%@include file="../../userRole.jsp" %>
                                    </p>
                                    <div style="clear: both;">&nbsp;</div>
                                    <div class="entry">

                                        <h:form>
                                            <h:dataTable border="1" value="#{userBean.users}" var="user">
                                                <h:column id="column1">
                                                    <f:facet name="header">
                                                        <h:outputText value="User id"></h:outputText>
                                                    </f:facet>
                                                    <h:outputText value="#{user.id}"></h:outputText>
                                                </h:column>
                                                <h:column id="column2">
                                                    <f:facet name="header">
                                                        <h:outputText value="Username"></h:outputText>
                                                    </f:facet>
                                                    <h:outputText value="#{user.username}"/>
                                                </h:column>
                                                <h:column id="column3">
                                                    <f:facet name="header">
                                                        <h:outputText value="Password"></h:outputText>
                                                    </f:facet>
                                                    <h:outputText value="#{user.password}"/>
                                                </h:column>
                                                <h:column id="column4">
                                                    <f:facet name="header">
                                                        <h:outputText value="Operations"></h:outputText>
                                                    </f:facet>
                                                    <h:outputLink value="accountRecord.jsf?id=#{user.id}">
                                                        <h:outputText value="Delete/Update"/>
                                                    </h:outputLink>
                                                </h:column>
                                                <f:facet name="footer">
                                                    <h:outputLink value="createAccount.jsf">
                                                        <h:outputText value="Create new account"/>
                                                    </h:outputLink>
                                                </f:facet>
                                            </h:dataTable>
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






