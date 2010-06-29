<!--
 Licensed to the Apache Software Foundation (ASF) under one or more
  contributor license agreements.  See the NOTICE file distributed with
  this work for additional information regarding copyright ownership.
  The ASF licenses this file to You under the Apache License, Version 2.0
  (the "License"); you may not use this file except in compliance with
  the License.  You may obtain a copy of the License at

      http://www.apache.org/licenses/LICENSE-2.0

  Unless required by applicable law or agreed to in writing, software
  distributed under the License is distributed on an "AS IS" BASIS,
  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
  See the License for the specific language governing permissions and
  limitations under the License.
-->
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="http://localhost:8084/employees/css/style.css"/>
        <title>Error Page</title>
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
                                <h2 class="title"><a href="#">Error page</a></h2>
                                <p class="meta">

                                    <%@include file="currentDate.jsp" %>

                                </p>
                                <div style="clear: both;">&nbsp;</div>
                                <div class="entry">

                                    Invalid username and/or password, please try
                                    <a href='<%= response.encodeURL("index.jsp")%>'>again</a>.

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
