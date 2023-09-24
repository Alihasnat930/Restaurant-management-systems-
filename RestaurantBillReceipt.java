package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class RestaurantBillReceipt extends Application {
    private ListView<String> menuList;
    private TextField itemNameField;
    private TextField itemPriceField;
    private TextField totalField;
    private Button addButton;
    private Button removeButton;
    private Button calculateButton;
    private Button printButton;
    private Label subtotalField;
    private Label taxField;
    private Label tipField;


    @Override
    public void start(Stage primaryStage) {
        // Create UI element
    	 Label Menu = new Label("TOTAL=SUB TOTAL+8% TAX+15% TIP  ");


        Label menuLabel = new Label("Menu:");
        menuList = new ListView<>();
        menuList.getItems().addAll(
            "Pizza - $10.99",
            "Hamburger - $5.99",
            "French Fries - $2.99",
            "Soft Drink - $1.99"
        );
        Label itemNameLabel = new Label("Item Name:");
        itemNameField = new TextField();
        Label itemPriceLabel = new Label("Item Price:");
        itemPriceField = new TextField();
        addButton = new Button("Add");
        removeButton = new Button("Remove");
        Label totalLabel = new Label("Total:");
        totalField = new TextField();
        calculateButton = new Button("Calculate");
        printButton = new Button("Print");
        
       

        Button calculatorButton = new Button("Calculator");


        // Add event handlers for buttons
        printButton.setOnAction(e -> printButtonClicked());
        addButton.setOnAction(event -> addItem());
        removeButton.setOnAction(event -> removeItem());
        calculateButton.setOnAction(event -> calculateTotal());
        printButton.setOnAction(event -> printReceipt());
        calculatorButton.setOnAction(event -> openCalculator());


        // Create layout
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(8);
        grid.setHgap(10);

        // Add UI elements to layout
        // Add UI elements to layout
        grid.add(Menu,4,8);
        grid.add(menuLabel, 0, 0);
        grid.add(menuList, 1, 0, 2, 4);
        grid.add(itemNameLabel, 3, 0);
        grid.add(itemNameField, 4, 0);
        grid.add(itemPriceLabel, 3, 1);
        grid.add(itemPriceField, 4, 1);
        grid.add(addButton, 4, 2);
        grid.add(removeButton, 4, 3);
        grid.add(totalLabel, 3, 4);
        grid.add(totalField, 4, 4);
        grid.add(calculateButton, 4, 5);
        grid.add(printButton, 4, 6);
        grid.add(calculatorButton, 4, 7);


        // Create scene and show stage
        Scene scene = new Scene(grid, 600, 400);
        primaryStage.setTitle("Restaurant Bill Receipt");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void printReceipt() {
    	
    	RestaurantBillReceipt B = new RestaurantBillReceipt();
    	B.start(new Stage());
    	
    	try {
    	    // Create menu.txt file and write menu items to it
    	    FileWriter writer = new FileWriter("menu.txt");
    	    for (String item : menuList.getItems()) {
    	        writer.write(item + "\n");
    	    }
    	    writer.close();
    	    System.out.println("Menu saved to menu.txt");
    	} catch (IOException e) {
    	    System.out.println("Error saving menu: " + e.getMessage());}}

    private void openCalculator() {
  	  Calculator c= new Calculator();
	    c.start(new Stage());}

    private void calculateTotal() {
    	double subtotal = 0;
    	double tax = 0;
    	double tip = 0;
    	for (String item : menuList.getItems()) {
    	String[] itemDetails = item.split(" - ");
    	String priceString = itemDetails[1].substring(1);
    	double price = Double.parseDouble(priceString);
    	subtotal += price;
    	}
    	tax = subtotal * 0.08; // 8% tax
    	tip = subtotal * 0.15; // 15% tip
    	double total = subtotal + tax + tip;
    	totalField.setText("$" + total);
    	}
    	
    private void removeItem() {
        int selectedIndex = menuList.getSelectionModel().getSelectedIndex();
        menuList.getItems().remove(selectedIndex);
    }

    private void printButtonClicked() {
        System.out.println("Subtotal: " + subtotalField.getText());
        System.out.println("Tax: " + taxField.getText());
        System.out.println("Tip: " + tipField.getText());
        System.out.println("Total: " + totalField.getText());

        }

	private void addItem() {
        String itemName = itemNameField.getText();
        String itemPrice = itemPriceField.getText();

        if (!itemName.isEmpty() &&!itemPrice.isEmpty()) {
        	double price = Double.parseDouble(itemPrice);
        	menuList.getItems().add(itemName + " - $" + price);
        	itemNameField.clear();
        	itemPriceField.clear();
        	}
        	}



        	
        	public static void main(String[] args) {
        	    launch(args);
        	}
        	}



