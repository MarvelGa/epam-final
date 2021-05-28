<%@ include file="/WEB-INF/jspf/directive/page.jspf" %>
<%@ include file="/WEB-INF/jspf/directive/taglib.jspf" %>
<%@ page isELIgnored="false" %>

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>Orders of User in Personal Cabinet</title>
    <meta charset="UTF-8"/>
    <link href="/static/style.css" rel="stylesheet"/>
</head>

<body>
<center>
    <%@include file="/WEB-INF/jsp/top.jsp" %>

    <table>
        <tr></tr>
        <tr></tr>
        <tr>
            <td>
                </br>
                <form action="./controller" method="GET">
                    <input type="hidden" name="command" value="userCabinet">
                    <input type="submit" value="Create New Delivery Order">
                </form>
                </br>
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





<%--    </br>--%>
<%--    <form action="./controller" method="GET">--%>
<%--        <input type="hidden" name="command" value="userCabinet">--%>
<%--        <input type="submit" value="Create New Delivery Order">--%>
<%--    </form>--%>
<%--    </br>--%>




    <%
        int counter = 1;
    %>
    <table border="1">
        <tr>
            <th>No.</th>
            <th>Order ID</th>
            <th>City FROM</th>
            <th>CITY TO</th>
            <th>Distance</th>
            <th>Price</th>
            <th>Volume of Parcel</th>
            <th>Created Date</th>
            <th>Status</th>
        </tr>
        <c:forEach var="record" items="${sessionScope.orderItems}">
            <tr>
                <td>
                    <%=counter++%>
                </td>

                <td>
                        ${record.id}
                </td>

                <td>
                        ${record.item.cityFrom}
                </td>

                <td>
                        ${record.item.cityTo}
                </td>

                <td>
                        ${record.distance}
                </td>

                <td>
                        ${record.item.price}
                </td>

                <td>
                      ${record.volume}
                </td>

                <td>
                        ${record.order.createdAt}
                </td>

                <td>
                        ${record.order.status}
                </td>
            </tr>
        </c:forEach>
    </table>
    </br></br>
    <a href="/null/controller?command=userCabinet">Go to Delivery List Page</a>
</center>
<%--<input type="hidden" name="command" value="user_orders">--%>
<input type="hidden" name="referer" value="${pageContext.request.requestURI}"/>
<center><h1>Welcome to FIRST AIR TRANSPORT COMPANY!</h1></center>
</br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br>
<%@include file="/WEB-INF/jsp/footer.jsp" %>
</body>
</html>