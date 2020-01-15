<html>
<head>
    <title>Туры</title>
    <link href="/css/styles.css" rel="stylesheet" type="text/css">
</head>
<body>
<div class="form-style-2">
    <div class="form-style-2-heading">
        Наши туры
    </div>
    <table>
        <tr>
            <th>Name</th>
            <th>Description</th>
            <th>Location</th>
            <th>Start Date</th>
            <th>End Date</th>
            <th>Count Limit</th>
        </tr>
        <#list allTours as tour>
            <tr>
                <td>${tour.name}</td>
                <td>${tour.description}</td>
                <td>${tour.location}</td>
                <td>${tour.startDate}</td>
                <td>${tour.endDate}</td>
                <td>${tour.countLimit}</td>
            </tr>
        </#list>
    </table>

</div>
</body>
</html>