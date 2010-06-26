<%@taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <title>Users</title>
    </head>

    <body>
        <table>
            <tr>
                <td>
                    <%@include file="../../menu.jsp" %>
                </td>
                <td>
                    <f:view>
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
                    </f:view>
                </td>
            </tr>
        </table>

    </body>
</html>
