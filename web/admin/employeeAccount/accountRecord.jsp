<%@taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@taglib uri="http://myfaces.apache.org/tomahawk" prefix="t" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <link rel="stylesheet" type="text/css" href="http://localhost:8084/employees/css/style.css"/>
        <title>Account Record</title>
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
                            <t:saveState value="#{userBean}"/>

                            <h:outputText value="New username"/>&nbsp;&nbsp;
                            <h:inputText id="username" value="#{userBean.username}" required="true" requiredMessage="Fill username textbox!"/>
                            <h:message for="username" styleClass="messages"/>
                            <br>

                            <h:outputText value="New password"/>&nbsp;&nbsp;
                            <h:inputText id="password" value="#{userBean.password}" required="true" requiredMessage="Fill password textbox!">
                                <f:validateLength  minimum="5"/>
                            </h:inputText>
                            <h:message for="password" styleClass="messages"/>
                            <br>

                            <h:outputText value="Current role:"/>&nbsp;&nbsp;
                            <h:outputText value="#{userBean.userRole}" />
                            <br>
                            <h:outputText value="Roles:"/>&nbsp;&nbsp;
                             <t:selectOneListbox id="roleId" size="1" value="#{userBean.userRole}">
                                 <t:selectItems value="#{userBean.roles}" var="role" itemLabel="#{role.label}" itemValue="#{role.label}"/>
                            </t:selectOneListbox>

                            <h:commandButton action="#{userController.updateAccount}" value="Update"/>
                            <br><br>

                            <h:outputText value="If you wish to delete this account click "/>&nbsp;
                            <h:commandLink action="#{userController.deleteAccount}">
                                <h:outputText value="here"/>
                            </h:commandLink>

                        </h:form>
                    </f:view>
                </td>
            </tr>
        </table>
    </body>
</html>
