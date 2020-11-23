package es.iespuertodelacruz.alanissimoes;

import es.iespuertodelacruz.alanissimoes.controlador.PalabrasCliente;
import es.iespuertodelacruz.alanissimoes.controlador.JugadoresCliente;
import java.util.ArrayList;
import java.util.Scanner;

public class MainMetodos {

    /**
     * Al salir del juego, reestablecemos las palabras a no usadas y borramos
     * los jugadores de la tabla jugador
     */
    public static void salir() {
        JugadoresCliente.delJugadores();
        PalabrasCliente.resetPalabras();
    }

    /**
     * Menu para ofrecer al usuario jugar otra partida
     *
     * @param cin leer datos
     * @return booleano que confirma si se vuelve a jugar o no
     * @throws AssertionError
     */
    public static boolean menuJugarOtraVez(Scanner cin) throws AssertionError {
        boolean jugarOtraVez = false;
        boolean opCorrecta;
        int opRepetir = 0;
        boolean repetirMenu;
        do {
            do {
                try {
                    System.out.println("\n1.- Jugar otra vez"
                            + "\n0.- Salir"
                            + "\nIntroduzca una opción: ");
                    opRepetir = cin.nextInt();
                    opCorrecta = true;
                } catch (Exception e) {
                    System.out.println("\nIntroduce una opción correcta, por favor...");
                    cin.nextLine();
                    opCorrecta = false;
                }
            } while (!opCorrecta);

            switch (opRepetir) {
                case 1:
                    PalabrasCliente.resetPalabras();
                    JugadoresCliente.delJugadores();
                    jugarOtraVez = true;
                    repetirMenu = false;
                    break;
                case 0:
                    salir();
                    System.out.println("\n¡Gracias por jugar!");
                    repetirMenu = false;
                    break;
                default:
                    System.out.println("\nIntroduce una opción correcta, por favor...");
                    repetirMenu = true;
            }

        } while (repetirMenu);

        return jugarOtraVez;
    }

    /**
     * Conocer cuántas rondas se quiere que tenga la partida
     *
     * @param cin leer datos
     * @return número de rondas
     */
    public static int numeroRondas(Scanner cin) {
        int rondas = 0;
        do {
            System.out.println("\n¿Cuántas rondas quiere jugar?");
            try {
                rondas = cin.nextInt();
                cin.nextLine();
            } catch (Exception e) {
                System.out.println("\nIntroduzca un número mayor a cero, por favor...");
                cin.nextLine();
            }
        } while (rondas <= 0);
        return rondas;
    }

    /**
     * Lógica del juego en solitario
     *
     * @param cin leer datos
     * @param jugador jugador
     */
    public static void juegoIndividual(Scanner cin, String jugador) {
        String palabraJugada = PalabrasCliente.getPalabraRandom();
        PalabrasCliente.updateHaSidoUsada(palabraJugada);
        boolean haGanado = juego(palabraJugada, cin);
        if (haGanado) {
            JugadoresCliente.updatePuntosJugador(jugador);
        }
    }

    /**
     * Lógica de juego en pareja
     *
     * @param cin leer datos
     * @param jugador1 jugador 1
     * @param jugador2 ugador 2
     * @param ronda número de ronda por la que van
     */
    public static void juegoDual(Scanner cin, String jugador1, String jugador2, int ronda) {
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
        PalabrasCliente.updateHaSidoUsada(palabraJugada);

        System.out.println("\n¡" + turnoJugador + ", a jugar!");
        boolean haGanado = juego(palabraJugada, cin);
        if (haGanado) {
            JugadoresCliente.updatePuntosJugador(turnoJugador);
        }
    }

    /**
     * Lógica del juego en una ronda
     *
     * @param palabraJugada palabra con la que se jugará
     * @param cin leer datos
     * @return boolean que informa si se ha ganado el luego (ronda)
     */
    private static boolean juego(String palabraJugada, Scanner cin) {
        char letra;
        ArrayList<Integer> posLetra;
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

    /**
     * Palabra a jugar, con los guiones
     *
     * @param palabraJugada palabra con la que se juega
     * @return palabra pintada en guiones
     */
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

    /**
     *
     * @param letra letra introducida por jugador
     * @param palabraJugada palabra con la que se juega
     * @return arrayList donde están guardadas las posiciones de la letra
     * introducida
     */
    private static ArrayList<Integer> posLetra(char letra, String palabraJugada) {
        ArrayList<Integer> posLetra = new ArrayList<>();

        for (int i = 0; i < palabraJugada.length(); i++) {
            if (palabraJugada.charAt(i) == letra) {
                posLetra.add(i);
            }
        }
        return posLetra;
    }

    /**
     * Pintar letra en la palabra de guiones
     *
     * @param posLetra arrayList de las posiciones de la letra
     * @param letra letra introducida
     * @param palabraGuiones palabra a jugar pintada en guiones
     * @return
     */
    private static StringBuilder pintarLetra(ArrayList<Integer> posLetra, char letra, StringBuilder palabraGuiones) {
        for (int pos : posLetra) {
            palabraGuiones.setCharAt(pos, letra);
        }
        return palabraGuiones;
    }

    /**
     * Pintar el dibujo del ahorcado
     *
     * @param error número de errores que se llevan
     */
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
    }

    /**
     * Conocer si se ha ganado la ronda
     *
     * @param palabraGuiones palabra a jugar pintada con guiones
     * @return boolean si se ha ganado o no
     */
    private static boolean haGanado(StringBuilder palabraGuiones) {
        for (int i = 0; i < palabraGuiones.length(); i++) {
            if (palabraGuiones.charAt(i) == '-') {
                return false;
            }
        }
        return true;
    }

}
