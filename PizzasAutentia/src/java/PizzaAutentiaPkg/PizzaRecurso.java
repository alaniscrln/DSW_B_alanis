/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PizzaAutentiaPkg;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.DELETE;

/**
 * REST Web Service
 *
 * @author Alanis
 */
public class PizzaRecurso {

    private String id;

    /**
     * Creates a new instance of PizzaRecurso
     */
    private PizzaRecurso(String id) {
        this.id = id;
    }

    /**
     * Get instance of the PizzaRecurso
     */
    public static PizzaRecurso getInstance(String id) {
        // The user may use some kind of persistence mechanism
        // to store and restore instances of PizzaRecurso class.
        return new PizzaRecurso(id);
    }

    /**
     * Retrieves representation of an instance of PizzaAutentiaPkg.PizzaRecurso
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(javax.ws.rs.core.MediaType.APPLICATION_XML)
    public String getXml() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }

    /**
     * PUT method for updating or creating an instance of PizzaRecurso
     * @param content representation for the resource
     */
    @PUT
    @Consumes(javax.ws.rs.core.MediaType.APPLICATION_XML)
    public void putXml(String content) {
    }

    /**
     * DELETE method for resource PizzaRecurso
     */
    @DELETE
    public void delete() {
    }
}
