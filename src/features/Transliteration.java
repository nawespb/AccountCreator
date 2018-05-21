package features;

import java.util.ArrayList;
import java.util.HashMap;

//Класс для транслитерации строки и вывода в форматированном виде
public class Transliteration {
    
    //Метод, возвращающий строку после транслитерации и форматирования
    public String translit (String text) {
        
        if (!text.trim().isEmpty()) {
            
            HashMap<String, String> map = getTranslitCollection();
            //Замена символов по установленным правилам транслитерации
            for (String s: map.keySet()) {
                text = text.replace(s, map.get(s));
            }

            //Форматирование полученного результата
            return formatName(text);
        } return "";    
    }
    
    //Метод для форматирования текста, возвращает форматированную строку
    private String formatName (String name) {
        
        String formattedName = "";
        ArrayList<String> list = new ArrayList<>();
        
        //Разделение строки на фрагменты по разделителю "пробел" и последующее добавление их в коллекцию
        for (String word : name.trim().split(" ")) {
            if (word.isEmpty()) continue;
            list.add(word);
        }
        //Выделение первого фрагмента (слова)
        formattedName = list.get(0)+".";
        //Перевод первой буквы в верхний регистр и последующих в нижний
        formattedName = formattedName.substring(0, 1).toUpperCase() + formattedName.substring(1, formattedName.length()).toLowerCase();
        //Удаление первого фрагмента из коллекции
        list.remove(0);
        //Добавление первых символов последующих фрагментов с переводом их в верхний регистр
        if (!list.isEmpty()) {
            for (int i = 0; i < list.size(); i++) {
                formattedName += ((list.get(i).charAt(0))+"").toUpperCase();
            }
        }    
        return formattedName;
    }
    
    //Метод, возвращающий коллекцию с сопоставлением символов для транслитерации
    private HashMap getTranslitCollection () {
        
        //Коллекция с сопоставлением символов для транслитерации
        HashMap<String, String> alphabet = new HashMap<>();
        
        alphabet.put("а", "a");
        alphabet.put("б", "b");
        alphabet.put("в", "v");
        alphabet.put("г", "g");
        alphabet.put("д", "d");
        alphabet.put("е", "e");
        alphabet.put("ё", "jo");
        alphabet.put("ж", "zh");
        alphabet.put("з", "z");
        alphabet.put("и", "i");
        alphabet.put("й", "j");
        alphabet.put("к", "k");
        alphabet.put("л", "l");
        alphabet.put("м", "m");
        alphabet.put("н", "n");
        alphabet.put("о", "o");
        alphabet.put("п", "p");
        alphabet.put("р", "r");
        alphabet.put("с", "s");
        alphabet.put("т", "t");
        alphabet.put("у", "u");
        alphabet.put("ф", "f");
        alphabet.put("х", "kh");
        alphabet.put("ц", "ts");
        alphabet.put("ч", "ch");
        alphabet.put("ш", "sh");
        alphabet.put("щ", "sch");
        alphabet.put("ъ", "");
        alphabet.put("ы", "y");
        alphabet.put("ь", "");
        alphabet.put("э", "e");
        alphabet.put("ю", "yu");
        alphabet.put("я", "ya");
        alphabet.put("А", "A");
        alphabet.put("Б", "B");
        alphabet.put("В", "V");
        alphabet.put("Г", "G");
        alphabet.put("Д", "D");
        alphabet.put("Е", "E");
        alphabet.put("Ё", "JO");
        alphabet.put("Ж", "ZH");
        alphabet.put("З", "Z");
        alphabet.put("И", "I");
        alphabet.put("Й", "J");
        alphabet.put("К", "K");
        alphabet.put("Л", "L");
        alphabet.put("М", "M");
        alphabet.put("Н", "N");
        alphabet.put("О", "O");
        alphabet.put("П", "P");
        alphabet.put("Р", "R");
        alphabet.put("С", "S");
        alphabet.put("Т", "T");
        alphabet.put("У", "U");
        alphabet.put("Ф", "F");
        alphabet.put("Х", "KH");
        alphabet.put("Ц", "TS");
        alphabet.put("Ч", "CH");
        alphabet.put("Ш", "SH");
        alphabet.put("Щ", "SCH");
        alphabet.put("Ъ", "");
        alphabet.put("Ы", "Y");
        alphabet.put("Ь", "");
        alphabet.put("Э", "E");
        alphabet.put("Ю", "YU");
        alphabet.put("Я", "YA");
        
        return alphabet;
    }
}
