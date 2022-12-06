import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Day6 {
    public static void main(String[] args) {
        solution();
    }

    public static void solution() {
        long startTime = System.currentTimeMillis();
        int charsProcessed = 0;

        try (Scanner scanner = new Scanner(Paths.get("day6.txt"))) {
            String line = scanner.nextLine();
            boolean part1 = false; // true = part1 | false = part2
            int num = part1 ? 3 : 14;

            OUTER_LOOP: for (int i = 0; i < line.length() - num - 1; i++) {
                String sequence = line.substring(i, i + num);

                List<Character> chars = new ArrayList<>();
                for (char c : sequence.toCharArray()) {
                    if (chars.contains(c)) continue OUTER_LOOP;
                    chars.add(c);
                }

                charsProcessed = i + num;
                break;
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        long endTime = System.currentTimeMillis();
        long totalTime = endTime - startTime;

        System.out.println("Antwoord: " + charsProcessed);
        System.out.println("Tijd: " + totalTime);
    }
}
