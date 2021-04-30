package org.eleven.controllers;

import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.eleven.entities.*;
import org.eleven.entities.Menu;
import org.eleven.resource.ColorPalette;
import org.eleven.resource.SceneLoader;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class MainSceneController implements Controller{

    @FXML MenuItem logOutButton;
    @FXML MenuBar menuBar;
    @FXML GridPane tableGrid;
    @FXML TableView tableMenu;
    @FXML AnchorPane orderItemsPane;
    @FXML AnchorPane orderStatsPanes;
    ArrayList<Button> tableButtons = new ArrayList<>();
    ArrayList<Region> tableRegions = new ArrayList<>();
    //Table View for the Menu:
    ArrayList<Item> menuItems = new ArrayList<>();
    TableColumn<Item, String> menuColumn1 = new TableColumn<>("Item ID");
    TableColumn<Item, String> menuColumn2 = new TableColumn<>("Item Name");
    TableColumn<Item, String> menuColumn3 = new TableColumn<>("Item Price");
    TableColumn<Item, String> menuColumn4 = new TableColumn<>("Item Type");
    //Table View for Orders:
    ArrayList<TableView> orderTables = new ArrayList<>();

    //Order Tab Text Fields
    @FXML Text tableNumberText;
    @FXML Text tableStatusText;
    @FXML Text orderStatusText;
    @FXML Text orderIDText;
    @FXML Text orderSubtotalText;
    @FXML Text orderTotalText;

    //Represents the currently selected table
    int selectedTableID = 1;
    Table selectedTable = FloorManager.getTable(selectedTableID);

    public void initialize() {
        initializeButtonGrid();
        initializeMenuTable();
        initializeOrderTableArray();
    }

    public void initializeButtonGrid() {
        //Table Grid Button and Region Initialization
        for(int i = 0; i < tableGrid.getChildren().size(); i++) {
            Node node = tableGrid.getChildren().get(i);
            if(node instanceof Button) {
                tableButtons.add((Button) node);
            } else if (node instanceof Region) {
                tableRegions.add((Region) node);
            }
        }
        tableButtons.forEach(b -> b.setText("TABLE"));
        tableRegions.forEach(r -> r.setBackground(new Background(new BackgroundFill(ColorPalette.Blue500(), CornerRadii.EMPTY, Insets.EMPTY))));
    }

    public void initializeMenuTable() {
        //Set up columns and add them to the MenuTable
        menuColumn1.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().itemIDString()));
        menuColumn2.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().itemName()));
        menuColumn3.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().itemPriceString()));
        menuColumn4.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().itemType()));
        tableMenu.getColumns().add(menuColumn1);
        tableMenu.getColumns().add(menuColumn2);
        tableMenu.getColumns().add(menuColumn3);
        tableMenu.getColumns().add(menuColumn4);
        //Add items from Menu Object to the local menuItems list (this is silly but scala and java ugh)
        Menu.items().foreach(i -> menuItems.add(i));
        //Add item to table
        menuItems.forEach(i -> tableMenu.getItems().add(i));
    }

    public void initializeOrderTableArray() {
        for(int t = 0; t < FloorManager.tables().size(); t++) {
            Table table = FloorManager.getTable(t);
            TableView tableView = newOrderTableView(table);
            orderTables.add(tableView);
        }
        orderItemsPane.getChildren().add(orderTables.get(0));
    }


    private TableView newOrderTableView(Table table) {
        TableView newTableView = new TableView();
        TableColumn<Item, String> itemName = new TableColumn<>("Item Name");
        TableColumn<Item, String> itemPrice = new TableColumn<>("Item Price");
//        TableColumn<Item, String> itemStatus = new TableColumn<>("Item Status");

        itemName.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().itemName()));
        itemPrice.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().itemPriceString()));
//        itemStatus.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().statusString()));

        newTableView.getColumns().add(itemName);
        newTableView.getColumns().add(itemPrice);
//        newTableView.getColumns().add(itemStatus);

        newTableView.prefWidthProperty().bind(orderItemsPane.widthProperty());
        newTableView.prefHeightProperty().bind(orderItemsPane.heightProperty());

        table.order().getItems().foreach(i -> newTableView.getItems().add(i));
        return newTableView;
    }

    public void update() {
        updateOrderTableView();
        updateOrderTabTextFields();
    }

    public void updateOrderTableView() {
        TableView currentView = orderTables.get(selectedTableID);
        Table currentTable = FloorManager.getTable(selectedTableID);
        currentView = newOrderTableView(currentTable);
        orderItemsPane.getChildren().removeAll();
        orderItemsPane.getChildren().add(currentView);
    }

    public void updateOrderTabTextFields() {
        tableNumberText.setText(String.valueOf(selectedTableID));
        tableStatusText.setText(selectedTable.status().ID());
        orderStatusText.setText(selectedTable.order().statusString());
        orderIDText.setText(String.valueOf(selectedTable.order().orderID()));
        orderSubtotalText.setText(selectedTable.order().subTotalString());
        orderTotalText.setText(selectedTable.order().totalString());
    }

    public void logOutButtonPressed(ActionEvent event) {
        Scene loginScene = SceneLoader.load_scene("login_scene_layout").scene();
        Stage primaryStage = (Stage) menuBar.getScene().getWindow();
        primaryStage.setScene(loginScene);
        primaryStage.setTitle("Automation Project - Login");
        primaryStage.setWidth(1000);
        primaryStage.setHeight(563);
        primaryStage.show();
    }

    public void tableButtonPressed(ActionEvent event) {
        selectedTableID = Integer.parseInt(extractID(event));
        selectedTable = FloorManager.getTable(selectedTableID);
        update();
    }

    public void addItemButtonPressed(ActionEvent event) {
        //Get currently selected item from the Menu Table
        Item selectedItem = (Item) tableMenu.getSelectionModel().getSelectedItem();
        selectedTable.order().addItem(selectedItem);
        System.out.println(selectedTable.order().subtotal());
        update();
    }

    public void deleteItemButtonPressed(ActionEvent event) {

    }

    public String extractID(ActionEvent event) {
        String id = ((Control) event.getSource()).getId();
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(id);
        StringBuilder extracted = new StringBuilder();
        while(matcher.find()) extracted.append(matcher.group());
        return extracted.toString();
    }

    public void tableStatusButtonPressed() { }
}
