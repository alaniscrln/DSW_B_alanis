package es.iespuertolacruz.rest.jpexposito.servicios;

import es.iespuertolacruz.rest.jpexposito.modelo.Alumno;

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

    @GET
    @Path("/xml")
    @Produces({MediaType.APPLICATION_XML})
    public Alumno getXml() {
        return generarAlumno();
    }

    @GET
    @Path("/json")
    @Produces({MediaType.APPLICATION_JSON})
    public Alumno getJson() {
        return generarAlumno();
    }

    @GET
    @Path("/text")
    @Produces({ MediaType.TEXT_PLAIN })
    public String getHTML() {
        return generarAlumno().toString();
    }

    private Alumno generarAlumno() {
        Alumno alumno = new Alumno("Juan", "Martín Pérez", 8);
        return alumno;
    }


}
