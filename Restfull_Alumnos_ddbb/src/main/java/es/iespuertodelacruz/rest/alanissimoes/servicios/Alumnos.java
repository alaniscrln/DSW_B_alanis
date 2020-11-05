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

    @GET
    @Path("/mostrar-alumnos")
    @Produces({MediaType.TEXT_PLAIN})
    public String getAlumnos(){
        return AlumnoBBDD.selectAll();
    }
    
    @GET
    @Path("/get/{id}")
    @Produces({MediaType.APPLICATION_XML})
    public Alumno getAlumno(@PathParam("id") int id) {
        return AlumnoBBDD.select(id);
    }

    @POST
    @Path("/create/{id}/{nombre}/{apellidos}/{nota}")
    @Produces({MediaType.TEXT_PLAIN})
    public String crearAlumno(@PathParam("id") int id, @PathParam("nombre") String nombre,
            @PathParam("apellidos") String apellidos, @PathParam("nota") int nota) {
        
        try {
            Alumno alumno = new Alumno(id, nombre, apellidos, nota);
            return "Se creó el alumno: " + alumno.toString();
        } catch (Exception e) {
            return "No se pudo crear el alumno";
        }
    }
    
    @DELETE
    @Path("/delete/{id}")
    @Produces({MediaType.TEXT_PLAIN})
    public String eliminarAlumno(@PathParam("id") int id){
        if (AlumnoBBDD.delete(id)) {
            return "Se ha eliminado el alumno con éxito.";
        }else{
            return "No se ha podido eliminar el alumno.";
        }
    }

    
    //  /update/nombre/alanis carolina?id=5
    @PUT
    @Path("/update/{atributo}/{valor}/{id}")
    @Produces({MediaType.TEXT_PLAIN})
    public String updateAlumno(@PathParam("atributo") String atributo, 
            @PathParam("valor") String valor, @PathParam("id") int id){
        
        String result = "";
        try {
            switch (atributo) {
                case "nombre":
                    if (AlumnoBBDD.updateNombre(valor, id)) {
                        result = "Nombre actualizado.";
                    }else{
                        result = "ERROR. Nombre no actualizado.";
                    }
                    break;
                case "apellidos":
                    if (AlumnoBBDD.updateApellidos(valor, id)) {
                        result = "Apellidos actualizados.";
                    }else{
                        result = "ERROR. Apellidos no actualizado.";
                    }
                    break;
                case "nota":
                    int nota = Integer.parseInt(valor);
                    if (AlumnoBBDD.updateNota(nota, id)) {
                        result = "Nota actualizada.";
                    }else{
                        result = "ERROR. Nota no actualizada.";
                    }
                    break;
                default:
                    throw new AssertionError();
            }
        } catch (Exception e) {
            result = "error.";
        }
        return result;
    }

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