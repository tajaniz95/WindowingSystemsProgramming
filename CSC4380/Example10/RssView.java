import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.*;
import javafx.event.*;

import javafx.stage.FileChooser;

import java.util.Vector;

import java.io.File;

public class RssView extends VBox {

    private VBox entriesBox;
    private TextField pathField;

    private Vector<PathHandler> pathHandlers;

    public RssView() {
        setSpacing(8.0);

        HBox top = new HBox();

        pathField = new TextField();
        
        Button openButton = new Button("Choose File");
        openButton.setOnAction(
            (ActionEvent event) -> {
                FileChooser chooser = new FileChooser();
                chooser.setTitle("Choose a File");

                File selected = chooser.showOpenDialog(null);
                if (selected != null) {
                    pathField.setText(selected.toString());
                }
            }
        );

        Button readButton = new Button("Read File");
        readButton.setOnAction(
            (ActionEvent event) -> {
                firePathEvent();
            }
        );

        top.getChildren().addAll(pathField, openButton, readButton);
        HBox.setHgrow(pathField, Priority.ALWAYS);

        this.getChildren().add(top);

        entriesBox = new VBox();

        this.getChildren().add(entriesBox);

        pathHandlers = new Vector<PathHandler>();
    }

    public void showError(String error) {
        Alert a = new Alert(AlertType.ERROR, error, ButtonType.OK);
        a.showAndWait();
    }

    public void showResults(Vector<RssResult> results) {
        entriesBox.getChildren().clear();

        for (RssResult result: results) {
            Hyperlink h = new Hyperlink(result.title);
            entriesBox.getChildren().add(h);
        }
    }

    public void addPathHandler(PathHandler handler) {
        pathHandlers.add(handler);
    }

    private void firePathEvent() {
        for (PathHandler ph: pathHandlers) {
            ph.handlePath(pathField.getText());
        }
    }
}