
<table>
    <tr>
        <td colspan="2">
            </br>
            <form action="./controller" method="GET">
                <input type="hidden" name="command" value="getAllUsersOrders">
                <input type="submit" value="Change Status/All Data">
            </form>
            </br>
        </td>
        <td colspan="2">
            <form action="./controller" method="GET">
                <input type="hidden" name="command" value="getOrders">
                <input type="submit" value="Display All Orders">
            </form>
        </td>

        <td colspan="2">
            <form action="./controller" method="GET">
                <input type="hidden" name="command" value="displayAllUsers">
                <input type="submit" value="Display All  Users">
            </form>
        </td>
    </tr>


    <tr>
        <td colspan="3" align="right" >
            <form action="./controller" method="GET">
                <input type="hidden" name="command" value="createOrderByAdmin">
                <input type="submit" value="Create order delivery">
            </form>
        </td>

        <td colspan="3" align="left" >
            <form action="./controller" method="GET">
                <input type="hidden" name="command" value="allUserDeliveries">
                <input type="submit" value="Show All My Deliveries">
            </form>
        </td>
    </tr>
</table>