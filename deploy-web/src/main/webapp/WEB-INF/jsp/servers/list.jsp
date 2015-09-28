<!DOCTYPE html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
    <head>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
    </head>
    <body>
        <div class="container">
            <table class="table">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Name</th>
                        <th>Hostname</th>
                        <th>Username</th>
                        <th>Password</th>
                        <th>Private Key Location</th>
                        <th>Authentication Type</th>
                    </tr>
                </thead>
                <tbody>
                    <c:if test="${not empty servers}">
                            <c:forEach var="server" items="${servers}">
                                <tr>
                                    <td>${server.id}</td>
                                    <td>${server.name}</td>
                                    <td>${server.host}</td>
                                    <td>${server.credentials.username}</td>
                                    <td>${server.credentials.password}</td>
                                    <td>${server.credentials.keyLocation}</td>
                                    <td>${server.credentials.type}</td>
                                </tr>
                            </c:forEach>
                    </c:if>
                </tbody>
            </table>
        </div>
    </body>
</html>