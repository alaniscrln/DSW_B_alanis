package es.iespuertodelacruz.rest.alanissimoes.servicios;

import es.iespuertodelacruz.rest.alanissimoes.modelo.Palabra;
import es.iespuertodelacruz.rest.alanissimoes.modelo.PalabraBBDD;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/palabra")
public class Palabras {

    /**
     * Comprobar el funcionamiento del Servicio
     *
     * @return
     */
    @GET
    @Path("/info")
    public Response getInfo() {
        String output = "Servicio Palabras OK ";
        return Response.status(200).entity(output).build();
    }

    /**
     * Obtener palabra por palabra
     * @param palabra palabra
     * @return objeto de la palabra
     */
    @GET
    @Path("/get")
    @Produces("application/json")
    @Consumes(MediaType.APPLICATION_JSON)
    public Palabra getPalabraByPalabra(@QueryParam("p") String palabra){
        Palabra p = null;
        try {
            p = PalabraBBDD.selectPalabra(palabra);
        } catch (Exception ex) {
            System.out.println("No se ha encontrado la palabra: " + ex.getMessage());
        }finally{
            return p;
        }
    }
    
    /**
     * Crear una palabra, guardarla en la bbdd y usarla
     *
     * @param p palabra a crear y usar
     * @return objeto de la palabra creada
     */
    @POST
    @Path("/insert")
    public String usarPalabra(@QueryParam("p") String p) {
        Palabra palabra = new Palabra();
        try {
            palabra.setPalabra(p);
            palabra.setHaSidoUsada(0); // 1 porque la usaremos
            PalabraBBDD.insert(p, palabra.HaSidoUsada());
        } catch (Exception e) {
            palabra = null;
            System.out.println("Error al crear la palabra : " + e.getMessage());
        }
        return palabra.getPalabra();
    }

    /**
     * Usar una palabra random de la bbdd
     *
     * @return palabra de la palabra objeto seleccionada
     */
    @GET
    @Path("/random")
    //@Produces({MediaType.APPLICATION_XML})
    public String usarPalabraRandom() {
        Palabra palabra;
        try {
            palabra = PalabraBBDD.selectRandom();
            palabra.setHaSidoUsada(1);
        } catch (Exception ex) {
            palabra = null;
            System.out.println("Error en seleccionar palabra random: " + ex.getMessage());
        }
        return palabra.getPalabra();
    }

    /**
     * Actualizar valor palabra haSidoUsada
     * @param p palabra a actualizar
     * @return confirmación de que ha sido actualizada
     */
    @PUT
    @Path("/update")
    @Consumes(MediaType.APPLICATION_JSON)
    public String actualizarHaSidoUsada(@QueryParam("p") String p) {
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
    
    /**
     * Reestablecer las palabras a no han sido usadas
     * @return confirmación de que han sido restablecidas
     */
    @PUT
    @Path("/reset")
    @Consumes(MediaType.APPLICATION_JSON)
    public String resetPalabras() {
        String str = "";
        try {
            PalabraBBDD.updateResetPalabras();
            str = "Palabras reseteadas";
        } catch (Exception ex) {
            str = "Palabras no reseteadas";
            System.out.println("Error en resetear palabras: " + ex.getMessage());
        } finally {
            return str;
        }
    }
    
}
