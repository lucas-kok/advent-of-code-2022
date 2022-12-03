import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Day3 {

    public static void main(String[] args) {
        solution();
    }

    public static void solution() {
        long startTime = System.currentTimeMillis();
        int prioritySum = 0;
        int badgeSum = 0;

        try (Scanner scanner = new Scanner(Paths.get("day3.txt"))) {
            Map<Character, Integer> badgeCount = new HashMap<>();
            int lineIndex = 1;

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                int midIndex = line.length() / 2;
                String[] compartments = { line.substring(0, midIndex), line.substring(midIndex) };

                Map<Character, Integer> itemsCount = new HashMap<>();
                for (int i = 0; i < compartments.length; i++) {

                    // Part 1
                    String compartment = compartments[i];
                    for (char item : compartment.toCharArray()) {
                        if (i == 0) itemsCount.putIfAbsent(item, 1);
                        else if (itemsCount.getOrDefault(item, -1) != -1)  {
                            prioritySum += item - (item >= 97 ? 96 : 38);
                            itemsCount.put(item, -1);
                        }

                        // Part 2
                        if (lineIndex == 1) badgeCount.putIfAbsent(item, 1);
                        else if (badgeCount.getOrDefault(item, lineIndex) == lineIndex - 1) {
                            badgeCount.put(item, lineIndex);
                            if (lineIndex == 3 && badgeCount.get(item) == 3) {
                                badgeSum += item - (item >= 97 ? 96 : 38);
                            }
                        }
                    }
                }

                if (lineIndex == 3) badgeCount = new HashMap<>();
                lineIndex = lineIndex == 3 ? 1 : lineIndex + 1;
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        long endTime = System.currentTimeMillis();
        long totalTime = endTime - startTime;

        System.out.println("Antwoord 1: " + prioritySum);
        System.out.println("Antwoord 2: " + badgeSum);
        System.out.println("Tijd: " + totalTime);
    }
}
