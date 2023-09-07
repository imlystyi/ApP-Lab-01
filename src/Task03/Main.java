/* Vladyslav Yakubovskyi,
 * Lviv Polytechnic National University, Institute of Computer Science and Information Technologies,
 * Department of Information Systems and Networks, "PI-21" Student group,
 * Discipline "Applied programming",
 * Laboratory work #01,
 * Task #03,
 * "Main.java" file */

package Task03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Welcome to the email validator.\n" +
                "Enter your email or \"q\" to exit from program.");
        while (true) {
            System.out.print("> ");
            final String email = reader.readLine().replaceAll(" ", "");
            if (email.equals("q"))
                break;

            System.out.println(validateEmail(email)
                    ? "Valid."
                    : "Invalid.");
        }
    }

    private static Boolean validateEmail(final String email) {
        if (email == null || email.isEmpty())
            return false;

        final String[] emailParts = email.split("@");
        if (emailParts.length != 2 || emailParts[0].isEmpty() || emailParts[1].isEmpty())
            return false;

        final String username = emailParts[0];

        final String[] service = emailParts[1].split("\\.");  // Use dot as regular literal!
        if (service.length != 2 || service[0].isEmpty() || service[1].isEmpty())
            return false;

        final String server = service[0];
        final String domain = service[1];

        final char[] usernameChars = username.toCharArray();
        final char[] serverChars = server.toCharArray();
        final char[] domainChars = domain.toCharArray();

        for (final char ch: usernameChars)
            if (!Character.isLetterOrDigit(ch) && ch != '.' && ch != '_' && ch != '-')
                return false;
        for (final char ch: serverChars)
            if (!Character.isLetterOrDigit(ch) && ch != '_')
                return false;
        for (final char ch: domainChars)
            if (!Character.isLetterOrDigit(ch))
                return false;

        return true;
    }
}
