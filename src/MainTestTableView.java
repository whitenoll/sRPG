
import entity.Item;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.Dice;
import util.HibernateUtil;
import util.ItemBuild;

import java.util.Observable;

public class MainTestTableView extends Application {

    Stage window;
    public static void main(String[] args) {
        launch(args);
    }
    Object transaction = null;
    ItemBuild ib = new ItemBuild();

    @Override
    public void start(Stage primaryStage) throws Exception{
        window = primaryStage;
        window.setTitle("test tableview");

        VBox vBox = new VBox();
        Scene scene= new Scene(vBox);
        window.setScene(scene);
        window.show();

    }
     try

    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Throwable var3 = null;
        try {
            public ObservableList<Item> = session.createQuery("from Item", Item.class).list();
        } catch (Throwable var13) {
            var3 = var13;
            throw var13;
        } finally {
            if (session != null) {
                if (var3 != null) {
                    try {
                        session.close();
                    } catch (Throwable var12) {
                        var3.addSuppressed(var12);
                    }
                } else {
                    session.close();
                }
            }

        }
    } catch (Exception var15) {
        if (transaction != null) {
            ((Transaction)transaction).rollback();
        }

        var15.printStackTrace();
    }

    }



}
