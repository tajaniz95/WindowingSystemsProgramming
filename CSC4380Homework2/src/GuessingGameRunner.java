import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class GuessingGameRunner extends Application {
	@Override
	
	public void start(Stage primaryStage) {
		GuessingGameWidget ggw = new GuessingGameWidget();
		
		primaryStage.setTitle("Guessing Game");
		
		primaryStage.setScene(new Scene(ggw, 400, 200));
		primaryStage.show();
	}

}