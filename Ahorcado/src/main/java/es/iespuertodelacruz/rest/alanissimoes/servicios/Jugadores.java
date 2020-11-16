package es.iespuertodelacruz.rest.alanissimoes.servicios;

import es.iespuertodelacruz.rest.alanissimoes.modelo.Jugador;
import es.iespuertodelacruz.rest.alanissimoes.modelo.JugadorBBDD;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
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
    
    @GET
    @Path("/get")
    @Produces("application/json")
    @Consumes(MediaType.APPLICATION_JSON)
    public Jugador getJugadorByNombre(@QueryParam("nombre") String nombre){
        Jugador jugador = null;
        try {
            jugador = JugadorBBDD.selectJugador(nombre);
        } catch (Exception ex) {
            System.out.println("No se ha encontrado el jugador: " + ex.getMessage());
        }finally{
            return jugador;
        }
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
    
    
    /*
    
    @PUT
    @Path("/update")
    @Consumes(MediaType.APPLICATION_XML)
    public String actualizarHaSidoUsada(@QueryParam("p") String p, Palabra updatePalabra) {
        String str = "";
        try {
            PalabraBBDD.updateHaSidoUsada(p);
            str = "Palabra actualizada";
        } catch (Exception ex) {
            str = "Palabra no actualizada";
            System.out.println("Error en actualizar palabra haSidoUsada: " + ex.getMessage());
        } finally {
            return str;
        }
    }
    */
    @PUT
    @Path("/update")
    @Consumes(MediaType.APPLICATION_XML)
    public String updatePuntos(@QueryParam("nombre") String nombre){
        String str;
        try {
            System.out.println("hola, paso por aqui ewe");
            JugadorBBDD.updatePuntos(nombre);
            System.out.println("puntos actualizados owo");
            str = "Jugador actualizado";
        }catch (Exception ex) {
            str = "Jugador no actualizado";
            System.out.println("Error en actualizar puntos jugador: " + ex.getMessage());
        }
        return str;
    }
}
