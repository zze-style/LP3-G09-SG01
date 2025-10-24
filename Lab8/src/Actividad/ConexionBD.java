package Actividad;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.SQLException;

public class ConexionBD {
    private static final String url = "jdbc:sqlite:actividadbase.db";

    public static Connection conectar() {
        Connection con = null;
        try {
            con = DriverManager.getConnection(url);
            System.out.println("Conexión establecida.");
        } catch (SQLException e) {
            System.out.println("Error al conectar: " + e.getMessage());
        }
        return con;
    }
}


