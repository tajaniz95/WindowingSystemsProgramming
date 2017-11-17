import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.application.Application;

public class PointSourceRunner extends Application {
	public void start(Stage primaryStage){
		PointSource ps = new PointSource();

		primaryStage.setTitle("Point Source Widget");

		primaryStage.setScene(new Scene(ps, 400, 400));
		primaryStage.show();
	}
}