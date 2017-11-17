import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.fxml.FXMLLoader;
import java.net.URL;
import java.io.InputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Runner extends Application {
	@Override
	public void start (Stage stage) {
		try {
			FileInputStream istream = new FileInputStream("Layout.fxml");
			FXMLLoader loader = new FXMLLoader();
			Parent root = loader.load(istream);
			
			Controller c = loader.getController();
			c.addBasicHandler(
					(String str) -> {
						System.out.println(str);
					}
			);
			
			Scene scene = new Scene(root, 600, 600);
			
			stage.setTitle("In Class With FXML");
			stage.setScene(scene);
			stage.show();
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
