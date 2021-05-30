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
<center>
    <%@include file="/WEB-INF/jsp/top.jsp" %>

    <h2>Login Page</h2> <br>
    <br>
    <p>Not registered yet?<a href="/null/controller?command=registration"> Go to Registration Page</a></p>
    </br>
    <c:if test="${not empty errorMessage and empty exception and empty code}">
        <h3 style="color:tomato">${errorMessage}</h3>
    </c:if>

    <c:choose>
    <c:when test="${sessionScope.user==null }">

    <table class="table" style="background-color: #ECF0F1"  padding: 5px; border: 1px solid #fff;>
        <td padding: 5px; border: 1px solid #fff;>
            <form id="loginForm" action="/null/controller?command=authorization" method="post">

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

<c:remove var="email"/>
<c:remove var="errorMessage"/>

</br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br>
<input type="hidden" name="referer" value="${pageContext.request.requestURI}"/>
<%@include file="/WEB-INF/jsp/footer.jsp" %>

</body>
</html>


