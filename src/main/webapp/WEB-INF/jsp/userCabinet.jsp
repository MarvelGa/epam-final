<%@ include file="/WEB-INF/jspf/directive/page.jspf" %>
<%@ include file="/WEB-INF/jspf/directive/taglib.jspf" %>
<%@ page isELIgnored="false" %>

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>Home page</title>
    <meta charset="UTF-8"/>
    <link href="/static/style.css" rel="stylesheet"/>
</head>

<body style="background-color: #D8BFD8;">
<center>
    <%@include file="/WEB-INF/jsp/top.jsp" %>

    <h2>User Personal Cabinet!</h2>

    </br> </br>
    <table>
        <tr></tr>
        <tr></tr>
        <tr>
            <td>
<%--                </br>--%>
<%--                <form action="./controller" method="GET">--%>
<%--                    <input type="hidden" name="command" value="userCabinet">--%>
<%--                    <input type="submit" value="Create New Delivery Order">--%>
<%--                </form>--%>
<%--                </br>--%>
            </td>
            <td>
                <form action="./controller" method="GET">
                    <input type="hidden" name="command" value="allUserDeliveries">
                    <input type="submit" value="Show All Your Deliveries">
                </form>
            </td>
        </tr>
        <tr></tr>
        <tr></tr>
    </table>

    <%@include file="/WEB-INF/jsp/common/delivery.jsp" %>
<%--    <br>--%>
<%--    <%--%>
<%--        int counter = 1;--%>
<%--    %>--%>

<%--    <table border="1">--%>
<%--        <tr>--%>
<%--            <th>No.</th>--%>
<%--            <th>ID</th>--%>
<%--            <th>City FROM</th>--%>
<%--            <th>City TO</th>--%>
<%--            <th>Destination</th>--%>
<%--            <th colspan="1">Operation</th>--%>
<%--        </tr>--%>
<%--        <c:forEach var="record" items="${cityAndDistance}">--%>
<%--            <tr>--%>
<%--                <td><%=counter++%>--%>
<%--                </td>--%>
<%--                <td>--%>
<%--                        ${record.id}--%>
<%--                </td>--%>
<%--                <td>--%>
<%--                        ${record.cityFrom}--%>
<%--                </td>--%>
<%--                <td>--%>
<%--                        ${record.cityTo}--%>
<%--                </td>--%>
<%--                <td>--%>
<%--                        ${record.distance}--%>
<%--                </td>--%>

<%--                <td>--%>
<%--                    <form action="./controller" method="GET">--%>
<%--                        <input type="hidden" name="command" value="create-delivery">--%>
<%--                        <input type="hidden" name="id" value="${record.id}">--%>
<%--                        <input type="submit" value="Create delivery">--%>
<%--                    </form>--%>
<%--                </td>--%>
<%--            </tr>--%>
<%--        </c:forEach>--%>
<%--    </table>--%>


</center>
<input type="hidden" name="referer" value="${pageContext.request.requestURI}"/>
</br></br></br></br></br></br></br></br>
<%@include file="/WEB-INF/jsp/footer.jsp" %>
</body>

</html>