package projectOverview;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class LoginPage extends VBox
{
    public LoginPage()
    {

        //Creating Holder
        HBox username_holder = new HBox();
        HBox password_holder = new HBox();

        //Creating Elements
        TextField txt_username = new TextField();
        PasswordField txt_password = new PasswordField();

        Label lbl_username = new Label("Username :");
        Label lbl_pw = new Label("Password :");

        Button btn_login = new Button("Login");

        //Adding Elements
        username_holder.getChildren().addAll(lbl_username, txt_username);
        password_holder.getChildren().addAll(lbl_pw, txt_password);

        this.getChildren().addAll(username_holder, password_holder, btn_login);

        //Design
        this.setPrefHeight(400);
        this.setPrefWidth(400);
        this.setPadding(new Insets(12));
        this.setSpacing(8);
        this.setAlignment(Pos.CENTER);

        username_holder.setAlignment(Pos.CENTER);
        username_holder.setSpacing(8);
        password_holder.setAlignment(Pos.CENTER);
        password_holder.setSpacing(8);

        //Init Login BTN
        btn_login.setOnAction(event -> {
            String userName = txt_username.getText();
            String password = txt_password.getText();
            if (userName.equals("admin") && password.equals("admin")) {
                Stage adminPanelStage = new Stage();
                Scene scene = new Scene(new AdminPanel().get_root());
                adminPanelStage.setScene(scene);
                adminPanelStage.setResizable(false);
                adminPanelStage.setHeight(600);
                adminPanelStage.setWidth(800);
                adminPanelStage.show();
                this.getScene().getWindow().hide();
                System.out.println("Login As Admin");
            } else if(txt_username.getText().equals("user") && txt_password.getText().equals("user")) {
                Stage adminPanelStage = new Stage();
                User user = new User(txt_username.getText(),txt_password.getText());
                Scene scene = new Scene(new UserPanel(user));
                adminPanelStage.setScene(scene);
                adminPanelStage.setResizable(false);
                adminPanelStage.setHeight(600);
                adminPanelStage.setWidth(800);
                adminPanelStage.show();
                this.getScene().getWindow().hide();
                System.out.println("Login As User");
            }else {
                System.out.println("Login failed");
            }
        });

    }
}
