package es.iespuertodelacruz.alanissimoes;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        String jugador1 = "";
        String jugador2 = "";
        int op, opNumJugador;
        boolean salirJuego = false;
        boolean jugarOtraVez = false;
        System.out.println("AHORCADO");

        do {
            System.out.println("\nElige el número de jugadores: "
                    + "\n1.- Un jugador"
                    + "\n2.- Dos jugadores"
                    + "\n0.- Salir"
                    + "\nIntroduzca una opción: ");
            opNumJugador = cin.nextInt();
            cin.nextLine();
            switch (opNumJugador) {
                case 1: {
                    System.out.println("\nNombre del jugador: ");
                    jugador1 = cin.nextLine();
                    JugadoresCliente.crearJugador(jugador1);
                    int rondas = numeroRondas(cin);
                    for (int i = 0; i < rondas; i++) {
                        System.out.println("\nRonda número " + (i + 1));
                        juegoIndividual(cin, jugador1);
                    }
                    Jugador jugador1Obj = JugadoresCliente.getJugadorByNombre(jugador1);
                    System.out.println("\n====================================================");
                    System.out.println("\nRondas ganadas: " + jugador1Obj.getPuntos() + "/" + rondas);
                    System.out.println("\n====================================================");

                    jugarOtraVez = menuJugarOtraVez(cin);

                    break;
                }
                case 2: {
                    System.out.println("\nNombre del jugador 1: ");
                    jugador1 = cin.nextLine();
                    JugadoresCliente.crearJugador(jugador1);
                    System.out.println("\nNombre del jugador 2: ");
                    jugador2 = cin.nextLine();
                    JugadoresCliente.crearJugador(jugador2);

                    int rondas = numeroRondas(cin);
                    for (int i = 0; i < rondas; i++) {
                        System.out.println("\nRonda número " + (i + 1));
                        juegoDual(cin, jugador1, jugador2, i + 1);
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

                    jugarOtraVez = menuJugarOtraVez(cin);

                    break;
                }
                case 0:
                    salir();
                    System.out.println("\n¡Gracias por jugar!");
                    salirJuego = true;
                    break;
                default:
                    throw new AssertionError();
            }

        } while (jugarOtraVez && !salirJuego);

    }

    private static void salir() {
        JugadoresCliente.delJugadores();
        PalabrasCliente.resetPalabras();
    }

    private static boolean menuJugarOtraVez(Scanner cin) throws AssertionError {
        boolean jugarOtraVez = false;
        //menu de salir o jugar otra vez (si se juega otra vez hay q resetear todo)
        System.out.println("\n1.- Jugar otra vez"
                + "\n0.- Salir"
                + "\nIntroduzca una opción: ");
        int opRepetir = cin.nextInt();
        switch (opRepetir) {
            case 1:
                PalabrasCliente.resetPalabras();
                JugadoresCliente.delJugadores();
                jugarOtraVez = true;
                break;
            case 0:
                salir();
                System.out.println("\n¡Gracias por jugar!");
                break;
            default:
                throw new AssertionError();
        }
        return jugarOtraVez;
    }

    private static int numeroRondas(Scanner cin) {
        System.out.println("\n¿Cuántas rondas quiere jugar?");
        int rondas = 0;
        do {
            try {
                rondas = cin.nextInt();
                cin.nextLine();
            } catch (Exception e) {
                System.out.println("\nIntroduzca un número, por favor...");
            }
        } while (rondas <= 0);
        return rondas;
    }

    private static void juegoIndividual(Scanner cin, String jugador) {
        String palabraJugada = PalabrasCliente.getPalabraRandom();
        System.out.println(palabraJugada);
        PalabrasCliente.updateHaSidoUsada(palabraJugada);   // marcarla como que ya ha sido usada
        System.out.println("Palabra a jugar: " + palabraJugada);
        boolean haGanado = juego(palabraJugada, cin);
        if (haGanado) {
            JugadoresCliente.updatePuntosJugador(jugador);
        }
    }

    private static void juegoDual(Scanner cin, String jugador1, String jugador2, int ronda) {
        String palabraJugada;
        String palabraJugador;
        String turnoJugador;
        if (ronda % 2 == 1) {
            palabraJugador = jugador1;
            turnoJugador = jugador2;
        } else {
            palabraJugador = jugador2;
            turnoJugador = jugador1;
        }

        System.out.println("\nA " + palabraJugador + " le toca introducir la palabra: ");
        palabraJugada = cin.nextLine();
        PalabrasCliente.insertarPalabra(palabraJugada);
        PalabrasCliente.updateHaSidoUsada(palabraJugada);   // marcarla como que ya ha sido usada
        System.out.println("La palabra introducida es: " + palabraJugada);

        System.out.println("\n¡" + turnoJugador + ", a jugar!");
        boolean haGanado = juego(palabraJugada, cin);
        if (haGanado) {
            JugadoresCliente.updatePuntosJugador(turnoJugador);
        }
    }

    private static boolean juego(String palabraJugada, Scanner cin) {
        char letra;
        ArrayList<Integer> posLetra = new ArrayList<>();
        StringBuilder palabraGuiones = pintarGuiones(palabraJugada);
        for (int error = 0; error <= 6;) {
            if (haGanado(palabraGuiones)) {
                error = 7;
            } else {
                System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                pintarAhorcado(error);
                System.out.println("\n");
                System.out.println(palabraGuiones);
                if (error == 6) {
                    error++;
                } else {
                    System.out.println("\nIntroduzca una letra: ");
                    letra = cin.next().charAt(0);

                    posLetra = posLetra(letra, palabraJugada);
                    if (posLetra.isEmpty()) {
                        System.out.println("\nFallaste... :c");
                        System.out.println(palabraGuiones);
                        error++;
                    } else {
                        palabraGuiones = pintarLetra(posLetra, letra, palabraGuiones);
                        System.out.println("\n¡Acertaste!");
                        System.out.println(palabraGuiones);
                    }
                }
            }
            
        }

        if (haGanado(palabraGuiones)) {
            System.out.println("\n¡Felicidades! Has ganado :)");
        } else {
            System.out.println("\nLo siento... Has perdido :(");
            System.out.println("\nLa palabra era '" + palabraJugada + "'");
        }

        return haGanado(palabraGuiones);
    }

    private static StringBuilder pintarGuiones(String palabraJugada) {
        StringBuilder palabra = new StringBuilder();
        for (int i = 0; i < palabraJugada.length(); i++) {
            if (palabraJugada.charAt(i) != ' ') {
                palabra.append("-");
            } else {
                palabra.append(" ");
            }
        }
        return palabra;
    }

    private static ArrayList<Integer> posLetra(char letra, String palabraJugada) {
        ArrayList<Integer> posLetra = new ArrayList<>();

        for (int i = 0; i < palabraJugada.length(); i++) {
            if (palabraJugada.charAt(i) == letra) {
                posLetra.add(i);
            }
        }
        return posLetra;
    }

    private static StringBuilder pintarLetra(ArrayList<Integer> posLetra, char letra, StringBuilder palabraGuiones) {
        for (int pos : posLetra) {
            palabraGuiones.setCharAt(pos, letra);
        }
        return palabraGuiones;
    }

    private static void pintarAhorcado(int error) {

        String uno = "|---|";
        String dos = "|     ";
        String tres = "|      ";
        String cuatro = "|      ";
        String cinco = "| ";

        switch (error) {
            case 0:
                System.out.println(uno + "\n" + dos + "\n" + tres + "\n" + cuatro + "\n" + cinco);
                break;
            case 1:
                dos = "|   O";
                System.out.println(uno + "\n" + dos + "\n" + tres + "\n" + cuatro + "\n" + cinco);
                break;
            case 2:
                dos = "|   O";
                tres = "|   |  ";
                System.out.println(uno + "\n" + dos + "\n" + tres + "\n" + cuatro + "\n" + cinco);
                break;
            case 3:
                dos = "|   O";
                tres = "|  /| ";
                System.out.println(uno + "\n" + dos + "\n" + tres + "\n" + cuatro + "\n" + cinco);
                break;
            case 4:
                dos = "|   O";
                tres = "|  /|\\";
                System.out.println(uno + "\n" + dos + "\n" + tres + "\n" + cuatro + "\n" + cinco);
                break;
            case 5:
                dos = "|   O";
                tres = "|  /|\\";
                cuatro = "|   /  ";
                System.out.println(uno + "\n" + dos + "\n" + tres + "\n" + cuatro + "\n" + cinco);
                break;
            case 6:
                dos = "|   O";
                tres = "|  /|\\";
                cuatro = "|   /\\";
                System.out.println(uno + "\n" + dos + "\n" + tres + "\n" + cuatro + "\n" + cinco);
                break;
            default:
                throw new AssertionError();
        }

//        |---|    uno
//        |   O    dos
//        |  /|\   tres
//        |   /\   cuatro
//        |        cinco
    }

    private static boolean haGanado(StringBuilder palabraGuiones) {
        for (int i = 0; i < palabraGuiones.length(); i++) {
            if (palabraGuiones.charAt(i) == '-') {
                return false; //desde q encuentre q hay una letra q no ha acertado, ya sabemos q ha perdido       
            }
        }
        return true;
    }
}
