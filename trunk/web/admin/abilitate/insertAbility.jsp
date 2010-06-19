<%@taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <title>Ability</title>
        <link rel="stylesheet" type="text/css" href="../../css/cssverticalmenu.css"/>
        <script type="text/javascript" src="../../javascript/cssverticalmenu.js"></script>
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

                            <h:outputText value="New ability"/>&nbsp;&nbsp;
                            <h:inputText value="#{abilitateBean.name}" />&nbsp;&nbsp
                            <h:commandButton action="#{abilitateController.insertAbilitate}" value="Insert"/>

                        </h:form>
                    </td>
                </tr>
            </table>

        </body>
    </f:view>
</html>
