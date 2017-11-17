import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.VBox;

class Main extends VBox {
	public Main() {
		VBox box = new VBox();
		box.getChildren().addAll();
		
		PointSource ps = new PointSource();
		this.getChildren().addAll(ps);
		
		TextSource ts = new TextSource();
		this.getChildren().addAll(ts);
		
		SelectionSource ss = new SelectionSource();
		this.getChildren().addAll(ss);
		
		SubmissionLog sl = new SubmissionLog();
		this.getChildren().addAll(sl);
		
		ps.getSubmitButton().setOnAction(new EventHandler<ActionEvent>() {
		    	@Override 
		    	public void handle(ActionEvent e) {
		    		Double[] values = ps.getSliderValues();
		    		sl.WriteToLog("Slider X: " + values[0] + " ");
		    		sl.WriteToLog("Slider Y: " + values[1] + " ");
		    		sl.WriteToLog("Slider Z: " + values[2] + " ");
		    	}
			}
		);	
		
		ts.getSubmitButton().setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent d) {
					String[] s = ts.getField();
					sl.WriteToLog("Field: " + s[0]);
				}
			}
		);
		
		ss.getSubmissionButton().setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent z) {
					String[] a = ss.getRadioButton();
					sl.WriteToLog("RadioButton: " + a[0]);
					//sl.WriteToLog("RadioButton B: " + a[1]);
					//sl.WriteToLog("RadioButton C: " + a[2]);
					//sl.WriteToLog("RadioButton D: " + a[3]);
				}
			}
		);
	}
}
