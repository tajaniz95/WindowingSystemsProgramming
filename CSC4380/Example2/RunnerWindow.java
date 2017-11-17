import java.util.Optional;

import javafx.application.Application;
import javafx.event.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.*;
import javafx.scene.text.*;

import javafx.stage.Stage;
import javafx.geometry.*;

public class RunnerWindow extends Application {
	@Override
	
	public void start(Stage primaryStage) {
		ClassWidget cw = new ClassWidget();
		
		primaryStage.setTitle("working");
		
		primaryStage.setScene(new Scene(cw, 400, 400));
		primaryStage.show();
	}

}