<center>
    <table border="0">
        <tr>

            <th><h3><a href="controller?command=home">${resources.Home_page}</a> |</h3></th>
            <th><h3><a href="controller?command=loginPage">${resources.Login}</a> |</h3></th>
            <th><h3><a href="controller?command=registration">Registration Page</a> |</h3></th>
            <th><h3><a href="controller?command=registration">Our Routes/Rate</a> |</h3></th>
            <th><h3><a href="controller?command=registration">About us</a> |</h3></th>
            <th><h3>
                <a href='changeLocale' class='langstyle'>${resources.EN}</a>
                <strong style='width:2px'>|</strong>
                <a href='changeLocale?locale=ru' class='langstyle'>${resources.RU}</a>
            </h3>
            </th>
        </tr>
    </table>

    <div style="position: absolute; top: 8px; right: 100px;font-size: 14px;">
        <table>
            <tr>
                <th>
                    <c:choose>
                        <c:when test="${sessionScope.user!=null}">
                            <h4 style="color:forestgreen">Hello, ${sessionScope.user.firstName}!</h4>
                            <h4 style="color:forestgreen">You've entered as ${sessionScope.userRole}</h4>
                            <c:choose>
                                <c:when test="${sessionScope.user.roleId==1}">
                                    <a href="/null/controller?command=adminCabinet">${resources.Personal_cabinet}</a>
                                </c:when>
                                <c:otherwise>
                                    <a href="/null/controller?command=userCabinet">${resources.Personal_cabinet}</a>
                                    <a href="/null/controller?command=allUserDeliveries">${resources.All_your_delivery}</a>
                                </c:otherwise>
                            </c:choose>


                            <form action='' method="get">
                                </br>
                                <input type='submit' value='${resources.Log_out}'/>
                                <input type="hidden" name="command" value="logout">
                            </form>
                        </c:when>
                        <c:otherwise>
                            <h3 style="color:forestgreen">${resources.Hello_guest}!</h3>
                            <h3 style="color:forestgreen">${resources.Please_login}</h3>
                        </c:otherwise>
                    </c:choose>
                </th>
            </tr>
        </table>
    </div>

</center>