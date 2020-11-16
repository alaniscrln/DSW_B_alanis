/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.iespuertodelacruz.alanissimoes;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import org.glassfish.jersey.jackson.JacksonFeature;

/**
 *
 * @author Alanis
 */
public class JugadoresCliente {

    public static String getInfoServicio() {
        //GET
        Client client = ClientBuilder.newBuilder()
                .register(JacksonFeature.class)
                .build();

        WebTarget target = client.target("http://localhost:8080/ahorcado/").path("jugador/info");
        String response = target.request().get().readEntity(String.class);
        return response;
    }

    public static String crearJugador(String nombre) {
        //POST
        Client client = ClientBuilder.newBuilder()
                .register(JacksonFeature.class)
                .build();

        WebTarget target = client.target("http://localhost:8080/ahorcado").path("/jugador/crear");
        target = target.queryParam("nombre", nombre);
        String response = target.request().post(null, String.class);
        return response;
    }
    
    public static String updatePuntos(String nombre){
        //PUT
        Client client = ClientBuilder.newBuilder()
                .register(JacksonFeature.class)
                .build();

        WebTarget target = client.target("http://localhost:8080/ahorcado").path("/jugador/update");
        target = target.queryParam("nombre", nombre);
        String response = target.request().put(Entity.xml(target), String.class);
        return response;
    }
            
}
