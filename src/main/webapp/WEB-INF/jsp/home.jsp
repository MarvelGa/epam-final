<%@ include file="/WEB-INF/jspf/directive/page.jspf" %>
<%@ include file="/WEB-INF/jspf/directive/taglib.jspf" %>
<%@ page isELIgnored="false" %>

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>Home page</title>
    <meta charset="UTF-8"/>
    <link href="/static/style.css" rel="stylesheet"/>
</head>
<body>
<center>
    <%@include file="/WEB-INF/jsp/top.jsp" %>
    <h1>Welcome to FIRST AIR TRANSPORT COMPANY!</h1>
    <h3>We proceed carry out delivery on such routes!
        Price depends also from weight and volume of parcel.</h3>

    <p>Have already registered?<a href="/null/controller?command=loginPage"> Login to order the delivery!</a></p>
    <p>Not registered yet?<a href="/null/controller?command=registration"> Go to Registration Page</a></p>
    <%
        int counter = 1;
    %>
    <table border="1">
        <tr>
            <th>No.</th>
            <th>City FROM</th>
            <th>City TO</th>
            <th>Distance, km</th>
            <th>Minimum Price</th>
        </tr>
        <c:forEach var="record" items="${requestScope.data}">
            <tr>
                <td>
                    <%=counter++%>
                </td>

                <td>
                        ${record.cityFrom}
                </td>

                <td>
                        ${record.cityTo}
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
                    from ${RESULT}
                </td>
            </tr>
        </c:forEach>
    </table>


</center>
<input type="hidden" name="referer" value="${pageContext.request.requestURI}"/>
</br></br></br></br></br></br></br></br></br></br>
<%@include file="/WEB-INF/jsp/footer.jsp" %>
</body>
</html>