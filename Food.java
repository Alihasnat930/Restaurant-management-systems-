package application;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Food extends Application {
	public static void main(String[] args) {
	    launch(args);
	}

	@Override
	public void start(Stage primaryStage) {
    Pane contentPane = new Pane();
	    contentPane.setPrefSize(929, 522);
	    contentPane.setStyle("-fx-background-color: #87CEEB");
	    
	    Label lblWelcome = new Label("WELCOME TO OUR ONLINE FOOD SERVICE");
	    lblWelcome.setLayoutX(131);
	    lblWelcome.setLayoutY(25);
	    lblWelcome.setPrefSize(619, 92);
	    lblWelcome.setTextFill(Color.rgb(169, 169, 169));
	    lblWelcome.setFont(new javafx.scene.text.Font("Algerian", 27));
	    contentPane.getChildren().add(lblWelcome);
//
//	    Image img = new Image(" ");
//	    BackgroundImage background = new BackgroundImage(img, 
//	        BackgroundRepeat.NO_REPEAT, 
//	        BackgroundRepeat.NO_REPEAT, 
//	        BackgroundPosition.CENTER, 
//	        BackgroundSize.DEFAULT);
//	    contentPane.setBackground(new Background(background));

	   	    Button btnMenu = new Button("CLICK HERE");
	    btnMenu.setLayoutX(576);
	    btnMenu.setLayoutY(357);
	    btnMenu.setPrefSize(144, 55);
	    btnMenu.setFont(new javafx.scene.text.Font("Calibri", 22));
	    btnMenu.setOnAction(new EventHandler<javafx.event.ActionEvent>() {
	    @Override
	    public void handle(javafx.event.ActionEvent event) {
	    // Code to handle menu button click and open the menu class
	     RestaurantBillReceipt R= new RestaurantBillReceipt();
	    R.start(new Stage());
	    }
	    });
	    contentPane.getChildren().add(btnMenu);
	    Label lblMenu = new Label("TO SEE OUR MENU LIST.........");
	    lblMenu.setLayoutX(95);
	    lblMenu.setLayoutY(351);
	    lblMenu.setPrefSize(310, 55);
	    lblMenu.setTextFill(Color.rgb(169, 169, 169));
	    lblMenu.setFont(new javafx.scene.text.Font("Tahoma", 22));
	    contentPane.getChildren().add(lblMenu);

	    Scene scene = new Scene(contentPane);
	    primaryStage.setScene(scene);
	    primaryStage.setTitle("Food System");
	    primaryStage.show();
	    }


}


