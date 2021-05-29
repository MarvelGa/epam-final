<%@ include file="/WEB-INF/jspf/directive/page.jspf" %>
<%@ include file="/WEB-INF/jspf/directive/taglib.jspf" %>
<%@ page isELIgnored="false" %>

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>All user's deliveries</title>
    <meta charset="UTF-8"/>
    <link href="/static/style.css" rel="stylesheet"/>
</head>

<body>
<center>
    <%@include file="/WEB-INF/jsp/top.jsp" %>
    </br>
    <center><h2>All your order deliveries</h2></center>
    </br>

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
        </tr>
        <tr></tr>
        <tr></tr>
    </table>

    <%
        int counter = 1;
    %>
    <table border="1">
        <tr>
            <th>No.</th>
            <th>Order ID</th>
            <th>City FROM</th>
            <th>City TO</th>
            <th>Distance, km</th>
            <th>Weight of Parcel, tonne</th>
            <th>Volume of Parcel, <i>m<sup><small>3</small></sup></i></th>
            <th>Created Date</th>
            <th>Price</th>
            <th>Status</th>
        </tr>
        <c:forEach var="record" items="${sessionScope.allUserOrders}">
            <tr>
                <td>
                    <%=counter++%>
                </td>

                <td>
                        ${record.order.id}
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
            </tr>
        </c:forEach>
    </table>
    <br>


    </br></br>
    <a href="/null/controller?command=userCabinet">Go to Delivery List Page</a>
</center>
<input type="hidden" name="referer" value="${pageContext.request.requestURI}"/>
<center><h1>Welcome to FIRST AIR TRANSPORT COMPANY!</h1></center>
</br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br>
<%@include file="/WEB-INF/jsp/footer.jsp" %>
</body>
</html>
