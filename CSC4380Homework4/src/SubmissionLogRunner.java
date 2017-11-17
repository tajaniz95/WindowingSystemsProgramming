import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.application.Application;

public class SubmissionLogRunner extends Application {
	public void start(Stage primaryStage){
		SubmissionLog sl = new SubmissionLog();

		primaryStage.setTitle("Submission Log Widget");

		primaryStage.setScene(new Scene(sl, 500, 500));
		primaryStage.show();
	}
}