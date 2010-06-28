<%
            if (request.getUserPrincipal() != null) {
                String name = request.getUserPrincipal().getName();
            }
%>

<div id="currentUser">
    Welcome: <span><%= request.getRemoteUser()%></span>!&nbsp;&nbsp;
    <a href="http://localhost:8084/employees/logout.jsf">logout</a>
</div>