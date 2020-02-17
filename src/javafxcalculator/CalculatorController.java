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
 * @version 1.1 added subtraction and division operation
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
    
    @FXML
    private void handleSubtractionAction(ActionEvent event) {

        double first = Double.parseDouble(firstTextField.getText());
        double second = Double.parseDouble(secondTextField.getText());
        
        double result = first - second;
        
        resultTextField.setText(String.valueOf(result));
        
    }
    
    @FXML
    private void handleDivisionAction(ActionEvent event) {

        double first = Double.parseDouble(firstTextField.getText());
        double second = Double.parseDouble(secondTextField.getText());
        
        if (second == 0.0) {
            resultTextField.setText("Error!");
        } else {
            double result = first / second;

            resultTextField.setText(String.valueOf(result));
        }
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
