/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.club.loaddb.dao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import org.apache.log4j.Logger;

/**
 *
 * @author Osiel
 */
public class ReadFileDao {
    
    private static Logger logger = Logger.getLogger(ReadFileDao.class);
    
    public static ArrayList<String> read(String stringPath) {
        
        File file = new File(stringPath);
        
        if(!file.exists() || !file.isFile()) {
            logger.error("[read] Error no existe el archivo o no es un archivo");
            return null;
        }

        byte[] bs = new byte[2048];
        
        String stringLine = "";
        
        ArrayList<String> arrayList = new ArrayList<>();
        
        FileInputStream fileInputStream;
        
        try {
            fileInputStream = new FileInputStream(file);
        } catch (FileNotFoundException ex) {
            logger.error("[read] Error al buscar el archivo", ex);
            return null;
        }
       
        InputStreamReader inputStreamReader = 
                new InputStreamReader(fileInputStream);
        
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        try {
            while((stringLine = bufferedReader.readLine()) != null ) {
                arrayList.add(stringLine);
            }
        } catch (IOException ex) {
            logger.error("[read] Error al leer el archivo", ex);
            return null;
        }
        
        logger.info("[read] Regresando [" + arrayList.size() + "] linea(s)");
        
        return arrayList;
    }
    
    private static BufferedReader bufferedReader = null;
    
    public static int readInit(String stringPath) {
    
        File file = new File(stringPath);
        
        if(!file.exists() || !file.isFile()) {
            logger.error("[read] Error no existe el archivo o no es un archivo");
            return -1;
        }
        
        ArrayList<String> arrayList = new ArrayList<>();
        
        FileInputStream fileInputStream;
        
        try {
            fileInputStream = new FileInputStream(file);
        } catch (FileNotFoundException ex) {
            logger.error("[read] Error al buscar el archivo", ex);
            return -1;
        }
       
        InputStreamReader inputStreamReader = 
                new InputStreamReader(fileInputStream);
        
        bufferedReader = new BufferedReader(inputStreamReader);
        
        return 0;
    }
    
    public static String readLine() {
        try {
            return bufferedReader.readLine();
        } catch (IOException ex) {
            logger.error("[read] Error al leer el archivo", ex);
            return null;
        }
    }
    
    public static void readClose() {
        try {
            bufferedReader.close();
        } catch (IOException ex) {
            logger.error("[read] Error al cerrar el archivo", ex);
        }
    }
    
}
