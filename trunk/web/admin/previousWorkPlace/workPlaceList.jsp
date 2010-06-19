<%@taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <title>Previous work place</title>
        <link rel="stylesheet" type="text/css" href="../../css/cssverticalmenu.css"/>
        <script type="text/javascript" src="../../javascript/cssverticalmenu.js"></script>
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
                            <h:dataTable border="1" value="#{locMuncaAnteriorBean.workPlaceList}" var="workPlace">
                                <h:column id="column1">
                                    <f:facet name="header">
                                        <h:outputText value="Work place id"></h:outputText>
                                    </f:facet>
                                    <h:outputText value="#{workPlace.id}"></h:outputText>
                                </h:column>
                                <h:column id="column2">
                                    <f:facet name="header">
                                        <h:outputText value="Work place name"></h:outputText>
                                    </f:facet>
                                    <h:outputLink value="workPlaceRecord.jsf?id=#{workPlace.id}">
                                        <h:outputText value="#{workPlace.name}"/>
                                    </h:outputLink>
                                </h:column>
                                <f:facet name="footer">
                                    <h:outputLink value="insertWorkPlace.jsf">
                                        <h:outputText value="Insert new Work Place"/>
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
