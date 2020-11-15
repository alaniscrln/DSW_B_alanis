package es.iespuertodelacruz.alanissimoes;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        String palabraJugada = "";
        boolean salirJuego = false;
        int op;

        System.out.println("AHORCADO");
        do {
            System.out.println("1.- Insertar palabra"
                    + "\n2.- Palabra aleatoria"
                    + "\n0.Salir"
                    + "\nIntroduzca una opción: ");
            op = cin.nextInt();
            cin.nextLine();

            switch (op) {
                case 1:
                    System.out.println("Introduzca la palabra: ");
                    palabraJugada = cin.nextLine();
                    Palabras.insertarPalabra(palabraJugada);
                    //System.out.println("La palabra introducida es: " + palabraJugada);
                    break;
                case 2:
                    palabraJugada = Palabras.getPalabraRandom();
                    //System.out.println("Palabra a jugar: " + palabrajugada);
                    break;
                case 0:
                    salirJuego = true;
                    break;
                default:
                    throw new AssertionError();
            }

            //"limpiar" pantalla
            for (int i = 0; i < 20; i++) {
                System.out.println("\n\n");
            }

            juego(palabraJugada);

        } while (!salirJuego);

    }

    public static String pintarGuiones(String palabraJugada) {
        String palabra = "";
        for (int i = 0; i < palabraJugada.length(); i++) {
            if (palabraJugada.charAt(i) != ' ') {
                palabra += "_ ";
            } else {
                palabra += "  ";
            }
        }
        return palabra;
    }

    public static void juego(String palabraJugada) {

        String palabraGuiones = pintarGuiones(palabraJugada);
        //System.out.println(palabraGuiones);
        
        
    }
}
