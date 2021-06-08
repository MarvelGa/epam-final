<%@ include file="/WEB-INF/jspf/directive/page.jspf" %>
<%@ include file="/WEB-INF/jspf/directive/taglib.jspf" %>
<%@ taglib uri="/WEB-INF/tld/custom.tld" prefix="custom" %>
<%@ page isELIgnored="false" %>

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>${resources.View_of_orders_delivery}</title>
    <meta charset="UTF-8"/>
    <link href="/static/style.css" rel="stylesheet"/>
</head>
<body>
<center>
    <%@include file="/WEB-INF/jsp/top.jsp" %>
    <h3>${resources.View_of_orders_delivery}</h3>

    <p><a href="/tct/controller?command=adminCabinet"> ${resources.Go_to_main_admin_page}!</a></p>
    <c:choose>
        <c:when test="${requestScope.orderItemList.size()!=0}">
            </br>
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
                    <th>${resources.Last_status_update_data}</th>
                    <th>${resources.Price}</th>
                    <th>${resources.Status}</th>
                </tr>
                <c:forEach var="record" items="${requestScope.orderItemList}">
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

                    </tr>
                </c:forEach>
            </table>
        </c:when>
        <c:otherwise>
            <center><h2>${resources.You_have_no_order_delivery_yet}!</h2></center>
        </c:otherwise>
    </c:choose>
    <br>

</center>
<input type="hidden" name="referer" value="${pageContext.request.requestURI}"/>
</br>
<%@include file="/WEB-INF/jsp/footer.jsp" %>
</body>
</html>