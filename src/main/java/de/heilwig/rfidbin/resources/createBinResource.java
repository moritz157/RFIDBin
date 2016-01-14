/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.heilwig.rfidbin.resources;

import de.heilwig.rfidbin.Config;
import de.heilwig.rfidbin.entity.Bin;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

/**
 *
 * @author Moritz
 */
@Stateless
@Path("createBin/{Master-Pass}/{Name}/{longitude}/{latitude}")
public class createBinResource {
    
    @PersistenceContext
    EntityManager em;
    
    @POST
    public String createBin(@PathParam("Master-Pass") String masterPass, @PathParam("Name") String name, @PathParam("longitude") double longitude, @PathParam("latitude") double latitude){
        if(Config.checkMasterPass(masterPass)){
            Bin bin = new Bin();
            bin.setName(name);
            bin.setLongitude(longitude);
            bin.setLatitude(latitude);
            em.persist(bin);
            return "{'Status':'OK','Data':'Bin successfully created'}";
        }
        return "{'Status':'Error','Data':'Authentification failed'}";
    }
}
