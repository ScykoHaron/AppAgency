<html>
<head>
    <title>Регистрация</title>
    <link href="/css/styles.css" rel="stylesheet" type="text/css">
</head>
<body>
<#if error??>
    <div class="alert alert-danger" role="alert">Пользователь с таким Email уже есть в базе</div>
</#if>
<div class="form-style-2">
    <div class="form-style-2-heading">
        Регистрация
    </div>
    <form method="post" action="/signup">
        <label for="first-name">Имя:
            <input class="input-field" type="text"  id="first-name" name="firstName">
        </label>
        <label for="last-name">Фамилия:
            <input class="input-field" type="text"  id="last-name" name="lastName">
        </label>
        <label for="email">Email:
            <input class="input-field" type="text"  id="email" name="email">
        </label>
            <label for="password">Password:
            <input class="input-field" type="password" id="password" name="password">
        </label>
        <label for="birthday">Дата рождения:
            <input class="input-field" type="date" id="birthday" name="birthday">
        </label>

        <input type="submit" value="Зарегистрироваться">
    </form>

    <input type="button" onclick="history.back();" value="Назад"/>

</div>
</body>
</html>