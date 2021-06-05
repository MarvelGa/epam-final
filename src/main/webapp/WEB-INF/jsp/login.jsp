<%@ include file="/WEB-INF/jspf/directive/page.jspf" %>
<%@ include file="/WEB-INF/jspf/directive/taglib.jspf" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
    <title>${resources.Login_form}</title>
</head>
<body>
<center>
    <%@include file="/WEB-INF/jsp/top.jsp" %>
    <h2>${resources.Login_form}</h2>
    <c:choose>
    <c:when test="${sessionScope.user==null }">
    <p>Not registered yet?<a href="/tct/controller?command=registration"> Go to Registration Page</a></p>
    <c:if test="${not empty errorMessage and empty exception and empty code}">
        <h3 style="color:tomato">${errorMessage}</h3>
    </c:if>
    <table class="table">
        <td padding: 5px; border: 1px solid #fff;>
            <form id="loginForm" action="/tct/controller?command=authorization" method="post">
                <div class="field">
                    <br><br><label>Enter your email:</label>
                    <div class="input"><input type="text" name="email" id="email"></div>
                </div>
                <div class="field">
                    <label>Enter your password:</label>
                    <div class="input"><input type="password" name="password" id="pass"></div>
                </div>
                <div class="submit">
                    <button type="submit">Enter</button>
                </div>
                <input type="hidden" name="command" value="authorization">
            </form>
        </td>
    </table>
</center>
</c:when>
</c:choose>
</div>
<c:remove var="email"/>
<c:remove var="errorMessage"/>

</br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br>
<input type="hidden" name="referer" value="${pageContext.request.requestURI}"/>
<%@include file="/WEB-INF/jsp/footer.jsp" %>

</body>
</html>


