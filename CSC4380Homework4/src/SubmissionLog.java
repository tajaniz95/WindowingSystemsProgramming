import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;

class SubmissionLog extends GridPane {
	private TextArea area;
	private Region r;
	public SubmissionLog() {
		area = new TextArea();
		add(area, 0, 0);
		area.setEditable(false);
		setHgrow(area, Priority.ALWAYS);
		setVgrow(area, Priority.ALWAYS);
		
		r = new Region();
		add(r, 1, 5);
		setHgrow(r, Priority.ALWAYS);
		setVgrow(r, Priority.ALWAYS);

	}
	
	public void WriteToLog(String text) {
		area.appendText(text + "\n");
	}
}
