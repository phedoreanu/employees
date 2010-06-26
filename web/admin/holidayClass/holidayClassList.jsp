<%@taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <title>Holiday class</title>
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
                            <h:dataTable border="1" value="#{clasaConcediuBean.clasaConcediuList}" var="holidayClass">
                                <h:column id="column1">
                                    <f:facet name="header">
                                        <h:outputText value="Holiday Class id"></h:outputText>
                                    </f:facet>
                                    <h:outputText value="#{holidayClass.id}"></h:outputText>
                                </h:column>
                                <h:column id="column2">
                                    <f:facet name="header">
                                        <h:outputText value="Holiday class number"></h:outputText>
                                    </f:facet>
                                    <h:outputText value="#{holidayClass.nrClasa}"/>
                                </h:column>
                                <h:column id="column3">
                                    <f:facet name="header">
                                        <h:outputText value="Delete operation"></h:outputText>
                                    </f:facet>
                                    <h:commandLink action="#{clasaConcediuController.deleteClasaConcediu}">
                                        <h:outputText value="Delete"></h:outputText>
                                        <f:param name="idCls" value="#{holidayClass.id}"></f:param>
                                    </h:commandLink>
                                </h:column>
                                <f:facet name="footer">
                                    <h:outputLink value="insertHolidayClass.jsf">
                                        <h:outputText value="Insert new Holiday Class"/>
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
