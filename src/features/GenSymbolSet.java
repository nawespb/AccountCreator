package features;

public class GenSymbolSet {

    public static final String SIMPLESET =
            "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    public static final String HARDSET = 
            "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()";
    
    public static final String getSet(SymbolSet set) {
        if (set == SymbolSet.SIMPLE) {
            return SIMPLESET;
        } else return HARDSET;
     }
}
