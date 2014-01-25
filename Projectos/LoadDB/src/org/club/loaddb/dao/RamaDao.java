/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.club.loaddb.dao;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import org.apache.log4j.Logger;
import org.club.loaddb.connection.ConnectionMySql;
import org.club.loaddb.vo.RamaVO;

/**
 *
 * @author Osiel
 */
public class RamaDao {
    
    private static final Logger logger = Logger.getLogger(RamaDao.class);
    
    private static ConnectionMySql connectionMySql = null;
    
    public static void init (Properties properties) {

        connectionMySql = new ConnectionMySql();
        
        connectionMySql.init(properties);
        
    }
    
    public static RamaVO insert(RamaVO ramaVO) {
        
        Statement statement = connectionMySql.connection();
        
        String stringQry = "INSERT INTO rama ("
                + "ID_Contaminante,"
                + "Fecha,"
                + "Hora,"
                + "Contaminante,"
                + "Estacion,"
                + "Concentracion,"
                + "Unidad) VALUES ("
                + ramaVO.getIntIdContaminante() + ","
                + "\"" + ramaVO.getStringFecha() + "\","
                + ramaVO.getIntHora() + ","
                + "\"" + ramaVO.getStringContaminante() + "\","
                + "\"" + ramaVO.getStringEstacion() + "\","
                + "\"" + ramaVO.getStringConcentracion() + "\","
                + "\"" + ramaVO.getStringUnidad() + "\")"
                ;

        try {
            
            int intResult = statement.executeUpdate(stringQry);
            
            logger.info("[insert] [" + ramaVO.getIntIdContaminante() + 
                    "] Qry [" + stringQry + "]->["+intResult+"]");
            
        } catch (SQLException ex) {
            logger.error("[insert] Al ejecutar el qry", ex);
            return null;
        }
        
        connectionMySql.close();
        
        return ramaVO;

    }
    
}
