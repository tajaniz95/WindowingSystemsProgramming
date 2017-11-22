

import javafx.scene.control.Alert.AlertType;

public class Controller {
    
     public Controller(View view){
         
         Model model = new Model();
         
         view.addHandler1(
            (String s1, String s2) -> {
                if(s1 != "" || s2 != ""){
                    model.Download(s1,s2);
                } else {
                    view.showAlert(AlertType.ERROR, "Fill the both fields");
                }
            }
         );
         
         view.addHandler (
              () -> {
                String path = model.selectFile(view.getOwnerWindow());  
                if(path != null){
                    view.setPath(path);
                }
              }
         );
         model.addhandler1(
            (String s1, String s2) -> {
                view.showAlert(AlertType.ERROR, "Exceptions: " + s1);
                System.out.println(s2);
            }
         );
         model.addHandler(
                 () -> {
                     view.showAlert(AlertType.INFORMATION, "Successfully downloaded" );
                 }
         );
     }
}
