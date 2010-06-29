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

                                        <h:form>
                                            <h:outputText value="Name"/>&nbsp;&nbsp;
                                            <h:inputText id="name" value="#{employeeBean.name}" required="true" requiredMessage="Fill name textbox!"/>&nbsp;&nbsp
                                            <br>

                                            <h:outputText value="Address"/>&nbsp;&nbsp;
                                            <h:inputText id="address" value="#{employeeBean.adresa}" required="true" requiredMessage="Fill address textbox!"/>&nbsp;&nbsp
                                            <br>

                                            <h:outputText value="CNP"/>&nbsp;&nbsp;
                                            <h:inputText id="cnp" value="#{employeeBean.cnp}" required="true" requiredMessage="Fill CNP textbox!">
                                                <f:validateLength maximum="13" minimum="13"/>
                                            </h:inputText> &nbsp;&nbsp
                                            <br>

                                            <h:outputText value="Position"/>&nbsp;&nbsp;
                                            <t:selectOneListbox id="positionId" size="1" value="#{employeeBean.positionId}">
                                                <t:selectItems value="#{employeeBean.positions}" var="p" itemLabel="#{p.label}" itemValue="#{p.value}"/>
                                            </t:selectOneListbox>
                                            <br>

                                            <%--<h:outputText value="Username"/>&nbsp;&nbsp;
                                            <t:selectOneListbox id="userId" size="1" value="#{userBean.username}">
                                                <t:selectItems value="#{userBean.users}" var="u" itemLabel="#{u.label}" itemValue="#{u.label}"/>
                                            </t:selectOneListbox>--%>
                                            <br>
                                            <%--
                                            <h:outputText value="Salary Class"/>&nbsp;&nbsp;
                                            <t:selectOneListbox id="salaryId" size="1" value="#{}">
                                                <t:selectItems value="#{}" var="u" itemLabel="#{u.label}" itemValue="#{u.label}"/>
                                            </t:selectOneListbox>
                                            <br>

                                            <h:outputText value="Holiday Class"/>&nbsp;&nbsp;
                                            <t:selectOneListbox id="holidayId" size="1" value="#{}">
                                                <t:selectItems value="#{}" var="u" itemLabel="#{u.label}" itemValue="#{u.label}"/>
                                            </t:selectOneListbox>
                                            <br>
                                            --%>


                                            <h:commandButton action="#{employeeController.insertEmployee}" value="Insert"/>
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

