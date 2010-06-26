<%@taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
                        <h:form>
                            <h:outputText value="Please enter a number"/><br>
                            <h:outputText value="New holiday class"/>&nbsp;&nbsp;
                            <h:inputText value="#{clasaConcediuBean.nrClasa}" />&nbsp;&nbsp

                            <h:commandButton action="#{clasaConcediuController.insertClasaConcediu}" value="Insert"/>

                        </h:form>
                    </td>
                </tr>
            </table>
        </body>
    </f:view>
</html>
