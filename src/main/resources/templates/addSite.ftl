<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Реестр запрещенных сайтов</title>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/main.css">
</head>
<body ng-app="registryOfProhibitedSites">
<div class="container" ng-controller="AddSiteController">
    <div class="row">
        <div class="col-md-10">
            <form class="form-horizontal">
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
                <legend>Добавление сайта</legend>
                <div class="form-group">
                    <label for="link" class="col-sm-4 control-label">Ссылка</label>
                    <div class="col-sm-8">
                        <input type="text" ng-model="link" class="form-control" id="link" placeholder="Ссылка">
                    </div>
                </div>
                <div class="form-group">
                    <label for="ip" class="col-sm-4 control-label">IP-адрес</label>
                    <div class="col-sm-8">
                        <input type="text" ng-model="ip" class="form-control" id="ip" placeholder="IP-адрес">
                    </div>
                </div>
                <div class="form-group">
                    <label for="date" class="col-sm-4 control-label">Дата внесения в реестр</label>
                    <div class="col-sm-8">
                        <input type="text" ng-model="date" class="form-control" id="date" placeholder="Дата внесения в реестр">
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-8 col-sm-offset-4">
                        <button ng-click="addSite(link, ip, date)" class="btn btn-default">Добавить</button>
                    </div>
                </div>
            </form>
        </div>
    </div>

<script src="http://cdnjs.cloudflare.com/ajax/libs/angular.js/1.4.2/angular.min.js"></script>
<script type="text/javascript" src="js/main.js"></script>
</body>
</html>