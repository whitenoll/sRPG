import entity.Item;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import util.Dice;

public class ItemTableViewController {
    @FXML
    public Button button;
    public TextArea myTA;
    public TextField textFieldDice = new TextField();
    public  TextField numberOfDice = new TextField();
    public TextField textFieldDiceType = new TextField();
    String diceRoll;
    Dice cr = new Dice();
    @FXML
    private TableView<Item> table;
    // https://stackoverflow.com/questions/33714812/javafx-fxml-populating-tableview-using-hibernate

public void handleButtonClick(){
    System.out.println("this is happening!");
    button.setText("Reroll");
    myTA.setText("");
    diceRoll = textFieldDiceType.getText().toString().toLowerCase();
    diceRoll = diceRoll + "d" + textFieldDice.getText().toLowerCase();

    myTA.appendText(cr.calculateRollStringBuilder(diceRoll).toString());

    System.out.println(textFieldDice.getText().toLowerCase());
    }

    }

