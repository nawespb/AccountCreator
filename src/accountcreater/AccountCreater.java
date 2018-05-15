package accountcreater;

import features.PassGen;
import static features.SymbolSet.*;

public class AccountCreater {

    public static void main(String[] args) {
        
        PassGen pass = new PassGen();
        for (int i=0; i<100; i++) {
            System.out.println(pass.parse(8, HARD));
        }    
    }
}
