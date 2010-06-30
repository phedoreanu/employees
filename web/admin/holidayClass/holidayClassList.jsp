<%@taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@taglib uri="http://myfaces.apache.org/tomahawk" prefix="t" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <title>Holiday Class</title>
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
                                    <h2 class="title"><a href="#">Holiday Class</a></h2>
                                    <p class="meta">
                                        <%@include file="../../currentDate.jsp" %>
                                        <%@include file="../../userRole.jsp" %>
                                    </p>
                                    <div style="clear: both;">&nbsp;</div>
                                    <div class="entry">

                                        <h:form>
                                            <t:saveState value="#{clasaConcediuBean}"/>
                                            <h:dataTable border="1" value="#{clasaConcediuBean.clasaConcediuList}" var="holidayClass">
                                                <h:column id="column1">
                                                    <f:facet name="header">
                                                        <h:outputText value="Holiday Class id"></h:outputText>
                                                    </f:facet>
                                                    <h:outputText value="#{holidayClass.id}"></h:outputText>
                                                </h:column>
                                                <h:column id="column2">
                                                    <f:facet name="header">
                                                        <h:outputText value="Holiday class number"></h:outputText>
                                                    </f:facet>
                                                    <h:outputText value="#{holidayClass.nrClasa}"/>
                                                </h:column>
                                                <h:column id="column3">
                                                    <f:facet name="header">
                                                        <h:outputText value="Delete operation"></h:outputText>
                                                    </f:facet>
                                                    <h:commandLink action="#{clasaConcediuController.deleteClasaConcediu}">
                                                        <h:outputText value="Delete"></h:outputText>
                                                        <f:param name="idCls" value="#{holidayClass.id}"></f:param>
                                                    </h:commandLink>
                                                </h:column>
                                                <f:facet name="footer">
                                                    <h:outputLink value="insertHolidayClass.jsf">
                                                        <h:outputText value="Insert new Holiday Class"/>
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



