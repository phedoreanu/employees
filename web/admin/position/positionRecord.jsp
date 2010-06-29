<%@taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@taglib uri="http://myfaces.apache.org/tomahawk" prefix="t" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <link rel="stylesheet" type="text/css" href="http://localhost:8084/employees/css/style.css"/>
        <title>Position Record</title>
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
                            <t:saveState value="#{functieBean}"/>

                            <h:outputText value="New position name"/>&nbsp;&nbsp;
                            <h:inputText value="#{functieBean.name}" required="true" requiredMessage="Fill position textbox!"/>

                            <h:commandButton action="#{functieController.updateFunctie}" value="Update"/>
                            <br><br>
                            <h:messages styleClass="messages"/>
                            <h:outputText value="If you wish to delete this position click "/>&nbsp;
                            <h:commandLink action="#{functieController.deleteFunctie}">
                                <h:outputText value="here"/>
                            </h:commandLink>

                        </h:form>
                    </f:view>
                </td>
            </tr>
        </table>
    </body>
</html>
