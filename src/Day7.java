import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.OptionalLong;
import java.util.Scanner;

public class Day7 {

    public static void main(String[] args) {
        solution();
    }

    public static void solution() {
        long startTime = System.currentTimeMillis();
        Map<String, Long> dirs = new HashMap<>();

        try (Scanner scanner = new Scanner(Paths.get("day7.txt"))) {
            StringBuilder path = new StringBuilder();
            while (scanner.hasNextLine()) {
                String command = scanner.nextLine();

                if (command.contains("$ cd ..")) path = new StringBuilder(path.substring(0, path.lastIndexOf("/")));
                else if (command.contains("$ cd")) path.append("/").append(command.replace("$ cd ", ""));
                else if (Character.isDigit(command.charAt(0))) {
                    Long fileSize = Long.parseLong(command.split(" ")[0]);

                    String callbackPath = path.toString();
                    while (callbackPath.length() > 1) {
                        dirs.merge(callbackPath, fileSize, Long::sum);
                        callbackPath = callbackPath.substring(0, callbackPath.lastIndexOf("/"));
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        long sum = dirs.values().stream()
                .mapToLong(Long::longValue)
                .filter(x -> x <= 100000)
                .sum();

        long spaceRequired = 30000000 - (70000000 - dirs.get("//"));
        OptionalLong sizeOfTargetDir = dirs.values().stream()
                .mapToLong(Long::longValue)
                .filter(x -> x > spaceRequired)
                .min();

        long endTime = System.currentTimeMillis();
        long totalTime = endTime - startTime;

        System.out.println("Antwoord 1: " + sum);
        System.out.println("Antwoord 2: " + sizeOfTargetDir);
        System.out.println("Tijd: " + totalTime);
    }
}
