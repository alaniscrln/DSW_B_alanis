/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.iespuertodelacruz.jpexposito.modelo.file;

import es.iespuertodelacruz.jpexposito.exception.FicheroNoExisteException;
import es.iespuertodelacruz.jpexposito.exception.UsuarioNoInsertadoException;
import es.iespuertodelacruz.jpexposito.modelo.Usuario;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author jpexposito
 */
public class UsuarioFile {

    File usuarioFile;

    public UsuarioFile(String rutaFichero) throws FicheroNoExisteException {
        try {
            this.usuarioFile = new File(rutaFichero);
            boolean existeFichero = this.usuarioFile.exists();

            if (!existeFichero) {
                usuarioFile.createNewFile();
                FileWriter fileWriter = new FileWriter(this.usuarioFile);
                BufferedWriter bw = new BufferedWriter(fileWriter);
                bw.write("DNI , Nombre , Apellidos");
                bw.newLine();
                bw.close();
            }
        } catch (IOException e) {
            throw new FicheroNoExisteException("El fichero con ruta:" + rutaFichero
                    + ", no existe o no ha podido ser creado");
        }
    }

    /**
     * Metoro que realiza la insercion dentro de la BBDD
     *
     * @param usuario
     * @throws
     * es.iespuertodelacruz.jpexposito.exception.UsuarioNoInsertadoException
     *
     */
    public void insertar(Usuario usuario) throws UsuarioNoInsertadoException {

        try {

            FileWriter fileWriter = new FileWriter(this.usuarioFile, true);
            BufferedWriter bw = new BufferedWriter(fileWriter);
            bw.append(usuario.getDni() + " , " + usuario.getNombre() + " , " + usuario.getApellido());
            bw.newLine();
            bw.close();

        } catch (IOException e) {
            throw new UsuarioNoInsertadoException(usuario.getDni());
        }
    }

    public void modificar(String dni, String nuevoDni, String nuevoNombre, String nuevoApellido) {
        try {

            FileWriter fileWriter = new FileWriter(this.usuarioFile, true);
            BufferedWriter bw = new BufferedWriter(fileWriter);

            FileReader fileReader = new FileReader(this.usuarioFile);
            BufferedReader br = new BufferedReader(fileReader);

            String usuarios = "";

            String line;
            while ((line = br.readLine()) != null) {    //mientras no sea el final del fichero...
                if (!line.contains(dni)) {
                    usuarios += line + "\n";
                } else {
                    usuarios += nuevoDni + " , " + nuevoNombre + " , " + nuevoApellido + "\n";
                }
            }

            //para limpiar el archivo
            PrintWriter writer = new PrintWriter(this.usuarioFile);
            writer.print("");
            writer.close();

            bw.write(usuarios);
            bw.close();

        } catch (IOException e) {

        } finally {

        }

    }

    public void eliminar(String dni) {
        try {

            File nuevo = new File(this.usuarioFile.getPath());
            FileWriter fileWriter = new FileWriter(this.usuarioFile, true);
            BufferedWriter bw = new BufferedWriter(fileWriter);

            FileReader fileReader = new FileReader(this.usuarioFile);
            BufferedReader br = new BufferedReader(fileReader);

            String usuarios = "";

            String line;
            while ((line = br.readLine()) != null) {    //mientras no sea el final del fichero...
                if (!line.contains(dni)) {
                    usuarios += line + "\n";
                    System.out.println("escribiendo...\n");
                } else {
                    System.out.println("borrado!!!");
                }
            }

            //para limpiar el archivo
            PrintWriter writer = new PrintWriter(this.usuarioFile);
            writer.print("");
            writer.close();
//            
//            bw.write("");
//            bw.close();
            bw.write(usuarios);
            bw.close();

        } catch (IOException e) {

        } finally {

        }

    }

    public String buscar(String dni) {
        String usuario = null;
        try {
            FileReader fileReader = new FileReader(this.usuarioFile);
            BufferedReader br = new BufferedReader(fileReader);

            String line;
            boolean encontrado = false;
            while ((line = br.readLine()) != null || encontrado == false) {    //mientras no sea el final del fichero...
                if (line.contains(dni)) {
                    encontrado = true;
                    usuario = line;
                } else {

                }
            }

        } catch (IOException e) {
        } catch (NullPointerException ex) {
            System.out.println("\nNo se encontró el usuario.\n");
        }
        
        return usuario;

    }

    public void buscarTodos() {
        try {

            FileReader fileReader = new FileReader(this.usuarioFile);
            BufferedReader br = new BufferedReader(fileReader);

            String usuarios = "";

            String line;
            int idx = 0;
            System.out.println("\n========================================================\n");
            while ((line = br.readLine()) != null) {    //mientras no sea el final del fichero...
                System.out.println(idx + ".- " + line);
                idx++;
            }
            System.out.println("\n========================================================\n");

        } catch (IOException e) {

        } finally {

        }

    }

}
