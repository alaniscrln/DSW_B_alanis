/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.iespuertodelacruz.rest.alanissimoes.servicios;

import es.iespuertodelacruz.rest.alanissimoes.modelo.Jugador;
import es.iespuertodelacruz.rest.alanissimoes.modelo.JugadorBBDD;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
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
     *
     * @return
     */
    @GET
    @Path("/info")
    public Response getInfo() {
        String output = "Servicio Jugadores OK ";
        return Response.status(200).entity(output).build();
    }

    @POST
    @Path("/crear-jugador")
    public void crearJugador(int id, String nombre) {
        try {
            Jugador jugador = new Jugador(id, nombre);
        } catch (Exception e) {
            System.out.println("Error al crear al jugador " + nombre + ": " + e.getMessage() );
        }
    }

    @DELETE
    @Path("/eliminar-jugador")
    public void eliminarJugador(int id){
        JugadorBBDD.delete(id);
    }
    
    
    
    /*
    metodos a crear:
    crear jugador
    eliminar jugador
     */
}
