package features;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

public class SaveInTheFile {
    
    public static final String PATH_TO_PROPERTIES = new File(".").getAbsolutePath().replace(".", "\\AccountCreater\\resources\\config.properties");
    Properties prop = new Properties();
    
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
        
        FileInputStream fileInputStream;
        try {
            fileInputStream = new FileInputStream(PATH_TO_PROPERTIES);
            prop.load(fileInputStream);
            String config = prop.getProperty("path") + name + ".txt";
            fileInputStream.close();
            return config;
        } catch (IOException e) {
            System.out.println("Ошибка в программе: файл " + PATH_TO_PROPERTIES + " не обнаружено");
            e.printStackTrace();
        } return homeDir+"\\Desktop\\"+name+".txt";
    }
    
    public void setConfig (String config) throws IOException {
        FileOutputStream out;
        try {
            prop.setProperty("path", config);
            out = new FileOutputStream(PATH_TO_PROPERTIES);
            prop.store(out, null);
            out.close();
        } catch (FileNotFoundException fe){
            System.out.println("Ошибка в программе: файла " + PATH_TO_PROPERTIES + " не обнаружено");
            fe.printStackTrace();
        }
    }
}
