package es.iespuertodelacruz.rest.alanissimoes.servicios;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import es.iespuertodelacruz.rest.alanissimoes.modelo.Empleado;
import es.iespuertodelacruz.rest.alanissimoes.modelo.EmpleadoBBDD;
import es.iespuertodelacruz.rest.alanissimoes.modelo.Empleados;
import java.util.ArrayList;
import javax.ws.rs.DELETE;
import javax.ws.rs.PUT;
import javax.ws.rs.core.Response;

@Path("/empleado")
public class EmpleadosServicio {
    
    @GET
    @Path("/info")
    public Response getInfo() {
        String output = "Servicio Empleados OK ";
        return Response.status(200).entity(output).build();
    }
    @GET
    @Produces("application/xml")
    @Path("/get-empleados")
    public ArrayList<Empleado> getEmpleados() {
        Empleados objEmpleados = EmpleadoBBDD.selectAll();
        return objEmpleados.getEmpleados();
    }
   
    @POST
    @Produces("application/xml")
    @Path("/crear-empleado")
    public Empleado crearEmpleado(@QueryParam("dni") String dni, @QueryParam("nombre") String nombre, @QueryParam("apellidos") String apellidos) {
        Empleado empleado = new Empleado(dni, nombre, apellidos);
        EmpleadoBBDD.insert(dni, nombre, apellidos);
        return empleado;
    }

    @POST
    @Produces("application/xml")
    @Path("/get-empleado")
    public Empleado getEmpleado(@QueryParam("dni") String dni) {
        Empleado empleado = EmpleadoBBDD.selectEmpleado(dni);
        return empleado;
    }
    
    @DELETE
    @Path("/delete-empleado")
    public void deleteEmpleado(@QueryParam("dni") String dni){
        EmpleadoBBDD.delete(dni);
    }
    
    @PUT
    @Path("/update-empleado")
    public void updateEmpleado(@QueryParam("dni") String dni, @QueryParam("nombre") String nombre, @QueryParam("apellidos") String apellidos){
        EmpleadoBBDD.updateEmpleado(dni, nombre, apellidos);
    }
    
}
