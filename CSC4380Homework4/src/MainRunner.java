import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.application.Application;

public class MainRunner extends Application {
	public void start(Stage primaryStage){
		Main m = new Main();

		primaryStage.setTitle("Main Widget");

		primaryStage.setScene(new Scene(m, 600, 600));
		primaryStage.show();
	}
}