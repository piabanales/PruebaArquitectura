/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import beans.CasaBean;
import beans.UsuarioBeanLocal;
import javax.ejb.EJB;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author docenteFI
 */
@Path("casas")
public class CasasResource {
    
    @EJB
    private CasaBean casaBean;

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of CasasResource
     */
    public CasasResource() {
    }

    /**
     * Retrieves representation of an instance of ws.CasasResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
        return casaBean.test("Hola Casas");
    }

    /**
     * PUT method for updating or creating an instance of CasasResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
