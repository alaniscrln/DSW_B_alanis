package es.iespuertodelacruz.alanissimoes;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import org.glassfish.jersey.jackson.JacksonFeature;

public class Palabras {

    public static String getInfoServicio() {
        //GET
        Client client = ClientBuilder.newBuilder()
                .register(JacksonFeature.class)
                .build();

        WebTarget target = client.target("http://localhost:8080/ahorcado/").path("palabra/info");
        String response = target.request().get().readEntity(String.class);
        return response; 
    }
    
    public static String getPalabraRandom() {
        //GET
        Client client = ClientBuilder.newBuilder()
                .register(JacksonFeature.class)
                .build();

        WebTarget target = client.target("http://localhost:8080/ahorcado/").path("palabra/random");
        String response = target.request(MediaType.APPLICATION_XML).get().readEntity(String.class);
        return response;
    }

    public static String insertarPalabra(String palabra) {
        //POST
        Client client = ClientBuilder.newBuilder()
                .register(JacksonFeature.class)
                .build();

        WebTarget target = client.target("http://localhost:8080/ahorcado").path("/palabra/insert");
        target = target.queryParam("p", palabra);
        String response = target.request(MediaType.APPLICATION_XML).post(null, String.class);
        return response;
    }
    
}
