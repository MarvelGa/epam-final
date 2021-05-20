<%@ include file="/WEB-INF/jspf/directive/page.jspf" %>
<%@ include file="/WEB-INF/jspf/directive/taglib.jspf" %>
<%@ page isELIgnored="false" %>
<html>
<c:set var="title" value="Error" scope="page" />
<body>
<!-- header -->
<header>
    <title>Error page</title>
</header>
<!-- header -->
<%@include file="/WEB-INF/jsp/top.jsp" %>

<div class="container">
    <div class="col-6 justify-content-center h-50">
        <div class="bg-info h3 font-weight-bold text-center mt-5">${lang.The_following_error_occurred}</div>
        <c:set var="code" value="${requestScope['javax.servlet.error.status_code']}" />
        <c:set var="message" value="${requestScope['javax.servlet.error.message']}" />
        <c:set var="exception" value="${requestScope['javax.servlet.error.exception']}" />
        <c:if test="${not empty code}">
            <div class="alert alert-danger">Error code: ${code}</div>
        </c:if>
        <c:if test="${not empty message}">
            <div class="alert alert-danger">${message}</div>
        </c:if>
        <c:if test="${not empty exception}">
            ${exception.message}
        </c:if>
        <%-- if we get this page using forward --%>
        <c:if test="${not empty requestScope.errorMessage}">
            <div class="alert alert-danger">${requestScope.errorMessage}</div>
        </c:if>
    </div>
</div>
<!-- footer section -->
</br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br>
<%@include file="/WEB-INF/jsp/footer.jsp" %>
<!-- /footer section -->

</body>

</html>