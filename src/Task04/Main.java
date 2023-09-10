/* Vladyslav Yakubovskyi,
 * Lviv Polytechnic National University, Institute of Computer Science and Information Technologies,
 * Department of Information Systems and Networks, "PI-21" Student group,
 * Discipline "Applied programming",
 * Laboratory work #01,
 * Task #04,
 * "Main.java" file */

package Task04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Double[]> firstContainer;
        List<Double[]> secondContainer;

        Matrix firstMatrix;
        Matrix secondMatrix;

        System.out.println("Welcome to the matrix multiplication calculator.");

        while (true) {
            try {
                System.out.println("Enter first matrix:\n");
                firstContainer = getContainer(reader);
                firstMatrix = new Matrix(firstContainer);

                while (true) {
                    try {
                        System.out.println("Enter second matrix:\n");
                        secondContainer = getContainer(reader);
                        secondMatrix = new Matrix(secondContainer);

                        try {
                            final Matrix product = firstMatrix.multiply(secondMatrix);
                            System.out.print(product.toString() + "\n");
                            break;
                        } catch (IllegalArgumentException ex) {
                            System.out.println(ex.getMessage() + "\n");
                        }
                    } catch (IllegalArgumentException ex) {
                        System.out.println(ex.getMessage() + "\n");
                    }
                }
                break;
            } catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage() + "\n");
            }
        }
    }

    private static List<Double[]> getContainer(final BufferedReader reader) throws IOException {
        String input;
        String[] splitInput;

        Double[] row;
        final List<Double[]> container = new ArrayList<>();

        while (true) {
            input = reader.readLine();
            if (input.isEmpty()) {
                if (container.isEmpty()) {
                    throw new IllegalArgumentException("The matrix must contain at least one row.");
                } else {
                    return container;
                }
            }

            splitInput = input.split(" ");

            try {
                // Maps each string to double and converts to array.
                row = Arrays.stream(splitInput).map(Double::valueOf).toArray(Double[]::new);

                container.add(row);
            } catch (NumberFormatException ex) {
                System.out.print("Incorrect elements in row.");
            }
        }
    }
}
