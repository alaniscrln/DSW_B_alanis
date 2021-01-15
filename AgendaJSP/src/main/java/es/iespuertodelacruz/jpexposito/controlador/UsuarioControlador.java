package es.iespuertodelacruz.jpexposito.controlador;

import es.iespuertodelacruz.jpexposito.modelo.Usuario;
import es.iespuertodelacruz.jpexposito.exception.DatosIncorrectosException;
import es.iespuertodelacruz.jpexposito.exception.UsuarioExisteException;
import es.iespuertodelacruz.jpexposito.modelo.jdbc.dao.UsuarioDao;
import java.util.ArrayList;

/**
 *
 * @author jpexposito
 */
public class UsuarioControlador {

    UsuarioDao usuarioDao;

    public void UsuarioControlador() {

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

        usuarioDao.insertar(usuario);

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

        usuarioDao.modificar(dni, nombreNuevo, apellidosNuevo);

    }

    public void eliminar(String dni) throws DatosIncorrectosException {
        String camposIncorrectos = null;

        if (dni == null || dni.isEmpty()) {
            camposIncorrectos = "El dni no puede ser nulo o vacio,";
        }

        if (camposIncorrectos != null) {
            throw new DatosIncorrectosException(camposIncorrectos);
        }

        usuarioDao.eliminar(dni);

    }

    public Usuario buscar(String dni) throws DatosIncorrectosException {
        String camposIncorrectos = null;

        if (dni == null || dni.isEmpty()) {
            camposIncorrectos = "El dni no puede ser nulo o vacio,";
        }

        if (camposIncorrectos != null) {
            throw new DatosIncorrectosException(camposIncorrectos);
        }

        return usuarioDao.buscar(dni);
    }

    public ArrayList<Usuario> buscarTodos() {
        return usuarioDao.buscarTodos();
    }
}
