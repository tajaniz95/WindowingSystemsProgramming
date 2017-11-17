import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.application.*;
import javafx.event.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.concurrent.Task;
import java.lang.System;

public class WaitandAlert extends Application {
	@Override
	public void start(Stage stage) {
		VBox root = new VBox(8);
		
		TextArea text = new TextArea();
		text.setEditable(false);
		root.getChildren().add(text);
		VBox.setVgrow(text, Priority.ALWAYS);
		
		Button startButton = new Button("start");
		startButton.setOnAction(
				(ActionEvent event) -> {
					Thread th = new Thread() {
						@Override
						public void run() {
							try {
								Thread.sleep(5000);
							}catch (Exception e) {
								//pass, forget it
							}
							
							Platform.runLater(new Runnable() {
								@Override
								public void run() {
									text.setText(
										text.getText() + "run completed!\n"
									);
								}
							});
							
							Platform.runLater(
									() -> text.setText(text.getText() + "I am a lambda\n")
								);
							}
						};
					th.start();
				}
			);
		root.getChildren().add(startButton);
		
		Scene scene = new Scene(root, 400, 400);
		stage.setScene(scene);
		stage.setTitle("WaitAndAlert");
		stage.show();
	}
}


/*
 import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.application.*;

import javafx.stage.*;

public class WaitandAlert extends Application {
	@Override
	public void start(Stage stage) {
		VBox root = new VBox(8);
		
		
		Button startButton = new Button("start");
		startButton.setOnAction(
				(ActionEvent event) -> {
					Thread th = new Thread() {
						@Override
						public void run() {
							try {
								Thread.sleep(5000);
							}catch (Exception e) {
								//pass, fuck it
							}
							
							Platform.runLater(new Runnable() {
								@Override
								public void run() {
									text.setText(
										text.getText() + "run completed!\n"
									);
								}
							});
							
						}
					};
					th.start();
				}
			);
		root.getChildren().add(startButton);
		
		Scene scene = new Scene(root, 300, 300);
		stage.setScene(scene);
	}
}
 */
