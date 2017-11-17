import javafx.application.*;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class DragApp extends Application {
	@Override
	public void start(Stage stage) {
		InternalDrag id = new InternalDrag();
		FileDrag fd = new FileDrag();
		
		VBox root = new VBox();
		root.getChildren().addAll(id, fd);
		Scene s = new Scene(root, 600, 500);
		
		stage.setScene(s);
		stage.setTitle("Drag and Drop");
		stage.show();
	}
}
