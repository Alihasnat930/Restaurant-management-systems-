package application;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class LoginForm extends Application {
//private Image img_logo = new Image("C:\\Users\\Ali\\eclipse-workspace\\OOP_project\\src\\application\\logo.jpg", 90, 90, true, true);
private TextField textFieldUser;
private PasswordField passwordFieldPass;
public static void main(String[] args) {
    launch(args);
}

@Override
public void start(Stage primaryStage) {
    Pane contentPane = new Pane();
    contentPane.setPrefSize(612, 493);
    contentPane.setStyle("-fx-background-color: #87CEEB; -fx-border-color: #808080; -fx-border-width: 1px;");

    Label lblUser = new Label("USERNAME:");
    lblUser.setLayoutX(88);
    lblUser.setLayoutY(157);
    lblUser.setPrefSize(241, 43);
    lblUser.setTextFill(Color.rgb(220, 20, 60));
    lblUser.setFont(new javafx.scene.text.Font("Times New Roman", 20));
    contentPane.getChildren().add(lblUser);

    Label lblPass = new Label("PASSWORD:");
    lblPass.setLayoutX(86);
    lblPass.setLayoutY(265);
    lblPass.setPrefSize(229, 43);
    lblPass.setTextFill(Color.rgb(220, 20, 60));
    lblPass.setFont(new javafx.scene.text.Font("Times New Roman", 20));
    contentPane.getChildren().add(lblPass);

    textFieldUser = new TextField();
    textFieldUser.setLayoutX(143);
    textFieldUser.setLayoutY(211);
    textFieldUser.setPrefSize(311, 43);
    textFieldUser.setFont(new javafx.scene.text.Font("Times New Roman", 20));
    contentPane.getChildren().add(textFieldUser);

    passwordFieldPass = new PasswordField();
    passwordFieldPass.setLayoutX(143);
    passwordFieldPass.setLayoutY(304);
    passwordFieldPass.setPrefSize(311, 43);
    passwordFieldPass.setFont(new javafx.scene.text.Font("Times New Roman", 20));
    contentPane.getChildren().add(passwordFieldPass);

    Button btnLogin = new Button("LOGIN");
    btnLogin.setLayoutX(143);
    btnLogin.setLayoutY(388);
    btnLogin.setPrefSize(311, 43);
    btnLogin.setOnAction(new EventHandler<javafx.event.ActionEvent>() {
    	@Override
    	public void handle(javafx.event.ActionEvent event) {
    	String user = textFieldUser.getText();
    	String pass = passwordFieldPass.getText();


        if (user.equals("Admin") && pass.equals("12345")) {
            javafx.scene.control.Alert alert = new javafx.scene.control.Alert(javafx.scene.control.Alert.AlertType.INFORMATION);
            alert.setTitle("Login Successful");
            alert.setHeaderText("Welcome to our online fast food system!");
            alert.showAndWait();

            Food food = new Food();
            food.start(new Stage()); // this will start the Food class
        } else {
            javafx.scene.control.Alert alert = new javafx.scene.control.Alert(javafx.scene.control.Alert.AlertType.ERROR);
            alert.setTitle("Login Failed");
            alert.setHeaderText("Invalid username or password, please try again.");
            alert.showAndWait();
        }
    }
    });
    contentPane.getChildren().add(btnLogin);
//    ImageView imgView = new ImageView(img_logo);
//    imgView.setLayoutX(236);
//    imgView.setLayoutY(27);
//    contentPane.getChildren().add(imgView);

    Scene scene = new Scene(contentPane);
    primaryStage.setScene(scene);
    primaryStage.setTitle("Login Form");
    primaryStage.show();
}
}




