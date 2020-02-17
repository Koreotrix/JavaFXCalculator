package javafxcalculator;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;

/**
 *
 * @author Tristan
 * @version 2.0 revised calculator, including buttons to represent numbers 
 *      and operations
 */
public class CalculatorController implements Initializable {
    
    private double data = 0;
    private Operation operation;
    private List<Button> buttonList;
    
    @FXML
    private TextField resultTextField;
    
    @FXML
    private Button zeroButton, oneButton, twoButton, threeButton, fourButton,
            fiveButton, sixButton, sevenButton, eightButton, nineButton,
            clearButton, equalButton,
            plusButton, minusButton, divideButton, timesButton;
    
    @FXML
    private MenuItem enableClearItem, disableClearItem,
            darkThemeItem, lightThemeItem;
    
    @FXML
    private void handleNumberAction(ActionEvent event) {
        
        if (event.getSource() == zeroButton) { resultTextField.setText( resultTextField.getText() + "0"); }
        else if (event.getSource() == oneButton) { resultTextField.setText( resultTextField.getText() + "1"); }
        else if (event.getSource() == twoButton) { resultTextField.setText( resultTextField.getText() + "2"); }
        else if (event.getSource() == threeButton) { resultTextField.setText( resultTextField.getText() + "3"); }
        else if (event.getSource() == fourButton) { resultTextField.setText( resultTextField.getText() + "4"); }
        else if (event.getSource() == fiveButton) { resultTextField.setText( resultTextField.getText() + "5"); }
        else if (event.getSource() == sixButton) { resultTextField.setText( resultTextField.getText() + "6"); }
        else if (event.getSource() == sevenButton) { resultTextField.setText( resultTextField.getText() + "7"); }
        else if (event.getSource() == eightButton) { resultTextField.setText( resultTextField.getText() + "8"); }
        else if (event.getSource() == nineButton) { resultTextField.setText( resultTextField.getText() + "9"); }
        
    }
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        
        if (event.getSource() == clearButton) { resultTextField.setText(""); }
        else if (event.getSource() == plusButton) { 
            data = Double.parseDouble(resultTextField.getText());
            operation = Operation.ADDITION;
            resultTextField.setText(""); 
        } else if (event.getSource() == minusButton) { 
            data = Double.parseDouble(resultTextField.getText());
            operation = Operation.SUBTRACTION;
            resultTextField.setText(""); 
        } else if (event.getSource() == divideButton) { 
            data = Double.parseDouble(resultTextField.getText());
            operation = Operation.DIVISION;
            resultTextField.setText(""); 
        } else if (event.getSource() == timesButton) { 
            data = Double.parseDouble(resultTextField.getText());
            operation = Operation.MULTIPLICATION;
            resultTextField.setText(""); 
        } else if (event.getSource() == equalButton) { 
            
            Double dataTwo = Double.parseDouble(resultTextField.getText());
            
            switch (operation) {
                case ADDITION: resultTextField.setText(String.valueOf(data + dataTwo)); break;
                case SUBTRACTION: resultTextField.setText(String.valueOf(data - dataTwo)); break;
                case MULTIPLICATION: resultTextField.setText(String.valueOf(data * dataTwo)); break;
                case DIVISION: 
                    if (dataTwo == 0) { resultTextField.setText("Error!"); }
                    else { resultTextField.setText(String.valueOf(data / dataTwo)); }
                    break;
            }
        }
    }
    
    @FXML
    private void handleClearMenuAction(ActionEvent event) {
        if (event.getSource() == enableClearItem) { clearButton.setDisable(false); }
        else if (event.getSource() == disableClearItem) { clearButton.setDisable(true); }
    }
    
    @FXML
    private void handleThemeMenuAction(ActionEvent event) {
        
        if (event.getSource() == darkThemeItem) {
            for (Button button : buttonList) {
                button.setStyle("-fx-background-color:black;"
                        + "-fx-text-fill:white;"
                        + "-fx-border-width:2;"
                        + "-fx-border-color:white;");
            }
        } else if (event.getSource() == lightThemeItem) {
            for (Button button : buttonList) {
                button.setStyle("-fx-background-color:white;"
                        + "-fx-text-fill:black;"
                        + "-fx-border-width:2;"
                        + "-fx-border-color:black;");
            }
        }
    }
    
    @FXML
    private void handleFileMenuAction(ActionEvent event) {
        Platform.exit();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        resultTextField.setEditable(false);
        
        buttonList = new ArrayList<Button>();
        
        buttonList.add(zeroButton);
        buttonList.add(oneButton);
        buttonList.add(twoButton);
        buttonList.add(threeButton);
        buttonList.add(fourButton);
        buttonList.add(fiveButton);
        buttonList.add(sixButton);
        buttonList.add(sevenButton);
        buttonList.add(eightButton);
        buttonList.add(nineButton);
        
        buttonList.add(clearButton);
        buttonList.add(equalButton);
        
        buttonList.add(plusButton);
        buttonList.add(minusButton);
        buttonList.add(timesButton);
        buttonList.add(divideButton);
    }    
    
    enum Operation {
        ADDITION, MULTIPLICATION, DIVISION, SUBTRACTION;
    }
}

