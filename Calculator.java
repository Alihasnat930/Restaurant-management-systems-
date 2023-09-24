package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Calculator extends Application {
	private TextField textFieldNum1;
	private TextField textFieldNum2;
	private TextField textFieldRes;

	public static void main(String[] args) {
	    launch(args);
	}

	@Override
	public void start(Stage primaryStage) {
	    BorderPane root = new BorderPane();
	    root.setStyle("-fx-background-color: #808080;");

	    Label title = new Label("CALCULATOR");
	    title.setStyle("-fx-font-size: 20; -fx-font-weight: bold; -fx-text-fill: #000000; -fx-font-style: Arial;");
	    title.setMaxWidth(Double.MAX_VALUE);
	    title.setAlignment(javafx.geometry.Pos.CENTER);
	    root.setTop(title);

	    VBox center = new VBox();
	    center.setSpacing(20);

	    HBox num1 = new HBox();
	    num1.setSpacing(10);
	    Label num1Label = new Label("Enter Num1:");
	    num1Label.setStyle("-fx-font-size: 15; -fx-font-weight: bold; -fx-text-fill: #000000; -fx-font-style: Arial");
	    textFieldNum1 = new TextField();
	    textFieldNum1.setStyle("-fx-font-size: 15; -fx-font-weight: bold; -fx-text-fill: #000000;");
	    num1.getChildren().addAll(num1Label, textFieldNum1);

	    HBox num2 = new HBox();
	    num2.setSpacing(10);
	    Label num2Label = new Label("Enter Num2:");
	    num2Label.setStyle("-fx-font-size: 15; -fx-font-weight: bold; -fx-text-fill: #000000; -fx-font-style: Arial;");
	    textFieldNum2 = new TextField();
	    textFieldNum2.setStyle("-fx-font-size: 15; -fx-font-weight: bold; -fx-text-fill: #000000;");
	    num2.getChildren().addAll(num2Label, textFieldNum2);

	    HBox res = new HBox();
	    res.setSpacing(10);
	    Label resLabel = new Label("Result:");
	    resLabel.setStyle("-fx-font-size: 15; -fx-font-weight: bold; -fx-text-fill: #000000; -fx-font-style: Arial;");
	    textFieldRes = new TextField();
	    textFieldRes.setStyle("-fx-font-size: 15; -fx-font-weight: bold; -fx-text-fill: #000000;");
	    textFieldRes.setEditable(false);
	    res.getChildren().addAll(resLabel, textFieldRes);
	    
	    center.getChildren().addAll(num1, num2, res);
	    root.setCenter(center);

	    HBox bottom = new HBox();
	    bottom.setSpacing(10);
	    bottom.setMaxWidth(Double.MAX_VALUE);
	    bottom.setAlignment(javafx.geometry.Pos.CENTER);
	    Button btnAdd = new Button("ADDITION");
	    btnAdd.setStyle("-fx-font-size: 10; -fx-font-weight: bold; -fx-text-fill: #000000; -fx-background-color: #E0FFFF;");
	    btnAdd.setOnAction(e -> {
	        try {
	            double firstNum = Double.parseDouble(textFieldNum1.getText());
	            double secondNum = Double.parseDouble(textFieldNum2.getText());
	            textFieldRes.setText(String.valueOf(firstNum + secondNum));
	        } catch (NumberFormatException ex) {
	            Alert alert = new Alert(Alert.AlertType.ERROR);
	            alert.setTitle("Error");
	            alert.setContentText("Please enter valid numbers!");
	            alert.show();
	        }
	    });
	    Button btnSub = new Button("SUBTRACTION");
	    btnSub.setStyle("-fx-font-size: 10; -fx-font-weight: bold; -fx-text-fill: #000000; -fx-background-color: #E0FFFF;");
	    btnSub.setOnAction(e -> {
	        try {
	            double firstNum = Double.parseDouble(textFieldNum1.getText());
	            double secondNum = Double.parseDouble(textFieldNum2.getText());
	            textFieldRes.setText(String.valueOf(firstNum - secondNum));
	        } catch (NumberFormatException ex) {
	            Alert alert = new Alert(Alert.AlertType.ERROR);
	            alert.setTitle("Error");
	            alert.setContentText("Please enter valid numbers!");
	            alert.show();
	        }
	    });
	    Button btnMul = new Button("MULTIPLICATION");
	    btnMul.setStyle("-fx-font-size: 10; -fx-font-weight: bold; -fx-text-fill: #000000; -fx-background-color: #E0FFFF;");
	    btnMul.setOnAction(e -> {
	        try {
	            double firstNum = Double.parseDouble(textFieldNum1.getText());
	            double secondNum = Double.parseDouble(textFieldNum2.getText());
	            textFieldRes.setText(String.valueOf(firstNum * secondNum));
	        } catch (NumberFormatException ex) {
	            Alert alert = new Alert(Alert.AlertType.ERROR);
	            alert.setTitle("Error");
	            alert.setContentText("Please enter valid numbers!");
	            alert.show();
	        }
	    });
	    Button btnDiv = new Button("DIVISION");
	    btnDiv.setStyle("-fx-font-size: 10; -fx-font-weight: bold; -fx-text-fill: #000000; -fx-background-color: #E0FFFF;");
	    btnDiv.setOnAction(e -> {
	    	try {
	    	double firstNum = Double.parseDouble(textFieldNum1.getText());
	    	double secondNum = Double.parseDouble(textFieldNum2.getText());
	    	if (secondNum == 0) {
	    	Alert alert = new Alert(Alert.AlertType.ERROR);
	    	alert.setTitle("Error");
	    	alert.setContentText("Cannot divide by zero!");
	    	alert.show();
	    	} else {
	    	textFieldRes.setText(String.valueOf(firstNum / secondNum));
	    	}
	    	} catch (NumberFormatException ex) {
	    	Alert alert = new Alert(Alert.AlertType.ERROR);
	    	alert.setTitle("Error");
	    	alert.setContentText("Please enter valid numbers!");
	    	alert.show();
	    	}
	    	});
	    	bottom.getChildren().addAll(btnAdd, btnSub, btnMul, btnDiv);
	    	root.setBottom(bottom);

	    	Scene scene = new Scene(root, 450, 300);
	    	primaryStage.setScene(scene);
	    	primaryStage.setTitle("Calculator");
	    	primaryStage.show();
	    	}

	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		
	}

}