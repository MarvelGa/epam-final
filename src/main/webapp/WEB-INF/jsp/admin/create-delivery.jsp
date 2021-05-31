<%@ include file="/WEB-INF/jspf/directive/page.jspf" %>
<%@ include file="/WEB-INF/jspf/directive/taglib.jspf" %>
<%@ page isELIgnored="false" %>

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>Create Delivery By Admin</title>
    <meta charset="UTF-8"/>
    <link href="/static/style.css" rel="stylesheet"/>
</head>
<body>
<center>
    <%@include file="/WEB-INF/jsp/top.jsp" %>

    <p><a href="/null/controller?command=adminCabinet"> Go to Main Admin Page!</a></p>

    <%@include file="/WEB-INF/jsp/common/delivery.jsp" %>

</center>
<input type="hidden" name="referer" value="${pageContext.request.requestURI}" />
</br></br>
<%@include file="/WEB-INF/jsp/footer.jsp" %>
</body>
</html>