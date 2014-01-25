/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.club.loaddb.facade;

import java.util.ArrayList;
import org.club.loaddb.dao.ReadFileDao;

/**
 *
 * @author Osiel
 */
public class ReadFileFacade {
    
    public static synchronized ArrayList read (String stringPath) {
        return ReadFileDao.read(stringPath);
    }
    
    public static synchronized int readInit(String stringPath) {
        return ReadFileDao.readInit(stringPath);
    }
    
    public static synchronized String readLine() {
        return ReadFileDao.readLine();
    }
    
    public static synchronized void readClose() {
        ReadFileDao.readClose();
    }
}
