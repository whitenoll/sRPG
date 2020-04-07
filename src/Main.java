import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import util.Dice;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        Dice cr = new Dice();
       String wT = String.valueOf(cr.calculateRoll("2d8"));

                primaryStage.setTitle(wT);
        primaryStage.setScene(new Scene(root, 300, 575));
        primaryStage.show();

    }


    public static void main(String[] args) {
        launch(args);
    }
}
