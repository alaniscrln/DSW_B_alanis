package es.iespuertodelacruz.rest.alanissimoes.servicios;

import es.iespuertodelacruz.rest.alanissimoes.modelo.Alumno;
import es.iespuertodelacruz.rest.alanissimoes.modelo.AlumnoBBDD;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.Produces;

@Path("/alumnos")
public class Alumnos {

    @GET
    @Path("/info")
    public Response getInfo() {
        String output = "Servicio Alumnos OK ";
        return Response.status(200).entity(output).build();
    }

//    @GET
//    @Path("/xml")
//    @Produces({MediaType.APPLICATION_XML})
//    public Alumno getXml() {
//        return generarAlumno();
//    }
//    @GET
//    @Path("/json")
//    @Produces({MediaType.APPLICATION_JSON})
//    public Alumno getJson() {
//        return generarAlumno();
//    }
//
//    @GET
//    @Path("/text")
//    @Produces({ MediaType.TEXT_PLAIN })
//    public String getHTML() {
//        return generarAlumno().toString();
//    }
    @GET
    @Path("/get/{id}")
    @Produces({MediaType.APPLICATION_XML})
    public Alumno getAlumno(@PathParam("id") int id) {
        return AlumnoBBDD.select(id);
    }

    @POST
    @Path("/post/{id}/{nombre}/{apellidos}/{nota}")
    @Produces({MediaType.TEXT_PLAIN})
    public String crearAlumno(@PathParam("id") int id, @PathParam("nombre") String nombre,
            @PathParam("apellidos") String apellidos, @PathParam("nota") int nota) {
        
        try {
            System.out.println(id + "  " + nombre + apellidos + nota);
            Alumno alumno = new Alumno(id, nombre, apellidos, nota);
            return "Se creó el alumno: " + alumno.toString();
        } catch (Exception e) {
            return "No se pudo crear el alumno";
        }
    }
}
