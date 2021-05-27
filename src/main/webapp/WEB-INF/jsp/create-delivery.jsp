<%@ include file="/WEB-INF/jspf/directive/page.jspf" %>
<%@ include file="/WEB-INF/jspf/directive/taglib.jspf" %>
<%@ page isELIgnored="false" %>

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>Create new Delivery</title>
    <meta charset="UTF-8"/>
    <link href="/static/style.css" rel="stylesheet"/>
</head>

<body>

<center>
    <%@include file="/WEB-INF/jsp/top.jsp" %>

    <form action="/create-delivery/add/${distance.id}" method="POST">
        <table border="1">
            <tr>
                <th>City From</th>
                <th>City To</th>
                <th>Distance</th>
                <th>Choose weight</th>
                <th>Choose length</th>
                <th>Choose width</th>
                <th>Choose height</th>
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
            <input type="submit" value="Create order"/>
        </th>
        <input type="hidden" name="command" value="postCreateDelivery">
        <input type="hidden" name="id" value="${distance.id}">
    </form>


</center>


<%--<input type="hidden" name="referer" value="${pageContext.request.requestURI}" />--%>
<center><h1>Welcome to FIRST AIR TRANSPORT COMPANY!</h1></center>
</br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br>
<%@include file="/WEB-INF/jsp/footer.jsp" %>
</body>
</html>