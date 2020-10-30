package es.iespuertolacruz.rest.alanissimoes.servicios;

import es.iespuertodelacruz.rest.alanissimoes.controlador.Suma;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


//http://localhost:8080/calculadoraREST_Alanis_Simoes/calculadora/sumar?numero1=2&numero2=1
@Path("/sumar")
public class Sumar {

    @GET
    @Path("/{numero1}/{numero2}")
    @Produces(MediaType.TEXT_PLAIN)
    public /*Response*/String operar(@PathParam("numero1") String numero1, @PathParam("numero2") String numero2) {
        double resultado = 0;

        Suma suma = new Suma();
        resultado = suma.sumar(numero1, numero2);

        String output = "La suma de los números " + numero1 + " y " + numero2 + " es igual a " + resultado + ".";
        //Simply return the parameter passed as message
        //return Response.status(200).entity(output).build();
        return output;
    }

}
