import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.*;

import javafx.stage.Stage;

public class BasicApplication extends Application {
	@Override
	
	public void start(Stage primaryStage) {
		primaryStage.setTitle("window");
		
		GridPane root = new GridPane();
		
		BasicWidget1 bw = new BasicWidget1();
		root.add(bw, 0, 0);
		
		BasicWidget1 bw2 = new BasicWidget1();
		root.add(bw2, 2, 2);
		
		primaryStage.setScene(new Scene(root, 400, 400));
		primaryStage.show();
	}
}
