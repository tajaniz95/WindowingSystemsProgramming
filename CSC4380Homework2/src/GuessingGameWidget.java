import javafx.scene.layout.GridPane;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;

class GuessingGameWidget extends GridPane{
	int Countplus = 0; //Countplus is the correct guess
	int Countminus = 0; //Countminus is the incorrect guess
	public GuessingGameWidget(){
		Region r = new Region();
		add(r, 1, 5);
		GridPane.setHgrow(r, Priority.ALWAYS);
		GridPane.setVgrow(r, Priority.ALWAYS);
		
		TextArea area = new TextArea();
		add(area, 3, 1);
		area.setPrefSize(300,100); 
		area.setEditable(false);
		
		ToggleGroup tga = new ToggleGroup();
		
		RadioButton A = new RadioButton("A");
		add(A, 0, 0);
		A.setToggleGroup(tga);
		
		RadioButton B = new RadioButton("B");
		add(B, 0, 1);
		B.setToggleGroup(tga);
		
		RadioButton C = new RadioButton("C");
		add(C, 1, 0);
		C.setToggleGroup(tga);
		
		RadioButton D = new RadioButton("D");
		add(D, 1, 1);
		D.setToggleGroup(tga);
		
		Button b = new Button("Guess");
		add(b, 3, 0);
		b.setOnAction(
			event -> {
				double Guess = Math.random() * 0.5;
				System.out.println(Guess);
				String newText = "\n";
				if (Guess <= 0.25) {
					Countplus++;
					area.appendText("Your guess is Correct!" + newText);
					area.appendText("Countplus = " + Countplus + "Countminus =" + Countminus + newText);
				}else {
					Countminus++;
                    area.appendText("Your guess is Incorrect!" + newText);  
                    area.appendText("Countplus = " + Countplus + " Countminus = " + Countminus + newText); 
				}
			}
		);
	}
}