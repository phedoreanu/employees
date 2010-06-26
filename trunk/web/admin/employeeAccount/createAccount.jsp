<%@taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@taglib uri="http://myfaces.apache.org/tomahawk" prefix="t" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>New account</title>
    </head>
    <f:view>
        <body>
            <table>
                <tr>
                    <td>
                        <%@include file="../../menu.jsp" %>
                    </td>
                    <td>
                        <h:form id="newUserForm">
                            <h:messages showDetail="true" showSummary="true"/>
                            
                            <h:outputText value="New username"/>&nbsp;&nbsp;
                            <h:inputText value="#{userBean.username}" required="true" requiredMessage="Fill!" />&nbsp;&nbsp
                            <br>
                            <h:outputText value="New password"/>&nbsp;&nbsp;
                            <h:inputText value="#{userBean.password}" />&nbsp;&nbsp
                            <br>
                            <h:outputText value="Roles:"/>&nbsp;&nbsp;
                            <%--<h:selectOneListbox id="roleId" size="1" value="#{userBean.roleId}">--%>
                            <t:selectOneListbox id="roleId" size="1" value="#{userBean.userRole}">
                                <t:selectItems value="#{userBean.roles}" var="role" itemLabel="#{role.label}" itemValue="#{role.label}"/>
                            </t:selectOneListbox>
                            <%--</h:selectOneListbox>--%>


                            <h:commandButton action="#{userController.createAccount}" value="Create account"/>

                        </h:form>
                    </td>
                </tr>
            </table>
        </body>
    </f:view>
</html>
