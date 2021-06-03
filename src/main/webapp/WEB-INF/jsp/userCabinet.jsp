<%@ include file="/WEB-INF/jspf/directive/page.jspf" %>
<%@ include file="/WEB-INF/jspf/directive/taglib.jspf" %>
<%@ page isELIgnored="false" %>

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title> ${resources.User_personal_cabinet} </title>
    <meta charset="UTF-8"/>
</head>

<center>
    <%@include file="/WEB-INF/jsp/top.jsp" %>

    <h2>${resources.User_personal_cabinet}!</h2>

    <table>
        <tr></tr>
        <tr></tr>
        <tr>
            <td>
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

    <%@include file="/WEB-INF/jsp/common/delivery.jsp" %>
</center>
<input type="hidden" name="referer" value="${pageContext.request.requestURI}"/>
</br></br></br></br></br></br>
<%@include file="/WEB-INF/jsp/footer.jsp" %>
</body>

</html>