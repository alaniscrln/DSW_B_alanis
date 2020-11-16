package es.iespuertodelacruz.rest.alanissimoes.modelo;

import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName(value = "palabra")
public class Palabra {
    private String palabra;
    private int haSidoUsada;

    public Palabra() {
    }

    public Palabra(String palabra, int haSidoUsada) {
        this.palabra = palabra;        
        this.haSidoUsada = haSidoUsada;
    }
    
    //-----------------------------------------------------------------------------
    
    public String getPalabra() {
        return palabra;
    }

    public void setPalabra(String palabra) {
        this.palabra = palabra;
    }

    public int HaSidoUsada() {
        return haSidoUsada;    
    }

    public void setHaSidoUsada(int haSidoUsada) {
        this.haSidoUsada = haSidoUsada;
    }

    //-----------------------------------------------------------------------------

    @Override
    public String toString() {
        return "Palabra: " + getPalabra() + "\nHa sido usada: " + (HaSidoUsada()==1);
    }
  
}
