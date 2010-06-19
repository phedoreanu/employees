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
        <link rel="stylesheet" type="text/css" href="../css/cssverticalmenu.css"/>
        <script type="text/javascript" src="../javascript/cssverticalmenu.js"></script>
    </head>

    <body>
        <table>
            <tr>
                <td>
                    <%@include file="../menu.jsp" %>
                </td>
                <td>
                    <f:view>
                        <h:form>
                            <h1>Welcome!</h1>
                        </h:form>
                    </f:view>
                </td>
            </tr>
        </table>

    </body>
</html>
