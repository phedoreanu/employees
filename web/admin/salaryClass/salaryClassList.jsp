<%@taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@taglib uri="http://myfaces.apache.org/tomahawk" prefix="t" %>

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

                                        <h:form>
                                            <t:saveState value="#{clasaSalariuBean}"/>

                                            <h:dataTable border="1" value="#{clasaSalariuBean.clsSalariuList}" var="salaryClass">
                                                <h:column id="column1">
                                                    <f:facet name="header">
                                                        <h:outputText value="Salary class id"></h:outputText>
                                                    </f:facet>
                                                    <h:outputText value="#{salaryClass.id}"></h:outputText>
                                                </h:column>
                                                <h:column id="column2">
                                                    <f:facet name="header">
                                                        <h:outputText value="Salary class number"></h:outputText>
                                                    </f:facet>
                                                    <h:outputText value="#{salaryClass.nrClasa}"/>
                                                </h:column>
                                                <h:column id="column3">
                                                    <f:facet name="header">
                                                        <h:outputText value="Delete operation"></h:outputText>
                                                    </f:facet>
                                                    <h:commandLink action="#{clasaSalariuController.deleteClasaSalariu}">
                                                        <h:outputText value="Delete"></h:outputText>
                                                        <f:param name="idCls" id="idCls" value="#{salaryClass.id}"></f:param>
                                                    </h:commandLink>
                                                </h:column>
                                                <f:facet name="footer">
                                                    <h:outputLink value="insertSalaryClass.jsf">
                                                        <h:outputText value="Insert new Salary Class"/>
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

