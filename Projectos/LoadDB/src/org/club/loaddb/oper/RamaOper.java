/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.club.loaddb.oper;

import com.club.loaddb.helper.RamaHelper;
import java.util.ArrayList;
import java.util.Properties;
import org.apache.log4j.Logger;
import org.club.loaddb.dao.ReadFileDao;
import org.club.loaddb.facade.RamaFacade;
import org.club.loaddb.facade.ReadFileFacade;
import org.club.loaddb.vo.RamaVO;

/**
 *
 * @author Osiel
 */
public class RamaOper {
    
    private static final Logger logger = Logger.getLogger(RamaOper.class);
    
    public void insert(String stringPath) {
        
        ArrayList arrayList = ReadFileFacade.read(stringPath);
        
        RamaVO[] ramaVOs = RamaHelper.getRamaVO(arrayList);
        
        RamaFacade.init(new Properties());
        
        for(int intI=0; intI<ramaVOs.length; intI++) {
            
            logger.info("[insert] Insertando a la base de datos, linea ["+intI+"]");
                    
            if (RamaFacade.insert(ramaVOs[intI]) == null ) 
                
                logger.error("[insert] No se pudo insertar a la base de datos");
        }
    }
    
    public void insertTwo (String stringPath) {
        
        if(ReadFileFacade.readInit(stringPath)!=0) {
            logger.error("[insertTwo] No se pudo inicialiar la lectura");
            return;
        }
        
        String stringLinea;
        
        RamaFacade.init(new Properties());
        
        int intContador = 0;
        
        while((stringLinea = ReadFileFacade.readLine())!= null) {
            
            RamaVO ramaVO = RamaHelper.getRamaVO(stringLinea);
            
            ramaVO.setIntIdContaminante(intContador);
            
            if (RamaFacade.insert(ramaVO) == null ) 
                
                logger.error("[insert] No se pudo insertar a la base de datos");
            
            intContador +=1;
        }
        
        ReadFileDao.readClose();
    }
    
}
