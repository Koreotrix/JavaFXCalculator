package javafxcalculator;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

/**
 *
 * @author Tristan
 * @version 1.0 Simple add and multiplication calculator
 */
public class CalculatorController implements Initializable {
    
    @FXML
    private TextField firstTextField, secondTextField, resultTextField;
    
    @FXML
    private void handleAdditionAction(ActionEvent event) {
        
        double first = Double.parseDouble(firstTextField.getText());
        double second = Double.parseDouble(secondTextField.getText());
        
        double result = first + second;
        
        resultTextField.setText(String.valueOf(result));
    }
    
    @FXML
    private void handleMultiplicationAction(ActionEvent event) {

        double first = Double.parseDouble(firstTextField.getText());
        double second = Double.parseDouble(secondTextField.getText());
        
        double result = first * second;
        
        resultTextField.setText(String.valueOf(result));
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
