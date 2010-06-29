<%@taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <title>Ability</title>
        <link href="http://localhost:8084/employees/css/style.css" rel="stylesheet" type="text/css" media="screen" />
    </head>
    <f:view>
        <body>

            <div id="wrapper">
                <div id="header">
                    <div id="logo">
                        <h1><a href="#">Employees</a></h1>
                    </div>

                    <%@include file="../../header.jsp" %>
                </div>
                <div id="page">
                    <div id="page-bgtop">
                        <div id="page-bgbtm">
                            <div id="content">
                                <div class="post">
                                    <h2 class="title"><a href="#">Abilities</a></h2>
                                    <p class="meta">
                                        <%@include file="../../currentDate.jsp" %>
                                        <%@include file="../../userRole.jsp" %>
                                    </p>
                                    <div style="clear: both;">&nbsp;</div>
                                    <div class="entry">
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

                                        <p class="links"><a href="http://localhost:8084/employees/about.jsp">About</a></p>
                                    </div>
                                </div>
                                <div style="clear: both;">&nbsp;</div>
                            </div>

                            <%@include file="../../menu.jsp" %>

                            <div style="clear: both;">&nbsp;</div>
                        </div>
                    </div>
                </div>
            </div>
            <div id="footer">
                <p>Copyright &copy;  2010  All rights reserved.</p>
            </div>

        </f:view>
    </body>
</html>