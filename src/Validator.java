
public class Validator {
    private final String nullSymbol = " ";
    private String testString;
    /*перетаскиваем по символу из искомой строки*/
    private StringBuffer finalBufferString = new StringBuffer();
    /*приведенная к виду искомая строка*/
    private String finalString;
    /*подсчет скобок*/
    private int flagBrackets = 0;
    CustomGenericException customGenericException;

    public Validator(String testString) {
        this.testString = " " + testString + " ";
    }

    /*попытка охватить все вводимые строки с примерами попутно проверяя валидность интересующей
     * нас сущности*/
    public void validate() {
        String prevTempSymbol = " ";
        String nextTempSymbol;
        try {
            for (int i = 0; i < testString.length(); i++) {
                nextTempSymbol = String.valueOf(testString.charAt(i));
                if (testString.charAt(i) == ' ') {
                    finalBufferString.append(nullSymbol);
                } else if (nextTempSymbol
                        .matches("(\\d|[-+*/^().,])")) { // проверяем символ равнозначность с регулярой
                    if (nextTempSymbol.matches("([+*/^])")) {
                        if (prevTempSymbol.matches("([+*/^])")) { // если друг за другом идут знаки вычисления
                            throw customGenericException = new CustomGenericException("Повторяющийся символ");
                        }
                        finalBufferString.append(nullSymbol).append(nextTempSymbol).append(nullSymbol);
                        prevTempSymbol = nextTempSymbol;
                    } else if (nextTempSymbol.equals("-")) {
                        if (String.valueOf(testString.charAt(i + 1)).matches("\\d")) {
                            finalBufferString.append(nextTempSymbol);
                            prevTempSymbol = nextTempSymbol;
                        } else {
                            if (prevTempSymbol.equals(nextTempSymbol)) {
                                throw customGenericException = new CustomGenericException("Повторяющийся символ");
                            }
                            finalBufferString.append(nullSymbol).append(nextTempSymbol).append(nullSymbol);
                            prevTempSymbol = nextTempSymbol;
                        }
                    } else if (nextTempSymbol.matches("\\d")) {
                        if ((nextTempSymbol.equals("0")) && (prevTempSymbol.equals("/"))){
                            throw customGenericException = new CustomGenericException("Деление на 0");
                        }else if ((prevTempSymbol.matches("(\\d|[-.,(]|\\s)")) && (finalBufferString.toString().charAt(finalBufferString.length() - 1) != ' ')) {
                            finalBufferString.append(nextTempSymbol);
                        } else if ((prevTempSymbol.matches("([+*/^(]||\\s)")) && (finalBufferString.toString().charAt(finalBufferString.length()-1) == ' ')) {
                            finalBufferString.append(nextTempSymbol);
                        } else {
                            throw customGenericException = new CustomGenericException("Невалидные данные");
                        }
                        prevTempSymbol = nextTempSymbol;
                    } else if (nextTempSymbol.matches("([()])")) {// проверка количества скобок
                        if (flagBrackets < 0) {
                            throw customGenericException = new CustomGenericException("Ошибка в скобках");
                        }
                        if (nextTempSymbol.equals("(")) {
                            flagBrackets++;
                        } else {
                            flagBrackets--;
                        }
                        finalBufferString.append(nullSymbol).append(nextTempSymbol).append(nullSymbol);
                        prevTempSymbol = nextTempSymbol;
                    }
                } else {
                    throw customGenericException = new CustomGenericException("Встречается неверный символ в строке");
                }
            }
            if (flagBrackets!=0){
                throw customGenericException = new CustomGenericException("Ошибка в скобках");
            }
        } catch (Exception ex){
            System.out.println(customGenericException.getErrMessage());
            System.exit(0);
        } finally{
            cleanString(finalBufferString.toString());
        }

    }

    private void cleanString(String tempString) {
        finalString = tempString.replaceAll("\\s+", " ").replaceAll(",", ".").trim();
    }


    public String getFinalString() {
        return finalString;
    }
}
