
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <title>Employee</title>
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
                                    <h2 class="title"><a href="#">Employee</a></h2>
                                    <p class="meta">
                                        <%@include file="../../currentDate.jsp" %>
                                        <%@include file="../../userRole.jsp" %>
                                    </p>
                                    <div style="clear: both;">&nbsp;</div>
                                    <div class="entry">
                                        <h:form>
                                            <h:dataTable border="1" value="#{employeeBean.employeesList}" var="employee">
                                                <h:column id="column1">
                                                    <f:facet name="header">
                                                        <h:outputText value="Name"></h:outputText>
                                                    </f:facet>
                                                    <h:outputText value="#{employee.name}"></h:outputText>
                                                </h:column>
                                                <h:column id="column2">
                                                    <f:facet name="header">
                                                        <h:outputText value="Address"></h:outputText>
                                                    </f:facet>
                                                    <h:outputText value="#{employee.adresa}"/>
                                                </h:column>
                                                <h:column id="column3">
                                                    <f:facet name="header">
                                                        <h:outputText value="CNP"></h:outputText>
                                                    </f:facet>
                                                    <h:outputText value="#{employee.cnp}"/>
                                                </h:column>
                                                <h:column id="column4">
                                                    <f:facet name="header">
                                                        <h:outputText value="Position"></h:outputText>
                                                    </f:facet>
                                                    <h:outputText value="#{employee.positionName}"/>
                                                </h:column>
                                                <h:column id="column5">
                                                    <f:facet name="header">
                                                        <h:outputText value="Username"></h:outputText>
                                                    </f:facet>
                                                    <h:outputText value="#{employee.userId}"/>
                                                </h:column>
                                                <h:column id="column6">
                                                    <f:facet name="header">
                                                        <h:outputText value="Salary Class"></h:outputText>
                                                    </f:facet>
                                                    <h:outputText value="#{employee.clasaSalariuId}"/>
                                                </h:column>
                                                <h:column id="column7">
                                                    <f:facet name="header">
                                                        <h:outputText value="Holiday Class"></h:outputText>
                                                    </f:facet>
                                                    <h:outputText value="#{employee.clasaConcediuId}"/>
                                                </h:column>
                                                <h:column id="column8">
                                                    <f:facet name="header">
                                                        <h:outputText value="Delete/Update"></h:outputText>
                                                    </f:facet>
                                                    <h:outputLink value="employeeRecord.jsf?id=#{employee.angajatId}">
                                                        <h:outputText value="Delete/Update"/>
                                                    </h:outputLink>
                                                </h:column>
                                                <h:column id="column9">
                                                    <f:facet name="header">
                                                        <h:outputText value="Extra information"></h:outputText>
                                                    </f:facet>
                                                    <h:outputLink value="extraInfo.jsf?id=#{employee.angajatId}">
                                                        <h:outputText value="Add extra information"/>
                                                    </h:outputLink>
                                                </h:column>
                                                <f:facet name="footer">
                                                    <h:outputLink value="insertEmployee.jsf">
                                                        <h:outputText value="Insert new Employee"/>
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
