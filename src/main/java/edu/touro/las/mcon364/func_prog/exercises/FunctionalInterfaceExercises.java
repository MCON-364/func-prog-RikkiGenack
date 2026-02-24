package edu.touro.las.mcon364.func_prog.exercises;

import java.time.LocalDate;
import java.time.LocalDate.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * Functional Interface Practice
 *
 * In this assignment you will:
 *  - Create and return different functional interfaces
 *  - Apply them
 *  - Practice chaining where appropriate
 *
 * IMPORTANT:
 *  - Use lambdas
 *  - Do NOT use anonymous classes
 */
public class FunctionalInterfaceExercises {

    // =========================================================
    // PART 1 — SUPPLIERS
    // =========================================================

    /**
     * 1) Create a Supplier that returns the current year.
     * <p>
     * Hint:
     * You can get the current date using:
     * LocalDate.now()
     * <p>
     * Then extract the year using:
     * getYear()
     * <p>
     * Example (not the solution):
     *
     */
    public static Supplier<Integer> currentYearSupplier() {
        // TODO
        Supplier<Integer> integerSupplier = () -> LocalDate.now().getYear();
        return integerSupplier;
    }

    /**
     * 2) Create a Supplier that generates a random number
     * between 1 and 100.
     */
    public static Supplier<Integer> randomScoreSupplier() {
        // TODO
        return () -> ThreadLocalRandom.current().nextInt(1, 100);
    }

    // =========================================================
    // PART 2 — PREDICATES
    // =========================================================

    /**
     * 3) Create a Predicate that checks whether
     * a string is all uppercase.
     */
    public static Predicate<String> isAllUpperCase() {
        // TODO
        return string -> {
            //  if there's any letter that is not upper case
            if(string.chars().anyMatch(Character::isLetter)) {
                if (string.chars().anyMatch(Character::isLowerCase))
                    return false;
            }
            return true;

        };
    }

    /**
     * 4) Create a Predicate that checks whether
     * a number is positive AND divisible by 5.
     * <p>
     * Hint: consider chaining.
     */
    public static Predicate<Integer> positiveAndDivisibleByFive() {
        // TODO
        return integer -> integer % 5 == 0 && integer > 0;

    }

    // =========================================================
    // PART 3 — FUNCTIONS
    // =========================================================

    /**
     * 5) Create a Function that converts
     * a temperature in Celsius to Fahrenheit.
     * <p>
     * Formula: F = C * 9/5 + 32
     */
    public static Function<Double, Double> celsiusToFahrenheit() {
        // TODO
        return C -> C * 9 / 5 + 32;
    }

    /**
     * 6) Create a Function that takes a String
     * and returns the number of vowels in it.
     * <p>
     * Bonus: Make it case-insensitive.
     */
    public static Function<String, Integer> countVowels() {
        // TODO
        return string -> {
            int ctr = 0;

            for (int i = 0; i < string.length(); i++) {
                String curr = String.valueOf(string.charAt(i));
                if (curr.equalsIgnoreCase("a")|| curr.equalsIgnoreCase("e") || curr.equalsIgnoreCase("i") || curr.equalsIgnoreCase("o") || curr.equalsIgnoreCase("u")) {
                    ctr++;
                }
            }
            return ctr;
        };
    }

    // =========================================================
    // PART 4 — CONSUMERS
    // =========================================================

    /**
     * 7) Create a Consumer that prints a value
     * surrounded by "***"
     * <p>
     * Example output:
     * *** Hello ***
     */
    public static Consumer<String> starPrinter() {
        // TODO
        return string -> System.out.println("*** " + string + " ***");
    }

    /**
     * 8) Create a Consumer that prints the square
     * of an integer.
     */
    public static Consumer<Integer> printSquare() {
        // TODO
        return n -> System.out.println(n * n);
    }

    // =========================================================
    // PART 5 — APPLYING FUNCTIONAL INTERFACES
    // =========================================================

    /**
     * 9) Apply:
     * - A Predicate
     * - A Function
     * - A Consumer
     * <p>
     * Process the list as follows:
     * - Keep only strings longer than 3 characters
     * - Convert them to lowercase
     * - Print them
     */
    public static void processStrings(List<String> values) {
        // TODO
        List<String> updated = new ArrayList<>();
        //predicate
        Predicate<String> isLongerThan3 = s -> s.length() > 3;
        //function
        Function<String, String> lc = s -> s.toLowerCase();
        //consumer
        Consumer<String> printer = System.out::println;

        for (String value : values) {
            if (isLongerThan3.test(value)) {
                String lcValue = lc.apply(value);
                printer.accept(lcValue);
            }
        }
    }

    /**
     * 10) Apply:
     * - A Supplier
     * - A Predicate
     * - A Consumer
     * <p>
     * Generate 5 random scores.
     * Print only those above 70.
     */
    public static void generateAndFilterScores() {
        // TODO

        Supplier<Integer> randomScores = () -> ThreadLocalRandom.current().nextInt(1, 100);

        Predicate<Integer> above70 = n -> n > 70 && n<=100;

        Consumer<Integer> printer = System.out::println;


        for (int i = 0; i < 5; i++) {
            int r = randomScores.get();
            if (above70.test(r)) {
                printer.accept(r);
            }
        }

    }
}
