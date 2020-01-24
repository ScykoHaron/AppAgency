<html>
<head>
    <title>Редактирование</title>
    <link href="/css/styles.css" rel="stylesheet" type="text/css">
</head>
<body>
<div class="form-style-2">
    <div class="form-style-2-heading">
        Редактирование
    </div>
    <form method="post" action="/edit">
        <label for="first-name">Имя:
            <input class="input-field" type="text"  id="first-name" name="value">
            <input type="hidden"  id="first-name" name="field" value="first_name">
            <input type="submit" value="Изменить">
        </label>
    </form>

    <form method="post" action="/edit">
        <label for="last-name">Фамилия:
            <input class="input-field" type="text"  id="last-name" name="value">
            <input type="hidden"  id="last-name" name="field" value="last_name">
            <input type="submit" value="Изменить">
        </label>
    </form>

    <form method="post" action="/edit">
        <label for="password">Password:
            <input class="input-field" type="password" id="password" name="value">
            <input type="hidden"  id="password" name="field" value="password">
            <input type="submit" value="Изменить">
        </label>
    </form>

    <form method="post" action="/edit">
        <label for="birthday">Дата рождения:
            <input class="input-field" type="date" id="birthday" name="value">
            <input type="hidden"  id="birthday" name="field" value="birthday">
            <input type="submit" value="Изменить">
        </label>
    </form>

    <input type="button" onclick="location.href = '/profile';" value="Назад"/>

</div>
</body>
</html>