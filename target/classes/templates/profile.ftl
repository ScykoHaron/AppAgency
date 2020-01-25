<html>
<head>
    <title>Профиль</title>
    <link href="/css/styles.css" rel="stylesheet" type="text/css">
</head>
<body>
<div class="form-style-2">
    <div class="form-style-2-heading">${user.firstName + " "}${user.lastName}</div>

    <form method="get" action="/orders">
        <input type="submit" value="Мои заказы">
    </form>

    <form method="get" action="/tours">
        <input type="submit" value="Посмотреть туры">
    </form>

    <form method="get" action="/edit">
        <input type="submit" value="Редактировать аккаунт">
    </form>

    <form method="post" action="/profile">
        <input type="submit" value="Удалить аккаунт">
    </form>

    <a href="/logout">Выход</a>
</div>
</body>
</html>