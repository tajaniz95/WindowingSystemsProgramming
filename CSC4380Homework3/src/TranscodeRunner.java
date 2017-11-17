import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.application.Application;

public class TranscodeRunner extends Application {
	public void start(Stage primaryStage){
		TranscodeWidget tw = new TranscodeWidget();

		primaryStage.setTitle("Transcode Widget");

		primaryStage.setScene(new Scene(tw, 400, 400));
		primaryStage.show();
	}
}