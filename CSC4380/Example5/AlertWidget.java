
import javafx.scene.layout.GridPane;
import javafx.scene.control.Button;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Modality;
import javafx.stage.StageStyle;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.stage.Window;
import java.util.List;
import java.io.File;
import java.util.Optional;

class AlertWidget extends GridPane{
	public AlertWidget(){
		Button windowB = new Button("Window");
		add(windowB, 0, 0);
		windowB.setOnAction(
		    event -> {
			Stage s = new Stage();
			s.setTitle("new stage");
			s.initModality(Modality.WINDOW_MODAL);
			s.initOwner(this.getOwnerWindow());
			s.initStyle(StageStyle.UTILITY);
			s.setScene(new Scene(new PanelWidget1()));
			s.showAndWait();
			System.out.println("run");
		   }
		);
		
		Button alertB = new Button("Alert");
		add(alertB, 1, 0);
		alertB.setOnAction(
				event -> {
					Alert a = new Alert(AlertType.INFORMATION, "Class is almost over!", ButtonType.OK, ButtonType.FINISH);
					a.initOwner(getOwnerWindow());
					Optional<ButtonType> result = a.showAndWait();
										
					if(result.isPresent() && result.get() == ButtonType.OK) {
						System.out.println("Come on, it's almost over! Have some enthusiasm!");
					}
				}
			);
		
		Button saveB = new Button("Open");
		add(saveB, 2, 0);
		saveB.setOnAction(
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
							System.out.println(f.getName());
						}
					}else {
						System.out.println("Nothing was Selected!");
					}
				});
	}


	private Window getOwnerWindow(){
		Scene parentScene = this.getScene();
		if(parentScene != null) {
			return parentScene.getWindow();
		}

		return null;
	}
}