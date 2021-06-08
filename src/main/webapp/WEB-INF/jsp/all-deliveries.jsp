<%@ include file="/WEB-INF/jspf/directive/page.jspf" %>
<%@ include file="/WEB-INF/jspf/directive/taglib.jspf" %>
<%@ taglib uri="/WEB-INF/tld/custom.tld" prefix="custom" %>
<%@ page isELIgnored="false" %>

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>${resources.All_users_deliveries}</title>
    <meta charset="UTF-8"/>
    <link href="/static/style.css" rel="stylesheet"/>
</head>

<body>
<center>
    <%@include file="/WEB-INF/jsp/top.jsp" %>
    </br>
    <center><h2>${resources.All_your_order_deliveries}</h2></center>
    <%
        int counter = 1;
    %>
    <c:choose>
        <c:when test="${sessionScope.user.roleId==1}">
            <%@include file="/WEB-INF/jsp/common/bottom-panel.jsp" %>

            </br>
        </c:when>
        <c:otherwise>
            <p><a href="/tct/controller?command=userCabinet">${resources.Back_to_previously_page}!</a></p>
            </br>
        </c:otherwise>
    </c:choose>

    <c:choose>
        <c:when test="${sessionScope.allUserOrders.size()!=0}">
            <table border="1">
                <tr>
                    <th>No.</th>
                    <th>${resources.Order_id}</th>
                    <th>${resources.City_from}</th>
                    <th>${resources.City_to}</th>
                    <th>${resources.Distance}, km</th>
                    <th>${resources.Weight}, tonne</th>
                    <th>${resources.Volume_of_parcel}, <i>m<sup><small>3</small></sup></i></th>
                    <th>${resources.Created_date}</th>
                    <th>${resources.Price}</th>
                    <th>${resources.Status}</th>
                    <th>${resources.Role}</th>
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
            <center><font color='#228b22'><h2>${resources.You_have_no_order_delivery_yet}!</h2></font></center>
            </br>
            <table>
                <td>
                    <form action="./controller" method="GET">
                        <input type="hidden" name="command" value="userCabinet">
                        <input type="submit" value="${resources.Create_delivery_order}">
                    </form>
                </td>
            </table>
        </c:otherwise>
    </c:choose>
    </br>

</center>
<input type="hidden" name="referer" value="${pageContext.request.requestURI}"/>
</br></br></br></br></br></br>
<%@include file="/WEB-INF/jsp/footer.jsp" %>
</body>
</html>
