/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.club.loaddb.facade;

import java.util.Properties;
import org.club.loaddb.dao.RamaDao;
import org.club.loaddb.vo.RamaVO;

/**
 *
 * @author Osiel
 */
public class RamaFacade {
    
    public static synchronized void init(Properties properties) {
        RamaDao.init(properties);
    }
    
    public static synchronized RamaVO insert(RamaVO ramaVO) {
        return RamaDao.insert(ramaVO);
    }
    
}
