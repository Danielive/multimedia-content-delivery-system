<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--DOM--%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Система предоставления мультимедийного контента</title>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/main.css">
</head>
<body class="registryOfProhibitedSites">
<div class="container">
    <div class="row">
        <div class="col-md-10">
            <form class="form-horizontal" action="music" method="POST">
                <div class="panel-heading">Музыка</div>
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
                        <a href="http://localhost:8080/music" class="btn btn-primary" role="button">
                            <li>
                                Музыка
                            </li>
                        </a>
                    </ul>
                </menu>

                <img src="content/photos/1.jpg" width="768" height="600">
                <br>

                <video width="600" height="400" controls="controls">
                    <source src="content/videos/1.mp4" type="video/mp4">
                </video>
                <br>

                <audio width="600" height="400" controls>
                    <source src="content/music/1.mp3" type="audio/mpeg">
                </audio>
                <br>

                <legend>Музыка</legend>
                <div class="form-group">
                    <label class="col-sm-4 control-label">Название</label>
                    <c:if test="${not empty allMusic}">
                        <select class="form-control" name="id">
                            <c:forEach var="music" items="${allMusic}">
                                <option value=${music.id}>${music.name}, ${music.link}</option>
                            </c:forEach>
                        </select>
                    </c:if>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>