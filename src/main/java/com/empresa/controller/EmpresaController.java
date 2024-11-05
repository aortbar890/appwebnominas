package com.empresa.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class EmpresaController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public EmpresaController() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        manejarRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        manejarRequest(request, response);
    }

    private void manejarRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String controller = request.getParameter("controller");
        String opcion = request.getParameter("opcion");

        if ("empleado".equals(controller)) {
                RequestDispatcher dispatcher = request.getRequestDispatcher("/empleados?opcion=" + opcion);
                dispatcher.forward(request, response);

        } else if ("nomina".equals(controller)) {
                RequestDispatcher dispatcher = request.getRequestDispatcher("/nominas?opcion=" + opcion);
                dispatcher.forward(request, response);
        } else {
            // Página de error si el controlador es inválido
            request.setAttribute("errorMessage", "Controlador no válido.");
            RequestDispatcher dispatcher = request.getRequestDispatcher("/views/error.jsp");
            dispatcher.forward(request, response);
        }
    }
}
