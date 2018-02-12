import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String expression = "( 4 + 3 ) * 2           ^ -2   / 0            ";
        Transformation transformation = new Transformation(expression);
        transformation.transformate();
        Postfix postfix = new Postfix();
        postfix.evaluate(transformation.getList());
        PostfixCalculator postfixCalculator = new PostfixCalculator(postfix.getPostfixPool());
        System.out.println(postfix.getPostfixPool());
        System.out.println(postfixCalculator.calculate());
    }
}
