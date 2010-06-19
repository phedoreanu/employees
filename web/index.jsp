<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body onload="sendRedirect();">
        <script type="text/javascript">
            function sendRedirect() {
                document.location = 'http://localhost:8084/employees/admin/index.jsf';
            }
        </script>
    </body>
</html>
