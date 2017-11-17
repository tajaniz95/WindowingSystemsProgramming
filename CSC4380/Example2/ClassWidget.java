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
import javafx.application.Application;

class ClassWidget extends GridPane{
	
	public ClassWidget() {
		CheckBox cb = new CheckBox("Check Me!");
		add(cb, 0, 0);
		cb.selectedProperty().set(true);
		
		ToggleGroup tga = new ToggleGroup();
		
		RadioButton ra1 = new RadioButton("ra1");
		add(ra1, 0, 1);
		ra1.setToggleGroup(tga);
		
		RadioButton ra2 = new RadioButton("ra2");
		add(ra2, 0, 2);
		ra2.setToggleGroup(tga);
		
		RadioButton rb1 = new RadioButton("rb1");
		add(rb1, 1, 1);
		
		tga.selectedToggleProperty().addListener(
			(observable, old_val, new_val) -> {
				if(new_val == ra1) {
					System.out.println("ra1");
				}else {
					System.out.println("ra2");
				}
			}
		);
		
		ComboBox<String> combo = new ComboBox<String>();
		combo.getItems().addAll("One", "Two", "Three");
		add(combo, 0, 3);
		
		combo.valueProperty().addListener(
				(observable, old_val, new_val) -> {
					System.out.println(new_val);
				}
		);
		
		Button b = new Button("Print");
		add(b, 0, 50);
		b.setOnAction(
				(event) -> System.out.println(cb.selectedProperty().get())
		);
	
		b.disabledProperty().and(Bindings.not(cb.selectedProperty()));
		b.setOnAction(
				(event) -> System.out.println(combo.getValue())
		);
	}
}