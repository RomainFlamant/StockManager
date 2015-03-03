/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factory;

import dao.DaoGeneric;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author userinsta
 */
public class FactoryDao {
    
    public static DaoGeneric<?> getDao(Class classe){
        
        DaoGeneric<?> dao = null ;
        try {
            String daoString = "dao.Dao"+classe.getSimpleName();
           Class classeDao = Class.forName(daoString);
            
          dao = (DaoGeneric<?>) classeDao.newInstance();
            
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(FactoryDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dao;
   }
    
}
