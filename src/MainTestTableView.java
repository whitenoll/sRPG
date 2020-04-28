import entity.Item;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.hibernate.Session;
import org.hibernate.query.Query;
import util.HibernateUtil;

import java.util.List;

public class MainTestTableView extends Application {

    Stage window;
    TableView<Item> table;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("thenewboston - JavaFX");

        //Name column
        TableColumn<Item, Integer> idDColumn = new TableColumn<>("Item ID");
        idDColumn.setMinWidth(200);
        idDColumn.setCellValueFactory(new PropertyValueFactory<>("ID_item"));

        //container column
        TableColumn<Item, Integer> containerIdColumn = new TableColumn<>("Container ID");
        containerIdColumn.setMinWidth(100);
        containerIdColumn.setCellValueFactory(new PropertyValueFactory<>("containerID"));

        //description column
        TableColumn<Item, String> descriptionColumn = new TableColumn<>("description");
        descriptionColumn.setMinWidth(100);
        descriptionColumn.setCellValueFactory(new PropertyValueFactory<>("description"));

        //description column
        TableColumn<Item, Integer> descriptionIDColumn = new TableColumn<>("descriptionID");
        descriptionIDColumn.setMinWidth(100);
        descriptionIDColumn.setCellValueFactory(new PropertyValueFactory<>("descriptionID"));

        //health column
        TableColumn<Item, Integer>healthColumn = new TableColumn<>("health");
        healthColumn.setMinWidth(100);
        healthColumn.setCellValueFactory(new PropertyValueFactory<>("health"));

        //height column
        TableColumn<Item, Integer> heightColumn = new TableColumn<>("height");
        heightColumn.setMinWidth(100);
        heightColumn.setCellValueFactory(new PropertyValueFactory<>("height"));

        //hit dice column
        TableColumn<Item, String> hitdiceColumn = new TableColumn<>("hitDice");
        hitdiceColumn.setMinWidth(100);
        hitdiceColumn.setCellValueFactory(new PropertyValueFactory<>("hitDice"));

        //locationX column
        TableColumn<Item, Integer> locationXColumn = new TableColumn<>("locationX");
        locationXColumn.setMinWidth(100);
        locationXColumn.setCellValueFactory(new PropertyValueFactory<>("locationX"));

        //locationY column
        TableColumn<Item, Integer> locationYColumn = new TableColumn<>("locationY");
        locationYColumn.setMinWidth(100);
        locationYColumn.setCellValueFactory(new PropertyValueFactory<>("locationY"));

        //material column
        TableColumn<Item, String>materialColumn = new TableColumn<>("material");
        materialColumn.setMinWidth(100);
        materialColumn.setCellValueFactory(new PropertyValueFactory<>("material"));

        //name column
        TableColumn<Item, String> nameColumn = new TableColumn<>("name");
        nameColumn.setMinWidth(100);
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

        //typeId column
        TableColumn<Item, Integer> typeColumn = new TableColumn<>("typeId");
        typeColumn.setMinWidth(100);
        typeColumn.setCellValueFactory(new PropertyValueFactory<>("typeId"));

        //width column
        TableColumn<Item, Integer> widthColumn = new TableColumn<>("width");
        widthColumn.setMinWidth(100);
        widthColumn.setCellValueFactory(new PropertyValueFactory<>("width"));

        //length column
        TableColumn<Item, Integer> lengthColumn = new TableColumn<>("length");
        lengthColumn.setMinWidth(100);
        lengthColumn.setCellValueFactory(new PropertyValueFactory<>("length"));

        //color column
        TableColumn<Item, String> colorColumn = new TableColumn<>("color");
        colorColumn.setMinWidth(100);
        colorColumn.setCellValueFactory(new PropertyValueFactory<>("color"));






        table = new TableView<>();
        table.setItems(findAll());
        table.getColumns().addAll(idDColumn, containerIdColumn, descriptionColumn, descriptionIDColumn, healthColumn, heightColumn, hitdiceColumn,locationXColumn,locationYColumn,materialColumn,nameColumn,typeColumn,widthColumn,lengthColumn,colorColumn);

        VBox vBox = new VBox();
        vBox.getChildren().addAll(table);

        Scene scene = new Scene(vBox);
        window.setScene(scene);
        window.show();
    }


    // https://stackoverflow.com/questions/34968640/how-to-add-hibernate-hql-sql-results-list-to-javafx-tableview-observablelist
    // https://github.com/buckyroberts/Source-Code-from-Tutorials/blob/master/JavaFX/018_tableView/Product.java

    public ObservableList<Item> findAll() {

        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            //Query query = session.createQuery("select i from item as i");
            //Query result = session.createQuery("from item", Item.class).getResultList();
            //List<Item> result = session.createQuery("from item", Item.class).getResultList();
            //ObservableList<Item> list = FXCollections.observableArrayList(result.list());
            ObservableList<Item> list = FXCollections.observableArrayList(session.createQuery("from item", Item.class).getResultList());
            session.beginTransaction();

            session.getTransaction().commit();
            session.close();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}