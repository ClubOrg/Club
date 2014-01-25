/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.club.loaddb.helper;

import java.util.ArrayList;
import java.util.Iterator;
import org.apache.log4j.Logger;
import org.club.loaddb.vo.RamaVO;

/**
 *
 * @author Osiel
 */
public class RamaHelper {
    
    private static Logger logger = Logger.getLogger(RamaHelper.class); 
    
    public static RamaVO[] getRamaVO(ArrayList arrayList) {
        
        ArrayList<RamaVO> ramaVOList = new ArrayList<>();
        
        int intContador = 0;
        
        for(Iterator<String> iterator = arrayList.iterator(); 
                iterator.hasNext(); intContador ++) {
            
            String string = iterator.next();
            
            String[] strings = string.split(",");
            
            if(strings.length == 6) {
                
                RamaVO ramaVO = new RamaVO();
                
                ramaVO.setIntIdContaminante(intContador);
                
                ramaVO.setStringFecha(strings[0]);
                
                try {
                
                    ramaVO.setIntHora(Integer.parseInt(strings[1]));
                    
                } catch(NumberFormatException ex) {
                    logger.error("[getRamaVO] Al convertir valor", ex);
                    ramaVO.setIntHora(25);
                } 
                
                ramaVO.setStringContaminante(strings[2]);
                
                ramaVO.setStringEstacion(strings[3]);
                
                ramaVO.setStringConcentracion(strings[4]);
                
                ramaVO.setStringUnidad(strings[5]);
                
                ramaVOList.add(ramaVO);
            }
        }
        
        RamaVO[] ramaVOs = new RamaVO[ramaVOList.size()];
        
        ramaVOList.toArray(ramaVOs);
        
        return ramaVOs;
        
    }   

    public static RamaVO getRamaVO(String stringLinea) {
            
        String[] strings = stringLinea.split(",");
        
        stringLinea = null;

        if(strings.length == 6) {

            RamaVO ramaVO = new RamaVO();

            ramaVO.setIntIdContaminante(-1);

            ramaVO.setStringFecha(strings[0]);

            try {

                ramaVO.setIntHora(Integer.parseInt(strings[1]));

            } catch(NumberFormatException ex) {
                logger.error("[getRamaVO] Al convertir valor", ex);
                ramaVO.setIntHora(25);
            } 

            ramaVO.setStringContaminante(strings[2]);

            ramaVO.setStringEstacion(strings[3]);
            
            double doubleConcentracion = -99.9;
            
            try {
                doubleConcentracion = Double.parseDouble(strings[4]);
            } catch(NumberFormatException ex) {
                logger.error("[getRamaVO] Al convertir valor concentraacion", ex);
            } 
            
            if(doubleConcentracion == -99.9)
                ramaVO.setStringConcentracion("NA");
            else
                ramaVO.setStringConcentracion(strings[4]);

            ramaVO.setStringUnidad(strings[5]);

            return ramaVO;
        }
        
        strings = null;
        
        return null;
    }
}
