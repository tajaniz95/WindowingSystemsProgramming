import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.application.Application;

public class MainInterfaceRunner extends Application {
	public void start(Stage primaryStage){
		MainInterfaceWidget mw = new MainInterfaceWidget();

		primaryStage.setTitle("Main Interface");

		primaryStage.setScene(new Scene(mw, 500, 500));
		primaryStage.show();
	}
}