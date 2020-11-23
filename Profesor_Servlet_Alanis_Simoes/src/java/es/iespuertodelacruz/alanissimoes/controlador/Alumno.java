/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.iespuertodelacruz.alanissimoes.controlador;

/**
 *
 * @author Alanis
 */
public class Alumno {

    private String nombre;
    private String apellido1;
    private String apellido2;
    private String dni;
    private String curso;

    //--------------------------------------------------------------------------
    public Alumno(String nombre, String apellido1, String apellido2, String dni, String curso) {
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.dni = dni;
        this.curso = curso;
    }

    //--------------------------------------------------------------------------

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }
    //--------------------------------------------------------------------------

    @Override
    public String toString() {
        return apellido1 + " " + apellido2 + ", " + nombre + ". DNI: " + dni + ". Curso:  " + curso;
    }

}
