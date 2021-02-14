import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import projectOverview.LoginPage;


public class Main extends Application
{

    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        //Start of Application ( Creating Main Scene and Setup Stage )
        Scene scene = new Scene(new LoginPage());
        primaryStage.setScene(scene);
        primaryStage.setTitle("Login Page");
        primaryStage.setResizable(false);
        primaryStage.show();


        
    }
}
