package es.iespuertodelacruz.rest.alanissimoes.modelo;


import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Alumno {
    private int id;
    private String nombre;
    private String apellidos;
    private Integer nota;

    public Alumno() { }

    public Alumno(int id, String nombre, String apellidos, Integer nota) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.nota = nota;
        this.almacenarBBDD();
    }
    
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

    @Override
    public String toString() {
        return "Alumno:"+this.nombre+" " +this.apellidos +", edad:"+this.nota;
    }
    
    //--------------------------------------------------------------------------
    
    public void almacenarBBDD(){
        ConexionInicioBBDD.crearTabla();
        AlumnoBBDD.insert(id, nombre, apellidos, nota);
    }


}
