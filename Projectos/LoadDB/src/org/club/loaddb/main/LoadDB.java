/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.club.loaddb.main;

import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.log4j.BasicConfigurator;
import org.club.loaddb.oper.RamaOper;

/**
 *
 * @author Osiel
 */
public class LoadDB {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        BasicConfigurator.configure();
        
        RamaOper ramaOper = new RamaOper();
        
        long l1 = System.currentTimeMillis();
        
        ramaOper.insertTwo("D:\\HackDF\\rama.csv");
        
        long l2 = System.currentTimeMillis();
        
        l1 = l2-l1;
        
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss.SSS");
        
        System.out.println("Total {"+dateFormat.format(new Date(l1))+"}");
    }
    
}
