<html>
    <head>
        <link rel="stylesheet" type="text/css" href="http://localhost:8084/employees/css/style.css"/>
        <title>Login Page</title>
    </head>

    <body>

        <div id="wrapper">
            <div id="header">
                <div id="logo">
                    <h1><a href="#">Employees</a></h1>
                </div>

            </div>
            <div id="page">
                <div id="page-bgtop">
                    <div id="page-bgbtm">
                        <div id="content">
                            <div class="post">
                                <h2 class="title"><a href="#">Login</a></h2>
                                <p class="meta">

                                    <%@include file="currentDate.jsp" %>

                                </p>
                                <div style="clear: both;">&nbsp;</div>
                                <div class="entry">

                                    <form method="POST" action='<%= response.encodeURL("j_security_check")%>' >
                                        <table border="0" cellspacing="5">
                                            <tr>
                                                <th align="right">Username:</th>
                                                <td align="left"><input type="text" name="j_username"></td>
                                            </tr>
                                            <tr>
                                                <th align="right">Password:</th>
                                                <td align="left"><input type="password" name="j_password"></td>
                                            </tr>
                                            <tr>
                                                <td align="right"><input type="submit" value="Log In"></td>
                                                <td align="left"><input type="reset"></td>
                                            </tr>
                                        </table>
                                    </form>

                                    <p class="links"><a href="http://localhost:8084/employees/about.jsp">About</a></p>
                                </div>
                            </div>
                            <div style="clear: both;">&nbsp;</div>
                        </div>

                        <div style="clear: both;">&nbsp;</div>
                    </div>
                </div>
            </div>
        </div>

        <div id="footer">
            <p>Copyright &copy;  2010  All rights reserved.</p>
        </div>

    </body>
</html>
