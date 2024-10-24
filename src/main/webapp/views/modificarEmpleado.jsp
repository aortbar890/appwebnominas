<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Modificar Empleado</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-DyZv3lvU1gtNmcN1y27PmBvH0JtK+26x9CO8c6xf1eXl3dI5aY3AOM2jzC11N9g6" crossorigin="anonymous">
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
    <h2>Modificar Empleado</h2>
    <form action="empleados" method="post">
        <input type="hidden" name="opcion" value="modificar">
        
        <label for="dni">DNI:</label>
        <input type="text" id="dni" name="dni" value="${empleado.dni}" readonly><br><br>

        <label for="nombre">Nombre:</label>
        <input type="text" id="nombre" name="nombre" value="${empleado.nombre}" required><br><br>

        <label for="sexo">Sexo:</label>
        <input type="text" id="sexo" name="sexo" value="${empleado.sexo}" required /><br/>
        <br><br>

        <label for="categoria">Categoría (1-10):</label>
        <input type="number" id="categoria" name="categoria" min="1" max="10" value="${empleado.categoria}" required><br><br>

        <label for="anyos">Años en la Empresa:</label>
        <input type="number" id="anyos" name="anyos" min="0" value="${empleado.anyos}" required><br><br>

        <input type="submit" value="Guardar Cambios" class="btn btn-secondary">
    </form>
    <br>
    <a href="index.jsp" class="btn btn-secondary">Volver al inicio</a>
</body>
</html>
