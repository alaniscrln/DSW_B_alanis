package es.iespuertodelacruz.rest.alanissimoes.modelo;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Empleado {

    private String dni;
    private String nombre;
    private String apellidos;

    //-----------------------------------------------------------------------------
    public Empleado() {
    }

    public Empleado(String dni, String nombre, String apellidos) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellidos = apellidos;
    }

    //-----------------------------------------------------------------------------

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
    
    //-----------------------------------------------------------------------------

    @Override
    public String toString() {
        return "Empleados{" + "dni=" + dni + ", nombre=" + nombre + ", apellidos=" + apellidos + '}';
    }

}
