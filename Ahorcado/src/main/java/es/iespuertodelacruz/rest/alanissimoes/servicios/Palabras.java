package es.iespuertodelacruz.rest.alanissimoes.servicios;

import es.iespuertodelacruz.rest.alanissimoes.modelo.Palabra;
import es.iespuertodelacruz.rest.alanissimoes.modelo.PalabraBBDD;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author Alanis
 */
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
            palabra.setHaSidoUsada(1); // 1 porque la usaremos
            PalabraBBDD.insert(p, palabra.HaSidoUsada());
        } catch (Exception e) {
            palabra = null;
            System.out.println("Error al crear la palabra : " + e.getMessage());
        }
        return palabra.getPalabra();
    }
//    @POST
//    @Path("/insert")
//    public String usarPalabra(@QueryParam("p") String p) {
//        Palabra palabra = new Palabra();
//        try {
//            ConexionInicioPalabraBBDD.crearTabla();
//            System.out.println(p);
//            palabra.setPalabra(p);
//            palabra.setHaSidoUsada(1); // 1 porque la usaremos
//            PalabraBBDD.insert(p, palabra.HaSidoUsada());
//        } catch (Exception e) {
//            palabra = null;
//            System.out.println("Error al crear la palabra : " + e.getMessage());
//        }
//        return palabra.toString();
//    }

    /**
     * Usar una palabra random de la bbdd
     *
     * @return objeto de la palabra seleccionada
     */
    @GET
    @Path("/random")
    @Produces({MediaType.APPLICATION_XML})
    public String usarPalabraRandom() {
        Palabra palabra = PalabraBBDD.selectRandom();
        palabra.setHaSidoUsada(1);
        return palabra.getPalabra();
    }

}
