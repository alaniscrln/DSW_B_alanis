package es.iespuertodelacruz.alanissimoes;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import org.glassfish.jersey.client.ClientProperties;
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
        String response = target.request(/*MediaType.APPLICATION_XML*/).post(null, String.class);
        return response;
    }
    
    public static Response updateHaSidoUsada(String palabra){
        //PUT
        Client client = ClientBuilder.newBuilder()
                .register(JacksonFeature.class)
                .build();
        WebTarget target = client.target("http://localhost:8080/ahorcado");
        //.path("/palabra/update");
        target = target.queryParam("p", palabra);
        
        Palabra p = target.path("/palabra/get")
                .queryParam("p", palabra)
                .request().get(Palabra.class);
        p.setHaSidoUsada(1);
        
        target = client.target("http://localhost:8080/ahorcado").path("/palabra/update");
        Response response = target.request().put(Entity.json(p));
        return response;
    }
    
    
//    public static Response updateHaSidoUsada(String palabra){
//        //PUT
//        Client client = ClientBuilder.newBuilder()
//                .register(JacksonFeature.class)
//                .build();
//        
//        Palabra updatePalabra = new Palabra(palabra, 1);
//
//        client.property(ClientProperties.SUPPRESS_HTTP_COMPLIANCE_VALIDATION, true);
//        WebTarget target = client.target("http://localhost:8080/ahorcado").path("/palabra/update");
//        target = target.queryParam("p", palabra);
//        Response response = target.request().put(Entity.xml(updatePalabra));
//        return response;
//    }
    
}
