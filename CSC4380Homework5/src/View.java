
import java.util.Vector;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import static javafx.scene.layout.GridPane.setHgrow;
import static javafx.scene.layout.GridPane.setVgrow;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.stage.Window;

public class View extends GridPane {
     private TextField z; 
     private TextField t;
     private Button aButton;
     private Button bButton;
     public Vector<HandlerOne> handOne = new Vector<HandlerOne>();
     public Vector<HandlerTwo> handTwo = new Vector<HandlerTwo>();        
     
     
      public void addHandler(HandlerOne h1){
        handOne.add(h1);
    }
    public void addHandler1(HandlerTwo h2){
        handTwo.add(h2);
    }
    
    public View(){                   
        Region r = new Region();
	add(r, 1, 5);
	setHgrow(r, Priority.ALWAYS);
	setVgrow(r, Priority.ALWAYS);
        
        z = new TextField();
        add(z,0,0);
        z.setPromptText("URL to download");
 
        t = new TextField();
        add(t,0,1);
        t.setPromptText("File to write to");
        
        aButton = new Button("Select File");
        add(aButton,1,0);
        
         bButton = new Button("Start Download");
        add(bButton,1,1);
    
    
    aButton.setOnAction(
       (event) -> {           
           for(HandlerOne h1 : handOne ){
               h1.handle();
           }
       }
    
    );
    
    bButton.setOnAction(
      (event) -> {
         String url = z.getText();
         String path = t.getText(); 
         for(HandlerTwo h2 : handTwo) {
             h2.handle(url, path);
         }
      }
    );
    
    }
    
    public void setPath(String str){
        t.setText(str);
    }
    
    Window getOwnerWindow(){
        Scene parentScene = this.getScene();
        if(parentScene != null){
           return parentScene.getWindow();
        }
        
       return null; 
    } 
    
    public void showAlert(AlertType at, String text){
        Alert a = new Alert(at, text);
        a.showAndWait();
    }
       
}
