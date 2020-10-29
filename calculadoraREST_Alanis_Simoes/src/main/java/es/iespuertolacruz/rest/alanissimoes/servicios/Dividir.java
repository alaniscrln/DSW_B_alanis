package es.iespuertolacruz.rest.alanissimoes.servicios;

import es.iespuertodelacruz.rest.alanissimoes.controlador.Division;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

//http://localhost:8080/calculadoraREST_Alanis_Simoes/calculadora/dividir?numero1=2&numero2=1
@Path("/dividir")
public class Dividir {

    @GET
    public Response operar(@QueryParam("numero1") String numero1, @QueryParam("numero2") String numero2) {
        double resultado = 0;

        Division division = new Division();
        resultado = division.dividir(numero1, numero2);

        String output = "La división de los números " + numero1 + " y " + numero2 + " es igual a " + resultado + ".";
        //Simply return the parameter passed as message
        return Response.status(200).entity(output).build();
    }

}
