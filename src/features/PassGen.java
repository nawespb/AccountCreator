package features;

//Класс для генерации пароля по заданной сложности и количеству необходимых символов
public class PassGen {
    
    //Метод, возвращающий строку с генерированным паролем
    public String genPassword (int lengthPass, SymbolSet set) {
        
        char[] array = new char[lengthPass];
        //Получение списка символов для пароля
        String ss = GenSymbolSet.getSet(set);
        //Случайная выборка символов из множества и добавление их в массив
        for (int i = 0; i < lengthPass; i++) {
            array[i] = ss.charAt(0 + (int) (Math.random() * ss.length()));
        }
        String tempPass = "";
        //Вывод массива символов в строку
        for (char s: array) {
            tempPass+=s;
        }
        //Проверка, сгенерированного пароля на соответствие минимальным требованиям
        if (checkTempPass(array)) {
            return tempPass;
        }
        return genPassword(lengthPass, set);
    }
    
    //Метод, проверяющий пароль на соответствие минимальным требованиям
    private boolean checkTempPass (char[] tempArray) {
        
        boolean upperCase = false;
        boolean lowerCase = false;
        boolean number = false;
        
        //Проверка на содержание в пароле символа в верхнем регистре
        for (int i = 0; i < tempArray.length; i++) {
            if (Character.isUpperCase(tempArray[i])) {
                upperCase = true;
                break;
            }
        }
        
        //Проверка на содержание в пароле символа в нижнем регистре
        for (int i = 0; i < tempArray.length; i++) {
            if (Character.isLowerCase(tempArray[i])) {
                lowerCase = true;
                break;
            }
        }
        
        //Проверка на содержание в пароле числа
        for (int i = 0; i < tempArray.length; i++) {
            if (isNumber((tempArray[i]+""))) {
                number = true;
                break;
            }
        }
        
        //Итоговая проверка на комплексное соответствие
        if (upperCase && lowerCase && number) {
            return true;
        } else return false;
    }
    
    //Метод, проверяющий, что строку возможно привести к числу
    private static boolean isNumber(String s) {
        
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
