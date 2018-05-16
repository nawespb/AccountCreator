package accountcreater;

import features.PassGen;
import static features.SymbolSet.*;
import features.Transliteration;

public class AccountCreater {

    public static void main(String[] args) {
        
        PassGen pass = new PassGen();
        for (int i=0; i<5; i++) {
            System.out.println(pass.parse(8, SIMPLE));
        }    
    
        Transliteration tr = new Transliteration();
        System.out.println(tr.translit("Иванов Иван Иванович"));

    }
}
