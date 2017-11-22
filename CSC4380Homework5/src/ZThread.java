
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

enum Status {
    PENDING, SUCCESS, FAILURE;
}
public class ZThread extends Thread {
    private Status currStatus;
    private String msg;
    private URL website;
    private Path dest;
    
public ZThread(URL website, Path dest) {
    currStatus = Status.PENDING;
    msg = "";
    this.website = website;    
    this.dest = dest;
}
@Override 
public void run(){
    try(InputStream in = website.openStream()){
        synchronized(in){
            Files.copy(in,dest,StandardCopyOption.REPLACE_EXISTING);
        }
        currStatus = Status.SUCCESS;
        msg = "Success!";
        System.out.println(msg);
    }catch(Exception e){
        currStatus = Status.FAILURE;
        msg = e.getMessage();
    }
}
    public Status getStatus(){
        return currStatus;
    }
    
    public String getMsg(){
        return msg;
    }
}
