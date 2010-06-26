<%@taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@taglib uri="http://myfaces.apache.org/tomahawk" prefix="t" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<%
            if (request.getUserPrincipal() != null) {
                String name = request.getUserPrincipal().getName();
            }
%>

<html>
    <head>
        <title>Admin</title>
    </head>

    <body>
        <table>
            <tr>
                <td>
                    <%@include file="../menu.jsp" %>
                </td>
                <td>
                    <h1>Change the password of your acount!</h1>
                    <h:outputText value="New password"></h:outputText>&nbsp
                    <h:inputSecret value="#{userBean.password}"/>
                    <h:commandButton value="Change password" action="#{userController.updateAdminPassw}">
                        <f:param name="userName" value=""></f:param>
                    </h:commandButton>
                </td>
        </table>

    </body>
</html>
