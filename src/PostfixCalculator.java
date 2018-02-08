import java.util.Stack;

public class PostfixCalculator {
    private Stack<String> postfixPool;
    private Stack<Double> calculatedPool = new Stack<>();

    public PostfixCalculator(Stack<String> postfixPool) {
        this.postfixPool = postfixPool;
    }

    public Double calculate() {
        double tempValue1;
        double tempValue2;
        String character;
        do {
            if (postfixPool.peek().matches("(0$|-?[1-9]\\d*(\\.\\d*[1-9]$)?|-?0\\.\\d*[1-9])")) {
                calculatedPool.push(Double.valueOf(postfixPool.pop()));
            } else {
                character = postfixPool.pop();
                tempValue2 = calculatedPool.pop();
                tempValue1 = calculatedPool.pop();
                switch (character) {
                    case "+":
                        calculatedPool.push(tempValue1 + tempValue2);
                        break;
                    case "-":
                        calculatedPool.push(tempValue1 - tempValue2);
                        break;
                    case "*":
                        calculatedPool.push(tempValue1 * tempValue2);
                        break;
                    case "/":
                        calculatedPool.push(tempValue1 / tempValue2);
                        break;
                    case "^":
                        calculatedPool.push(Math.pow(tempValue1,tempValue2));
                        break;

                }
            }
        } while (!postfixPool.empty());
        return calculatedPool.peek();
    }
}
