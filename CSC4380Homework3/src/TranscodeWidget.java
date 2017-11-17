import java.io.File;
import java.util.List;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Window;


class TranscodeWidget extends GridPane {
	String T; //target
	String S; //source
	String Q; //quality
	double A = 0;
	public TranscodeWidget() {
		Region r = new Region();
		add(r, 0, 6);
		setHgrow(r, Priority.ALWAYS);
		setVgrow(r, Priority.ALWAYS);
		
		TextField field1 = new TextField();
		add(field1, 0, 0);
		setHgrow(field1, Priority.ALWAYS);
		field1.setPromptText("Source Text-Field");
		field1.setEditable(false);
		
		Button b1 = new Button("Get Source");
		add(b1, 1, 0);
		b1.setOnAction(
				event -> {
					FileChooser chooser = new FileChooser();
					chooser.setTitle("Choose a File");
					chooser.getExtensionFilters().addAll(
							new ExtensionFilter("Source Files", "*.java", ".py"),
							new ExtensionFilter("All Files", "*")
							);
					List<File> fs = chooser.showOpenMultipleDialog(getOwnerWindow());
					if(fs != null) {
						for(File f: fs) {
							field1.setText(f.getAbsolutePath());
						}
					}else {
						System.out.println("Nothing was Selected!");
					}
				});
		
		TextField field2 = new TextField();
		add(field2, 0, 1);
		setHgrow(field2, Priority.ALWAYS);
		field2.setPromptText("Target Text-Field");
		field2.setEditable(false);
		
		Button b2 = new Button("Get Target");
		add(b2, 1, 1);
		b2.setOnAction(
				event -> {
					FileChooser save = new FileChooser();
					save.setTitle("Save a File");
					save.getExtensionFilters().addAll(
							new ExtensionFilter("Source Files", "*.java", ".py"),
							new ExtensionFilter("All Files", "*")
							);
					List<File> fs = save.showOpenMultipleDialog(getOwnerWindow());
					if(fs != null) {
						for(File f: fs) {
							field2.setText(f.getAbsolutePath());
						}
					}else {
						System.out.println("Nothing was Selected!");
					}
				});  
		
		Slider slider = new Slider(0, 9, 0.5);
		add(slider, 0, 3, 2, 1);
		slider.setMin(0);
		slider.setMax(9);
		slider.setShowTickLabels(true);
		slider.setShowTickMarks(true);
		slider.setMajorTickUnit(1);
		slider.setBlockIncrement(1);
		setHgrow(slider, Priority.ALWAYS);
		
		Button b3 = new Button("Start");
		add(b3, 0, 4);
		
		ProgressBar bar = new ProgressBar();
		add(bar, 0, 5);
		bar.setMaxWidth(Double.MAX_VALUE);
		
		Button b4 = new Button("Step");
		add(b4, 1, 5);
		
		 b3.setOnAction(
				event -> {
					if(field1.getText().isEmpty() || field2.getText().isEmpty()) {
						Alert crazy = new Alert(AlertType.ERROR);
						crazy.setTitle("Error Message");
						crazy.setHeaderText("User did something wrong. Try Again.");
						crazy.setContentText("Source Text Field or Target Text Field is Empty!");
						
						crazy.showAndWait();
					}else {
						bar.setProgress(0);
						S = field1.getText();
						System.out.println("S: " + S);
						T = field2.getText();
						System.out.println("T: " + T);
						
						String z = " ";
						final Label text = new Label();
						text.setTooltip(new Tooltip(z));
						text.setText((slider.getValue()) + " ");
						Q = text.getText();
						System.out.println(Q);
					}
				}
			); 
		
		b4.setOnAction(
				event -> {
					if(S == null || T == null || Q == null) {
						Alert type = new Alert(AlertType.INFORMATION);
						type.setTitle("Error Message");
						type.setHeaderText("User did something wrong. Try Again.");
						type.setContentText("Source, Quality, and Target are not stored");
					}
					
					if(A < 1) {
						A += 0.1;
						bar.setProgress(A);
					} else {
						bar.setProgress(ProgressBar.INDETERMINATE_PROGRESS);
					}
				}
			);
		
	}
	
	private Window getOwnerWindow(){
		Scene parentScene = this.getScene();
		if(parentScene != null) {
			return parentScene.getWindow();
		}

		return null;
	}
}
