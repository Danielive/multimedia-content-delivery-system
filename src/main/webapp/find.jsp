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
        <div class="col-md-12">
            <form class="form-horizontal" action="find" method="POST">
                <div class="panel-heading">Поиск</div>
                <hr>
                <menu>
                    <ul class="navbar nav">
                        <a href="http://localhost:8080/photo">
                            <li  class="btn btn-primary" role="button">
                                Фотографии
                            </li>
                        </a>
                        <a href="http://localhost:8080/music">
                            <li  class="btn btn-primary" role="button">
                                Музыка
                            </li>
                        </a>
                        <a href="http://localhost:8080/video">
                            <li  class="btn btn-primary" role="button">
                                Видеозаписи
                            </li>
                        </a>
                        <a href="http://localhost:8080/find">
                            <li  class="btn btn-info" role="button">
                                Поиск
                            </li>
                        </a>
                    </ul>
                </menu>
                <hr>
                <div class="form-group">
                    <div class="col-sm-8">
                        <input type="text" class="form-control" id="find" placeholder="Поиск">
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-8 col-sm-offset-4">
                        <button class="btn btn-default">Найти</button>
                    </div>
                </div>
                <hr>
                <div class="form-group">
                    <c:if test="${not empty allFiles}">
                        <c:forEach var="file" items="${allFiles}">
                            <br>
                            <h5 align="center">${file.name}</h5>
                            <c:choose>
                                <c:when test="${file.type == 0}">
                                    <p align="center"><img src=${file.link}></p>
                                </c:when>
                                <c:when test="${file.type == 1}">
                                    <p align="center"><audio controls>
                                        <source src=${file.link} type="audio/mpeg"></audio></p>
                                </c:when>
                                <c:when test="${file.type == 2}">
                                    <p align="center"><video class="vid" width="600" height="400" controls="controls">
                                        <source src=${file.link} type="video/mp4"></video></p>
                                </c:when>
                            </c:choose>
                            <br>
                        </c:forEach>
                    </c:if>
                    <c:if test="${empty allFiles}">
                        <p class="other" align="center">Не найдено</p>
                    </c:if>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>