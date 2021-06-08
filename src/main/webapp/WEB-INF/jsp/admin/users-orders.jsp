<%@ include file="/WEB-INF/jspf/directive/page.jspf" %>
<%@ include file="/WEB-INF/jspf/directive/taglib.jspf" %>
<%@ taglib uri="/WEB-INF/tld/custom.tld" prefix="custom" %>
<%@ page isELIgnored="false" %>

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>${resources.Change_status_of_order_delivery}</title>
    <meta charset="UTF-8"/>
    <link href="/static/style.css" rel="stylesheet"/>
</head>
<body>
<center>
    <%@include file="/WEB-INF/jsp/top.jsp" %>
    <h3>${resources.Change_status_of_order_delivery}</h3>

    <p><a href="/tct/controller?command=adminCabinet"> ${resources.Go_to_main_admin_page}!</a></p>

    </br>
    <%
        int counter = 1;
    %>
    <table border="1">
        <tr>
            <th>No.</th>
            <th>${resources.Order_id}</th>
            <th>${resources.User_email}</th>
            <th>${resources.User_first_name}</th>
            <th>${resources.User_last_name}</th>
            <th>${resources.City_from}</th>
            <th>${resources.City_to}</th>
            <th>${resources.Distance}, km</th>
            <th>${resources.Weight}, tonne</th>
            <th>${resources.Volume_of_parcel}, <i>m<sup><small>3</small></sup></i></th>
            <th>${resources.Last_status_update_data}</th>
            <th>${resources.Price}</th>
            <th>${resources.Status}</th>
            <th>${resources.Role}</th>
            <th colspan="1" style="background-color: #b0c4de">${resources.Operation}</th>

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
                    <c:set var="city" value="${record.item.cityFrom}"/>
                        ${resources[city]}
                </td>

                <td>
                    <c:set var="city" value="${record.item.cityTo}"/>
                        ${resources[city]}
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

                <td style="background-color: #b0c4de">

                    <form action="./controller" method="GET">
                        <input type="hidden" name="command" value="changeStatusDelivery">
                        <input type="hidden" name="id" value="${record.order.id}">
                        <input type="submit" value="${resources.Change_status_delivery}">
                    </form>
                </td>

            </tr>
        </c:forEach>
    </table>
    <br>

</center>
<input type="hidden" name="referer" value="${pageContext.request.requestURI}"/>
</br></br>
<%@include file="/WEB-INF/jsp/footer.jsp" %>
</body>
</html>