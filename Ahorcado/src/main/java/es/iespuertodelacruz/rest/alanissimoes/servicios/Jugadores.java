/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.iespuertodelacruz.rest.alanissimoes.servicios;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

/**
 *
 * @author Alanis
 */

@Path("/jugador")
public class Jugadores {
    
    /**
     * Comprobar el funcionamiento del Servicio
     * @return 
     */
    @GET
    @Path("/info")
    public Response getInfo() {
        String output = "Servicio Jugadores OK ";
        return Response.status(200).entity(output).build();
    }

    /*
    metodos a crear:
    crear jugador
    getjugador
    eliminar jugador
    */
    
}
