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
public class Principal implements Initializable {

    @FXML
    private TextField num1;

    @FXML
    private TextField num2;

    private ObservableList<String> listaOp = FXCollections.observableArrayList();
    @FXML
    private ChoiceBox<String> op;

    @FXML
    private Button igual;

    @FXML
    private TextField result;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // una vez comienza el programa, carga las operaciones en la lista
        cargarOps();

    }

    public double getNum1() {
        double numero;
        try {
            numero = Double.parseDouble(this.num1.getText());
        } catch (Exception ex) {
            //si la entrada resulta no ser un número, num1 pasa a ser NaN
            numero = Double.NaN;
        }
        return numero;
    }

    public double getNum2() {
        double numero;
        try {
            numero = Double.parseDouble(this.num2.getText());
        } catch (Exception ex) {
            //si la entrada resulta no ser un número, num2 pasa a ser NaN
            numero = Double.NaN;
        }
        return numero;
    }

    public void setResult(double result) {
        this.result.setText(Double.toString(result));
    }

    /**
     * Método que carga las operaciones posibles a realizar en el 'choicebox'.
     */
    private void cargarOps() {

        listaOp.clear();

        listaOp.addAll("+", "-", "*", "/");
        op.getItems().addAll(listaOp);
        op.setValue("+");
    }

    /**
     * Método que realiza la operación correspondiente una vez se haya hecho click
     * en el botón "=".
     * @param e 
     */
    public void calcularResultado(ActionEvent e) {

        switch (op.getValue()) {
            case "+":
                Suma sum = new Suma();
                setResult(sum.sumar(getNum1(), getNum2()));
                break;
            case "-":
                Resta res = new Resta();
                setResult(res.restar(getNum1(), getNum2()));
                break;
            case "*":
                Multiplicacion mult = new Multiplicacion();
                setResult(mult.multiplicar(getNum1(), getNum2()));
                break;
            case "/":
                Division div = new Division();
                setResult(div.dividir(getNum1(), getNum2()));
                break;
            default:
                throw new AssertionError();
        }

    }
}
