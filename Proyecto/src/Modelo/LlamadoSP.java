package Modelo;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import javax.swing.JOptionPane;

public class LlamadoSP {

    public ConexionDB conexion; 

    // Método para insertar cliente en la base de datos
    public static void insertarCliente(String cedula, String nombre1, String nombre2, String apellido1, String apellido2, String telefono) {
        
        // Obtener la conexión a la base de datos
        try (Connection conn = ConexionDB.getConnection();) {

            // Definir el procedimiento almacenado
            String consultaSQL = "{CALL ingresar_cliente(?, ?, ?, ?, ?, ?)}";
            CallableStatement llamada = conn.prepareCall(consultaSQL);

            llamada.setString(1, cedula);
            llamada.setString(2, nombre1);
            llamada.setString(3, nombre2);
            llamada.setString(4, apellido1);
            llamada.setString(5, apellido2);
            llamada.setString(6, telefono);

            int filasAfectadas = 0; // Variable para contar las filas afectadas
            filasAfectadas = llamada.executeUpdate(); // Obtiene el número de filas afectadas

            // Comprobar si la inserción fue exitosa
            if (filasAfectadas > 0) {
                JOptionPane.showMessageDialog(null, "Cliente insertado correctamente.");
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo insertar el cliente.");
            }

            llamada.close(); // Cerrar el CallableStatement

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al insertar el cliente: " + e.getMessage());
        }

     
    }

// Método para consultar un cliente por cédula usando un procedimiento almacenado
public static ResultSet consultarCliente(String cedula) {
    
    Connection conn = null;
    CallableStatement llamada = null;
    ResultSet rs = null;
    
    try {
        // Obtener la conexión a la base de datos
        conn = ConexionDB.getConnection();
        
        // Definir el procedimiento almacenado
        String consultaSQL = "{CALL consultar_cliente(?)}";
        llamada = conn.prepareCall(consultaSQL);

        // Establecer el parámetro de entrada
        llamada.setString(1, cedula);

        // Ejecutar el procedimiento y obtener el resultado
        rs = llamada.executeQuery();

        // Importante: NO cerrar la conexión ni el CallableStatement aquí
        return rs; // Devolvemos el ResultSet

    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error al consultar el cliente: " + e.getMessage(),
                                      "Error", JOptionPane.ERROR_MESSAGE);
        return null;
    }
}




// Método para actualizar un cliente en la base de datos usando un procedimiento almacenado
public static void actualizarCliente(String cedula, String nombre1, String nombre2, String apellido1, String apellido2, String telefono) throws SQLException {
    
    // Obtener la conexión a la base de datos
    try (Connection conn = ConexionDB.getConnection()) {

        // Definir el procedimiento almacenado
        String consultaSQL = "{CALL actualizar_cliente(?, ?, ?, ?, ?, ?)}";
        CallableStatement llamada = conn.prepareCall(consultaSQL);

        // Establecer los parámetros de entrada
        llamada.setString(1, cedula);
        llamada.setString(2, nombre1);
        llamada.setString(3, nombre2);
        llamada.setString(4, apellido1);
        llamada.setString(5, apellido2);
        llamada.setString(6, telefono);

        // Ejecutar el procedimiento y obtener el resultado
        int filasAfectadas = llamada.executeUpdate();

        // Comprobar si la actualización fue exitosa
        if (filasAfectadas > 0) {
            JOptionPane.showMessageDialog(null, "Cliente actualizado correctamente.");
        } else {
            JOptionPane.showMessageDialog(null, "No se pudo actualizar el cliente.");
        }

        // Cerrar el CallableStatement
        llamada.close();

    } catch (SQLException e) {
        throw new SQLException("Error al actualizar el cliente: " + e.getMessage());
    }
}


// Método para eliminar un cliente en la base de datos usando un procedimiento almacenado
public static void eliminarCliente(String cedula) throws SQLException {
    // Obtener la conexión a la base de datos
    try (Connection conn = ConexionDB.getConnection()) {
        
        // Definir el procedimiento almacenado
        String consultaSQL = "{CALL eliminar_cliente(?)}";
        CallableStatement llamada = conn.prepareCall(consultaSQL);
        
        // Establecer el parámetro de entrada
        llamada.setString(1, cedula);
        
        // Ejecutar el procedimiento y obtener el resultado
        int filasAfectadas = llamada.executeUpdate();
        
        // Comprobar si la eliminación fue exitosa
        if (filasAfectadas > 0) {
            JOptionPane.showMessageDialog(null, "Cliente eliminado correctamente.");
        } else {
            JOptionPane.showMessageDialog(null, "No se pudo eliminar el cliente. Verifique la cédula.");
        }
        
        // Cerrar el CallableStatement
        llamada.close();
        
    } catch (SQLException e) {
        // Capturar el error de SQL y mostrarlo en un mensaje de error
        JOptionPane.showMessageDialog(null, "Error al eliminar el cliente: " + e.getMessage(),
                                      "Error", JOptionPane.ERROR_MESSAGE);
        throw e; // Lanzar la excepción para que sea manejada por el llamador si es necesario
    }
}


// Método para insertar una reservación en la base de datos usando un procedimiento almacenado
public static void insertarReservacion(String cedulaCliente, int numHabitacion, int idTipoPago, int idEmpleado,
java.sql.Date fechaInicio, java.sql.Date fechaFin) {
    
try (Connection conn = ConexionDB.getConnection()) {
String consultaSQL = "{CALL insertar_reservacion(?, ?, ?, ?, ?, ?)}";
CallableStatement llamada = conn.prepareCall(consultaSQL);

// Establecer los parámetros del procedimiento almacenado
llamada.setString(1, cedulaCliente);
llamada.setInt(2, numHabitacion);
llamada.setInt(3, idTipoPago);
llamada.setInt(4, idEmpleado);
llamada.setDate(5, fechaInicio);
llamada.setDate(6, fechaFin);

// Ejecutar el procedimiento almacenado
int filasAfectadas = llamada.executeUpdate();

if (filasAfectadas > 0) {
JOptionPane.showMessageDialog(null, "Reservación insertada correctamente.");
} else {
JOptionPane.showMessageDialog(null, "No se pudo insertar la reservación.");
}

} catch (SQLException e) {
JOptionPane.showMessageDialog(null, "Error al insertar reservación: " + e.getMessage(),
"Error", JOptionPane.ERROR_MESSAGE);
}
}







// Método para consultar una reservación en la base de datos usando un procedimiento almacenado
public static ResultSet consultarReservacion(int idReservacion) {
    ResultSet rs = null;
    try {
        // Obtener la conexión a la base de datos
        Connection conn = ConexionDB.getConnection();

        // Definir el procedimiento almacenado
        String consultaSQL = "{CALL consultar_reservacion(?)}";
        CallableStatement llamada = conn.prepareCall(consultaSQL);

        // Establecer el parámetro de entrada
        llamada.setInt(1, idReservacion);

        // Ejecutar el procedimiento y obtener el resultado
        rs = llamada.executeQuery();

    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error al consultar la reservación: " + ex.getMessage(),
                                      "Error", JOptionPane.ERROR_MESSAGE);
    }

    return rs; // Devolvemos el ResultSet para procesarlo en la ventana que lo necesite
}



// Método para actualizar una reservación en la base de datos
public static void actualizarReservacion(int idReservacion, String cedulaCliente, int numHabitacion, int idTipoPago, int idEmpleado, Date fechaInicio, Date fechaFin) {

    // Obtener la conexión a la base de datos
    try (Connection conn = ConexionDB.getConnection()) {

        // Definir el procedimiento almacenado
        String consultaSQL = "{CALL actualizar_reservacion(?, ?, ?, ?, ?, ?, ?)}";
        CallableStatement llamada = conn.prepareCall(consultaSQL);

        // Asignar los parámetros al procedimiento
        llamada.setInt(1, idReservacion);
        llamada.setString(2, cedulaCliente);
        llamada.setInt(3, numHabitacion);
        llamada.setInt(4, idTipoPago);
        llamada.setInt(5, idEmpleado);
        llamada.setDate(6, new java.sql.Date(fechaInicio.getTime()));
        llamada.setDate(7, new java.sql.Date(fechaFin.getTime()));

        // Ejecutar el procedimiento y obtener el número de filas afectadas
        int filasAfectadas = llamada.executeUpdate();

        // Verificar si la actualización fue exitosa
        if (filasAfectadas > 0) {
            JOptionPane.showMessageDialog(null, "Reservación actualizada correctamente.");
        } else {
            JOptionPane.showMessageDialog(null, "No se pudo actualizar la reservación.");
        }

        // Cerrar el CallableStatement
        llamada.close();

    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error al actualizar la reservación: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
}



// Método en la clase LlamadoSP para eliminar una reservación usando el SP
public static void eliminarReservacion(int idReservacion) throws SQLException {
    // Obtener la conexión a la base de datos
    try (Connection conn = ConexionDB.getConnection()) {
        // Definir el procedimiento almacenado
        String consultaSQL = "{CALL eliminar_reservacion(?)}";
        CallableStatement llamada = conn.prepareCall(consultaSQL);

        // Asignar el parámetro al procedimiento
        llamada.setInt(1, idReservacion);

        // Ejecutar el procedimiento
        int filasAfectadas = llamada.executeUpdate();

        // Verificar si la eliminación fue exitosa
        if (filasAfectadas > 0) {
            System.out.println("Reservación eliminada correctamente.");
        } else {
            System.out.println("No se encontró la reservación a eliminar.");
        }

        // Cerrar el CallableStatement
        llamada.close();
    } catch (SQLException e) {
        // Manejar errores de SQL
        throw new SQLException("Error al eliminar la reservación: " + e.getMessage(), e);
    }
}



}
