<%@taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
                        <h:form>
                            <h:outputText value="Please insert a number"></h:outputText><br>
                            <h:outputText value="New salary class"/>&nbsp;&nbsp;
                            <h:inputText value="#{clasaSalariuBean.nrClasa}" />&nbsp;&nbsp

                            <h:commandButton action="#{clasaSalariuController.insertClasaSalariu}" value="Insert"/>

                        </h:form>
                    </td>
                </tr>
            </table>
        </body>
    </f:view>
</html>
