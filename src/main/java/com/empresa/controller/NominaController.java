package com.empresa.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.empresa.dao.NominaDAO;

public class NominaController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public NominaController() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
String opcion = request.getParameter("opcion");

if ("verSalario".equals(opcion)) {
    // Mostrar el formulario de búsqueda de salario
    RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/verSalario.jsp");
    requestDispatcher.forward(request, response);
} else {
    response.sendRedirect("index.jsp");
}
}

    
protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    String opcion = request.getParameter("opcion");

    if ("verSalario".equals(opcion)) {
        String dni = request.getParameter("dni");
        NominaDAO nominaDAO = new NominaDAO();
        try {
            int salario = nominaDAO.obtenerSalario(dni);
            if (salario != -1) {
                request.setAttribute("salario", salario);
            } else {
                request.setAttribute("error", "Empleado no encontrado");
            }
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/verSalario.jsp");
            requestDispatcher.forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
            request.setAttribute("error", "Error al obtener el salario");
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/error.jsp");
            requestDispatcher.forward(request, response);
        }
    } else {
        response.sendRedirect("index.jsp");
    }
}


}
