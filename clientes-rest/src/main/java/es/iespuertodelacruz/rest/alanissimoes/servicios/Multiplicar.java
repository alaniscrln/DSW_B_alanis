package es.iespuertodelacruz.rest.alanissimoes.servicios;

import es.iespuertodelacruz.rest.alanissimoes.controlador.Multiplicacion;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

//http://localhost:8080/calculadoraREST_Alanis_Simoes/calculadora/multiplicar?numero1=2&numero2=1
@Path("/multiplicar")
public class Multiplicar {

    @GET
    @Path("/{numero1}/{numero2}")
    public Response operar(@PathParam("numero1") String numero1, @PathParam("numero2") String numero2) {
        double resultado = 0;

        Multiplicacion multiplicacion = new Multiplicacion();
        resultado = multiplicacion.multiplicar(numero1, numero2);

        String output = numero1 + " * " + numero2 + " = " + resultado;
        //Simply return the parameter passed as message
        return Response.status(200).entity(output).build();
    }

}
