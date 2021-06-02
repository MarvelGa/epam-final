<%@ include file="/WEB-INF/jspf/directive/page.jspf" %>
<%@ include file="/WEB-INF/jspf/directive/taglib.jspf" %>
<%@ taglib uri="/WEB-INF/tld/custom.tld" prefix="custom" %>
<%@ page isELIgnored="false" %>

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>View Data Of Delivery</title>
    <meta charset="UTF-8"/>
    <link href="/static/style.css" rel="stylesheet"/>
</head>
<body>
<center>
    <%@include file="/WEB-INF/jsp/top.jsp" %>
    <h3>View Data Of Delivery</h3>
    <%
        int counter = 1;
    %>
    <p><a href="/null/controller?command=adminCabinet"> Go to Main Admin Page!</a></p>
    <a href="/null/controller?command=getAllUsersOrders"> Back to Previously Page!</a>
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
        </tr>
            <tr>
                <td>
                    <%=counter++%>
                </td>

                <td>
                        ${orderItem.order.id}
                </td>

                <td>
                        ${orderItem.user.email}
                </td>

                <td>
                        ${orderItem.user.firstName}
                </td>

                <td>
                        ${orderItem.user.lastName}
                </td>

                <td>
                        ${orderItem.item.cityFrom}
                </td>

                <td>
                        ${orderItem.item.cityTo}
                </td>

                <td>
                        ${orderItem.distance}
                </td>

                <td>
                        ${orderItem.item.maxWeight}
                </td>

                <td>
                    <c:out value="${orderItem.item.maxLength * orderItem.item.maxWidth * orderItem.item.maxHeight}"/>
                </td>

                <td>
                    <custom:formatDate value="${orderItem.order.createdAt}" pattern="dd.MM.yyyy HH:mm"/>
<%--                        ${orderItem.order.createdAt}--%>
                </td>

                <td>
                        ${orderItem.item.price}
                </td>

                <td>
                        ${orderItem.order.status}
                </td>

                <td>
                        ${orderItem.user.roleName}
                </td>

            </tr>

        </br>

        <form action="./controller" method="POST">
            <input type="hidden" name="command" value="confirmationChangeStatus">
            <input type="hidden" name="orderId" value=${orderItem.order.id}>
            </br>
        <table>
            </br>
            <tr>
                <td>
                    <label for="status">Change Status</label>
                </td>
                <td>
                    <select name="status">
                        <option value="NEW" ${users.adress!=null?(orderItem.order.status.equals("NEW")?"selected": ""): ""}>
                            NEW
                        </option>
                        <option value="PENDING"${users.adress!=null?(orderItem.order.status.equals("PENDING")?"selected": ""): ""} >
                            PENDING
                        </option>
                        <option value="COMPLETE" ${users.adress!=null?(orderItem.order.status.equals("COMPLETE")?"selected": ""): ""}>
                            COMPLETE
                        </option>
                        <option value="CANCELED"${users.adress!=null?(orderItem.order.status.equals("CANCELED")?"selected": ""): ""} >
                            CANCELED
                        </option>
                    </select>
                </td>
            </tr>

        </table>
        <tr>
            </br>
            <td colspan="2">
                <input type="submit" value="Confirm changing status"/>
            </td>
        </tr>
        </form>

    </table>
    </br>

<%--    <form action="./controller" method="GET">--%>
<%--        <input type="hidden" name="command" value="changeStatusDelivery">--%>
<%--        <input type="hidden" name="id" value="${record.order.id}">--%>
<%--        <input type="submit" value="Сhange Status Delivery">--%>
<%--    </form>--%>


</center>
<input type="hidden" name="referer" value="${pageContext.request.requestURI}"/>
</br></br>
<%@include file="/WEB-INF/jsp/footer.jsp" %>
</body>
</html>