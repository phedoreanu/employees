<%@taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@taglib uri="http://myfaces.apache.org/tomahawk" prefix="t" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <title>Account</title>
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
                                    <h2 class="title"><a href="#">User Account</a></h2>
                                    <p class="meta">
                                        <%@include file="../../currentDate.jsp" %>
                                        <%@include file="../../userRole.jsp" %>
                                    </p>
                                    <div style="clear: both;">&nbsp;</div>
                                    <div class="entry">

                                        <h:form id="newUserForm">
                                            <table>
                                                <tr>
                                                    <td>
                                                        <h:outputText value="New username"/>&nbsp;&nbsp;
                                                    </td>
                                                    <td>
                                                        <h:inputText id="username" value="#{userBean.username}" required="true" requiredMessage="Fill username textbox!" />&nbsp;&nbsp
                                                        <h:message for="username" styleClass="messages"/>
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td>
                                                        <h:outputText value="New password"/>&nbsp;&nbsp;
                                                    </td>
                                                    <td>
                                                        <h:inputSecret id="password" value="#{userBean.password}" required="true" requiredMessage="Fill password textbox!">
                                                            <f:validateLength  minimum="5"/>
                                                        </h:inputSecret> &nbsp;&nbsp
                                                        <h:message for="password" styleClass="messages"/>
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td>
                                                        <h:outputText value="Roles:"/>&nbsp;&nbsp;
                                                    </td>
                                                    <td>
                                                        <t:selectOneListbox id="roleId" size="1" value="#{userBean.userRole}">
                                                            <t:selectItems value="#{userBean.roles}" var="role" itemLabel="#{role.label}" itemValue="#{role.label}"/>
                                                        </t:selectOneListbox>
                                                    </td>
                                                </tr>
                                            </table>
                                            <br><br>

                                            <h:commandButton action="#{userController.createAccount}" value="Create account"/>

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


