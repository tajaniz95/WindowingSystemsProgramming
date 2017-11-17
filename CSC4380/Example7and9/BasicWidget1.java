
import java.util.Vector;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

class BasicWidget1 extends GridPane {
	private Vector<BasicHandler> handlers = new Vector<BasicHandler>();
	
	public BasicWidget1() {
		
		TextField tf = new TextField();
		add(tf, 0, 0);
		
		Button b = new Button("Submit");
		add(b, 1, 0);
		
		b.setOnAction(
				event -> {
					String str = tf.getText();
					for(BasicHandler bh: handlers) {
						bh.handle(str);
					}
				}
			);
	}
	
	public void addBasicHandler(BasicHandler bh) {
		handlers.add(bh);
	}
}
