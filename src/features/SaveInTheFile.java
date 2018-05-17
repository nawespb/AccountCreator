package features;

import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

public class SaveInTheFile {
    
    public static final String PATH_TO_PROPERTIES = "src/resources/config.properties";
    
    public void saver (String text, String name) {
        
        try(FileWriter writer = new FileWriter(getConf(name), false))
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
    
    private String getConf (String name) {
        String homeDir = System.getProperty("user.home");
        Properties prop = new Properties();
        FileInputStream fileInputStream;
        try {
            fileInputStream = new FileInputStream(PATH_TO_PROPERTIES);
            prop.load(fileInputStream);
            return prop.getProperty("path") + name + ".txt";
        } catch (IOException e) {
            System.out.println("Ошибка в программе: файл " + PATH_TO_PROPERTIES + " не обнаружено");
            e.printStackTrace();
        } return homeDir+"\\Desktop\\"+name+".txt";
    }
}
