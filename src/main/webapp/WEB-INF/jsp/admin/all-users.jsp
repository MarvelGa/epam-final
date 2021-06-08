<%@ include file="/WEB-INF/jspf/directive/page.jspf" %>
<%@ include file="/WEB-INF/jspf/directive/taglib.jspf" %>
<%@ page isELIgnored="false" %>

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>${resources.Display_of_all_users}</title>
    <meta charset="UTF-8"/>
    <link href="/static/style.css" rel="stylesheet"/>
</head>
<body>
<center>
    <%@include file="/WEB-INF/jsp/top.jsp" %>
    <h3>${resources.View_of_all_users}</h3>
    <p><a href="/tct/controller?command=adminCabinet"> ${resources.Go_to_main_admin_page}!</a></p>
    </br>
    <%
        int counter = 1;
    %>
    <table border="1">
        <tr>
            <th>No.</th>
            <th>${resources.User_email}</th>
            <th>${resources.User_first_name}</th>
            <th>${resources.User_last_name}</th>
            <th>${resources.Role}</th>
            <th colspan="1" style="background-color: #b0c4de">Operations</th>
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

                <td>
                    <form action="./controller" method="GET">
                        <input type="hidden" name="command" value="listDeliveries">
                        <input type="hidden" name="userId" value= ${record.id}>
                        <input type="submit" value="${resources.Show_deliveries_of_the_user}">
                    </form>
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