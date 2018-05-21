package features;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

//Класс для сохранения полученного результата в файл
public class SaveInTheFile {
    
    //Строка, содержащая путь к файлу с конфигурацией
    public static final String PATH_TO_PROPERTIES = new File(".").getAbsolutePath().replace(".", "\\AccountCreater\\resources\\config.properties");
    //Переменная, содержащая домашнюю директорию пользователя
    public static final String HOMEDIR = System.getProperty("user.home");
    //Переменная, содержащая путь для сохранения по-умолчанию
    public static final String DEFAULT_PATH = HOMEDIR+"\\Desktop\\";
    
    Properties prop = new Properties();
    
    //Метод для сохранения результата работы программы в файл
    public void saver (String text, String name) {
        
        //Создание файла с определенным именем и последующаяя запись результатов в файл
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
    
    //Метод для получения "пути для сохранения" из файла конфигурации
    private String getConf (String name) {
        
        //Чтение настроек из файла конфигурации
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
        }   
        
        //Если конфигурационный файл пустой или отсутствует, возвращаются настройки по-умолчанию
        return DEFAULT_PATH+name+".txt";
    }
    
    //Метод, мозволяющий изменить кофигурационный файл
    public void setConfig (String config) throws IOException {
        
        //Вненсение изменений в конфигурационный файл
        FileOutputStream out;
        try {
            prop.setProperty("path", config);
            out = new FileOutputStream(PATH_TO_PROPERTIES);
            prop.store(out, null);
            out.close();
        } catch (FileNotFoundException fe){
            System.out.println("Ошибка в программе: файл " + PATH_TO_PROPERTIES + " не обнаружено");
            fe.printStackTrace();
        }
    }
}
