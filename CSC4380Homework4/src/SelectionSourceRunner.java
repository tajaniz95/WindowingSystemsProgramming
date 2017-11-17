import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.application.Application;

public class SelectionSourceRunner extends Application {
	public void start(Stage primaryStage){
		SelectionSource ss = new SelectionSource();

		primaryStage.setTitle("Selection Source Widget");

		primaryStage.setScene(new Scene(ss, 400, 400));
		primaryStage.show();
	}
}