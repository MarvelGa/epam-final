<%@ include file="/WEB-INF/jspf/directive/page.jspf" %>
<%@ include file="/WEB-INF/jspf/directive/taglib.jspf" %>
<%@ page isELIgnored="false" %>

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>All Users' Orders</title>
    <meta charset="UTF-8"/>
    <link href="/static/style.css" rel="stylesheet"/>
</head>
<body>
<center>
    <%@include file="/WEB-INF/jsp/top.jsp" %>
    <h3>Change Status Of Order Delivery</h3>

    <p><a href="/null/controller?command=adminCabinet"> Go to Main Admin Page!</a></p>

<%--    <%@include file="/WEB-INF/jsp/admin/admin-panel.jsp" %>--%>
    </br>
    <%
        int counter = 1;
    %>
    <table border="1">
        <tr>
            <th>No.</th>
            <th>Order ID</th>
            <th>User email</th>
            <th>User First Name</th>
            <th>User Last Name</th>
            <th>City FROM</th>
            <th>City TO</th>
            <th>Distance, km</th>
            <th>Weight of Parcel, tonne</th>
            <th>Volume of Parcel, <i>m<sup><small>3</small></sup></i></th>
            <th>Last Status Update Data</th>
            <th>Price</th>
            <th>Status</th>
            <th>Role</th>
            <th colspan="1" style="background-color: #b0c4de">Operations</th>

        </tr>
        <c:forEach var="record" items="${sessionScope.listUsersOrders}">
            <tr>
                <td>
                    <%=counter++%>
                </td>

                <td>
                        ${record.order.id}
                </td>

                <td>
                        ${record.user.email}
                </td>

                <td>
                        ${record.user.firstName}
                </td>

                <td>
                        ${record.user.lastName}
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
                        ${record.item.maxWeight}
                </td>

                <td>
                    <c:out value="${record.item.maxLength * record.item.maxWidth * record.item.maxHeight}"/>
                </td>

                <td>
                        ${record.order.createdAt}
                </td>

                <td>
                        ${record.item.price}
                </td>

                <td>
                        ${record.order.status}
                </td>

                <td>
                        ${record.user.roleName}
                </td>

                <td style="background-color: #b0c4de">

                    <form action="./controller" method="GET">
                        <input type="hidden" name="command" value="changeStatusDelivery">
                        <input type="hidden" name="id" value="${record.order.id}">
                        <input type="submit" value="Change Status Delivery">
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