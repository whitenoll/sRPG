import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TableViewTest extends Application {

    Stage window;
    Scene scene1, scene2;
    public static void main(String[] args) {
        launch(args);
    }


    @Override
    public void start(Stage primaryStage) throws Exception{
        window = primaryStage;
        Parent root = FXMLLoader.load(getClass().getResource("itemTableView.fxml"));

        // Dice cr = new Dice();
       //String wT = String.valueOf(cr.calculateRoll("2d8"));

        String wT = "sRPG";
        window.setTitle(wT);
        window.setScene(new Scene(root, 300, 575));
        window.show();

    }


}
