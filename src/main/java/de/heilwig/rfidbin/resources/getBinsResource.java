/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.heilwig.rfidbin.resources;

import de.heilwig.rfidbin.entity.Bin;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 *
 * @author Moritz
 */
@Stateless
@Path("getBins")
public class getBinsResource {
    @PersistenceContext
    EntityManager em;
    @GET
    @Produces(value = "application/json")
    public List<Bin> getBins(){
        Query createNativeQuery = em.createNativeQuery("SELECT * from Bin", Bin.class);
        List<Bin> get = (List<Bin>) createNativeQuery.getResultList();        
        return get;
    }
    
}
