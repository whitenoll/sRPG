import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.awt.*;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import util.Dice;
public class Controller {
    @FXML
    public Button button;
    public TextArea myTA;
    public TextField textFieldDice = new TextField();
    public TextField textFieldDiceType = new TextField();
    String diceroll;
    Dice cr = new Dice();

public void handleButtonClick(){
    System.out.println("this is happening!");
    button.setText("Reroll");
    myTA.setText("");

    myTA.appendText(cr.calculateRollStringBuilder(textFieldDice.getText()).toString().toLowerCase());
    /// may be useful for making critical roles stand out
    // myTA.setStyle("-fx-text-fill: red ;") ;
    System.out.println(textFieldDice.getText().toLowerCase());
    }
    }

