<html>
<head>
    <title>Мои заказы</title>
    <link href="/css/styles.css" rel="stylesheet" type="text/css">
</head>
<body>
<div class="form-style-2">
    <div class="form-style-2-heading">
        Мои заказы
    </div>
    <table>
        <tr>
            <th>Order Id</th>
            <th>Name</th>
            <th>Description</th>
            <th>Location</th>
            <th>Start Date</th>
            <th>End Date</th>
            <th>Time Key</th>
        </tr>
        <#list userOrders as order>
            <tr>
                <td>${order.orderId}</td>
                <td>${order.name}</td>
                <td>${order.description}</td>
                <td>${order.location}</td>
                <td>${order.startDate}</td>
                <td>${order.endDate}</td>
                <td>${order.timeKey}</td>
                <td>
                    <input type="submit" value="Отменить">
                </td>
            </tr>
        </#list>
    </table>
    <input type="button" onclick="history.back();" value="Назад"/>
</div>
</body>
</html>