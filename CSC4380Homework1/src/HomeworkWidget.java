import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.stage.Stage;

class HomeworkWidget extends GridPane{
	private String str = "";
	public HomeworkWidget() {
		CheckBox cb1 = new CheckBox("cb1");
		add(cb1, 0, 0);
		cb1.selectedProperty().set(true);
		
		ToggleGroup tga1 = new ToggleGroup();
		
		RadioButton ra1 = new RadioButton("ra1");
		add(ra1, 0, 1);
		ra1.setToggleGroup(tga1);
		
		RadioButton ra2 = new RadioButton("ra2");
		add(ra2, 0, 2);
		ra2.setToggleGroup(tga1);
		
		RadioButton ra3 = new RadioButton("ra3");
		add(ra3, 0, 3);
		ra3.setToggleGroup(tga1);
		
		CheckBox cb2 = new CheckBox("cb2");
		add (cb2, 1, 0);
		cb2.selectedProperty().set(true);
		
		ToggleGroup tga2 = new ToggleGroup();
		
		RadioButton rb1 = new RadioButton("rb1");
		add(rb1, 1, 1);
		rb1.setToggleGroup(tga2);
		
		RadioButton rb2 = new RadioButton("rb2");
		add(rb2, 1, 2);
		rb2.setToggleGroup(tga2);
		
		RadioButton rb3 = new RadioButton("rb3");
		add(rb3, 1, 3);
		rb3.setToggleGroup(tga2);
		
		Region r = new Region();
		add(r, 1, 5);
		GridPane.setHgrow(r, Priority.ALWAYS);
		GridPane.setVgrow(r, Priority.ALWAYS);
		
		Button b1 = new Button("Print");
		add(b1, 3, 1);
		b1.setOnAction (
				(event) -> System.out.println(str+= "\n Program Finish! \n ")
		);
		  
		cb1.selectedProperty().addListener(
			(observable, old_val, new_val) -> {
				if(new_val != null) {
					System.out.println("cb1 enable");
					ra1.setDisable(false);
					ra2.setDisable(false);
					ra3.setDisable(false);
				}else {
					System.out.println("cb1 disable");
					ra1.setDisable(true);
					ra2.setDisable(true);
					ra3.setDisable(true);
				}
			}
		);
		
		cb2.selectedProperty().addListener(
			(observable, old_val, new_val) -> {
				if(new_val != null) {
					System.out.println("cb2 enable");
					rb1.setDisable(false);
					rb2.setDisable(false);
					rb3.setDisable(false);
				}else {
					System.out.println("cb2 disable");
					rb1.setDisable(true);
					rb2.setDisable(true);
					rb3.setDisable(true);
				}
			}
		);
		
		  Button b2 = new Button("Submit");
		  add(b2, 3, 0);
		  b2.setOnAction (
				  (event) -> {
		                 if(cb1.isSelected()) { 
		                   if (ra1.isSelected()){
		                       str += ra1.getText()+ " ";
		                   }
		                   if (ra2.isSelected()){
		                       str += ra2.getText() + " ";
		                   }
		                   if (ra3.isSelected()){
		                       str += ra3.getText()+ " ";
		                   }
		                 }
		                 if(cb2.isSelected()) {		         
		                   if (rb1.isSelected()){
		                       str += rb1.getText() + " ";
		                   }
		                   if (rb2.isSelected()){
		                       str += rb2.getText()+ " ";
		                   }
		                   if (rb3.isSelected()){
		                       str += rb3.getText() + " ";
		                   }
		                 }
		           	}
				  );
		
	}
}	