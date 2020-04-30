import entity.Item;
import entity.ItemType;

import java.util.Arrays;
import java.util.List;

import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.scene.SceneBuilder;
import javafx.scene.control.*;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.StackPaneBuilder;
import javafx.stage.Stage;
import javafx.util.Callback;

import javafx.application.Application;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Callback;
import org.hibernate.Session;
import org.hibernate.query.Query;
import util.HibernateUtil;
import javafx.beans.property.SimpleStringProperty;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

public class MainTestTableView extends Application {

    Stage window;
    TableView<Item> table;
    TextField nameInput, containerInput, descriptionInput, descriptionIDInput, healthInput, heightInput,
            hitDiceInput, locationXInput, locationYInput, materialInput, itemTypeInput, widthInput, lengthInput,
            colorInput;


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("tableview - sRPG - JavaFX");

        //Name column
        TableColumn<Item, Integer> idDColumn = new TableColumn<>("Item ID");
        idDColumn.setMinWidth(200);
        idDColumn.setCellValueFactory(new PropertyValueFactory<>("itemId"));

        //container column
        TableColumn<Item, Integer> containerIdColumn = new TableColumn<>("Container ID");
        containerIdColumn.setMinWidth(100);
        containerIdColumn.setCellValueFactory(new PropertyValueFactory<>("containerId"));

        //description column
        TableColumn<Item, String> descriptionColumn = new TableColumn<>("description");
        descriptionColumn.setMinWidth(100);
        descriptionColumn.setCellValueFactory(new PropertyValueFactory<>("description"));

        //description column
        TableColumn<Item, Integer> descriptionIDColumn = new TableColumn<>("Description ID");
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
        // possible solution: https://stackoverflow.com/questions/37509031/javafx-populate-tableview-with-a-onetomany-relationship
        TableColumn<Item, Item> typeColumn = new TableColumn<>("type Id(itemType)");
        typeColumn.setMinWidth(250);

        typeColumn.setCellValueFactory(new PropertyValueFactory<> ("itemType"));

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

        //Name input
        nameInput = new TextField();
        nameInput.setPromptText("name");
        nameInput.setMinWidth(100);

        //container Input
        containerInput = new TextField();
        containerInput.setPromptText("container");
        containerInput.setMinWidth(100);

        //description Input
        descriptionInput = new TextField();
        descriptionInput.setPromptText("description");
        descriptionInput.setMinWidth(100);

        //descriptionID Input
        descriptionIDInput = new TextField();
        descriptionIDInput.setPromptText("descriptionID");
        descriptionIDInput.setMinWidth(100);

        //health Input
        healthInput = new TextField();
        healthInput.setPromptText("health");
        healthInput.setMinWidth(100);

        //height Input
        heightInput = new TextField();
        heightInput.setPromptText("height");
        heightInput.setMinWidth(100);

        //hitDice Input
        hitDiceInput = new TextField();
        hitDiceInput.setPromptText("hitDice");
        hitDiceInput.setMinWidth(100);

        //locationX Input
        locationXInput = new TextField();
        locationXInput.setPromptText("locationX");
        locationXInput.setMinWidth(100);

        //locationY Input
        locationYInput = new TextField();
        locationYInput.setPromptText("locationY");
        locationYInput.setMinWidth(100);

        //material Input
        materialInput = new TextField();
        materialInput.setPromptText("material");
        materialInput.setMinWidth(100);

        //itemType Input
        itemTypeInput = new TextField();
        itemTypeInput.setPromptText("itemType");
        itemTypeInput.setMinWidth(100);

        //width Input
        widthInput = new TextField();
        widthInput.setPromptText("width");
        widthInput.setMinWidth(100);

        //Length Input
        lengthInput = new TextField();
        lengthInput.setPromptText("Length");
        lengthInput.setMinWidth(100);

        //color Input
        colorInput = new TextField();
        colorInput.setPromptText("color");
        colorInput.setMinWidth(100);


        //Button
        Button addButton = new Button("Add");
        addButton.setOnAction(e -> addButtonClicked());
        Button deleteButton = new Button("Delete");
        deleteButton.setOnAction(e -> deleteButtonClicked());

        HBox hBox = new HBox();
        hBox.setPadding(new Insets(10,10,10,10));
        hBox.setSpacing(10);
        hBox.getChildren().addAll(nameInput, containerInput, descriptionInput, descriptionIDInput, healthInput,
                hitDiceInput, locationXInput, locationYInput, materialInput, itemTypeInput, widthInput,
                lengthInput, colorInput, addButton, deleteButton);


        table = new TableView<>();
        table.setItems(findAll());
        table.getColumns().addAll(idDColumn, containerIdColumn, descriptionColumn, descriptionIDColumn, healthColumn, heightColumn, hitdiceColumn,locationXColumn,locationYColumn,materialColumn,nameColumn,widthColumn,lengthColumn,colorColumn,typeColumn);

        VBox vBox = new VBox();
        vBox.getChildren().addAll(table,hBox);

        Scene scene = new Scene(vBox);
        window.setScene(scene);
        window.show();
    }


    public void addButtonClicked(){
        Item item = new Item();
        item.setName(nameInput.getText());

    }
    public void deleteButtonClicked(){

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
            ObservableList<Item> list = FXCollections.observableArrayList(session.createQuery("from Item", Item.class).getResultList());
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