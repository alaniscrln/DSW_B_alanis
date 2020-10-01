/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.iespuertodelacruz.alanissimoes.controlador;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 *
 * @author Alanis
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private TextField cantidad;
    @FXML
    private Button aEuro;
    @FXML
    private Button aDolar;
    @FXML
    private TextField resultado;

    @FXML
    private void dolarAEuro(ActionEvent e) {
        double cambio = getCantidad() * 0.85;
        this.resultado.setText(cambio + " €");
    }
    
    @FXML
    private void euroADolar(ActionEvent e) {
        double cambio = getCantidad() * 1.17;
        this.resultado.setText(cambio + " $");
    }

    private double getCantidad() {
        double dinero;
        try {
            dinero = Double.parseDouble(this.cantidad.getText());
        } catch (Exception ex) {
            dinero = Double.NaN;
        }
        return dinero;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

    }

}
