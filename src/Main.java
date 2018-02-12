import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String expression = reader.readLine();
        Validator validator = new Validator(expression);
        validator.validate();
        expression = validator.getFinalString();
        Transformation transformation = new Transformation(expression);
        transformation.transformate();
        Postfix postfix = new Postfix();
        postfix.evaluate(transformation.getList());
        PostfixCalculator postfixCalculator = new PostfixCalculator(postfix.getPostfixPool());
        System.out.println(postfixCalculator.calculate());
    }
}
