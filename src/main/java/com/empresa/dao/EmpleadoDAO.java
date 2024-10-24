package com.empresa.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.empresa.conexion.Conexion;
import com.empresa.model.DatosNoCorrectosException;
import com.empresa.model.Empleado;

public class EmpleadoDAO {
    private Connection connection;
    private PreparedStatement statement;

    // Obtener lista de empleados
    public List<Empleado> obtenerEmpleados() throws SQLException, DatosNoCorrectosException {
        List<Empleado> listaEmpleados = new ArrayList<>();
        String sql = "SELECT dni, nombre, sexo, categoria, anyos FROM empleados";

        try {
            connection = obtenerConexion();
            statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Empleado emp = new Empleado(
                    resultSet.getInt("anyos"),
                    resultSet.getInt("categoria"),
                    resultSet.getString("dni"),
                    resultSet.getString("nombre"),
                    resultSet.getString("sexo").charAt(0)
                );
                listaEmpleados.add(emp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (statement != null) statement.close();
            if (connection != null) connection.close();
        }

        return listaEmpleados;
    }

    // Método para buscar empleados
    public List<Empleado> buscarEmpleados(String dni, String nombre, String sexo, String categoria, String anyos) throws SQLException, DatosNoCorrectosException {
        List<Empleado> listaEmpleados = new ArrayList<>();
        StringBuilder sql = new StringBuilder("SELECT dni, nombre, sexo, categoria, anyos FROM empleados WHERE 1=1");
        
        if (dni != null && !dni.isEmpty()) {
            sql.append(" AND dni = ?");
        }
        if (nombre != null && !nombre.isEmpty()) {
            sql.append(" AND nombre LIKE ?");
        }
        if (sexo != null && !sexo.isEmpty()) {
            sql.append(" AND sexo = ?");
        }
        if (categoria != null && !categoria.isEmpty()) {
            sql.append(" AND categoria = ?");
        }
        if (anyos != null && !anyos.isEmpty()) {
            sql.append(" AND anyos = ?");
        }

        try {
            connection = obtenerConexion();
            statement = connection.prepareStatement(sql.toString());
            int index = 1;

            if (dni != null && !dni.isEmpty()) {
                statement.setString(index++, dni);
            }
            if (nombre != null && !nombre.isEmpty()) {
                statement.setString(index++, "%" + nombre + "%"); // Para que busque como un LIKE
            }
            if (sexo != null && !sexo.isEmpty()) {
                statement.setString(index++, sexo);
            }
            if (categoria != null && !categoria.isEmpty()) {
                statement.setInt(index++, Integer.parseInt(categoria));
            }
            if (anyos != null && !anyos.isEmpty()) {
                statement.setInt(index++, Integer.parseInt(anyos));
            }

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Empleado emp = new Empleado(
                    resultSet.getInt("anyos"),
                    resultSet.getInt("categoria"),
                    resultSet.getString("dni"),
                    resultSet.getString("nombre"),
                    resultSet.getString("sexo").charAt(0)
                );
                listaEmpleados.add(emp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (statement != null) statement.close();
            if (connection != null) connection.close();
        }

        return listaEmpleados;
    }

    private Connection obtenerConexion() throws SQLException {
        return Conexion.getConnection();
    }
}
