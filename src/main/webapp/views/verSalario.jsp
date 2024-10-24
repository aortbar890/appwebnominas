<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Buscar Salario de Empleado</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-DyZv3lvU1gtNmcN1y27PmBvH0JtK+26x9CO8c6xf1eXl3dI5aY3AOM2jzC11N9g6" crossorigin="anonymous">
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
    <h1>Buscar Salario de Empleado</h1>
    <form action="nomina?opcion=verSalario" method="post">
        <label for="dni">DNI del Empleado:</label>
        <input type="text" id="dni" name="dni" required>
        <br>
        <input type="submit" value="Buscar" class="btn btn-secondary">
    </form>
    
    <c:if test="${not empty salario}">
        <h2>Salario del Empleado: ${salario} €</h2>
    </c:if>
    <c:if test="${not empty error}">
        <p style="color:red;">${error}</p>
    </c:if>
    
    <br>
    <a href="index.jsp" class="btn btn-secondary">Volver al inicio</a>
</body>
</html>
