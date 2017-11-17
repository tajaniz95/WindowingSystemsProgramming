import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class RunnerWindow3 extends Application {
	@Override

	public void start(Stage primaryStage){
		AlertWidget aw = new AlertWidget();
		aw.setAlignment(Pos.CENTER);

		primaryStage.setTitle("inclass");

		primaryStage.setScene(new Scene(aw,400,400));
		primaryStage.show();
	}
}