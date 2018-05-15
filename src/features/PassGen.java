package features;

public class PassGen {
    
    public String parse (int lengthPass, SymbolSet set) {
        
        char[] array = new char[lengthPass];
        String ss = GenSymbolSet.getSet(set);
        for (int i = 0; i < lengthPass; i++) {
            array[i] = ss.charAt(0 + (int) (Math.random() * ss.length()));
        }
        String tempPass = "";
        for (char s: array) {
            tempPass+=s;
        }   
        if (checkTempPass(array)) {
            return tempPass;
        }
        return parse(lengthPass, set);
    }
    
    private boolean checkTempPass (char[] tempArray) {
        
        boolean upperCase = false;
        boolean lowerCase = false;
        boolean number = false;
        
        for (int i = 0; i < tempArray.length; i++) {
            if (Character.isUpperCase(tempArray[i])) {
                upperCase = true;
                break;
            }
        }
        for (int i = 0; i < tempArray.length; i++) {
            if (Character.isLowerCase(tempArray[i])) {
                lowerCase = true;
                break;
            }
        }
        for (int i = 0; i < tempArray.length; i++) {
            if (isNumber((tempArray[i]+""))) {
                number = true;
                break;
            }
        }
        if (upperCase && lowerCase && number) {
            return true;
        } else return false;
    }
    
    private static boolean isNumber(String s) {
        
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
