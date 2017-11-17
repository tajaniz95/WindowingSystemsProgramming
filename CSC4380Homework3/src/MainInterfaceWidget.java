import javafx.scene.layout.GridPane;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;

class MainInterfaceWidget extends GridPane{
	public MainInterfaceWidget() {
		
		TabPane pane = new TabPane();
		add(pane, 0, 3, 2, 1);
		
		Region r = new Region();
		add(r, 1, 5);
		setHgrow(r, Priority.ALWAYS);
		setVgrow(r, Priority.ALWAYS);
		
	/*	ScrollPane scroller = new ScrollPane();
		add(scroller, 0, 4, 2, 1);
		scroller.setContent(pane);
		scroller.setHbarPolicy(ScrollBarPolicy.ALWAYS);
		scroller.setVbarPolicy(ScrollBarPolicy.ALWAYS);
		setVgrow(scroller, Priority.ALWAYS);
		setHgrow(scroller, Priority.ALWAYS); */
		
		Button b = new Button("Add Transcode");
		add(b, 4, 5);
		b.setOnAction(
			(event) -> {
				Tab t = new Tab();
				ScrollPane scroller = new ScrollPane();
				t.setText("TranscodeWidget");
				scroller.setContent(new TranscodeWidget());
				scroller.setHbarPolicy(ScrollBarPolicy.NEVER);
				scroller.setVbarPolicy(ScrollBarPolicy.ALWAYS);
				t.setContent(scroller);
				pane.getTabs().add(t);
			}
		);
	}
}
