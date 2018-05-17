package features;

import java.util.ArrayList;
import java.util.HashMap;

public class Transliteration {

    public String translit (String text) {
        
        HashMap<String, String> map = getTranslitCollection();
        
        for (String s: map.keySet()) {
            text = text.replace(s, map.get(s));
        }
        
        return formatName(text);
    }
    
    private String formatName (String name) {
        
        String formattedName = "";
        ArrayList<String> list = new ArrayList<>();
        for (String word : name.trim().split(" ")) {
            if (word.isEmpty()) continue;
            list.add(word);
        }
        formattedName = list.get(0)+".";
        formattedName = formattedName.substring(0, 1).toUpperCase() + formattedName.substring(1, formattedName.length());
        list.remove(0);
        if (!list.isEmpty()) {
            for (int i = 0; i < list.size(); i++) {
                formattedName += ((list.get(i).charAt(0))+"").toUpperCase();
            }
        }    
        return formattedName;
    }
    
    private HashMap getTranslitCollection () {
        
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
        alphabet.put("ъ", "''");
        alphabet.put("ы", "y");
        alphabet.put("ь", "'");
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
        alphabet.put("Ъ", "''");
        alphabet.put("Ы", "Y");
        alphabet.put("Ь", "'");
        alphabet.put("Э", "E");
        alphabet.put("Ю", "YU");
        alphabet.put("Я", "YA");
        
        return alphabet;
    }
}
