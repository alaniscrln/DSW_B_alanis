package es.iespuertolacruz.jpexposito;

import org.glassfish.jersey.jackson.JacksonFeature;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;

public class HolaMundoCliente {

    public static void main(String[] args) {

        Client client = ClientBuilder.newBuilder()
                .register(JacksonFeature.class)
                .build();

//        WebTarget target = client.target("http://localhost:8080/rest/").path("hola-mundo/jpexposito");
//        String response = target.request().get().readEntity(String.class);
//        System.out.println("Respuesta :" + response);

       // Entity<> entity = ...;
        
        String result = client.target("http://localhost:8080/rest/")
                .path("/sumar").request().post(entity ,String.class);
        
        System.out.println("Respuesta :" + result);

    }
}

