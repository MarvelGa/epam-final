<%@ include file="/WEB-INF/jspf/directive/page.jspf" %>
<%@ include file="/WEB-INF/jspf/directive/taglib.jspf" %>
<%@ taglib uri="/WEB-INF/tld/custom.tld" prefix="custom" %>
<%@ page isELIgnored="false" %>

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>List the Orders Delivery Of Particular User</title>
    <meta charset="UTF-8"/>
    <link href="/static/style.css" rel="stylesheet"/>
</head>

<body>
<center>
    <%@include file="/WEB-INF/jsp/top.jsp" %>
    </br>
    <center><h2>List the Orders Delivery Of Particular User</h2></center>

    <c:choose>
        <c:when test="${sessionScope.user.roleId==1}">
            <p><a href="/null/controller?command=adminCabinet"> Go to Main Admin Page!</a></p>
            <p><a href="/null/controller?command=displayAllUsers"> Back to previously Page!</a></p>
<%--            <%@include file="/WEB-INF/jsp/admin/admin-panel.jsp" %>--%>
            </br>
        </c:when>
        <c:otherwise>
            <table>
                <tr></tr>
                <tr></tr>
                <tr>
                    <td>
                        <form action="./controller" method="GET">
                            <input type="hidden" name="command" value="userCabinet">
                            <input type="submit" value="Create New Delivery Order">
                        </form>
                    </td>
                </tr>
                <tr></tr>
                <tr></tr>
            </table>
        </c:otherwise>
    </c:choose>


<c:choose>
    <c:when test="${requestScope.listOfUsersOrders.size()!=0}">
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
            <th>Role</th>
        </tr>
        <c:forEach var="record" items="${requestScope.listOfUsersOrders}">
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
<%--                        ${record.order.createdAt}--%>
                            <custom:formatDate value="${record.order.createdAt}" pattern="dd.MM.yyyy HH:mm"/>
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
            </tr>
        </c:forEach>
    </table>
    </c:when>
    <c:otherwise>
        <center><h2>This User has no order yet!</h2></center>
    </c:otherwise>
</c:choose>

    <%--    <a href="/null/controller?command=userCabinet">Go to Delivery List Page</a>--%>
<%--    <%@include file="/WEB-INF/jsp/common/bottom-panel.jsp" %>--%>

</center>
<input type="hidden" name="referer" value="${pageContext.request.requestURI}"/>
<%--<center><h1>Welcome to FIRST AIR TRANSPORT COMPANY!</h1></center>--%>
</br></br>
<%@include file="/WEB-INF/jsp/footer.jsp" %>
</body>
</html>
