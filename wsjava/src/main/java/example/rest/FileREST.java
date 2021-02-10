/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package example.rest;

import example.controlador.file.UsuarioFileControlador;
import example.exception.DatosIncorrectosException;
import example.exception.UsuarioExisteException;
import example.modelo.Usuario;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author Alanis
 */
@Path("/restfile")
public class FileREST {
    
    @POST
    @Path("/insert")
    @Produces(MediaType.APPLICATION_JSON)    
    /**
     * genera y retorna un numero aleatorio
     * @return Response
     */
    public Response insertar(@QueryParam("dni") String dni, @QueryParam("nombre") String nombre, @QueryParam("apellidos") String apellidos) throws DatosIncorrectosException, UsuarioExisteException{
        
        UsuarioFileControlador ufc = new UsuarioFileControlador();
        Usuario usu = ufc.insertar(dni, nombre, apellidos);
        
        return Response.ok(
                response("Insertar usuario", "", usu), 
                MediaType.APPLICATION_JSON).build();
    }
    
    private String response(String operation, String parameter, Usuario result) {
        JSONObject obj = new JSONObject();
        JSONObject usuario = new JSONObject();
        try {
            
            usuario.put("dni", result.getDni());
            usuario.put("nombre", result.getNombre());
            usuario.put("apellidos", result.getApellido());
            
            obj.put("operacion", operation);
            obj.put("parametro", parameter);
            obj.put("resultado", usuario);            
            return obj.toString(4);
        } catch (JSONException ex) {
            System.err.println("JSONException: " + ex.getMessage());
        }
        return "";
    }
    
}
