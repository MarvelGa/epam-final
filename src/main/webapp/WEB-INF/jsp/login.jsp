<%@ include file="/WEB-INF/jspf/directive/page.jspf" %>
<%@ include file="/WEB-INF/jspf/directive/taglib.jspf" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
    <title>Login form</title>
</head>

<body>

<center>
    <%@include file="/WEB-INF/jsp/top.jsp" %>
<%--    <h3 style="color:tomato"> ${errorObj.errorAuthorization} </h3>--%>

    <c:if test="${not empty errorMessage and empty exception and empty code}">
        <h3 style="color:tomato">${errorMessage}</h3>
    </c:if>
<%--<h3 style="color:tomato"> ${errorObj.errorAuthorization} </h3>--%>
<%--<c:choose>--%>
<%--    <c:when test="${sessionScope.users==null }">--%>
<%--        <form id="loginForm" action="/controller" method="post">--%>
<%--            <div class="field">--%>
<%--                </br></br><label>Enter your login:</label>--%>
<%--                <div class="input"><input type="text" name="login" value="${users.login}" id="login"/></div>--%>
<%--            </div>--%>

<%--            <div class="field">--%>
<%--                <label>Enter your password:</label>--%>
<%--                <div class="input"><input type="password" name="password" id="pass"/></div>--%>
<%--            </div>--%>

<%--            <div class="submit">--%>
<%--                <button type="submit">Enter</button>--%>
<%--                <label id="remember"><input name="" type="checkbox" value=""/> Remember me</label>--%>
<%--            </div>--%>
<%--            <input type="hidden" name ="command" value="authorization" >--%>
<%--        </form>--%>
<%--    </c:when>--%>
<%--</c:choose>--%>
<%--</div>--%>

<form id="loginForm" action="/controller" method="post">
    <div class="field">
        </br></br><label>Enter your login:</label>
        <div class="input"><input type="text" name="login" id="login"/></div>
    </div>

    <div class="field">
        <label>Enter your password:</label>
        <div class="input"><input type="password" name="password" id="pass"/></div>
    </div>

    <div class="submit">
        <button type="submit">Enter</button>
    </div>
    <input type="hidden" name ="command" value="authorization" >

    </br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br>
    <%@include file="/WEB-INF/jsp/footer.jsp" %>
</form>
</center>
</body>
</html>


