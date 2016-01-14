/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.heilwig.rfidbin.resources;

import de.heilwig.rfidbin.entity.Product;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

/**
 *
 * @author Moritz
 */
@Stateless
@Path("getKind/{SerialNumber}")
public class getKindResource {
    @PersistenceContext
    EntityManager em;
    
    @GET
    public String getKind(@PathParam("SerialNumber") String serialNumber){
        Query createNativeQuery = em.createNativeQuery("SELECT * from PRODUCT WHERE serialNumber = '"+serialNumber+"'", Product.class);
        List<Product> get = (List<Product>) createNativeQuery.getResultList(); 
        if(get.isEmpty()){
            return "{'Status':'Error','Data':'This Serial-Number was not found'}";
        }
        return "{'Status':'OK','Data':'"+get.get(0).getKind()+"'}";
        
    }
}
