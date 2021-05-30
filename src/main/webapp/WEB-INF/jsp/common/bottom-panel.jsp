<c:choose>
    <c:when test="${sessionScope.user.roleId==1}">
        <p><a href="/null/controller?command=adminCabinet"> Go to Main Admin Page!</a></p>
    </c:when>
    <c:otherwise>
        <a href="/null/controller?command=userCabinet">Go to Delivery List Page</a>
    </c:otherwise>
</c:choose>