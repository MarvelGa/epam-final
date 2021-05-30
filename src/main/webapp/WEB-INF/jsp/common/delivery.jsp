<br>
<%
    int counter = 1;
%>

<table border="1">
    <tr>
        <th>No.</th>
        <th>ID</th>
        <th>City FROM</th>
        <th>City TO</th>
        <th>Destination</th>
        <th colspan="1">Operation</th>
    </tr>
    <c:forEach var="record" items="${cityAndDistance}">
        <tr>
            <td><%=counter++%>
            </td>
            <td>
                    ${record.id}
            </td>
            <td>
                    ${record.cityFrom}
            </td>
            <td>
                    ${record.cityTo}
            </td>
            <td>
                    ${record.distance}
            </td>

            <td>
                <form action="./controller" method="GET">
                    <input type="hidden" name="command" value="create-delivery">
                    <input type="hidden" name="id" value="${record.id}">
                    <input type="submit" value="Create delivery">
                </form>
            </td>
        </tr>
    </c:forEach>
</table>