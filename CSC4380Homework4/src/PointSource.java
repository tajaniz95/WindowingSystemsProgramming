import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;

class PointSource extends GridPane {
	
	private Button submitButton;
	private Slider s1, s2, s3;
	private Region r;
	
	public PointSource() {
		
		s1 = new Slider(0, 20, 0.5);
		add(s1, 0, 0, 2, 1);
		s1.setMin(0);
		s1.setMax(20);
		s1.setShowTickLabels(true);
		s1.setShowTickMarks(true);
		s1.setMajorTickUnit(1);
		s1.setBlockIncrement(1);
		setHgrow(s1, Priority.ALWAYS);
		
		s2 = new Slider(0, 20, 0.5);
		add(s2, 0, 1, 2, 1);
		s2.setMin(0);
		s2.setMax(20);
		s2.setShowTickLabels(true);
		s2.setShowTickMarks(true);
		s2.setMajorTickUnit(1);
		s2.setBlockIncrement(1);
		setHgrow(s2, Priority.ALWAYS);
		
		s3 = new Slider(0, 20, 0.5);
		add(s3, 0, 2, 2, 1);
		s3.setMin(0);
		s3.setMax(20);
		s3.setShowTickLabels(true);
		s3.setShowTickMarks(true);
		s3.setMajorTickUnit(1);
		s3.setBlockIncrement(1);
		setHgrow(s3, Priority.ALWAYS);
		
		r = new Region();
		add(r, 1, 5);
		setHgrow(r, Priority.ALWAYS);
		setVgrow(r, Priority.ALWAYS);
		
		submitButton = new Button("Submit");
		add(submitButton, 4, 1);
		
	}
	
	public Button getSubmitButton() {
		return submitButton;
	}
	
	public Double[] getSliderValues() {
		Double[] values = new Double[3];
		
		values[0] = s1.getValue();
		values[1] = s2.getValue();
		values[2] = s3.getValue();
		
		return values;
	}	
}
