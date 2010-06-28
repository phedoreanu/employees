<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
            String idRapport = request.getParameter("id");
            String reportName = request.getParameter("reportName");
            String reportTitle = request.getParameter("reportTitle");
%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
        <title>Ability</title>
    </head>

    <body onLoad="javascript:document.getElementById('abilityId').submit();">
        <form action="http://localhost:8084/employees/Reports/ability" id="abilityId" method="post" onsubmit="alert(document.getElementById('abilityId').action); return true;">
              <input type="hidden" name="id" value="<%=idRapport%>">
            <input type="hidden" name="reportName" value="<%=reportName%>">
            <input type="hidden" name="reportTitle" value="<%=reportTitle%>">
        </form>
    </body>
</html>