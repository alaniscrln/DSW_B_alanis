package es.iespuertodelacruz.rest.alanissimoes.modelo;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Alanis
 */
@XmlRootElement
public class Palabra {
    private String palabra;
    private boolean haSidoUsada;

    public Palabra() {
    }

    public Palabra(String palabra, int haSidoUsada) {
        this.palabra = palabra;        
        this.haSidoUsada = (haSidoUsada == 1);  // 0 = false, 1 = true
        almacenarBBDD();
    }
    
    //-----------------------------------------------------------------------------
    
    public String getPalabra() {
        return palabra;
    }

    public void setPalabra(String palabra) {
        this.palabra = palabra;
    }

    public int HaSidoUsada() {
        return haSidoUsada? 1:0;    // true:false
    }

    public void setHaSidoUsada(boolean haSidoUsada) {
        this.haSidoUsada = haSidoUsada;
    }

    @Override
    public String toString() {
        return "Palabra: " + getPalabra() + "\nHa sido usada: " + (HaSidoUsada()==1);
    }

    //-----------------------------------------------------------------------------
    
    public void almacenarBBDD(){
        ConexionInicioPalabraBBDD.crearTabla();
        PalabraBBDD.insert(getPalabra(),HaSidoUsada());
    }

    
}
