package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConexionDB {

     // Declare the JDBC objects.
      static Connection con = null;
            ResultSet rs = null;
            
          // Método para obtener una conexión
          public static Connection getConnection() {
              try {
                   // Establish the connection.
              Class.forName("com.mysql.jdbc.Driver");
              con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel?verifyServerCertificate=false&useSSL=true", "root", "1234");
                con.setAutoCommit(true);
                  
                  return con;

        } catch (ClassNotFoundException cnfex) {
            System.err.println("Error en la conexión: No se encontró el controlador de MySQL.");
            cnfex.printStackTrace();
            System.exit(1); // Terminar el programa en caso de error crítico
        } catch (SQLException sqlex) {
            System.err.println("Conexión no disponible: Error al conectar con la base de datos.");
            sqlex.printStackTrace();
            System.exit(1); // Terminar el programa en caso de error crítico
        }
        return null; // Esto nunca debería ocurrir, pero es necesario para evitar errores de compilación
    }

    // Método para cerrar la conexión
    public static void closeConnection(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
                
                System.out.println("Conexión cerrada correctamente.");
            } catch (SQLException e) {
                System.err.println("Error al cerrar la conexión.");
                e.printStackTrace();
            }
        }
    }
}
