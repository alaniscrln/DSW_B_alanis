package es.iespuertolacruz.rest.jpexposito.modelo;


import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Alumno {

    private String nombre;
    private String apellidos;
    private Integer nota;

    public Alumno() { }

    public Alumno(String nombre, String apellidos, Integer nota) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.nota = nota;
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

    public Integer getNota() {
        return nota;
    }

    public void setNota(Integer nota) {
        this.nota = nota;
    }

    public String toString() {
        return "Alumno:"+this.nombre+" " +this.apellidos +", edad:"+this.nota;
    }
}
