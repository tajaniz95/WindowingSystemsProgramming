import javafx.application.*;
import javafx.scene.*;
import javafx.stage.*;

public class RssApp extends Application {
    @Override
    public void start(Stage stage) {
        RssView root = RssFactory.getRssView();

        Scene scene = new Scene(root, 700.0, 700.0);

        stage.setTitle("Rss Application");
        stage.setScene(scene);
        stage.show();
    }
}
