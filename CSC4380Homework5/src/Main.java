

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main extends Application {
     @Override
   public void start(Stage primaryStage) {
           View view = new View();
           Controller controlled = new Controller(view);
           
            primaryStage.setTitle("Model View Controller");
            
            primaryStage.setScene(new Scene(view, 400,400));            
            primaryStage.show();
    }  

   public static void main(String[] args) {
       launch(args);
   }
}

