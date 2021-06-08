<%@ include file="/WEB-INF/jspf/directive/page.jspf" %>
<%@ include file="/WEB-INF/jspf/directive/taglib.jspf" %>
<%@ taglib uri="/WEB-INF/tld/custom.tld" prefix="custom" %>
<%@ page isELIgnored="false" %>

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>${resources.List_the_orders}</title>
    <meta charset="UTF-8"/>
    <link href="/static/style.css" rel="stylesheet"/>
</head>

<body>
<center>
    <%@include file="/WEB-INF/jsp/top.jsp" %>
    </br>
    <center><h2>${resources.List_the_orders}</h2></center>

    <c:choose>
        <c:when test="${sessionScope.user.roleId==1}">
            <p><a href="/tct/controller?command=adminCabinet"> ${resources.Go_to_main_admin_page}!</a></p>
            <p><a href="/tct/controller?command=displayAllUsers">${resources.Back_to_previously_page}!</a></p>
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
                            <input type="submit" value=${resources.Create_new_delivery_order}>
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
            <th>${resources.Order_id}</th>
            <th>${resources.City_from}</th>
            <th>${resources.City_to}</th>
            <th>${resources.Distance}</th>
            <th>${resources.Weight}</th>
            <th>${resources.Volume_of_parcel}, <i>m<sup><small>3</small></sup></i></th>
            <th>${resources.Created_date}</th>
            <th>${resources.Price}</th>
            <th>${resources.Status}</th>
            <th>${resources.Role}</th>
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
            </tr>
        </c:forEach>
    </table>
    </c:when>
    <c:otherwise>
        <center><h2>${resources.This_user_has_no_order_yet}!</h2></center>
    </c:otherwise>
</c:choose>

</center>
<input type="hidden" name="referer" value="${pageContext.request.requestURI}"/>
</br></br>
<%@include file="/WEB-INF/jsp/footer.jsp" %>
</body>
</html>
