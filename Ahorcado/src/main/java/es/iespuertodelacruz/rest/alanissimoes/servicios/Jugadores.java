package es.iespuertodelacruz.rest.alanissimoes.servicios;

import es.iespuertodelacruz.rest.alanissimoes.modelo.Jugador;
import es.iespuertodelacruz.rest.alanissimoes.modelo.JugadorBBDD;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
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
    @Path("/crear")
    public Jugador crearJugador(@QueryParam("nombre") String nombre) {
        Jugador jugador = new Jugador();
        try {
            jugador.setNombre(nombre);
            jugador.setPuntos(0);
            JugadorBBDD.insert(nombre);
        } catch (Exception e) {
            jugador = null;
            System.out.println("Error al crear al jugador " + nombre + ": " + e.getMessage() );
        }
        return jugador;
    }

    @DELETE
    @Path("/eliminar")
    public String eliminarJugador(@QueryParam("nombre") String nombre){
        String str;
        try {
        JugadorBBDD.delete(nombre);
            str = "Jugador eliminado";
        }catch (Exception ex) {
            str = "Jugador no eliminado: " + ex.getMessage();
        }
        return str;
    }
    
    @PUT
    @Path("/update")
    public String updatePuntos(@QueryParam("nombre") String nombre){
        String str;
        try {
            JugadorBBDD.updatePuntos(nombre);
            str = "Jugador actualizado";
        }catch (Exception ex) {
            str = "Jugador no actualizado";
        }
        return str;
    }
}
