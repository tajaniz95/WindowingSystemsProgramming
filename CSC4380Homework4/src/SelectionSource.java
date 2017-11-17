import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;

class SelectionSource extends GridPane {
	private RadioButton r1, r2, r3, r4;
	private Button submissionButton;
	private ToggleGroup tga;
	private Region r;
	public SelectionSource() {
		r = new Region();
		add(r, 1, 5);
		setHgrow(r, Priority.ALWAYS);
		setVgrow(r, Priority.ALWAYS);
		
		tga = new ToggleGroup();
		
		r1 = new RadioButton("A");
		add(r1, 0, 0);
		r1.setToggleGroup(tga);
		
		r2 = new RadioButton("B");
		add(r2, 0, 1);
		r2.setToggleGroup(tga);
		
		r3 = new RadioButton("C");
		add(r3, 1, 0);
		r3.setToggleGroup(tga);
		
		r4 = new RadioButton("D");
		add(r4, 1, 1);
		r4.setToggleGroup(tga);
		
		submissionButton = new Button("Submit");
		add(submissionButton, 2, 0);		
	}
	
	public Button getSubmissionButton() {
		return submissionButton;
	}	
	
	public String[] getRadioButton() {
		String[] a = new String[1];
		if(r1.isSelected()) {
			a[0] = r1.getText();
		}
		if(r2.isSelected()) {
			a[0] = r2.getText();
		}
		if(r3.isSelected()) {
			a[0] = r3.getText();
		}
		if(r4.isSelected()) {
			a[0] = r4.getText();
		}
		return a;
	}
}
