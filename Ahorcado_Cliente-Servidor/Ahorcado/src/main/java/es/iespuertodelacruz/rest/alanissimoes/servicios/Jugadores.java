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
    
    /**
     * Obtener jugador por nombre de la BBDD jugador
     * @param nombre nombre del jugador a obtner
     * @return objeto del jugador
     */
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

    /**
     * Crear jugador en la BBDD jugador
     * @param nombre nombre del jugador
     * @return objeto jugador creado
     */
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

    /**
     * Eliminar jugadores de la tabla jugadores
     * @return confirmación de que han sido eliminados
     */
    @DELETE
    @Path("/eliminar")
    public String eliminarJugadores(){
        String str;
        try {
        JugadorBBDD.deleteJugadores();
        str = "Jugadores eliminados";
        }catch (Exception ex) {
            str = "Jugadores no eliminados: " + ex.getMessage();
        }
        return str;
    }
    
    /**
     * Actualizar puntos del jugador
     * @param nombre nombre del jugador
     * @return confirmación de que ha sido actualizado
     */
    @PUT
    @Path("/update")
    @Consumes(MediaType.APPLICATION_JSON)
    public String updatePuntos(@QueryParam("nombre") String nombre){
        String str;
        try {
            JugadorBBDD.updatePuntos(nombre);
            str = "Jugador actualizado";
        }catch (Exception ex) {
            str = "Jugador no actualizado";
            System.out.println("Error en actualizar puntos jugador: " + ex.getMessage());
        }
        return str;
    }

}
