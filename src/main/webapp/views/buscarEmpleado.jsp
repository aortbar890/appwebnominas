<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Buscar Empleado</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-DyZv3lvU1gtNmcN1y27PmBvH0JtK+26x9CO8c6xf1eXl3dI5aY3AOM2jzC11N9g6" crossorigin="anonymous">
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
    <h2>Buscar Empleado</h2>
    <form action="empleados" method="get">
        <input type="hidden" name="opcion" value="buscar">
        
        <label for="dni">DNI:</label>
        <input type="text" id="dni" name="dni"><br><br>

        <label for="nombre">Nombre:</label>
        <input type="text" id="nombre" name="nombre"><br><br>

        <label for="sexo">Sexo:</label>
        <select id="sexo" name="sexo">
            <option value="">Seleccione</option>
            <option value="M">Hombre</option>
            <option value="F">Mujer</option>
        </select><br><br>

        <label for="categoria">Categoría (1-10):</label>
        <input type="number" id="categoria" name="categoria" min="1" max="10"><br><br>

        <label for="anyos">Años en la Empresa:</label>
        <input type="number" id="anyos" name="anyos" min="0"><br><br>

        <input type="submit" value="Buscar" class="btn btn-secondary">
    </form>
    <br>
    <a href="index.jsp" class="btn btn-secondary">Volver al inicio</a>
</body>
</html>
