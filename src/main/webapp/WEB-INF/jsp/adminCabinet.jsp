<%@ include file="/WEB-INF/jspf/directive/page.jspf" %>
<%@ include file="/WEB-INF/jspf/directive/taglib.jspf" %>
<%@ page isELIgnored="false" %>

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>Admin Personal Cabinet</title>
    <meta charset="UTF-8"/>
    <link href="/static/style.css" rel="stylesheet"/>
</head>
<body>
<center>
    <%@include file="/WEB-INF/jsp/top.jsp" %>
    <table>
        <tr></tr>
        <tr></tr>
        <tr>
            <td>
                </br>
                <form action="./controller" method="GET">
                    <input type="hidden" name="command" value="getAllUsersOrders">
                    <input type="submit" value="Display All Users' Orders">
                </form>
                </br>
            </td>
            <td>
                <form action="./controller" method="GET">
                    <input type="hidden" name="command" value="allUserDeliveries">
                    <input type="submit" value="Display All  Orders">
                </form>
            </td>
        </tr>
        <tr></tr>
        <tr></tr>
    </table>





</center>
<input type="hidden" name="referer" value="${pageContext.request.requestURI}" />
<center><h1>AdminCabinet!</h1></center>
</br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br>
<%@include file="/WEB-INF/jsp/footer.jsp" %>
</body>
</html>