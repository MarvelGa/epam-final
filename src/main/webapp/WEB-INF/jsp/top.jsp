<center>
    <table border="0">
        <tr>
            <th><a href="controller?command=home">${resources.Home_page}</a> |</th>
            <%--            <th><a href="${pageContext.request.contextPath}/home">${resources.Home_page}</a> | </th>--%>
            <th><a href="controller?command=loginPage">${resources.Login}</a> |</th>
            <th><a href="controller?command=registration">Register</a> |</th>
            <th><a href="/gtc/controller?command=calculator">Calculator</a> |</th>
            <th><a href="/gtc/controller?command=order">Order</a></th>
            <th>
                <a href="/controller?command=login">${resources.Login}</a>
            </th>
            <th></th>
            <th></th>
            <th></th>
            <th>
                <a href='changeLocale' class='langstyle'>${resources.EN}</a>
                <strong style='width:2px'>|</strong>
                <a href='changeLocale?locale=ru' class='langstyle'>${resources.RU}</a>
            </th>
            <th>
                <c:choose>
                    <c:when test="${sessionScope.user!=null}">
                        <h4 style="color:forestgreen">Hello, ${sessionScope.user.firstName}</h4></br>
                        <h4 style="color:forestgreen">You've entered
                            as ${sessionScope.userRole}</h4></br>
                        <c:choose>
                            <c:when test="${sessionScope.user.roleId==1}">
                                </br>
                                <a href="/null/controller?command=adminCabinet">${resources.Personal_cabinet}</a>
                                </br>
                            </c:when>
                            <c:otherwise>
                                </br>
                                <a href="/null/controller?command=userCabinet">${resources.Personal_cabinet}</a>
                                </br></br>
                                <a href="/null/controller?command=allUserDeliveries">${resources.All_your_delivery}</a>
                                </br>
                            </c:otherwise>
                        </c:choose>

                        </br>
                        <form action='' method="get">
                            <input type='submit' value='${resources.Log_out}'/>
                            <input type="hidden" name="command" value="logout">
                        </form>
                    </c:when>
                    <c:otherwise>
                        <h3 style="color:forestgreen">${resources.Hello_guest}</h3></br>
                    </c:otherwise>
                </c:choose>
            </th>
        </tr>
    </table>
</center>