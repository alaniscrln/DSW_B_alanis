package es.iespuertodelacruz.alanissimoes.controlador;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import org.glassfish.jersey.jackson.JacksonFeature;

public class PalabrasCliente {

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
        String response = target.request().get().readEntity(String.class);
        return response;
    }

    public static String insertarPalabra(String palabra) {
        //POST
        Client client = ClientBuilder.newBuilder()
                .register(JacksonFeature.class)
                .build();

        WebTarget target = client.target("http://localhost:8080/ahorcado").path("/palabra/insert");
        target = target.queryParam("p", palabra);
        String response = target.request().post(null, String.class);
        return response;
    }

    public static Response updateHaSidoUsada(String palabra) {
        //PUT
        Client client = ClientBuilder.newBuilder()
                .register(JacksonFeature.class)
                .build();
        WebTarget target = client.target("http://localhost:8080/ahorcado");

        Palabra p = target.path("/palabra/get")
                .queryParam("p", palabra)
                .request().get(Palabra.class);

        target = client.target("http://localhost:8080/ahorcado").path("/palabra/update").queryParam("p", palabra);
        Response response = target.request().put(Entity.json(p));
        return response;

    }
    
    public static Response resetPalabras() {
        //PUT
        Client client = ClientBuilder.newBuilder()
                .register(JacksonFeature.class)
                .build();
        WebTarget target = client.target("http://localhost:8080/ahorcado");

        Palabra p = target.path("/palabra/get")
                .queryParam("p", "electroencefalograma")
                .request().get(Palabra.class);
        // al ser put me pide obligatoriamente poner algo en el (put), no sé por que. por eso está el obj p
         //pero realmente no se utiliza para nada
        target = client.target("http://localhost:8080/ahorcado").path("/palabra/reset");
        Response response = target.request().put(Entity.json(p));
        return response;

    }

}
