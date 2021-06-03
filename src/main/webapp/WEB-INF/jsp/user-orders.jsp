<%@ include file="/WEB-INF/jspf/directive/page.jspf" %>
<%@ include file="/WEB-INF/jspf/directive/taglib.jspf" %>
<%@ page isELIgnored="false" %>

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>${resources.Make_an_order_page}</title>
    <meta charset="UTF-8"/>
</head>

<body>
<center>
    <%@include file="/WEB-INF/jsp/top.jsp" %>


    <c:choose>
        <c:when test="${sessionScope.user.roleId==1}">
            <%@include file="/WEB-INF/jsp/common/bottom-panel.jsp" %>
            <%--            <%@include file="/WEB-INF/jsp/admin/admin-panel.jsp" %>--%>
            </br> </br>
        </c:when>
        <c:otherwise>
            <table>
                <tr></tr>
                <tr></tr>
                <tr>
                    <td>
                        </br>
                        <form action="./controller" method="GET">
                            <input type="hidden" name="command" value="userCabinet">
                            <input type="submit" value="${resources.Create_new_delivery_order}">
                        </form>
                        </br>
                    </td>
                    <td>
                        <form action="./controller" method="GET">
                            <input type="hidden" name="command" value="allUserDeliveries">
                            <input type="submit" value="${resources.Show_all_your_deliveries}">
                        </form>
                    </td>
                </tr>
                <tr></tr>
                <tr></tr>
            </table>
        </c:otherwise>
    </c:choose>

    <%
        int counter = 1;
    %>
    <table border="1">
        <tr>
            <th>№</th>
            <th>${resources.Order_id}</th>
            <th>${resources.City_from}</th>
            <th>${resources.City_to}</th>
            <th>${resources.Distance}</th>
            <th>${resources.Weight}</th>
            <th>${resources.Volume_of_parcel}, <i>m<sup><small>3</small></sup></i></th>
            <th>${resources.Created_date}</th>
            <th>${resources.Price}</th>
            <th>${resources.Status}</th>
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
                        ${record.item.maxWeight}
                </td>

                <td>
                        ${record.volume}
                </td>

                <td>
                    <custom:formatDate value="${record.order.createdAt}" pattern="dd.MM.yyyy HH:mm"/>
<%--                        ${record.order.createdAt}--%>
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
    </br></br>

</center>
<input type="hidden" name="referer" value="${pageContext.request.requestURI}"/>
</br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br>
<%@include file="/WEB-INF/jsp/footer.jsp" %>
</body>
</html>