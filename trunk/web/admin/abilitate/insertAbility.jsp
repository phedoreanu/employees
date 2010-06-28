<%@taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <link rel="stylesheet" type="text/css" href="http://localhost:8084/employees/css/myStyle.css"/>
        <title>Ability</title>
    </head>
    <f:view>
        <body>
            <table>
                <tr>
                    <td>
                        <%@include file="../../menu.jsp" %>
                    </td>
                    <td>
                        <h:form id="abilityForm">
                            <h:outputText value="New ability"/>&nbsp;&nbsp;
                            <h:inputText id="ability" value="#{abilitateBean.name}" required="true" requiredMessage="Fill ability textbox!"
                                         validator="#{abilitateController.validateAbilityDuplicates}"/>&nbsp;&nbsp
                            <h:commandButton action="#{abilitateController.insertAbilitate}" value="Insert"/>
                            <h:messages styleClass="messages"/>
                        </h:form>
                    </td>
                </tr>
            </table>

        </body>
    </f:view>
</html>
