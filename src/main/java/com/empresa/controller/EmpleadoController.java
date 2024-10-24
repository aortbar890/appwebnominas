package com.empresa.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.empresa.dao.EmpleadoDAO;
import com.empresa.model.DatosNoCorrectosException;
import com.empresa.model.Empleado;

public class EmpleadoController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String opcion = request.getParameter("opcion");

        if ("listar".equals(opcion)) {
            // Opción para listar todos los empleados
            EmpleadoDAO empleadoDAO = new EmpleadoDAO();
            List<Empleado> lista = new ArrayList<>();
            try {
                lista = empleadoDAO.obtenerEmpleados();
                request.setAttribute("lista", lista);
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/listarEmpleados.jsp");
                requestDispatcher.forward(request, response);
            } catch (SQLException e) {
                request.setAttribute("error", "Error al obtener la lista de empleados.");
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/error.jsp");
                requestDispatcher.forward(request, response);
            } catch (DatosNoCorrectosException e) {
                request.setAttribute("error", "Datos no correctos.");
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/error.jsp");
                requestDispatcher.forward(request, response);
            }
        }  else if ("formBuscar".equals(opcion)) {
            // Muestra el formulario de búsqueda
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/buscarEmpleado.jsp");
            requestDispatcher.forward(request, response);
        }  else if ("buscar".equals(opcion)) {
            // Opción para buscar empleados
            String dni = request.getParameter("dni");
            String nombre = request.getParameter("nombre");
            String sexo = request.getParameter("sexo");
            String categoria = request.getParameter("categoria");
            String anyos = request.getParameter("anyos");
    
            EmpleadoDAO empleadoDAO = new EmpleadoDAO();
            List<Empleado> listaEmpleados = new ArrayList<>();
    
            try {
                // Llama al método de búsqueda solo si se han ingresado criterios
                listaEmpleados = empleadoDAO.buscarEmpleados(dni, nombre, sexo, categoria, anyos);
                request.setAttribute("listaEmpleados", listaEmpleados);
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/resultadosEmpleado.jsp");
                requestDispatcher.forward(request, response);
            } catch (SQLException e) {
                request.setAttribute("error", "Error al buscar empleados.");
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/error.jsp");
                requestDispatcher.forward(request, response);
            } catch (DatosNoCorrectosException e) {
                request.setAttribute("error", "Datos no correctos.");
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/error.jsp");
                requestDispatcher.forward(request, response);
            }
        } else if ("modificar".equals(opcion)) {
            // Opción para modificar un empleado
            String dni = request.getParameter("dni");
            EmpleadoDAO empleadoDAO = new EmpleadoDAO();
            Empleado empleado = null;
    
            try {
                List<Empleado> listaEmpleados = empleadoDAO.buscarEmpleados(dni, null, null, null, null);
                if (!listaEmpleados.isEmpty()) {
                    empleado = listaEmpleados.get(0); 
                    request.setAttribute("empleado", empleado);
                    RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/modificarEmpleado.jsp");
                    requestDispatcher.forward(request, response);
                } else {
                    request.setAttribute("error", "Empleado no encontrado.");
                    RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/error.jsp");
                    requestDispatcher.forward(request, response);
                }
            } catch (SQLException e) {
                request.setAttribute("error", "Error al buscar el empleado.");
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/error.jsp");
                requestDispatcher.forward(request, response);
            } catch (DatosNoCorrectosException e) {
                request.setAttribute("error", "Datos no correctos.");
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/error.jsp");
                requestDispatcher.forward(request, response);
            }
        } else {
            response.sendRedirect("index.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Opción para buscar empleados
        String dni = request.getParameter("dni");
        String nombre = request.getParameter("nombre");
        String sexo = request.getParameter("sexo");
        String categoria = request.getParameter("categoria");
        String anyos = request.getParameter("anyos");

        EmpleadoDAO empleadoDAO = new EmpleadoDAO();
        List<Empleado> listaEmpleados = new ArrayList<>();

        try {
            // Llama al método de búsqueda
            listaEmpleados = empleadoDAO.buscarEmpleados(dni, nombre, sexo, categoria, anyos);
            // Cambia el nombre del atributo a 'listaEmpleados' para que coincida con el JSP
            request.setAttribute("listaEmpleados", listaEmpleados);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/resultadosEmpleado.jsp");
            requestDispatcher.forward(request, response);
        } catch (SQLException e) {
            request.setAttribute("error", "Error al buscar empleados.");
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/error.jsp");
            requestDispatcher.forward(request, response);
        } catch (DatosNoCorrectosException e) {
            request.setAttribute("error", "Datos no correctos.");
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/error.jsp");
            requestDispatcher.forward(request, response);
        }
    }
}
