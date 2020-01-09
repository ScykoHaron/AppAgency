<html>
<head>
    <title>Туда и обратно</title>
    <link href="/css/styles.css" rel="stylesheet" type="text/css">
</head>
<body>
<div class="form-style-2">
    <div class="form-style-2-heading">
        Добро пожаловать на сайт турагентства "Туда и обратно"
    </div>

    <form method="post" action="/login">
    <label for="login">Login:
        <input class="input-field" type="text"  id="login" name="email">
    </label>
    <label for="password">Password:
        <input class="input-field" type="password" id="password" name="password">
    </label>

    <input type="submit" value="Войти">
    </form>

    <form method="get" action="/signup">
    <input type="submit" value="Регистрация">
    </form>

    <form method="get" action="/tours">
    <input type="submit" value="Посмотреть туры">
    </form>
</div>
</body>
</html>