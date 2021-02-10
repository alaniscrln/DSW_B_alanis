package es.iespuertodelacruz.jpexposito.controlador;

import es.iespuertodelacruz.jpexposito.modelo.Usuario;
import es.iespuertodelacruz.jpexposito.exception.DatosIncorrectosException;
import es.iespuertodelacruz.jpexposito.exception.FicheroNoExisteException;
import es.iespuertodelacruz.jpexposito.exception.UsuarioExisteException;
import es.iespuertodelacruz.jpexposito.exception.UsuarioNoInsertadoException;
import es.iespuertodelacruz.jpexposito.modelo.file.UsuarioFile;
import es.iespuertodelacruz.jpexposito.modelo.jdbc.dao.UsuarioDao;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jpexposito
 */
public class UsuarioControlador {

    //UsuarioDao usuarioDao;
    UsuarioFile uf;
    public void UsuarioControlador() throws FicheroNoExisteException {
        //usuarioDao = new UsuarioDao();
        uf = new UsuarioFile("agenda.txt");
    }

    public void insertar(String dni, String nombre, String apellidos) throws DatosIncorrectosException, UsuarioExisteException {
        String camposIncorrectos = null;

        if (dni == null || dni.isEmpty()) {
            camposIncorrectos = "El dni no puede ser nulo o vacio,";
        }

        if (nombre == null || nombre.isEmpty()) {
            camposIncorrectos += " El nombre no puede ser nulo o vacio,";
        }

        if (apellidos == null || apellidos.isEmpty()) {
            camposIncorrectos += " Los apellidos no puede ser nulo o vacio";
        }

        if (camposIncorrectos != null) {
            throw new DatosIncorrectosException(camposIncorrectos);
        }

        Usuario usuario = new Usuario(dni, nombre, apellidos);

        try {
            uf.insertar(usuario);
        } catch (UsuarioNoInsertadoException ex) {
            System.out.println("error: " + ex.getMessage());
        }

    }

    public void modificar(String dni, String nombreNuevo, String apellidosNuevo) throws DatosIncorrectosException, UsuarioExisteException {
        String camposIncorrectos = null;

        if (dni == null || dni.isEmpty()) {
            camposIncorrectos = "El dni no puede ser nulo o vacio,";
        }

        if (nombreNuevo == null || nombreNuevo.isEmpty()) {
            camposIncorrectos += " El nombre no puede ser nulo o vacio,";
        }

        if (apellidosNuevo == null || apellidosNuevo.isEmpty()) {
            camposIncorrectos += " Los apellidos no puede ser nulo o vacio";
        }

        if (camposIncorrectos != null) {
            throw new DatosIncorrectosException(camposIncorrectos);
        }

        uf.modificar(dni, dni, nombreNuevo, nombreNuevo);

    }

    public void eliminar(String dni) throws DatosIncorrectosException {
        String camposIncorrectos = null;

        if (dni == null || dni.isEmpty()) {
            camposIncorrectos = "El dni no puede ser nulo o vacio,";
        }

        if (camposIncorrectos != null) {
            throw new DatosIncorrectosException(camposIncorrectos);
        }

        uf.eliminar(dni);

    }

    public String buscar(String dni) throws DatosIncorrectosException {
        String camposIncorrectos = null;

        if (dni == null || dni.isEmpty()) {
            camposIncorrectos = "El dni no puede ser nulo o vacio,";
        }

        if (camposIncorrectos != null) {
            throw new DatosIncorrectosException(camposIncorrectos);
        }

        return uf.buscar(dni);
    }

    public void buscarTodos() {
        uf.buscarTodos();
    }
}
