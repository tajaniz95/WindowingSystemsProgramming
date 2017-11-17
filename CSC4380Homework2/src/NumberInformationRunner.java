import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class NumberInformationRunner extends Application {
	@Override
	
	public void start(Stage primaryStage) {
		NumberInformationWidget nw = new NumberInformationWidget();
		
		primaryStage.setTitle("Homework 2 Part 1");
		
		primaryStage.setScene(new Scene(nw, 735, 400));
		primaryStage.show();
	}

}