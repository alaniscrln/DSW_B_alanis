package es.iespuertolacruz.rest.alanissimoes.servicios;

import es.iespuertodelacruz.rest.alanissimoes.controlador.Resta;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

//http://localhost:8080/calculadoraREST_Alanis_Simoes/calculadora/restar?numero1=2&numero2=1
@Path("/restar")
public class Restar {

    @GET
    public Response operar(@QueryParam("numero1") String numero1, @QueryParam("numero2") String numero2) {
        double resultado = 0;

        Resta resta = new Resta();
        resultado = resta.restar(numero1, numero2);

        String output = "La resta de los números " + numero1 + " y " + numero2 + " es igual a " + resultado + ".";
        //Simply return the parameter passed as message
        return Response.status(200).entity(output).build();
    }

}
