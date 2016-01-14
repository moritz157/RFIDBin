/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.heilwig.rfidbin.resources;

import de.heilwig.rfidbin.Config;
import de.heilwig.rfidbin.entity.Product;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

/**
 *
 * @author Moritz
 */
@Stateless
@Path("resetKind/{MasterPass}/{SerialNumber}")
public class resetKindResource {
    @PersistenceContext
    EntityManager em;
    
    @POST
    public String resetKind(@PathParam("MasterPass") String masterPass, @PathParam("SerialNumber") String serialNumber){
       if(Config.checkMasterPass(masterPass)){
           Query createNativeQuery = em.createNativeQuery("SELECT * from PRODUCT WHERE serialNumber = '"+serialNumber+"'", Product.class);
           List<Product> get = (List<Product>) createNativeQuery.getResultList(); 
           em.remove(get.get(0));
           System.out.println("Resetted Kind for Serial Number: "+serialNumber);
           return "{'Status':'OK','Data':'Serialnumber "+serialNumber+" successfully deleted'}";
       } 
       return "{'Status':'Error','Data':'Authentification failed'}";
    }
}
