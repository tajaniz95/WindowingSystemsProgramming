
import java.io.File;
import java.net.URL;
import java.nio.file.CopyOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Vector;
import javafx.stage.FileChooser;
import javafx.stage.Window;

public class Model {
    public Vector<HandlerOne> handOne = new Vector<HandlerOne>();
    public Vector<HandlerTwo> handTwo = new Vector<HandlerTwo>();
    private static final CopyOption standardCopyOption = null; 
   // TheView view = new TheView();
   
    
    public void addHandler(HandlerOne h1){
        handOne.add(h1);
    }
    public void addhandler1(HandlerTwo h2){
        handTwo.add(h2);
    }
  
    public Model(){
        
    }
    
    public void Download (String url, String path){
        try{
            URL website = new URL(url);
            Path dest = Paths.get(path);
            downloading(website, dest);       
        } catch(Exception e){           
            fail(e.getMessage(),e.getStackTrace().toString());
        }
    } 

    private void downloading(URL website, Path dest) {
        ZThread thread = new ZThread(website, dest);
        try {
            thread.start();
        } catch(Exception e) {
            String msg = e.getMessage();            
            fail(msg, e.getStackTrace().toString());
        }
        Status threadStatus = thread.getStatus();
        if(threadStatus == Status.SUCCESS){
            success();
        } else if(threadStatus == Status.FAILURE){            
             fail(thread.getMsg(), null);
        }
    }
    
    public String selectFile(Window ownerWindow){
        FileChooser selecter = new FileChooser();
        selecter.setTitle("Select a file");
        File file = selecter.showSaveDialog(ownerWindow);
        if(file != null){
            return file.getAbsolutePath();
        }
        return null; 
    }
    private void success(){
        for(HandlerOne h1 : handOne){
            h1.handle();
        }
    }
    
    private void fail(String msg, String stacktrace){
        for(HandlerTwo h2 : handTwo){
            h2.handle(msg, stacktrace);
        }
    }
}
