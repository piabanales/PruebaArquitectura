/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import beans.SingletonBeanLocal;
import javax.ejb.EJB;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author docenteFI
 */
@Path("state")
@RequestScoped
public class StateResource {
    
    @EJB
    private SingletonBeanLocal singletonBean;

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of StateResource
     */
    public StateResource() {
    }

    /**
     * Retrieves representation of an instance of ws.StateResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getText() {
        return singletonBean.getState();
    }
    
    @GET
    @Path("set")
    @Produces(MediaType.TEXT_PLAIN)
    public String setText(@QueryParam("state") String state) {
        return singletonBean.setState(state);
    }

    /**
     * PUT method for updating or creating an instance of StateResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.TEXT_PLAIN)
    public void putText(String content) {
    }
}
