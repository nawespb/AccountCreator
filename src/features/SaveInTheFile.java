package features;

import java.io.FileWriter;
import java.io.IOException;

public class SaveInTheFile {
    
    public void saver (String text) {
        
        try(FileWriter writer = new FileWriter(System.getProperty("user.home")+"\\Desktop\\1.txt", true))
        {
            writer.write(text);
            writer.write(System.lineSeparator());
            writer.write(System.lineSeparator());
            writer.flush();
        }
        catch(IOException ex){
             
            System.out.println(ex.getMessage());
        }
        
    }
}
