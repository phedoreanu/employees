<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <title>Welcome</title>
        <link href="../css/style.css" rel="stylesheet" type="text/css" media="screen" />
    </head>
    <body>
        <div id="wrapper">
            <div id="header">
                <div id="logo">
                    <h1><a href="#">Employees</a></h1>
                </div>

                <%@include file="../header.jsp" %>
            </div>
            <div id="page">
                <div id="page-bgtop">
                    <div id="page-bgbtm">
                        <div id="content">
                            <div class="post">
                                <h2 class="title"><a href="#">Welcome to Employee Management</a></h2>
                                <p class="meta">
                                    <%@include file="../currentDate.jsp" %>
                                    <%@include file="../userRole.jsp" %>

                                </p>
                                <div style="clear: both;">&nbsp;</div>
                                <div class="entry">
                                    <p>This is a web site for employee management</p>
                                    <p class="links"><a href="http://localhost:8084/employees/about.jsp">About</a></p>
                                </div>
                            </div>
                            <div style="clear: both;">&nbsp;</div>
                        </div>

                        <%@include file="../menu.jsp" %>

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
