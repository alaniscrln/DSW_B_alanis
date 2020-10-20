/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PizzaAutentiaPkg;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

/**
 * REST Web Service
 *
 * @author Alanis
 */
@Path("/ps")
public class PizzasRecursos {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of PizzasRecursos
     */
    public PizzasRecursos() {
    }

    /**
     * Retrieves representation of an instance of PizzaAutentiaPkg.PizzasRecursos
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(javax.ws.rs.core.MediaType.APPLICATION_XML)
    public String getXml() {
        //TODO return proper representation object
        
        return "<datos>Ejemplo Colección</datos>";
        //throw new UnsupportedOperationException();
    }

    /**
     * POST method for creating an instance of PizzaRecurso
     * @param content representation for the new resource
     * @return an HTTP response with content of the created resource
     */
    @POST
    @Consumes(javax.ws.rs.core.MediaType.APPLICATION_XML)
    @Produces(javax.ws.rs.core.MediaType.APPLICATION_XML)
    public javax.ws.rs.core.Response postXml(String content) {
        //TODO
        return Response.created(context.getAbsolutePath()).build();
    }

    /**
     * Sub-resource locator method for {id}
     */
    @Path("{id}")
    public PizzaRecurso getPizzaRecurso(@PathParam("id") String id) {
        return PizzaRecurso.getInstance(id);
    }
}
