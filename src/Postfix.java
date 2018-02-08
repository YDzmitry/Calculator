import java.util.*;

public class Postfix {

    private final static Map<String, Integer> mapPriorityOperation = new HashMap<>();
    private LinkedList<String> tempPool = new LinkedList<>(); //стек для хранения операторов
    private Stack<String> postfixPool = new Stack<>(); // стек для хранения цифр и операторов в порядке поступления
    private String tempValue;

    static {
        mapPriorityOperation.put("(", 1);
        mapPriorityOperation.put(")", 1);
        mapPriorityOperation.put("-", 2);
        mapPriorityOperation.put("+", 2);
        mapPriorityOperation.put("*", 3);
        mapPriorityOperation.put("/", 3);
        mapPriorityOperation.put("^", 4);
    }

    public Stack<String> evaluate(ArrayList<String> list) {
        for (int i = 0; i < list.size(); i++) {
            tempValue = list.get(i);
            if (tempValue.matches("(0$|-?[1-9]\\d*(\\.\\d*[1-9]$)?|-?0\\.\\d*[1-9])")) {
                postfixPool.add(tempValue);
            } else {
                if (tempPool.isEmpty()) {
                    tempPool.add(tempValue);
                } else {
                    if (tempValue.equals("(") || tempPool.getLast().equals("(")) {
                        tempPool.add(tempValue);
                    } else if (tempValue.equals(")")) {
                        cleanPool();
                    } else if (priority(tempPool.getLast()) < priority(tempValue)) {
                        tempPool.add(tempValue);
                    } else if (priority(tempPool.getLast()) >= priority(tempValue)) {
                        cleanPool();
                        tempPool.add(tempValue);
                    }
                }
            }
        }
        tempValue = null;
        cleanPool();
        Collections.reverse(postfixPool);
        return postfixPool;
    }


    private void cleanPool() {
        for (int j = tempPool.size() - 1; j >= 0; j--) {
            if (tempValue != null) {
                if ((tempPool.get(j).equals("(")) && (tempValue.equals(")"))) {
                    tempPool.remove(j);
                    break;
                }
                if (priority(tempValue) > priority(tempPool.get(j))) {
                    break;
                }
            }
            postfixPool.add(tempPool.get(j));
            tempPool.remove(j);
        }
    }

    private int priority(String op) {
        return mapPriorityOperation.get(op);
    }

    public Stack<String> getPostfixPool() {
        return postfixPool;
    }
}
