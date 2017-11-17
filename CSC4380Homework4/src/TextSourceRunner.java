import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.application.Application;

public class TextSourceRunner extends Application {
	public void start(Stage primaryStage){
		TextSource ts = new TextSource();

		primaryStage.setTitle("Text Source Widget");

		primaryStage.setScene(new Scene(ts, 400, 400));
		primaryStage.show();
	}
}