<%@ include file="/WEB-INF/jspf/directive/page.jspf" %>
<%@ include file="/WEB-INF/jspf/directive/taglib.jspf" %>
<%@ page isELIgnored="false" %>

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>Admin Personal Cabinet</title>
    <meta charset="UTF-8"/>
</head>
<body>
<center>
    <%@include file="/WEB-INF/jsp/top.jsp" %>
    <center><h1>Admin Cabinet</h1></center>
    <%@include file="/WEB-INF/jsp/admin/admin-panel.jsp" %>

</center>
<input type="hidden" name="referer" value="${pageContext.request.requestURI}" />
</br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br>
<%@include file="/WEB-INF/jsp/footer.jsp" %>
</body>
</html>