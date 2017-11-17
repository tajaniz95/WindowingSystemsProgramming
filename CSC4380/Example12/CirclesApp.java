import javafx.application.*;
import javafx.scene.*;
import javafx.stage.*;

public class CirclesApp extends Application {
	@Override
	public void start(Stage stage) {
		Circles cs = new Circles();
		try {
			cs.setPageCount(5);
		}catch(CirclesException ce) {
			System.out.println(ce.getMessage());
		}
		
		cs.addPageRequestHandler(
				(int id) -> {
					System.out.println("Page requested: " + id);
				}
			);
		
		Scene scene = new Scene(cs, 300, 300);
		
		stage.setScene(scene);
		stage.setTitle("Circle");
		stage.show();
	}

}
