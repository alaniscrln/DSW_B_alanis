package es.iespuertodelacruz.rest.alanissimoes.modelo;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Alanis
 */
@XmlRootElement
public class Jugador {
    private String nombre;
    private int puntos;
    
    //-----------------------------------------------------------------------------

    public Jugador() {
    }

    public Jugador(String nombre) {
        this.nombre = nombre;
        this.puntos = 0;
    }

    //-----------------------------------------------------------------------------

    public String getNombre(){
        return this.nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPuntos() {
        return this.puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }
    
    //-----------------------------------------------------------------------------

    @Override
    public String toString() {
        return "Jugador{" + "\nnombre = " + nombre + "\npuntos = " + puntos + "\n}";
    }

}
