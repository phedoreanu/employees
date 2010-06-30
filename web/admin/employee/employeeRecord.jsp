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

                                        <h:form id="employeeForm">
                                            <t:saveState value="#{employeeBean}"/>
                                            <table>
                                                <tr>
                                                    <td>
                                                        <h:outputText value="Name"/>&nbsp;&nbsp;
                                                    </td>
                                                    <td>
                                                        <h:inputText id="name" value="#{employeeBean.name}" required="true" requiredMessage="Fill name textbox!"/>
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td>
                                                        <h:outputText value="Address"/>
                                                    </td>
                                                    <td>
                                                        <h:inputText id="address" value="#{employeeBean.adresa}" required="true" requiredMessage="Fill address textbox!"/>
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td>
                                                        <h:outputText value="CNP"/>
                                                    </td>
                                                    <td>
                                                        <h:inputText id="cnp" value="#{employeeBean.cnp}" required="true" requiredMessage="Fill CNP textbox!">
                                                            <f:validateLength maximum="13" minimum="13"/>
                                                        </h:inputText>
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td>
                                                        <h:outputText value="Position"/>
                                                    </td>
                                                    <td>
                                                        <t:selectOneListbox id="positionId" size="1" value="#{employeeBean.positionId}">
                                                            <t:selectItems value="#{employeeBean.positions}" var="p" itemLabel="#{p.label}" itemValue="#{p.value}"/>
                                                        </t:selectOneListbox>
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td>
                                                        <h:outputText value="Username"/>
                                                    </td>
                                                    <td>
                                                        <t:selectOneListbox id="userId" size="1" value="#{employeeBean.userId}">
                                                            <t:selectItems value="#{employeeBean.users}" var="u" itemLabel="#{u.label}" itemValue="#{u.value}"/>
                                                        </t:selectOneListbox>
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td>
                                                        <h:outputText value="Holiday Class"/>
                                                    </td>
                                                    <td>
                                                        <t:selectOneListbox id="holidayId" size="1" value="#{employeeBean.clasaConcediuId}">
                                                            <t:selectItems value="#{employeeBean.holidayClass}" var="cc" itemLabel="#{cc.label}" itemValue="#{cc.value}"/>
                                                        </t:selectOneListbox>
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td>
                                                        <h:outputText value="Salary Class"/>
                                                    </td>
                                                    <td>
                                                        <t:selectOneListbox id="salaryId" size="1" value="#{employeeBean.clasaSalariuId}">
                                                            <t:selectItems value="#{employeeBean.salaryClass}" var="cs" itemLabel="#{cs.label}" itemValue="#{cs.value}"/>
                                                        </t:selectOneListbox>
                                                    </td>
                                                </tr>
                                            </table>

                                            <h:commandButton action="#{employeeController.updateEmployee}" value="Update"/>
                                            <h:messages styleClass="messages"/>
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

        </body>
    </f:view>
</html>

