package com.empresa.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.empresa.conexion.Conexion;
import com.empresa.model.Empleado;
import com.empresa.model.Nomina;
import com.empresa.model.DatosNoCorrectosException;

public class NominaDAO {
    private Connection connection;
    private PreparedStatement statement;

    // Obtener salario de un empleado por DNI
    public int obtenerSalario(String dni) throws SQLException {
        Empleado empleado = obtenerEmpleadoPorDNI(dni);
        return (empleado != null) ? Nomina.sueldo(empleado) : -1; // -1 si no se encuentra
    }

    // Obtener empleado por DNI 
    private Empleado obtenerEmpleadoPorDNI(String dni) throws SQLException {
        Empleado emp = null;
        String sql = "SELECT dni, nombre, sexo, categoria, anyos FROM empleados WHERE dni = ?";

        try {
            connection = obtenerConexion();
            statement = connection.prepareStatement(sql);
            statement.setString(1, dni);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                try {
                    emp = new Empleado(
                        resultSet.getInt("anyos"),
                        resultSet.getInt("categoria"),
                        resultSet.getString("dni"),
                        resultSet.getString("nombre"),
                        resultSet.getString("sexo").charAt(0)
                    );
                } catch (DatosNoCorrectosException e) {
                    e.printStackTrace(); // Log error if data is incorrect
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (statement != null) statement.close();
            if (connection != null) connection.close();
        }

        return emp;
    }

    // Método para obtener la conexión
    private Connection obtenerConexion() throws SQLException {
        return Conexion.getConnection();
    }
}
