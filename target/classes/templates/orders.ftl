<html>
<head>
    <title>Мои заказы</title>
    <link href="/css/styles.css" rel="stylesheet" type="text/css">
</head>
<body>
<#if error??>
    <div class="alert alert-danger" role="alert">Нельзя отменить тур после его начала</div>
</#if>
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
                    <form method="post" action="/orders">
                        <input type="hidden" name="order" value="${order.orderId}">
                        <input type="hidden" name="tour" value="${order.tourId}">
                        <input type="hidden" name="startdate" value="${order.startDate}">
                        <input type="submit" value="Отменить">
                    </form>

                </td>
            </tr>
        </#list>
    </table>
    <input type="button" onclick="location.href = '/profile';" value="Назад"/>
</div>
</body>
</html>