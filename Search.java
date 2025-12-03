package codereview;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Search {

    public static void main(String[] args) {
        if (args.length != 3) {
            System.out.println("Usage: search <pattern> <file>");
            return;
        }

        String command = args[0];
        String pattern = args[1];
        String filename = args[2];

        if (!command.equals("search")) {
            System.out.println("Invalid command: " + command);
            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            int lineNumber = 1;
            while ((line = reader.readLine()) != null) {
                if (line.contains(pattern)) {
                    System.out.println(lineNumber + ": " + line);
                }
                lineNumber++;
            }
        } catch (IOException e) {
            System.out.println("Error when reading file" + e.getMessage());
        }
    }
}