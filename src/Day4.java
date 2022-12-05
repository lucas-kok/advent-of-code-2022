import org.w3c.dom.ranges.Range;

import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Scanner;

public class Day4 {

    public static void main(String[] args) {
        solution();
    }

    public static void solution() {
        long startTime = System.currentTimeMillis();
        int fullOverlappingTasks = 0;
        int overlappingTasks = 0;

        try (Scanner scanner = new Scanner(Paths.get("day4.txt"))) {
            while (scanner.hasNextLine()) {
                String[] tasks = scanner.nextLine().split(",");
                int[][] nums = new int[2][2];
                for (int i = 0; i < tasks.length; i++) {
                    String[] taskRanges = tasks[i].split("-");
                    nums[i][0] = Integer.parseInt(taskRanges[0]);
                    nums[i][1] = Integer.parseInt(taskRanges[1]);
                }

                if ((nums[0][0] >= nums [1][0] && nums[0][1] <= nums[1][1]) || (nums[1][0] >= nums[0][0] && nums[1][1] <= nums[0][1])) fullOverlappingTasks++; // Part 1
                if (nums[0][0] <= nums[1][1] && nums[1][0] <= nums[0][1]) overlappingTasks++;  // Part 2
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        long endTime = System.currentTimeMillis();
        long totalTime = endTime - startTime;

        System.out.println("Antwoord 1: " + fullOverlappingTasks);
        System.out.println("Antwoord 2: " + overlappingTasks);
        System.out.println("Tijd: " + totalTime);
    }
}
