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

        System.out.println("AHORCADO");

        System.out.println("\nElige el número de jugadores: "
                + "\n1.- Un jugador"
                + "\n2.- Dos jugadores"
                + "\n0.- Salir"
                + "\nIntroduzca una opción: ");
        opNumJugador = cin.nextInt();
        cin.nextLine();
        switch (opNumJugador) {
            case 1:
                System.out.println("\nNombre del jugador: ");
                jugador1 = cin.nextLine();
                JugadoresCliente.crearJugador(jugador1);
                
                for (int i = 0; i < numeroRondas(cin); i++) {
                    System.out.println("\nRonda número " + (i+1));
                    juegoIndividual(cin, jugador1);
                }
                
                break;
            case 2:
                System.out.println("\nNombre del jugador 1: ");
                jugador1 = cin.nextLine();
                JugadoresCliente.crearJugador(jugador1);
                System.out.println("\nNombre del jugador 2: ");
                jugador2 = cin.nextLine();
                JugadoresCliente.crearJugador(jugador2);
                juegoDual(cin, jugador1, jugador2);
                break;
            case 0:
                salirJuego = true;
                break;
            default:
                throw new AssertionError();
        }

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
        PalabrasCliente.updateHaSidoUsada(palabraJugada);   // marcarla como que ya ha sido usada
        System.out.println("Palabra a jugar: " + palabraJugada);
        boolean haGanado = juego(palabraJugada, cin);
        if (haGanado) {
            JugadoresCliente.updatePuntos(jugador);
        }
    }

    private static void juegoDual(Scanner cin, String jugador1, String jugador2) {

        System.out.println("1.- Insertar palabra"
                + "\n2.- Palabra aleatoria"
                + "\nIntroduzca una opción: ");
        int op = cin.nextInt();
        cin.nextLine();
        String palabraJugada = "";

        switch (op) {
            case 1:
                System.out.println("Introduzca la palabra: ");
                palabraJugada = cin.nextLine();
                PalabrasCliente.insertarPalabra(palabraJugada);
                System.out.println("La palabra introducida es: " + palabraJugada);
                break;
            case 2:
                palabraJugada = PalabrasCliente.getPalabraRandom();
                PalabrasCliente.updateHaSidoUsada(palabraJugada);   // marcarla como que ya ha sido usada
                System.out.println("Palabra a jugar: " + palabraJugada);
                break;
            default:
                throw new AssertionError();
        }

        juego(palabraJugada, cin);

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
                        error++;
                    } else {
                        palabraGuiones = pintarLetra(posLetra, letra, palabraGuiones);
                        System.out.println("\n¡Acertaste!");
                    }
                }
            }
        }

        if (haGanado(palabraGuiones)) {
            System.out.println("\n¡Felicidades! Has ganado :)");
        } else {
            System.out.println("\nLo siento... Has perdido :(");
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
