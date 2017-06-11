/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import beans.ExampleBeanLocal;
import javax.ejb.EJB;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author docenteFI
 */
@Path("example")
@RequestScoped
public class ExampleResource {

    @Context
    private UriInfo context;
    
    @EJB
    private ExampleBeanLocal exampleBean;

    /**
     * Creates a new instance of ExampleResource
     */
    public ExampleResource() {
    }

    /**
     * Retrieves representation of an instance of ws.ExampleResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getText() {
        return exampleBean.hola();
    }

    /**
     * PUT method for updating or creating an instance of ExampleResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.TEXT_PLAIN)
    public void putText(String content) {
    }
}
