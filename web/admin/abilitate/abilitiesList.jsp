<%@taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
            String name = request.getUserPrincipal().getName();
            boolean isAdmin = request.isUserInRole("administrator");


%>
<html>
    <head>
        <title>Ability</title>
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
                            <h:dataTable border="1" value="#{abilitateBean.abilities}" var="abilitate">
                                <h:column id="column1">
                                    <f:facet name="header">
                                        <h:outputText value="Ability id"></h:outputText>
                                    </f:facet>
                                    <h:outputText value="#{abilitate.id}"></h:outputText>
                                </h:column>
                                <h:column id="column2">
                                    <f:facet name="header">
                                        <h:outputText value="Ability name"></h:outputText>
                                    </f:facet>
                                    <h:outputLink value="fisaAbilitate.jsf?id=#{abilitate.id}">
                                        <h:outputText value="#{abilitate.name}"/>
                                    </h:outputLink>
                                </h:column>
                                <f:facet name="footer">
                                    <h:outputLink value="insertAbility.jsf">
                                        <h:outputText value="Insert new Ability"/>
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