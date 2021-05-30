<%@ include file="/WEB-INF/jspf/directive/page.jspf" %>
<%@ include file="/WEB-INF/jspf/directive/taglib.jspf" %>
<%@ page isELIgnored="false" %>

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>Display of all Users</title>
    <meta charset="UTF-8"/>
    <link href="/static/style.css" rel="stylesheet"/>
</head>
<body>
<center>
    <%@include file="/WEB-INF/jsp/top.jsp" %>
    <h3>View Of All Users In DataBase</h3>

    <p><a href="/null/controller?command=adminCabinet"> Go to Main Admin Page!</a></p>

    <%@include file="/WEB-INF/jsp/admin/admin-panel.jsp" %>

    <%
        int counter = 1;
    %>
    <table border="1">
        <tr>
            <th>No.</th>
            <th>User email</th>
            <th>User First Name</th>
            <th>User Last Name</th>
            <th>Role</th>
        </tr>
        <c:forEach var="record" items="${requestScope.listUsers}">
            <tr>
                <td>
                    <%=counter++%>
                </td>

                <td>
                        ${record.email}
                </td>

                <td>
                        ${record.firstName}
                </td>

                <td>
                        ${record.lastName}
                </td>

                <td>
                        ${record.roleName}
                </td>

            </tr>
        </c:forEach>
    </table>
    <br>

</center>
<input type="hidden" name="referer" value="${pageContext.request.requestURI}"/>
</br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br>
<%@include file="/WEB-INF/jsp/footer.jsp" %>
</body>
</html>