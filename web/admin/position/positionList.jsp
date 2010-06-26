<%@taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <title>Position</title>
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
                            <h:dataTable border="1" value="#{functieBean.positions}" var="position">
                                <h:column id="column1">
                                    <f:facet name="header">
                                        <h:outputText value="Position id"></h:outputText>
                                    </f:facet>
                                    <h:outputText value="#{position.id}"></h:outputText>
                                </h:column>
                                <h:column id="column2">
                                    <f:facet name="header">
                                        <h:outputText value="Position title"></h:outputText>
                                    </f:facet>
                                    <h:outputLink value="positionRecord.jsf?id=#{position.id}">
                                        <h:outputText value="#{position.name}"/>
                                    </h:outputLink>
                                </h:column>
                                <f:facet name="footer">
                                    <h:outputLink value="insertPosition.jsf">
                                        <h:outputText value="Insert new Position"/>
                                    </h:outputLink>
                                </f:facet>
                            </h:dataTable>
                        </h:form>
                    </f:view>
                </td>
            </tr>
        </table>

    </body>
</html>
