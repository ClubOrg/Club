/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.club.loaddb.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import org.apache.log4j.Logger;

/**
 *
 * @author Osiel
 */
public class ConnectionMySql {
    
    private static final Logger logger = Logger.getLogger(ConnectionMySql.class);
    
    private Connection connection = null;
    
    private String stringIp = "169.254.118.23";
    
    private String stringDB = "";
    
    private String stringUser = "";
    
    private String stringPassword = "";
    
    static {
        try { 
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            logger.error("[static] Error al cargar el driver MySql", ex);
        }
    }
    
    public void init(Properties properties) {
        
        stringIp = properties.getProperty("CONNECTION.MYSQL.IP", "localhost");
        
        stringDB = properties.getProperty("CONNECTION.MYSQL.DATEBASE", "rama");
        
        stringUser = properties.getProperty("CONNECTION.MYSQL.USER", "root");
        
        stringPassword = properties.getProperty("CONNECTION.MYSQL.PASSWORD", "Club2014");
    }
    
    public Statement connection() {
        
        try {
           connection = DriverManager.getConnection(
                    "jdbc:mysql://"+stringIp+"/"+stringDB,stringUser, stringPassword);
        } catch (SQLException ex) {
            logger.error("[connection] Error al realizar la conexiòn", ex);
        }

        try {
            return connection.createStatement();
        } catch (SQLException ex) {
            logger.error("[connection] Error al crear la sentencia", ex);
            close();
            return null;
        }
    }
    
    public void close() {
        try {
            connection.close();
        } catch (SQLException ex) {
            logger.error("[close] Error al cerrar la conexòn", ex);
        }
    }
}
