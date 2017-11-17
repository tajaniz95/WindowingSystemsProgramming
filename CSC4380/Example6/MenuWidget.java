import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.control.Button;
import javafx.scene.control.MenuBar;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;

class MenuWidget extends VBox{
	public MenuWidget() {
		MenuBar bar = new MenuBar();
		
		Menu menu = new Menu("File");
		
		MenuItem openItem = new MenuItem("Open");
		
		openItem.setOnAction(
				event -> {
					System.out.println("Open Clicked");
				});
		
		MenuItem saveItem = new MenuItem("Save");
		
		saveItem.setOnAction(
				event -> {
					System.out.print("Save Clicked!");
		});
		
		SeparatorMenuItem sep = new SeparatorMenuItem();
		
		Menu recents = new Menu("Recent Items");
		
		MenuItem liesItem = new MenuItem("Lies");
		
		liesItem.setOnAction(
				event -> {
					System.out.println("Lies Clicked");
				});
		
		MenuItem secretsItem = new MenuItem("Secrets");
		
		secretsItem.setOnAction(
				event -> {
					System.out.println("Secrets Clicked");
				});
		
		recents.getItems().addAll(liesItem, secretsItem);
		
		menu.getItems().addAll(openItem, saveItem, sep, recents);
		
		bar.getMenus().addAll(menu);
		
		this.getChildren().addAll(bar);
		
		GridPane pane = new GridPane();
		this.getChildren().add(pane);
		VBox.setVgrow(pane, Priority.ALWAYS);
		
		pane.setStyle("-fx-grid-lines-visible: true; -fx-stroke: black;");
		
		Button b = new Button("I am a Button");
		pane.add(b, 0, 0);
		
		b.setOnAction(
				event -> {
					System.out.println(" Button Clicked ");
				});
		
	}
}
