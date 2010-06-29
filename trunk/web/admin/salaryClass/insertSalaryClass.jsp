<%@taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="http://localhost:8084/employees/css/style.css"/>
        <title>New salary class</title>
    </head>
    <f:view>
        <body>
            <table>
                <tr>
                    <td>
                        <%@include file="../../menu.jsp" %>
                    </td>
                    <td>
                        <h:form id="salaryForm">
                            <h:outputText value="Please insert a number"></h:outputText><br>
                            <h:outputText value="New salary class"/>&nbsp;&nbsp;
                            <h:inputText id="salaryClass" value="#{clasaSalariuBean.nrClasa}"  required="true" requiredMessage="Fill salary class texbox!"/>&nbsp;&nbsp

                            <h:commandButton action="#{clasaSalariuController.insertClasaSalariu}" value="Insert"/>
                            <h:message for="salaryClass" styleClass="messages"/>
                        </h:form>
                    </td>
                </tr>
            </table>
        </body>
    </f:view>
</html>
