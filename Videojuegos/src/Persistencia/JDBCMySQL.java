/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Proyectos
 */
public class JDBCMySQL {

    Connection conn = null;

    /**
     * Método general de conexión a BD
     *
     * @author ICC Inés Calderón 2018
     * @return Connection
     */
    public Connection conectar() {

        try {
            String ruta = "jdbc:mysql://";
            String servidor = "boq8znahomxmmay8bswh-mysql.services.clever-cloud.com" + "/";
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(ruta.concat(servidor).concat("boq8znahomxmmay8bswh").concat("?autoReconnect=true&useSSL=false"), "urznzutlyl87k6wb", "cnMOE4t6OBveEQCgS3Xq");

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(JDBCMySQL.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            return conn;
        }

    }

    /**
     * Método general de desconexión a BD
     *
     * @author ICC Inés Calderón 2018
     */
    public void desconectar() {
        conn = null;
    }
}
