/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.heilwig.rfidbin.resources;

import de.heilwig.rfidbin.Config;
import de.heilwig.rfidbin.entity.Company;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

/**
 *
 * @author Moritz
 */
@Stateless
@Path("registerCompany/{MasterPass}/{ApiKey}/{CompanyId}")
public class registerCompanyResource {
    @PersistenceContext
    EntityManager em;
    @POST
    public String registerCompany(@PathParam("MasterPass") String masterPass, @PathParam("ApiKey") String apiKey, @PathParam("CompanyId") String companyId){
        if(Config.checkMasterPass(masterPass)){
            Company company = new Company();
            company.setApiKey(apiKey);
            company.setCompanyId(companyId);
            //em.merge(company);
            em.persist(company);
            return "{'Status':'OK','Data':'Company successfully registered'}";
        }else{
            return "{'Status':'Error','Data':'Authentification failed'}";
        }
    }
}
