/* Vladyslav Yakubovskyi,
 * Lviv Polytechnic National University, Institute of Computer Science and Information Technologies,
 * Department of Information Systems and Networks, "PI-21" Student group,
 * Discipline "Applied programming",
 * Laboratory work #01,
 * Task #02,
 * "Main.java" file */

package Task02;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Enter lines separated by spaces.\n> ");
        final String input = reader.readLine();
        final String[] strings = input.split(" ");

        // Insertion sort.
        int key;
        String tempString;
        for (int ii = 0; ii < strings.length; ii++) {
            tempString = strings[ii];
            key = ii - 1;

            while (key >= 0 && strings[key].compareTo(tempString) > 0) {
                strings[key + 1] = strings[key];
                key = key - 1;
            }

            strings[key + 1] = tempString;
        }

        System.out.println("Sorted: ");
        for (final String ss : strings) {
            System.out.print(ss + " ");
        }
    }
}
