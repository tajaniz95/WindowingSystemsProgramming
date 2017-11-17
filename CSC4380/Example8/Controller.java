import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.event.ActionEvent;
import java.util.Vector;

public class Controller {
	@FXML protected TextField tf = null;
	
	@FXML protected void handle_click_java(ActionEvent e) {
		emitBasicEvent();
	}
	
	Vector<BasicHandler> handlers = new Vector<BasicHandler>();
	public void addBasicHandler(BasicHandler bh) {
		handlers.add(bh);
	}
	
	private void emitBasicEvent() {
		for(BasicHandler bh: handlers) {
			bh.handle(tf.getText());
		}
	}
}