<br>
<%
    int counter = 1;
%>

<table border="1">
    <tr>
        <th>No.</th>
        <th>ID</th>
        <th>${resources.City_from}</th>
        <th>${resources.City_to}</th>
        <th>${resources.Destination}</th>
        <th colspan="1">${resources.Operation}</th>
    </tr>
    <c:forEach var="record" items="${cityAndDistance}">
        <tr>
            <td><%=counter++%>
            </td>
            <td>
                    ${record.id}
            </td>
            <td>
                <c:set var="city" value="${record.cityFrom}"/>
                    ${resources[city]}
            </td>
            <td>
                <c:set var="city" value="${record.cityTo}"/>
                    ${resources[city]}
            </td>
            <td>
                    ${record.distance}
            </td>

            <td>
                <form action="./controller" method="GET">
                    <input type="hidden" name="command" value="create-delivery">
                    <input type="hidden" name="id" value="${record.id}">
                    <input type="submit" value="${resources.Create_delivery}">
                </form>
            </td>
        </tr>
    </c:forEach>
</table>