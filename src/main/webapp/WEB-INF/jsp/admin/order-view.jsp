<%@ include file="/WEB-INF/jspf/directive/page.jspf" %>
<%@ include file="/WEB-INF/jspf/directive/taglib.jspf" %>
<%@ taglib uri="/WEB-INF/tld/custom.tld" prefix="custom" %>
<%@ page isELIgnored="false" %>

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>${resources.View_data_of_delivery}</title>
    <meta charset="UTF-8"/>
    <link href="/static/style.css" rel="stylesheet"/>
</head>
<body>
<center>
    <%@include file="/WEB-INF/jsp/top.jsp" %>
    <h3>${resources.View_data_of_delivery}</h3>
    <%
        int counter = 1;
    %>
    <p><a href="/tct/controller?command=adminCabinet"> ${resources.Go_to_main_admin_page}!</a></p>
    <a href="/tct/controller?command=getAllUsersOrders"> ${resources.Back_to_previously_page}!</a>
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
                <c:set var="city" value="${record.item.cityFrom}"/>
                ${resources[city]}
            </td>

            <td>
                <c:set var="city" value="${record.item.cityTo}"/>
                ${resources[city]}
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
                        <label for="status">${resources.Change_status}</label>
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
                    <input type="submit" value="${resources.Confirm_changing_status}"/>
                </td>
            </tr>
        </form>

    </table>
    </br>

</center>
<input type="hidden" name="referer" value="${pageContext.request.requestURI}"/>
</br></br>
<%@include file="/WEB-INF/jsp/footer.jsp" %>
</body>
</html>