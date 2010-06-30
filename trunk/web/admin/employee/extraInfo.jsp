<%@taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@taglib uri="http://myfaces.apache.org/tomahawk" prefix="t" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <link rel="stylesheet" type="text/css" href="http://localhost:8084/employees/css/style.css"/>
        <title>Employee</title>
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
                                    <h2 class="title"><a href="#">Employee</a></h2>
                                    <p class="meta">

                                        <%@include file="../../currentDate.jsp" %>
                                        <%@include file="../../userRole.jsp" %>

                                    </p>
                                    <div style="clear: both;">&nbsp;</div>
                                    <div class="entry">

                                        <h:dataTable border="1" value="#{extraInfoBean.locuriAnterioare}" var="loc">
                                            <h:column id="column1">
                                                <f:facet name="header">
                                                    <h:outputText value="Name"></h:outputText>
                                                </f:facet>
                                                <h:outputText value="#{loc.numeLoc}"/>
                                            </h:column>
                                            <h:column id="column2">
                                                <f:facet name="header">
                                                    <h:outputText value="Address"></h:outputText>
                                                </f:facet>
                                                <h:outputText value="#{loc.dataAngajare}"/>
                                            </h:column>
                                            <h:column id="column3">
                                                <f:facet name="header">
                                                    <h:outputText value="CNP"></h:outputText>
                                                </f:facet>
                                                <h:outputText value="#{employee.dataPlecare}"/>
                                            </h:column>
                                        </h:dataTable>

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

        </body>
    </f:view>
</html>

