import java.util.ArrayList;

public class Transformation {

    private String tempString;
    private ArrayList<String> list = new ArrayList<>();

    public Transformation(String tempString) {
        this.tempString = tempString;
    }

    public void transformate(){
        tempString = cleanString(tempString);
        transforming(tempString);
    }

    /*Добавление в массив всех символов*/
    private void transforming(String tempString){
        for (int i = 0,temp = 0; i < tempString.length(); i++) {
            if (tempString.charAt(i)==' '){
                list.add(tempString.substring(temp,i));
                temp=i+1;
            }if (i==tempString.length()-1){
                list.add(tempString.substring(temp,i+1));
            }
        }
        list.trimToSize();
    }

    /*Очищение входной строки от лишних пробелов
    * Замена ',' на '.' для дробных чисел*/
    private String cleanString(String tempString) {
        tempString = tempString.replaceAll("\\s+", " ").replaceAll(",+",".").trim();
        return tempString;
    }

    public  ArrayList<String> getList() {
        return list;
    }
}
