
import javafx.application.Application;
import javafx.event.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.*;
import javafx.scene.text.*;
import javafx.beans.binding.*;

import javafx.stage.Stage;
import javafx.geometry.*;

public class HomeworkRunner extends Application {
	@Override
	
	public void start(Stage primaryStage) {
		HomeworkWidget hw = new HomeworkWidget();
		
		primaryStage.setTitle("working");
		
		primaryStage.setScene(new Scene(hw, 400, 400));
		primaryStage.show();
	}

}