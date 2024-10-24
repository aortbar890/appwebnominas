<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.empresa.model.Empleado" %>

<html>
<head>
    <title>Resultados de Búsqueda</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-DyZv3lvU1gtNmcN1y27PmBvH0JtK+26x9CO8c6xf1eXl3dI5aY3AOM2jzC11N9g6" crossorigin="anonymous">
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
<h2>Resultados de Búsqueda</h2>

<%
    // Obtener la lista de empleados del request
    List<Empleado> listaEmpleados = (List<Empleado>) request.getAttribute("listaEmpleados");

    if (listaEmpleados != null && !listaEmpleados.isEmpty()) {
%>
    <table border="1">
        <tr>
            <th>DNI</th>
            <th>Nombre</th>
            <th>Sexo</th>
            <th>Categoría</th>
            <th>Años en la Empresa</th>
            <th>Acciones</th>
        </tr>
        <% for (Empleado empleado : listaEmpleados) { %>
            <tr>
                <td><%= empleado.getDni() %></td>
                <td><%= empleado.getNombre() %></td>
                <td><%= empleado.getSexo() %></td>
                <td><%= empleado.getCategoria() %></td>
                <td><%= empleado.getAnyos() %></td>
                <td>
                    <a href="empleados?opcion=modificar&dni=<%= empleado.getDni() %>&nombre=<%= empleado.getNombre() %>&sexo=<%= empleado.getSexo() %>&categoria=<%= empleado.getCategoria() %>&anyos=<%= empleado.getAnyos() %>">Modificar</a>
                </td>
            </tr>
        <% } %>
    </table>
<%
    } else {
%>
    <p>No se encontraron empleados que cumplan con los criterios de búsqueda.</p>
<%
    }
%>
<br>
<a href="index.jsp" class="btn btn-secondary">Volver al inicio</a>
</body>
</html>
