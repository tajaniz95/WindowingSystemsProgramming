import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.application.Application;

public class RunnerWindow4 extends Application {
	public void start(Stage primaryStage){
		MenuWidget mw = new MenuWidget();

		primaryStage.setTitle("inclass");

		primaryStage.setScene(new Scene(mw,400,400));
		primaryStage.show();
	}
}
