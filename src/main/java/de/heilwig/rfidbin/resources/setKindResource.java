/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.heilwig.rfidbin.resources;

import de.heilwig.rfidbin.entity.Company;
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
@Path("setKind/{APIKey}/{CompanyID}/{SerialNumber}/{Kind}")
public class setKindResource {
   @PersistenceContext
   EntityManager em;
   
   @POST
   public String setKind(@PathParam("APIKey") String apiKey, @PathParam("CompanyID") String companyId, @PathParam("SerialNumber") String serialNumber, @PathParam("Kind") int kind){
       //Check ApiKey
       Query createNativeQuery = em.createNativeQuery("SELECT * from COMPANY WHERE apiKey = '"+apiKey+"'", Company.class);
       List<Company> get = (List<Company>) createNativeQuery.getResultList();
       //If any Company has the entered apiKey
       if(!get.isEmpty()){
           //If the entered companyId is equal to the companyId in the database
           if(get.get(0).getCompanyId().equals(companyId)){       
                //Register Product
                Product product = new Product();
                product.setSerialNumber(serialNumber);
                product.setKind(kind);
                //em.merge(product);
                em.persist(product);
                return "{'Status':'OK','Data':'Kind successfully setted'}";
           }
       }
       return "{'Status':'Error','Data':'Unvalid API-Key}";

   }
}
