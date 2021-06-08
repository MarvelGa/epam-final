<%@ include file="/WEB-INF/jspf/directive/page.jspf" %>
<%@ include file="/WEB-INF/jspf/directive/taglib.jspf" %>
<%@ page isELIgnored="false" %>

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>Home page</title>
    <meta charset="UTF-8"/>
</head>
<body>

<center>
    <%@include file="/WEB-INF/jsp/top.jsp" %>
    <h2>${resources.Welcome_to_company}!</h2>
    <h3>${resources.Our_routes}!
        ${resources.About_price}.</h3>
    <c:choose>
    <c:when test="${sessionScope.user==null }">
    <p>${resources.Have_already_registered}?<a
            href="/tct/controller?command=loginPage"> ${resources.Login_to_delivery}!</a></p>
    <p>${resources.Not_registered_yet}?<a
            href="/tct/controller?command=registration"> ${resources.Go_to_registration_page}!</a></p>
    </c:when>
    </c:choose>

    <%
        int counter = 1;
    %>
    <table border="1">
        <tr>
            <th>No.</th>
            <th>${resources.City_from}</th>
            <th>${resources.City_to}</th>
            <th>${resources.City_to}</th>
            <th>${resources.Minimum_price}</th>
        </tr>
        <c:forEach var="record" items="${requestScope.data}">
            <tr>
                <td>
                    <%=counter++%>
                </td>

                <td>
                    <c:set var="city" value="${record.cityFrom}"/>
                        ${resources[city]}
                </td>

                <td>
                    <c:set var="city" value="${record.cityTo}"/>
                        ${resources[city]}
                </td>

                <td>
                        ${record.distance}
                </td>

                <td>
                    <c:set var="minPrice" value="${record.distance*1/3}"/>
                    <%
                        double value = Double.valueOf("" + pageContext.getAttribute("minPrice", PageContext.PAGE_SCOPE));
                        double scale = Math.pow(10, 2);
                        double result = Math.ceil(value * scale) / scale;
                        pageContext.getRequest().setAttribute("RESULT", result);
                    %>
                        ${resources.From} ${RESULT}
                </td>
            </tr>
        </c:forEach>
    </table>


</center>
<input type="hidden" name="referer" value="${pageContext.request.requestURI}"/>
</br></br></br></br></br></br>
<%@include file="/WEB-INF/jsp/footer.jsp" %>
</body>
</html>