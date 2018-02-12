public class Main {
    public static void main(String[] args) {
        String expression = "(17 ^ 4 + 5 * 974 ^ 33 + 2.24 * 4.75)^0";
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
