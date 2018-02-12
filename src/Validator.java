
public class Validator {
    private final String nullSymbol = " ";
    private String testString;
    /*перетаскиваем по значению из искомой строки*/
    private String finalString;
    /*подсчет скобок*/
    private int flagBrackets = 0;
    /*подсчет знаков вычисления*/
    private int flagSignCalculation = 0;
    /*подсчет чисел*/
    private int flagValue;

    public Validator(String testString) {
        this.testString = testString + " ";
    }

    /*попытка охватить все вводимые строки с примерами попутно проверяя валидность интересующей
     * нас сущности*/
    public boolean validate() {
        String prevTempSymbol = " ";
        String nextTempSymbol;
        try {
            for (int i = 0; i < testString.length(); i++) {
                nextTempSymbol = String.valueOf(testString.charAt(i));
                if (nextTempSymbol
                        .matches("(\\d|[-+*/^()])")) {
                    if (nextTempSymbol.matches("([+*/])")) {
                        if (prevTempSymbol.matches("([+*/])")) { // если друг за другом идут знаки вычисления
                            throw new CustomGenericException("Повторяющийся символ");
                        }
                        finalString += nextTempSymbol + nullSymbol;
                        prevTempSymbol = nextTempSymbol;
                    } else if (nextTempSymbol.equals("-")) {
                        if (String.valueOf(testString.charAt(i + 1)).matches("\\d")) {
                            finalString += nextTempSymbol;
                            prevTempSymbol = nullSymbol;
                        } else {
                            if (prevTempSymbol.equals(nextTempSymbol)){
                                throw new CustomGenericException("Повторяющийся символ");
                            }
                            finalString += nextTempSymbol + nullSymbol;
                            prevTempSymbol = nextTempSymbol;
                        }
                    } else if (nextTempSymbol.matches("\\d")) {
                        if ((prevTempSymbol.matches("\\d")) && (testString.charAt(i-1)!=' '))
                        finalString += nextTempSymbol + nullSymbol;
                    }
                }

                // }else if (!nextTempSymbol.equals(" ")) return false;
            }
        } catch (Exception ex) {
            return false;
        } finally {
            return true;
        }
    }

    private String cleanString(String tempString) {
        System.out.println(tempString);
        tempString = tempString.replaceAll("\\s+", " ").replaceAll(",", ".").trim();
        return tempString;
    }

    private String deleteDublicate() {
        for (int i = 0; i < 1; i++) {
            // if (testString.matches()
        }
        return null;
    }

    /*если попадается двойное использование знака
    2 / / 2
    кидаем исключение*/
    //private void checkNextValue()

    public String getFinalString() {
        return finalString;
    }
}
