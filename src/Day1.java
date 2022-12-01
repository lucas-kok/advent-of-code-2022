import java.nio.file.Paths;
import java.util.*;

public class Day1 {

    public static void main(String[] args) {
        solution();
    }

    public static void solution() {
        long startTime = System.currentTimeMillis();
        List<Integer> totalCalories = new ArrayList<>();

        try (Scanner scanner = new Scanner(Paths.get("day1.txt"))) {
            int subTotal = 0;

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();

                if (line.isEmpty()) {
                    totalCalories.add(subTotal);
                    subTotal = 0;

                    continue;
                }

                if (!scanner.hasNextLine()) totalCalories.add(Integer.parseInt(line));

                subTotal += Integer.parseInt(line);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        Collections.sort(totalCalories);
        Collections.reverse(totalCalories);

        int max = totalCalories.get(0); // Part 1
        int topThreeTotal = totalCalories.get(0) + totalCalories.get(1) + totalCalories.get(2); // Part 2


        long endTime = System.currentTimeMillis();
        long totalTime = endTime - startTime;

        System.out.println("Antwoord 1: " + max);
        System.out.println("Antwoord 2: " + topThreeTotal);
        System.out.println("Tijd: " + totalTime);
    }
}
