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
    <center><h4>All your order deliveries</h4></center>
    </br>








    <%
        int counter = 1;
    %>
    <table border="1">
        <tr>
            <th>No.</th>
            <th>Order ID</th>
            <th>Products total Price</th>
            <th>Product Name</th>
            <th>Products Quantity</th>
            <th>Order Created Date</th>
        </tr>
        <c:forEach var="record" items="${orderItems}">
            <tr>
                <td><%=counter++%>
                </td>
                <td>${record.order_id}
                </td>
                <td>
                    <c:out value="${record.product_price * record.quantity}"/>
                </td>
                <td>
                        ${record.product_name}
                </td>
                <td>
                        ${record.quantity}
                </td>
                <td>
                        ${record.time}
                </td>
            </tr>
        </c:forEach>
    </table>
    <br>





</center>
<input type="hidden" name="referer" value="${pageContext.request.requestURI}" />
<center><h1>Welcome to FIRST AIR TRANSPORT COMPANY!</h1></center>
</br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br>
<%@include file="/WEB-INF/jsp/footer.jsp" %>
</body>
</html>
