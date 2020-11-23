package es.iespuertodelacruz.alanissimoes;

import es.iespuertodelacruz.alanissimoes.controlador.JugadoresCliente;
import es.iespuertodelacruz.alanissimoes.controlador.Jugador;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int opNumJugador = 0;
        boolean salirJuego = false;
        boolean jugarOtraVez = false;

        System.out.println("AHORCADO");
        do {
            boolean opCorrecta;
            do {
                System.out.println("\nElige el número de jugadores: "
                        + "\n1.- Un jugador"
                        + "\n2.- Dos jugadores"
                        + "\n0.- Salir"
                        + "\nIntroduzca una opción: ");
                try {
                    opNumJugador = cin.nextInt();
                    cin.nextLine();
                    opCorrecta = true;
                } catch (Exception e) {
                    System.out.println("\nIntroduce una opción correcta, por favor...");
                    cin.nextLine();
                    opCorrecta = false;
                }
            } while (!opCorrecta);

            switch (opNumJugador) {
                case 1:
                    jugarOtraVez = unJugador(cin);
                    break;
                case 2: {
                    jugarOtraVez = dosJugadores(cin);
                    break;
                }
                case 0:
                    MainMetodos.salir();
                    System.out.println("\n¡Gracias por jugar!");
                    salirJuego = true;
                    break;
                default:
                    System.out.println("\nIntroduce una opción correcta, por favor...");
                    jugarOtraVez = true;
            }

        } while (jugarOtraVez && !salirJuego);

    }

    //-----------------------------------------------------------------------------------
    /**
     * Lógica a seguir cuando son dos jugadores
     *
     * @param cin leer datos
     * @return si se quiere jugar otra vez
     * @throws AssertionError
     */
    private static boolean dosJugadores(Scanner cin) throws AssertionError {
        String jugador1;
        String jugador2;
        boolean jugarOtraVez;
        System.out.println("\nNombre del jugador 1: ");
        jugador1 = cin.nextLine();
        JugadoresCliente.crearJugador(jugador1);
        System.out.println("\nNombre del jugador 2: ");
        jugador2 = cin.nextLine();
        JugadoresCliente.crearJugador(jugador2);
        int rondas = MainMetodos.numeroRondas(cin);
        for (int i = 0; i < rondas; i++) {
            System.out.println("\nRonda número " + (i + 1));
            MainMetodos.juegoDual(cin, jugador1, jugador2, i + 1);
            cin.nextLine();
        }
        Jugador jugador1Obj = JugadoresCliente.getJugadorByNombre(jugador1);
        Jugador jugador2Obj = JugadoresCliente.getJugadorByNombre(jugador2);
        System.out.println("\n====================================================");
        System.out.println("\n" + jugador1 + ": ");
        System.out.println("\nRondas ganadas: " + jugador1Obj.getPuntos() + "/" + rondas);
        System.out.println("\n" + jugador2 + ": ");
        System.out.println("\nRondas ganadas: " + jugador2Obj.getPuntos() + "/" + rondas);
        if (jugador1Obj.getPuntos() == jugador2Obj.getPuntos()) {
            System.out.println("\n¡Vaya! Hubo empate...");
        } else {
            String jugadorGanador = (jugador1Obj.getPuntos() > jugador2Obj.getPuntos()) ? jugador1 : jugador2;
            System.out.println("\n¡Felicidades, " + jugadorGanador + ", eres el ganador!");
        }
        System.out.println("\n====================================================");
        jugarOtraVez = MainMetodos.menuJugarOtraVez(cin);
        return jugarOtraVez;
    }

    /**
     * Lógica a seguir cuando es un jugador
     *
     * @param cin leer datos
     * @return si se quiere jugar otra vez
     * @throws AssertionError
     */
    private static boolean unJugador(Scanner cin) throws AssertionError {
        String jugador1;
        boolean jugarOtraVez;
        System.out.println("\nNombre del jugador: ");
        jugador1 = cin.nextLine();
        JugadoresCliente.crearJugador(jugador1);
        int rondas = MainMetodos.numeroRondas(cin);
        for (int i = 0; i < rondas; i++) {
            System.out.println("\nRonda número " + (i + 1));
            MainMetodos.juegoIndividual(cin, jugador1);
        }
        Jugador jugador1Obj = JugadoresCliente.getJugadorByNombre(jugador1);
        System.out.println("\n====================================================");
        System.out.println("\nRondas ganadas: " + jugador1Obj.getPuntos() + "/" + rondas);
        System.out.println("\n====================================================");
        jugarOtraVez = MainMetodos.menuJugarOtraVez(cin);
        return jugarOtraVez;
    }

}
