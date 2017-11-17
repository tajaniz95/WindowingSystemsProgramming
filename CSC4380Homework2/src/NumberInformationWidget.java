import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;


class NumberInformationWidget extends GridPane {
	public NumberInformationWidget() {
		
		TextArea area = new TextArea();
		add(area, 0, 1);
		area.setEditable(true);
		setHgrow(area, Priority.ALWAYS);
		setVgrow(area, Priority.ALWAYS);
		
		TextField field = new TextField();
		add(field, 0, 0);
		setHgrow(field, Priority.ALWAYS);
		field.setOnAction(
				event -> {
					try {
						Integer.parseInt(field.getText());
						field.appendText("field: " + field.getText() + "\n");
					}catch (NumberFormatException ex) {
						area.appendText(field.getText() + " is not a valid Number, enter a valid number \n");
					}
				}
		);
		field.setPromptText("Enter Text!");
		
		ComboBox<String> combo = new ComboBox<String>();
		combo.getItems().addAll("Even", "Prime");
		add(combo, 1, 0);
		
		combo.setOnMousePressed(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				combo.requestFocus();
			}
		});
		
		Button b = new Button("Run");
		add(b, 2, 0);
		b.setOnAction(
				event -> {
					if(combo.valueProperty().get() == "Even"){
                        int user = Integer.valueOf(field.getText());
                         if(user % 2 == 0 ){
                             area.appendText(field.getText() + " is an Even number. \n");
                        } else {
                             area.appendText(field.getText() + " is an Odd number. \n");
                        }
                     }                                                                                                                       
                     if(combo.valueProperty().get() == "Prime"){
                        int user = Integer.valueOf(field.getText());
                        boolean flag = false;
                        if(user <= 1){
                            area.appendText(field.getText() + " is not a Prime number \n");
                        } else {
                           for(int i = 2; i <= user/2; i++){
                               if(user % i == 0){
                                   flag = true;
                                   break;
                               }
                           }
                           if(!flag){
                               area.appendText(field.getText() + " is a Prime number. \n");
                           } else{
                               area.appendText(field.getText() + " is not a Prime number. \n");
                           }                          
                        }  
                     }
				}		
		);
		
		
		Region r = new Region();
		add(r, 1, 5);
		GridPane.setHgrow(r, Priority.ALWAYS);
		GridPane.setVgrow(r, Priority.ALWAYS);
		
	}
}