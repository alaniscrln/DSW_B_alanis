package es.iespuertolacruz.jpexposito;

import org.glassfish.jersey.jackson.JacksonFeature;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

public class MultiplicacionClientePost {

    public static void main(String[] args) {

        Client client = ClientBuilder.newBuilder()
                .register(JacksonFeature.class)
                .build();

        WebTarget target = client.target("http://localhost:8080").path("/rest/multiplicar/1/2");
        String response = target.request().post(null, String.class);

        System.out.println("Respuesta :"+response);

    }
}

