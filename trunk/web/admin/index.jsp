<%@taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <f:view>
        <head>

            <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
            <title>Prima pagina</title>
        </head>
        <body>
            <h:form>

                <h:outputText value="#{userBean.username}"></h:outputText><br>

                <h:outputText value="Abilitate"></h:outputText>&nbsp;&nbsp;
                <h:inputText value="#{abilitateBean.name}"></h:inputText>&nbsp;&nbsp;
                <%--<h:commandButton value="Insereaza" action="#{abilitateBean.insertAbilitate}"></h:commandButton>--%>
                <br>

                <h:dataTable border="1" value="#{abilitateBean.abilities}" var="abilitate">
                    <h:column id="column1">
                        <f:facet name="header">
                            <h:outputText value="idAbilitate"></h:outputText>
                        </f:facet>
                        <h:outputText value="#{abilitate.id}"></h:outputText>
                    </h:column>
                    <h:column id="column2">
                        <f:facet name="header">
                            <h:outputLink value="Nume"></h:outputLink>
                        </f:facet>
                        <h:outputLink value="abilitate/fisaAbilitate.jsf?id=#{abilitate.id}">
                            <h:outputText value="#{abilitate.name}"/>
                        </h:outputLink>
                    </h:column>
                    <%--<h:column id="column3">
				<h:commandLink action="#{abilitateBean.deleteAbilitate}">
					<h:outputText value="Delete"></h:outputText>
					<f:param name="idAbil" value="#{abilitate.idAbilitate}"></f:param>
				</h:commandLink>
			</h:column>
			<h:column id="column4">
				<h:commandLink action="goToUpdate">
				 	<f:param name="idAbil" value="#{abilitate.idAbilitate}"></f:param>
				 	<f:param name="numeAbil" value="#{abilitate.numeAbilitate}"></f:param>
					<h:outputText value="Update"></h:outputText>
				</h:commandLink>
			</h:column>--%>
                </h:dataTable>
            </h:form>
            
        </body>
    </f:view>
</html>