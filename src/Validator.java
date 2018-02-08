
public class Validator {
    private String testString;

    public Validator(String testString) {
        this.testString = testString;
    }

    public boolean validate(){
        testString = cleanString(testString);
        if (!testString.matches("(0$|-?[1-9]\\d*(\\.\\d*[1-9]$)?|-?0\\.\\d*[1-9]|[-+*/^])")){
            return false;
        }
        return true;
    }

    private String cleanString(String tempString) {
        System.out.println(tempString);
        tempString = tempString.replaceAll("\\s+", " ").replaceAll(",",".").trim();
        return tempString;
    }

    private String deleteDublicate(){
        for (int i = 0; i < 1; i++) {
           // if (testString.matches()
        }
        return null;
    }

    public String getTestString() {
        return testString;
    }
}
