<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Реестр запрещенных сайтов</title>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/main.css">
</head>
<body ng-app="registryOfProhibitedSites">
<div class="container" ng-controller="AppCtrl">
    <div class="col-md-10">
        <div class="panel panel-default">
            <div class="panel-heading">Реестр запрещенных сайтов</div>
            <menu>
                <ul>
                    <a href="http://localhost:8080/registry" class="btn btn-primary" role="button">
                        <li>
                            Список сайтов
                        </li>
                    </a>
                    <a href="http://localhost:8080/addsite" class="btn btn-primary" role="button">
                        <li>
                            Добавить сайт в список
                        </li>
                    </a>
                    <a href="http://localhost:8080/deletesite" class="btn btn-primary" role="button">
                        <li>
                            Удалить сайт из списка
                        </li>
                    </a>
                </ul>
            </menu>
            <div class="panel-body">
                <table class="table table-striped">
                    <thead>
                    <tr>
                        <th>Ссылка</th>
                        <th>IP-адрес</th>
                        <th>Дата внесения в реестр</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr ng-repeat="item in registry">
                        <td><a href="">{{item.link}}</a></td>
                        <td>{{item.ip}}</td>
                        <td>{{item.date}}</td>
                    </tr>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>

<script src="http://cdnjs.cloudflare.com/ajax/libs/angular.js/1.4.2/angular.min.js"></script>
<script type="text/javascript" src="js/main.js"></script>
</body>
</html>