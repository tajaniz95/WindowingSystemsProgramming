import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.*;

import javafx.stage.Stage;

class BasicWidget extends GridPane {
	public BasicWidget() {
		Label l = new Label("Hi, I'm a label!");
		add(l, 0, 0);
		
		Region r = new Region();
		GridPane.setHgrow(r, Priority.ALWAYS);
		GridPane.setVgrow(r, Priority.ALWAYS);
		add(r, 1, 1);
		
		Button b = new Button("Click me");
		add(b, 2, 2);		
	}
}