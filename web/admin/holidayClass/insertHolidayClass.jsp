<%@taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="http://localhost:8084/employees/css/style.css"/>
        <title>New holiday class</title>
    </head>
    <f:view>
        <body>
            <table>
                <tr>
                    <td>
                        <%@include file="../../menu.jsp" %>
                    </td>
                    <td>
                        <h:form id="holidayForm">
                            <h:outputText value="Please enter a number"/><br>
                            <h:outputText value="New holiday class"/>&nbsp;&nbsp;
                            <h:inputText id="holidayClass" value="#{clasaConcediuBean.nrClasa}" required="true" requiredMessage="Fill holiday class texbox!">
                                 <f:validateLongRange minimum="21"/>
                            </h:inputText>&nbsp;&nbsp
                            
                            <h:commandButton action="#{clasaConcediuController.insertClasaConcediu}" value="Insert"/>
                            
                            <h:message for="holidayClass" styleClass="messages"/>
                        </h:form>
                    </td>
                </tr>
            </table>
        </body>
    </f:view>
</html>
