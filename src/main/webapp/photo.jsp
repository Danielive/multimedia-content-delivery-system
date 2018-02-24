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
                        <a href="http://localhost:8080/photo" class="btn btn-primary" role="button">
                            <li>
                                Фото
                            </li>
                        </a>
                        <a href="http://localhost:8080/music" class="btn btn-primary" role="button">
                            <li>
                                Музыка
                            </li>
                        </a>
                        <a href="http://localhost:8080/video" class="btn btn-primary" role="button">
                            <li>
                                Видео
                            </li>
                        </a>
                    </ul>
                </menu>

                <legend>Фотографии</legend>
                <div class="form-group">
                    <c:if test="${not empty allPhoto}">
                        <c:forEach var="photo" items="${allPhoto}">
                            <br>
                            <p>${photo.name}</p>
                            <img src=${photo.link}
                                         <%--width="768" height="600"--%>
                            >
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