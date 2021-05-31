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

<div id="content">
    <center>
        <table>
            <tr>
                <td>
                    <c:choose>
                        <c:when test="${sessionScope.user==null}">
                            <h2>REGISTRATION FORM</h2> <br>

                            <c:if test="${not empty errorMessage and empty exception and empty code}">
                                <h4 style="color:tomato">${errorMessage}</h4>
                            </c:if>
                            <form id="formRegistration" action="/null/controller?command=register" method="post">

                                <div class="field">
                                    <label>Enter your email:</label>
                                    <div class="input"><input type="text" name="email"
                                                              value='${sessionScope.user.email}'
                                                              id="email"/></div>
                                </div>

                                <div class="field">
                                    <label>Enter your name:</label>
                                    <div class="input"><input type="text" name="name"
                                                              value='${sessionScope.user.firstName}' id="name"/>
                                    </div>
                                </div>

                                <div class="field">
                                    <label>Enter your lastName:</label>
                                    <div class="input"><input type="text" name="lastName"
                                                              value='${sessionScope.user.lastName}'
                                                              id="lastName"/>
                                    </div>
                                </div>

                                <div class="field">
                                    <label>Enter your password:</label>
                                    <div class="input"><input type="password" name="password"
                                                              value="${sessionScope.user.password}"
                                                              id="password"/></div>
                                </div>

                                <div class="submit">
                                    <button type="submit">Register</button>
                                </div>

                                <c:remove var="errorMessage"/>
                                <c:remove var="user"/>
                            </form>
                        </c:when>
                    </c:choose>
                </td>

                <td>
                    </br></br>
                    <c:choose>
                        <c:when test="${errorMessages!=null}">
                            <ul style="color:tomato">
                                Error list: <br/>
                                <c:forEach items="${errorMessages}" var="i">
                                    <li><c:out value="${i}"/></li>
                                    <br/>
                                </c:forEach>
                            </ul>
                        </c:when>
                    </c:choose>
                </td>
            </tr>
        </table>
    </center>
</div>

<input type="hidden" name="referer" value="${pageContext.request.requestURI}"/>
</br></br></br></br></br></br></br></br></br></br></br></br>
<%@include file="/WEB-INF/jsp/footer.jsp" %>
</body>
</html>