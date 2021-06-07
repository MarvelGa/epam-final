<%@ include file="/WEB-INF/jspf/directive/page.jspf" %>
<%@ include file="/WEB-INF/jspf/directive/taglib.jspf" %>
<%@ page isELIgnored="false" %>

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>${resources.Create_new_Delivery}</title>
    <meta charset="UTF-8"/>
    <link href="/static/style.css" rel="stylesheet"/>
</head>

<body>
<center>
    <%@include file="/WEB-INF/jsp/top.jsp" %>
    <h3>${resources.Create_new_Delivery}</h3>

    <c:choose>
        <c:when test="${sessionScope.user.roleId==1}">
            <p><a href="/tct/controller?command=adminCabinet"> ${resources.Back_to_previously_page}!</a></p>
        </c:when>
        <c:otherwise>
            <a href="/tct/controller?command=userCabinet">${resources.Back_to_previously_page}!</a>
            </br></br> </br>
        </c:otherwise>
    </c:choose>


    <form action="/tct/controller?command=postCreateDelivery" method="POST">
        <table border="1">
            <tr>
                <th>${resources.City_from}</th>
                <th>${resources.City_to}</th>
                <th>${resources.Distance}</th>
                <th>${resources.Choose_weight}</th>
                <th>${resources.Choose_length}</th>
                <th>${resources.Choose_width}</th>
                <th>${resources.Choose_height}</th>
            </tr>

            <tr>
                <td>
                    ${distance.cityFrom}
                </td>
                <td>
                    ${distance.cityTo}
                </td>

                <td>
                    ${distance.distance}
                </td>

                <td>
                    <select name="weight">
                        <option value="1" selected="selected">1</option>
                        <option value="2">2</option>
                        <option value="3">3</option>
                        <option value="4">4</option>
                        <option value="5">5</option>
                        <option value="6">6</option>
                        <option value="7">7</option>
                    </select>
                </td>

                <td>
                    <select name="length">
                        <option value="1" selected="selected">1</option>
                        <option value="2">2</option>
                        <option value="3">3</option>
                        <option value="4">4</option>
                        <option value="5">5</option>
                        <option value="6">6</option>
                        <option value="7">7</option>
                    </select>
                </td>

                <td>
                    <select name="width">
                        <option value="1" selected="selected">1</option>
                        <option value="2">2</option>
                        <option value="3">3</option>
                        <option value="4">4</option>
                        <option value="5">5</option>
                        <option value="6">6</option>
                        <option value="7">7</option>
                    </select>
                </td>

                <td>
                    <select name="height">
                        <option value="1" selected="selected">1</option>
                        <option value="2">2</option>
                        <option value="3">3</option>
                        <option value="4">4</option>
                        <option value="5">5</option>
                        <option value="6">6</option>
                        <option value="7">7</option>
                    </select>
                </td>
            </tr>
        </table>
        </br>

        <th style="'background-color: #228b22'">
            <input type="submit" value="${resources.Create_order}"/>
        </th>
        <input type="hidden" name="command" value="postCreateDelivery">
        <input type="hidden" name="id" value="${distance.id}">
    </form>


</center>
<input type="hidden" name="referer" value="${pageContext.request.requestURI}"/>
</br></br>
<%@include file="/WEB-INF/jsp/footer.jsp" %>
</body>
</html>