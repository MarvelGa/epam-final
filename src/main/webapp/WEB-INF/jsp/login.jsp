<%@ include file="/WEB-INF/jspf/directive/page.jspf" %>
<%@ include file="/WEB-INF/jspf/directive/taglib.jspf" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
    <title>${resources.Login_form}</title>
    <link href="/static/style.css" rel="stylesheet"/>
</head>
<body>

<%@include file="/WEB-INF/jsp/top.jsp" %>

<div id="content" style="position: center">

            <c:if test="${not empty errorMessage and empty exception and empty code}">
            <h3 style="color:tomato">${errorMessage}</h3>
            </c:if>

            <c:choose>
            <c:when test="${sessionScope.user==null }">
            <form id="loginForm"  action="/null/controller?command=authorization" method="post">
                <div class="field">
                    </br></br><label>${resources.Enter_your_email}:</label>
                    <div class="input"><input type="text" name="email" id="email"/></div>
                </div>

                <div class="field">
                    <label>${resources.Enter_your_password}:</label>
                    <div class="input"><input type="password" name="password" id="pass"/></div>
                </div>

                <div class="submit">
                    <button type="submit">${resources.Enter}</button>
                </div>
                <input type="hidden" name="command" value="authorization">
                <c:remove var="email"/>
            </form>
            </c:when>
            </c:choose>

            <c:remove var="errorMessage"/>
</div>

</br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br>
<input type="hidden" name="referer" value="${pageContext.request.requestURI}"/>
<%@include file="/WEB-INF/jsp/footer.jsp" %>

</body>
</html>


