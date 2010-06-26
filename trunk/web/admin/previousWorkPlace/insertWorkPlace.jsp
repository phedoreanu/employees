<%@taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>New work place</title>
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

                            <h:outputText value="New work place"/>&nbsp;&nbsp;
                            <h:inputText value="#{locMuncaAnteriorBean.name}" />&nbsp;&nbsp

                            <h:commandButton action="#{locMuncaAnteriorController.insertWorkPlace}" value="Insert"/>

                        </h:form>
                    </td>
                </tr>
            </table>
        </body>
    </f:view>
</html>
