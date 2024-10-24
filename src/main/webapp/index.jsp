<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Gestión de Empleados</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-DyZv3lvU1gtNmcN1y27PmBvH0JtK+26x9CO8c6xf1eXl3dI5aY3AOM2jzC11N9g6" crossorigin="anonymous">
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
    <h1>Bienvenido a la Gestión de Empleados</h1>

    <table border="1">
        <tr>
            <th>Opción</th>
            <th>Acción</th>
        </tr>
        <tr>
            <td>Mostrar Empleados</td>
            <td><a href="empleados?opcion=listar">Ver Lista</a></td>
        </tr>
        <tr>
            <td>Ver Salario de un Empleado</td>
            <td><a href="nomina?opcion=verSalario">Ver Salario</a></td>
        </tr>
        <tr>
            <td>Modificar Empleado</td>
            <td><a href="empleados?opcion=formBuscar">Buscar Datos</a></td>
        </tr>
    </table>
</body>
</html>
