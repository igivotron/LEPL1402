package oop;

/**
 * This class can be used to build simple arithmetic expression
 * with binary operator +,-,* and involving one variable 'x'.
 *
 * The expression can be
 * 1) evaluated by replacing the variable x with a specific value
 * 2) derivated to obtain a new expression
 *
 * You must modify this class to make it work
 * You can/should extend this class with inner classes the way you want.
 * You can also modify it but you are not allowed to modify the signature
 * of existing methods
 *
 * As a reminder, the formulas for the derivations as are followed
 *  - (f + g)' = f' + g'
 *  - (f*g)' = f'g + fg'
 *  - (x)' = 1
 *  - (C)' = 0 with C a constant
 */
public abstract class Expression {

    /**
     * Creates the basic variable expression 'x'
     * @return the expression 'x'
     */
    public static Expression x() {
         return X.INSTANCE;
    }

    /**
     * Creates the basic constant expression 'v'
     * @return the expression 'v'
     */
    public static Expression value(double v) {
         return new Value(v);
    }

    /**
     * Creates the binary expression 'this + r'
     * @param r the right operator
     * @return the binary expression 'this + r'
     */
    public Expression plus(Expression r) {
         return new BinaryExpression('+', this,r);
    }

    /**
     * Creates the binary expression 'this - r'
     * @param r the right operator
     * @return the binary expression 'this - r'
     */
    public Expression minus(Expression r) {
         return new BinaryExpression('-', this,r);
    }

    /**
     * Creates the binary expression 'this * r'
     * @param r the right operator
     * @return the binary expression 'this * r'
     */
    public Expression mul(Expression r) {
         return new BinaryExpression('*', this,r);
    }

    /**
     * Evaluate the expression with fixed value for x
     * @param xValue the value taken by x for the evaluation
     * @return the evaluation of the expression considering x=xValue
     */
    public abstract double evaluate(double xValue);

    /**
     * Derivate the expression wrt to 'x'
     * @return the derivative of the expression with respect to 'x'
     */
    public abstract Expression derivate();

    private static class X extends Expression{
        private static final X INSTANCE = new X();
        private X(){}

        @Override
        public double evaluate(double xValue) {
            return xValue;
        }

        @Override
        public Expression derivate() {
            return value(1);
        }
    }

    private static class BinaryExpression extends Expression{
        private final Expression left;
        private final Expression right;
        private final char operator;

        private BinaryExpression(char operator, Expression left, Expression right){
            this.operator = operator;
            this.left = left;
            this.right = right;
        }

        @Override
        public double evaluate(double xValue) {
            double leftRes = left.evaluate(xValue);
            double rightRes = right.evaluate(xValue);
            if(operator == '+') return leftRes + rightRes;
            else if (operator == '-') return leftRes - rightRes;
            else if (operator == '*') return leftRes * rightRes;
            throw new IllegalArgumentException();
        }

        @Override
        public Expression derivate() {
            Expression leftPrime = left.derivate();
            Expression rightPrime = right.derivate();
            if(operator == '+') return leftPrime.plus(rightPrime);
            else if (operator == '-') return leftPrime.minus(rightPrime);
            else if (operator == '*') return leftPrime.mul(right).plus(left.mul(rightPrime));
            throw new IllegalArgumentException();
        }
    }

    private static class Value extends Expression{
        private final double value;

        private Value(double value){
            this.value = value;
        }
        @Override
        public double evaluate(double xValue) {
            return value;
        }

        @Override
        public Expression derivate() {
            return value(0);
        }
    }



}
