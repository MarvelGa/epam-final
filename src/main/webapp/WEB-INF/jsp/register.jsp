<%@ include file="/WEB-INF/jspf/directive/page.jspf" %>
<%@ include file="/WEB-INF/jspf/directive/taglib.jspf" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
    <title>${resources.Login_form}</title>
<%--    <link href="/static/style.css" rel="stylesheet"/>--%>
</head>

<body>


    <%@include file="/WEB-INF/jsp/top.jsp" %>

<%--<%@ include file="/WEB-INF/jspf/directive/page.jspf" %>--%>
<%--<%@ include file="/WEB-INF/jspf/directive/taglib.jspf" %>--%>
<%--<%@ page isELIgnored="false" %>--%>
<%--<!DOCTYPE html>--%>
<%--  <html lang="en">--%>
<%--<head>--%>

<%--    <title>  <c:set var="title" value="${resources.Sign_up}" />    </title>--%>

<%--</head>--%>

<%--<body style="background-color: #666666;">--%>
<%--<%@include file="/WEB-INF/jsp/top.jsp" %>--%>
<%--<div class="limiter">--%>
<%--    <div class="container-login100">--%>
<%--        <div class="wrap-login100">--%>
<%--            <form class="login100-form validate-form" action="/controller?command=register" method="POST">--%>
<%--                    <span class="login100-form-title p-b-43">--%>
<%--                        ${resources.Signup_to_continue}--%>
<%--                    </span>--%>
<%--                <div class="wrap-input100 validate-input" data-validate="Name is required">--%>
<%--                    <input class="input100" type="text" name="name" placeholder='${resources.Name}'--%>
<%--                           value='${sessionScope.newUser.name}' minlength="4">--%>
<%--                    <span class="focus-input100"></span>--%>

<%--                </div>--%>

<%--                <div class="wrap-input100 validate-input" data-validate="Surname is required">--%>
<%--                    <input class="input100" type="text" name="surname" placeholder='${resources.Surname}'--%>
<%--                           value='${sessionScope.newUser.surname}' minlength="3">--%>
<%--                    <span class="focus-input100"></span>--%>

<%--                </div>--%>

<%--                <div class="wrap-input100 validate-input" data-validate="Valid email is required: ex@abc.xyz">--%>
<%--                    <input class="input100" type="email" name="email"--%>
<%--                           value='${sessionScope.newUser.email}' placeholder='${resources.Email}'>--%>
<%--                    <span class="focus-input100"></span>--%>

<%--                </div>--%>


<%--                <div class="wrap-input100 validate-input" data-validate="Password is required">--%>
<%--                    <input class="input100" type="password" id="password" name="password" minlength="4"--%>
<%--                           placeholder='${resources.Password}'>--%>
<%--                    <span class="focus-input100"></span>--%>

<%--                </div>--%>


<%--                <div class="wrap-input100 validate-input" data-validate="Password is required">--%>
<%--                    <input class="input100" type="password" id="repeat-password" name="repeat-password"--%>
<%--                           minlength="4" placeholder='${resources.Repeat_password}'>--%>
<%--                    <span class="focus-input100"></span>--%>

<%--                </div>--%>
<%--                <div id='error' class='text-right'></div>--%>
<%--                <div class="container-login100-form-btn">--%>
<%--                    <button class="login100-form-btn" id='submit-button'>--%>
<%--                        ${resources.sign_up}--%>
<%--                    </button>--%>
<%--                </div>--%>

<%--                <div class="text-center p-t-46 p-b-20">--%>
<%--                        <span class="txt2">--%>
<%--                            or <a href="/controller?command=login">${resources.Login}</a>--%>
<%--                        </span>--%>
<%--                </div>--%>
<%--                <div class='text-center h5 text-danger'>--%>
<%--                    ${sessionScope.errorSignUp}--%>
<%--                </div>--%>
<%--                <c:remove var="errorSignUp" />--%>
<%--                <c:remove var="newUser" />--%>
<%--            </form>--%>
<%--            <div class="login100-more" style="background-image: url('images/bg-02.jpg');">--%>
<%--            </div>--%>
<%--        </div>--%>
<%--    </div>--%>
<%--    <p id="test"></p>--%>
<%--</div>--%>
<%--<%@include file="/WEB-INF/jsp/footer.jsp" %>--%>
<%--</body>--%>

<%--  </html>--%>

<div id="content">
    <center>
        <table>
            <tr>
                <td>
                    <c:choose>
                        <c:when test="${sessionScope.users==null}">
                            <h2>REGISTER</h2> <br>

                            <c:if test="${not empty errorMessage and empty exception and empty code}">
                                <h3 style="color:tomato">${errorMessage}</h3>
                            </c:if>

                            <form id="formRegistration" action="/null/controller?command=register" method="post">

                                <div class="field">
                                    <label>Enter your email:</label>
                                    <div class="input"><input type="text" name="email" value="${(users.login)}"
                                                              id="login"/></div>
                                </div>

                                <div class="field">
                                    <label>Enter your name:</label>
                                    <div class="input"><input type="text" name="name" value="${users.name}" id="name"/>
                                    </div>
                                </div>

                                <div class="field">
                                    <label>Enter your lastName:</label>
                                    <div class="input"><input type="text" name="lastName" value="${users.name}" id="lastName"/>
                                    </div>
                                </div>

                                <div class="field">
                                    <label>Enter your password:</label>
                                    <div class="input"><input type="password" name="password"
                                                              value="${users.password1.equals(users.password2)?users.password1:""}"
                                                              id="password1"/></div>
                                </div>


                                <div class="submit">
                                    <button type="submit">Register</button>
                                </div>
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

        </br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br>
        <%@include file="/WEB-INF/jsp/footer.jsp" %>
</body>
</html>