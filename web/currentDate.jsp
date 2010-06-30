
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.text.*,java.util.*" session="false"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="../css/style.css" rel="stylesheet" type="text/css" media="screen" />
    </head>
    <body>
        <%!    DateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
            String now = fmt.format(new Date());
        %>
        <span class="date">Today is <%=now%> </span>
    </body>
</html>
