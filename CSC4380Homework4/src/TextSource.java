import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;

class TextSource extends GridPane {
	private TextField field;
	private Button subButton;
	private Region r;
	public TextSource() {
		field = new TextField();
		add(field, 0, 0);
		field.setPromptText("Text-String");
		setHgrow(field, Priority.ALWAYS);
		
		r = new Region();
		add(r, 1, 5);
		setHgrow(r, Priority.ALWAYS);
		setVgrow(r, Priority.ALWAYS);
		
		subButton = new Button("Submit");
		add(subButton, 1, 0);
		
	}
	
	public Button getSubmitButton() {
		return subButton;
	}
	
	public String[] getField() {
		String[] value = new String[1];
		value[0] = field.getText();
		return value;
	}
}
