package es.iespuertodelacruz.rest.alanissimoes.modelo;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Alanis
 */
@XmlRootElement
public class Jugador {
    private int id;
    private String nombre;
    private int puntos;
    
    //-----------------------------------------------------------------------------

    public Jugador() {
    }

    public Jugador(int id, String nombre, int puntos) {
        this.id = id;
        this.nombre = nombre;
        this.puntos = puntos;
    }

    //-----------------------------------------------------------------------------

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }
    
    //-----------------------------------------------------------------------------

    @Override
    public String toString() {
        return "Jugador{" + "\nid = " + id + "\nnombre = " + nombre + "\npuntos = " + puntos + "\n}";
    }
    
    /**
     * Almacenar en la bbdd palabra el objeto palabra
     */
    public void almacenarBBDD(){
        ConexionInicioPalabraBBDD.crearTabla();
        JugadorBBDD.insert(getId(),getNombre(),getPuntos());
    }    
    
}
