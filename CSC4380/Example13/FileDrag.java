import javafx.scene.layout.*;
import javafx.scene.paint.*;
import javafx.scene.shape.*;

import java.io.File;
import javafx.scene.input.*;

public class FileDrag extends Pane {
	public FileDrag() {
		Rectangle rect = new Rectangle();
		rect.relocate(50, 50);
		rect.setWidth(300.0);
		rect.setHeight(100.0);
		rect.setFill(Color.LIGHTGREEN);
		
		rect.setOnDragEntered(
				(DragEvent event) -> {
					if(event.getSource() != rect && event.getDragboard().hasFiles()) {
						rect.setFill(Color.DARKGREEN);
					}
					
					event.consume();
				}
			);
		
		rect.setOnDragExited(
				(DragEvent event) -> {
					rect.setFill(Color.LIGHTGREEN);
					event.consume();
				}
			);
		
		rect.setOnDragOver(
				(DragEvent event) -> {
					if(event.getDragboard().hasFiles()) {
						event.acceptTransferModes(TransferMode.COPY);
					}
					event.consume();
				}
			);
		
		rect.setOnDragDropped(
				(DragEvent event) ->{
					if(event.getDragboard().hasFiles()) {
						for(File f: event.getDragboard().getFiles()) {
							System.out.println(f.getPath());
						}
						event.setDropCompleted(true);
					}
					event.consume();
				}
			);
		
		this.getChildren().addAll(rect);
	}
}
