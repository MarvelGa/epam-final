<center>
<table>
    <tr>
        <td colspan="2">
            </br>
            <form action="./controller" method="GET">
                <input type="hidden" name="command" value="getAllUsersOrders">
                <input type="submit" value="${resources.Change_status_and_all_data}">
            </form>
            </br>
        </td>
        <td colspan="2">
            <form action="./controller" method="GET">
                <input type="hidden" name="command" value="getOrders">
                <input type="submit" value="${resources.Display_all_orders}">
            </form>
        </td>

        <td colspan="2">
            <form action="./controller" method="GET">
                <input type="hidden" name="command" value="displayAllUsers">
                <input type="submit" value="${resources.Display_all_users}">
            </form>
        </td>
    </tr>

    <table>
    <tr>
        <td colspan="3" align="right" >
            <form action="./controller" method="GET">
                <input type="hidden" name="command" value="createOrderByAdmin">
                <input type="submit" value="${resources.Create_order_delivery}">
            </form>
        </td>

        <td colspan="3" align="left" >
            <form action="./controller" method="GET">
                <input type="hidden" name="command" value="allUserDeliveries">
                <input type="submit" value="${resources.Show_all_my_deliveries}">
            </form>
        </td>
    </tr>
        </table>
</table>
    </center>