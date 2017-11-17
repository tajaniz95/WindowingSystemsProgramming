import javafx.scene.layout.GridPane;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.web.HTMLEditor;
import javafx.scene.layout.Priority;
import javafx.beans.value.*;
import javafx.beans.binding.*;
import javafx.event.*;

class ClassWidget1 extends GridPane {
	public ClassWidget1() {
		TextField field = new TextField();
		add(field, 0, 0);
		field.setOnAction(
				event -> System.out.println("Text: " + field.getText())
		);
		field.setPromptText("Enter Text!");
		
		Button b = new Button("Print");
		add(b, 0, 1);
		b.setOnAction(
				event -> System.out.println(field.getText())
		);
		b.setDefaultButton(true);
		
		TextArea area = new TextArea();
		add(area, 0, 2);
		setHgrow(area, Priority.ALWAYS);
		setVgrow(area, Priority.ALWAYS);
		
		HTMLEditor editor = new HTMLEditor();
		add(editor, 0, 4);
	}
}