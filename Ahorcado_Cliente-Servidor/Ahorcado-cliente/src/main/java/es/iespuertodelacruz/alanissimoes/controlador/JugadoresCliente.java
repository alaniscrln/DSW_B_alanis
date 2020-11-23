package es.iespuertodelacruz.alanissimoes.controlador;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import org.glassfish.jersey.jackson.JacksonFeature;

public class JugadoresCliente {

    public static String getInfoServicio() {
        //GET
        Client client = ClientBuilder.newBuilder()
                .register(JacksonFeature.class)
                .build();

        WebTarget target = client.target("http://localhost:8080/ahorcado/")
                .path("jugador/info");
        String response = target.request().get().readEntity(String.class);
        return response;
    }

    public static Jugador getJugadorByNombre(String nombre) {
        //GET
        Client client = ClientBuilder.newBuilder()
                .register(JacksonFeature.class)
                .build();

        WebTarget target = client.target("http://localhost:8080/ahorcado/")
                .path("jugador/get").queryParam("nombre", nombre);
        Jugador jugador = target.request().get().readEntity(Jugador.class);
        return jugador;
    }

    public static String crearJugador(String nombre) {
        //POST
        Client client = ClientBuilder.newBuilder()
                .register(JacksonFeature.class)
                .build();

        WebTarget target = client.target("http://localhost:8080/ahorcado")
                .path("/jugador/crear");
        target = target.queryParam("nombre", nombre);
        String response = target.request().post(null, String.class);
        return response;
    }

    public static Response updatePuntosJugador(String nombre) {
        //PUT
        Client client = ClientBuilder.newBuilder()
                .register(JacksonFeature.class)
                .build();
        WebTarget target = client.target("http://localhost:8080/ahorcado");
        target = target.queryParam("nombre", nombre);

        Jugador jugador = target.path("/jugador/get")
                .queryParam("nombre", nombre)
                .request().get(Jugador.class);

        jugador.setPuntos(jugador.getPuntos()); //prueba

        target = client.target("http://localhost:8080/ahorcado")
                .path("/jugador/update").queryParam("nombre", nombre);
        Response response = target.request().put(Entity.json(jugador));
        return response;
    }

    public static void delJugadores() {
        //DELETE
        Client client = ClientBuilder.newBuilder()
                .register(JacksonFeature.class)
                .build();
        WebTarget target = client.target("http://localhost:8080/ahorcado")
                .path("/jugador/eliminar");

        target.request().delete();
    }

}
