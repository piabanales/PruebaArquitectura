/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import beans.UsuarioBeanLocal;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import javax.ejb.EJB;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;

/**
 * REST Web Service
 *
 * @author docenteFI
 */
@Path("personas")
public class PersonasResource {
    
    @EJB
    private UsuarioBeanLocal userBean;

    public PersonasResource() {
    }

    /**
     * Retrieves representation of an instance of ws.PersonasResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces("application/json")
    public String getJson() {
        return userBean.getPersonas().toString(); //"{\"nombre\": \"juan\", \"apellido\": \"perez\"}";   
    }
    
    @GET
    @Path("token")
    public String getToken() {
        return UUID.randomUUID().toString();
    }
    
    @GET
    @Path("auth")
    public String auth(
            @HeaderParam("token") String token) {
        return "Token: " + token;
    }
    
    @GET
    @Path("response")
    @Produces("application/json")
    public Response getResponse() {
        String json = "{\"nombre\": \"juan\", \"apellido\": \"perez\"}";
        return Response.ok(json, "application/json").build();
    }
    
    @GET
    @Path("example")
    public String getExample(
            @QueryParam("nombre") String name,
            @QueryParam("apellido") String surname) {
        return name + " " + surname;
    }
    
    @GET
    @Path("get/{nombre}/{apellido}")
    public String getName(
            @PathParam("nombre") String name,
            @PathParam("apellido") String surname) {
        return "Persona: " + name + " " + surname;
    }
    
    @POST
    @Path("json")
    @Consumes("application/json")
    public String getString(String json) {
        return "Persona: " + json;
    }
    
    @POST
    @Path("form")
    @Consumes("application/x-www-form-urlencoded")
    public String post(
            @FormParam("nombre") String name,
            @FormParam("apellido") String surname) {
        return userBean.addUser(name, surname);
    }
    
    @GET
    @Path("map")
    public String map(@Context UriInfo ui) {
        MultivaluedMap<String, String> queryParams = ui.getQueryParameters();
        MultivaluedMap<String, String> pathParams = ui.getPathParameters();
        String nombre = queryParams.getFirst("nombre");
        return "Nombre: " + nombre;
    }

    /**
     * PUT method for updating or creating an instance of PersonasResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
