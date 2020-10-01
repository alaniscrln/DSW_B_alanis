/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.iespuertodelacruz.alanissimoes.controlador;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

/**
 *
 * @author Alanis
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private TextField cantidad;
    @FXML
    private ChoiceBox<String> moneda;
    @FXML
    private Button igual; 
    @FXML
    private TextField resultado;
    
    @FXML
    private void calcular(ActionEvent event) {
        
        String op = this.moneda.getValue();
        double cambio;
        
        switch (op) {
            case "$":        
                cambio = getCantidad() * 0.85;
                this.resultado.setText( cambio + " €" );
                break;
            case "€":
                cambio = getCantidad() * 1.17;
                this.resultado.setText( cambio + " $" );
                break;
            default:
                throw new AssertionError();
        }
        
    }
    
    private double getCantidad(){
        double dinero;
        try{
            dinero = Double.parseDouble(this.cantidad.getText());
        }catch (Exception ex) {
            dinero = Double.NaN;
        }
        return dinero;
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ObservableList<String> options = FXCollections.observableArrayList("$","€");
        moneda.setItems(options);
        moneda.setValue("$");

    }    
    
}
