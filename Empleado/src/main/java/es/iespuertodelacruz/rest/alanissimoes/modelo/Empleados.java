package es.iespuertodelacruz.rest.alanissimoes.modelo;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Empleados {
    
    private ArrayList<Empleado> empleados = new ArrayList<>();

    public Empleados() {
    }

    public ArrayList<Empleado> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(Empleado empleado) {
        this.empleados.add(empleado);
    }
    
    
    
}
