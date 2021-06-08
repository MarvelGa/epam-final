<c:choose>
    <c:when test="${sessionScope.user.roleId==1}">
        <p><a href="/tct/controller?command=adminCabinet">${resources.Go_to_main_admin_page}!</a></p>
    </c:when>
    <c:otherwise>
        <a href="/tct/controller?command=userCabinet">${resources.Go_to_delivery_list_page}</a>
    </c:otherwise>
</c:choose>