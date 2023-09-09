/* Vladyslav Yakubovskyi,
 * Lviv Polytechnic National University, Institute of Computer Science and Information Technologies,
 * Department of Information Systems and Networks, "PI-21" Student group,
 * Discipline "Applied programming",
 * Laboratory work #01,
 * Task #01,
 * "Main.java" file */

package Task01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Welcome to the calculator.\n" +
                "Enter your expression or \"q\" to exit from program.");
        while (true) {
            System.out.print("> ");

            final String input = reader.readLine().replaceAll(" ", "");

            if (input.equals("q"))
                break;

            try {
                System.out.println(Calculator.compute(input));
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
}
