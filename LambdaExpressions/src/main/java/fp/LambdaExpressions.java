package fp;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.*;

public class LambdaExpressions {
    /**
     * Return a binary operator that computes the sum of two Integer objects.
     */
    public static Object sumOfIntegers() {
        BinaryOperator<Integer> f = (a,b) -> a+b;
        return f;
    }

    /**
     * Return a predicate that tests whether a String is empty.
     */
    public static Object isEmptyString() {
        Predicate<String> f = s -> s.length() == 0;
        return f;
    }

    /**
     * Return a predicate that tests whether an Integer is an odd number.
     */
    public static Object isOddNumber() {
        Predicate<Integer> f = x -> x%2 == 1;
        return f;
    }

    /**
     * Return a function that computes the mean of a List of Double objects.
     * If the list is empty, an IllegalArgumentException must be thrown.
     */
    public static Object computeMeanOfListOfDoubles() {
        Function<List<Double>, Double> f = x -> {
            if (x.isEmpty()) throw new IllegalArgumentException();
            else {
                double sum = 0;
                for(double d: x){
                    sum += d;
                }
                return sum/x.size();
            }
        };
        return f;
    }

    /**
     * Remove the even numbers from a list of Integer objects.
     */
    public static void removeEvenNumbers(List<Integer> lst) {
        lst.removeIf(x -> x%2 == 0);
    }

    /**
     * Return a function that computes the factorial of an Integer.
     * If the number is zero, the factorial equals 1 by convention.
     * If the number is negative, an IllegalArgumentException must be thrown.
     */
    public static Object computeFactorial() {
        // TODO
        UnaryOperator<Integer> f = x -> {
            if(x < 0) throw new IllegalArgumentException();
            else {
                int y = 1;
                for (int i = 1; i<=x; i++){
                    y *= i;
                }
                return y;
            }
        };
        return f;
    }

    /**
     * Return a function that converts a list of String objects to lower case.
     */
    public static Object listOfStringsToLowerCase() {
        // TODO
        UnaryOperator<List<String>> f = x ->{
            List<String> y = new ArrayList<>();
            for (String s:x){
                y.add(s.toLowerCase());
            }
            return y;
        };
        return f;
    }

    /**
     * Return a function that concatenates two String objects.
     */
    public static Object concatenateStrings() {
        BinaryOperator<String> f = (a,b) -> a+b;
        return f;
    }

    public static class MinMaxResult {
        private int minValue;
        private int maxValue;

        MinMaxResult(int minValue,
                     int maxValue) {
            this.minValue = minValue;
            this.maxValue = maxValue;
        }

        int getMinValue() {
            return minValue;
        }

        int getMaxValue() {
            return maxValue;
        }
    }

    /**
     * Return a function that computes the minimum and maximum values in a list.
     * The content of the Optional must be present if and only if the list is non-empty.
     */
    public static Function<List<Integer>, Optional<MinMaxResult>> computeMinMax() {
        return l -> {
            if(l.isEmpty()) return Optional.empty();
            else{
                int min = l.get(0);
                int max = l.get(0);
                for(int i:l){
                    min = Math.min(min, i);
                    max = Math.max(max, i);
                }
                return Optional.of(new MinMaxResult(min, max));
            }
        };
    }

    /**
     * Return a function that, given a String object and a character, counts
     * the number of occurrences of the character inside the string.
     */
    public static Object countInstancesOfLetter() {
        BiFunction<String, Character, Integer> f = (s,c) -> {
            int count = 0;
            for(int i=0; i<s.length(); i++){
                if(s.charAt(i) == c) count++;
            }
            return count;
        };
        return f;
    }
}
