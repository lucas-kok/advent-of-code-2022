import java.nio.file.Paths;
import java.util.Scanner;

public class Day2 {

    public static void main(String[] args) {
        solution();
    }

    public static void solution() {
        long startTime = System.currentTimeMillis();
        int totalScore = 0;
        int secondTotalScore = 0;

        try (Scanner scanner = new Scanner(Paths.get("day2.txt"))) {
            int[][] outcomes = { { 3, 0, 6 }, { 6, 3, 0 }, { 0, 6, 3 } };
            int[][] answers = { { 3, 1, 2 }, { 1, 2, 3 }, { 2, 3, 1 } };

            while (scanner.hasNextLine()) {
                char[] pieces = scanner.nextLine().toCharArray();
                int opponentMove = pieces[0]- 65; // 0, 1 or 2
                int elfMove = pieces[2] - 88; // 0, 1 or 2

                totalScore += elfMove + 1 + outcomes[elfMove][opponentMove];
                secondTotalScore += answers[opponentMove][elfMove] + elfMove * 3;
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        long endTime = System.currentTimeMillis();
        long totalTime = endTime - startTime;

        System.out.println("Antwoord 1: " + totalScore);
        System.out.println("Antwoord 2: " + secondTotalScore);
        System.out.println("Tijd: " + totalTime);
    }
}
