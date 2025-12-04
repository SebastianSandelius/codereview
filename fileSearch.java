package codereview;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileSearch {

    public static void main(String[] args) {
        //new changes from my pull request
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

            String lowerPattern = pattern.toLowerCase();
            
            while ((line = reader.readLine()) != null) {

                String lowerLine = line.toLowerCase();

                if (lowerLine.contains(lowerPattern)) {
                    System.out.println(line);
                }
            }
        } catch (IOException e) {  
            System.out.println("Error when reading file" + e.getMessage());
        }
    }
}