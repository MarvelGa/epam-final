<c:choose>
    <c:when test="${sessionScope.user.roleId==1}">
        </br>
        <p><a href="/null/controller?command=adminCabinet"> Go to Main Admin Page!</a></p>
        </br>
    </c:when>
    <c:otherwise>
        </br>
        <a href="/null/controller?command=userCabinet">Go to Delivery List Page</a>
        </br>
    </c:otherwise>
</c:choose>