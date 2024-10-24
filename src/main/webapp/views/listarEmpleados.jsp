<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Lista de Empleados</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-DyZv3lvU1gtNmcN1y27PmBvH0JtK+26x9CO8c6xf1eXl3dI5aY3AOM2jzC11N9g6" crossorigin="anonymous">
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
    <h1>Lista de Empleados</h1>
    <table border="1">
        <tr>
            <th>DNI</th>
            <th>Nombre</th>
            <th>Sexo</th>
            <th>Categoría</th>
            <th>Años</th>
        </tr>
        <c:forEach var="empleado" items="${lista}">
            <tr>
                <td>${empleado.dni}</td>
                <td>${empleado.nombre}</td>
                <td>${empleado.sexo}</td>
                <td>${empleado.categoria}</td>
                <td>${empleado.anyos}</td>
            </tr>
        </c:forEach>
    </table>
    <br>
    <a href="index.jsp" class="btn btn-secondary">Volver al inicio</a>
</body>
</html>
