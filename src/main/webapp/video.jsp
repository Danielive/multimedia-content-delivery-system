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
            <form class="form-horizontal" action="video" method="GET">
                <div class="panel-heading">Видеозаписи</div>
                <menu>
                    <ul class="navbar nav-tabs">
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
                    </ul>
                </menu>
                <div class="form-group">
                    <c:if test="${not empty allVideo}">
                        <c:forEach var="video" items="${allVideo}">
                            <br>
                            <h5 align="center">${video.name}</h5>
                            <p align="center"><video class="vid" width="600" height="400" controls="controls">
                                <source src=${video.link} type="video/mp4"></video></p>
                            <br>
                        </c:forEach>
                    </c:if>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>