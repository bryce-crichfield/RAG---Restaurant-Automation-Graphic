package controllers;

import entities.Menu;
import entities.*;
import entities.status.OPEN;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import resource.SceneLoader;
import scala.collection.immutable.List;
import scala.collection.mutable.Queue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class MainSceneController implements Controller {

    @FXML
    MenuItem logOutButton;
    @FXML
    MenuBar menuBar;
    @FXML
    GridPane tableGrid;
    @FXML
    AnchorPane orderItemsPane;
    ArrayList<Button> tableGridButtons = new ArrayList<>();
    ArrayList<Region> tableGridRegions = new ArrayList<>();
    //Table Views for Menus:
    HashMap<String, TableView> menuTables = new HashMap<>();
    @FXML
    ChoiceBox seatNumChoiceBox;
    @FXML
    AnchorPane menuPane;
    @FXML
    AnchorPane queuePane;
    @FXML
    Button entreesFilterButton;
    @FXML
    Button lunchFilterButton;
    @FXML
    Button soupsFilterButton;
    @FXML
    Button dessertsFilterButton;
    @FXML
    Button drinksFilterButton;
    @FXML
    Button appetizersFilterButton;
    //Table View for Orders:
    ArrayList<TableView> orderTables = new ArrayList<>();

    //Order Tab Text Fields
    @FXML
    Text tableNumberText;
    @FXML
    Text tableStatusText;
    @FXML
    Text orderStatusText;
    @FXML
    Text orderIDText;
    @FXML
    Text orderSubtotalText;
    @FXML
    Text orderTotalText;

    //Represents the currently selected table
    int selectedTableID = 1;
    Table selectedTable = OrderManager.getTable(selectedTableID);

    public void initialize() {
        initializeButtonGrid();
        initializeSeatNumChoiceBox();
        initializeMenuTablesArray();
        initializeOrderTablesArray();
    }

    private void initializeButtonGrid() {
        //Table Grid Button and Region Initialization
        for (int i = 0; i < tableGrid.getChildren().size(); i++) {
            Node node = tableGrid.getChildren().get(i);
            if (node instanceof Button) {
                tableGridButtons.add((Button) node);
            } else if (node instanceof Region) {
                tableGridRegions.add((Region) node);
            }
        }
        tableGridButtons.forEach(b -> b.setText("Tbl. " + extractTableID(b)));
        tableGridRegions.forEach(r -> r.setBackground(new Background(new BackgroundFill(OPEN.color(), CornerRadii.EMPTY, Insets.EMPTY))));
    }

    private void initializeSeatNumChoiceBox() {
        for (int i = 1; i < 5; i++) {
            String option = "Seat: ".concat(String.valueOf(i));
            seatNumChoiceBox.getItems().add(option);
        }
    }

    private void initializeMenuTablesArray() {
        menuTables.put("entrees", newMenuTableView(Menu.entrees()));
        menuTables.put("appetizers", newMenuTableView(Menu.appetizers()));
        menuTables.put("lunch", newMenuTableView(Menu.lunch()));
        menuTables.put("desserts", newMenuTableView(Menu.desserts()));
        menuTables.put("soups", newMenuTableView(Menu.salads()));
        menuTables.put("drinks", newMenuTableView(Menu.drinks()));
        menuPane.getChildren().add(menuTables.get("drinks"));
    }

    private void initializeOrderTablesArray() {
        for (int t = 0; t < OrderManager.tables().size(); t++) {
            Table table = OrderManager.getTable(t);
            TableView tableView = newOrderTableView(table);
            orderTables.add(tableView);
        }
        orderItemsPane.getChildren().add(orderTables.get(0));
    }

    private TableView newMenuTableView(List<Item> items) {
        TableView newTableView = new TableView();
        //Set up columns and add them to the MenuTable
        TableColumn<Item, String> menuItemID = new TableColumn<>("Item ID");
        TableColumn<Item, String> menuItemName = new TableColumn<>("Item Name");
        TableColumn<Item, String> menuItemPrice = new TableColumn<>("Item Price");
        TableColumn<Item, String> menuItemType = new TableColumn<>("Item Type");
        menuItemID.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().itemIDString()));
        menuItemName.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().itemName()));
        menuItemPrice.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().itemPriceString()));
        menuItemType.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().itemType()));
        newTableView.getColumns().add(menuItemID);
        newTableView.getColumns().add(menuItemName);
        newTableView.getColumns().add(menuItemPrice);
        newTableView.getColumns().add(menuItemType);
        newTableView.prefWidthProperty().bind(menuPane.widthProperty());
        newTableView.prefHeightProperty().bind(menuPane.heightProperty());
        items.foreach(i -> newTableView.getItems().add(i));
        return newTableView;
    }

    private TableView newOrderTableView(Table table) {
        TableView newTableView = new TableView();
        TableColumn<Item, String> itemName = new TableColumn<>("Item Name");
        TableColumn<Item, String> itemPrice = new TableColumn<>("Item Price");
        TableColumn<Item, String> itemSeatNumber = new TableColumn<>("Seat Number");
        itemName.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().itemName()));
        itemPrice.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().itemPriceString()));
        itemSeatNumber.setCellValueFactory(data -> new SimpleStringProperty(String.valueOf(data.getValue().getSeatNum())));
        newTableView.getColumns().add(itemName);
        newTableView.getColumns().add(itemPrice);
        newTableView.getColumns().add(itemSeatNumber);
        newTableView.prefWidthProperty().bind(orderItemsPane.widthProperty());
        newTableView.prefHeightProperty().bind(orderItemsPane.heightProperty());
        table.getOrder().getItems().foreach(i -> newTableView.getItems().add(i));
        return newTableView;
    }

    private TableView newQueueTableView(Queue<Order> queue) {
        TableView newTableView = new TableView();
        TableColumn<Order, String> orderID = new TableColumn<>("Order ID");
        TableColumn<Order, String> tableID = new TableColumn<>("Table ID");
        TableColumn<Order, String> orderStatus = new TableColumn<>("Order Status");
        orderID.setCellValueFactory(data -> new SimpleStringProperty(String.valueOf(data.getValue().orderID())));
        orderStatus.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getStatus().ID()));
        tableID.setCellValueFactory(data -> new SimpleStringProperty(String.valueOf(data.getValue().tableid())));
        newTableView.getColumns().add(orderID);
        newTableView.getColumns().add(orderStatus);
        newTableView.getColumns().add(tableID);
        newTableView.prefWidthProperty().bind(queuePane.widthProperty());
        newTableView.prefHeightProperty().bind(queuePane.heightProperty());
        queue.foreach(o -> newTableView.getItems().add(o));
        return newTableView;
    }

    public void update() {
        updateOrderTableView();
        updateOrderTabTextFields();
        updateTableGrid();
        updateOrderQueueView();
    }

    private void updateOrderTableView() {
        Table currentTable = OrderManager.getTable(selectedTableID);
        TableView currentView = currentView = newOrderTableView(currentTable);
        orderItemsPane.getChildren().clear();
        orderItemsPane.getChildren().add(currentView);
    }

    private void updateOrderTabTextFields() {
        tableNumberText.setText(String.valueOf(selectedTableID));
        tableStatusText.setText(selectedTable.getStatus().ID());
        //TODO: FIX THIS
//        tableStatusText.setStyle("-fx-text-fill: " + selectedTable.getStatus().color().toString());
        orderStatusText.setText(selectedTable.getOrder().statusString());
        orderIDText.setText(String.valueOf(selectedTable.getOrder().orderID()));
        orderSubtotalText.setText(selectedTable.getOrder().subTotalString());
        orderTotalText.setText(selectedTable.getOrder().totalString());
    }

    private void updateTableGrid() {
        for (Region region : tableGridRegions) {
            int extractedID = Integer.parseInt(extractTableID((region)));
            if (extractedID == selectedTableID) {
                region.setBorder(new Border(new BorderStroke(Color.BLACK,
                        BorderStrokeStyle.DOTTED, CornerRadii.EMPTY, BorderStroke.MEDIUM)));
            } else {
                region.setBorder(null);
            }
            Color color = OrderManager.getTable(extractedID).getStatus().color();
            region.setBackground(new Background(new BackgroundFill(color, CornerRadii.EMPTY, Insets.EMPTY)));
        }
    }

    private void updateOrderQueueView() {
        queuePane.getChildren().clear();
        queuePane.getChildren().add(newQueueTableView(OrderManager.getQueue()));
    }

    public void logOutButtonPressed(ActionEvent event) {
        Scene loginScene = SceneLoader.load_scene("login_scene_layout").scene();
        Stage primaryStage = (Stage) menuBar.getScene().getWindow();
        primaryStage.setScene(loginScene);
        primaryStage.setTitle("Automation Project - Login");
        primaryStage.setWidth(1000);
        primaryStage.setHeight(563);
        primaryStage.setFullScreen(false);
        primaryStage.show();
    }

    public void tableButtonPressed(ActionEvent event) {
        selectedTableID = Integer.parseInt(extractTableID((Node) event.getSource()));
        selectedTable = OrderManager.getTable(selectedTableID);
        update();
    }

    public void addItemButtonPressed(ActionEvent event) {
        //Get currently selected item from the Menu Table
        TableView currentTab = (TableView) menuPane.getChildren().get(0);
        Item selectedItem = (Item) currentTab.getSelectionModel().getSelectedItem();
        if (selectedItem == null) return;
        selectedItem.setSeatNum(seatNumChoiceBox.getSelectionModel().getSelectedIndex() + 1);
        selectedTable.getOrder().addItem(selectedItem);
        System.out.println(selectedTable.getOrder().subtotal());
        update();
    }

    public void deleteItemButtonPressed(ActionEvent event) {
        TableView currentTab = (TableView) orderItemsPane.getChildren().get(0);
        System.out.println(currentTab.getItems());
        Object selectedItem = currentTab.getSelectionModel().getSelectedItem();
        System.out.println(selectedItem);
    }

    public void tableStatusButtonPressed() {
        selectedTable.setStatus(selectedTable.nextStatus());
        update();
    }

    public void filterButtonPressed(ActionEvent event) {
        String extractedType = extractMenuName((Node) event.getSource());
        System.out.println(extractedType);
        menuPane.getChildren().removeAll();
        menuPane.getChildren().clear();
        menuPane.getChildren().add(menuTables.get(extractedType));
    }

    public void submitOrderButtonPressed(ActionEvent event) {
        Order submitOrder = OrderManager.getTable(selectedTableID).getOrder();
        OrderManager.submitOrder(submitOrder);
        update();
        System.out.println(OrderManager.getQueue());
    }

    private String extractTableID(Node node) {
        String id = node.getId();
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(id);
        StringBuilder extracted = new StringBuilder();
        while (matcher.find()) extracted.append(matcher.group());
        return extracted.toString();
    }

    private String extractMenuName(Node node) {
        String id = node.getId();
        Pattern pattern = Pattern.compile("[a-zA-Z]+(?=FilterButton)");
        Matcher matcher = pattern.matcher(id);
        StringBuilder extracted = new StringBuilder();
        while (matcher.find()) extracted.append(matcher.group());
        return extracted.toString();
    }
}
