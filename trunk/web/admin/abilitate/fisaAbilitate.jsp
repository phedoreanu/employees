<%@taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@taglib uri="http://myfaces.apache.org/tomahawk" prefix="t" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<f:view>
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
                        <h:form>

                            <t:saveState value="#{abilitateBean}" />

                            <h:outputText value="New ability name"/>&nbsp;&nbsp;
                            <h:inputText value="#{abilitateBean.name}" />

                            <h:commandButton action="#{abilitateController.updateAbilitate}" value="Update"/>
                            <br><br>
                            <h:outputText value="If you wish to delete this ability click "/>&nbsp;
                            <h:commandLink action="#{abilitateController.deleteAbilitate}">
                                <h:outputText value="here"/>
                            </h:commandLink>

                        </h:form>
                    </td>
                </tr>
            </table>
        </body>
    </html>
</f:view>