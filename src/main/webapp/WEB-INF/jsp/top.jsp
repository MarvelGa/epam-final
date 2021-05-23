<center>

    <table border="0">

        <tr>
            <th><a href="controller?command=home">${resources.Home_page}</a> | </th>
<%--            <th><a href="${pageContext.request.contextPath}/home">${resources.Home_page}</a> | </th>--%>
            <th><a href="controller?command=loginPage">${resources.Login}</a> | </th>
            <th><a href="controller?command=registration">Register</a> | </th>
            <th><a href="/gtc/controller?command=calculator">Calculator</a> | </th>
            <th><a href="/gtc/controller?command=order">Order</a></th>
            <th></th>
            <th></th>
            <th></th>
            <th></th>
            <th>
                <a href='changeLocale' class='langstyle'>${resources.EN}</a>
                <strong style='width:2px'>|</strong>
                <a href='changeLocale?locale=ru' class='langstyle'>${resources.RU}</a>
            </th>

            <th>
            <div class="user">

                <c:if test="${not empty nameOfUser}"><p>Hello ${nameOfUser}!</p> </c:if>
            </div>
            <div class="message" style="color: #0f0425">
                <c:if test="${not empty message}">
                    <p>${message}.</p>
                </c:if>
            </div>
            </th>


            <th align= "right">
            <c:choose>

                <c:when test = "${sessionScope.user!=null}">
                    <h3 style="color:forestgreen">Hello, ${sessionScope.user.firstName}</h3></br>
                    <h3 style="color:forestgreen">You entered as ${sessionScope.user.roleId.equals(1)?"ADMIN":"USER"}</h3></br>
                    <form action='./login' method='post'>
                        <input type='hidden' name='logout' />
                        <input type='submit' value='LOGOUT'/>
                    </form>
                </c:when>

                <c:otherwise>
                    <h3 style="color:forestgreen">Hello, Guest</h3></br>
                </c:otherwise>

            </c:choose>
            </th>

        </tr>

    </table>


</center>