import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class BasicRunner1 extends Application {
	@Override
	
	public void start(Stage stage) {
		BasicWidget1 root = new BasicWidget1();
		root.addBasicHandler(
				(String str) -> {
					System.out.println(str);
				}
			);
		
		Scene scene = new Scene(root, 600, 600);
		stage.setTitle("In Class");
		stage.setScene(scene);
		stage.show();
	}
}
