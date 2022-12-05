import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Day5 {

    public static void main(String[] args) {
        solution();
    }

    public static void solution() {
        long startTime = System.currentTimeMillis();

        int stackCount = 9;
        List<List<Character>> stacks = new ArrayList<>();
        List<List<Character>> modernStacks = new ArrayList<>();

        try (Scanner scanner = new Scanner(Paths.get("day5.txt"))) {
            while (scanner.hasNextLine()) { // Filling lists with crates
                char[] pieces = scanner.nextLine().toCharArray();
                if (pieces[1] == '1') break; // End reached

                for (int i = 0; i < stackCount; i++) {
                    if (stacks.size() < i + 1)  {
                        stacks.add(new ArrayList<>());
                        modernStacks.add(new ArrayList<>());
                    }

                    char crate = pieces[1 + (i * 4)];
                    if (crate == ' ') continue;

                    stacks.get(i).add(crate);
                    modernStacks.get(i).add(crate);
                }
            }

            while (scanner.hasNextLine()) { // Executing instructions
                String line = scanner.nextLine();
                if (line.isEmpty()) continue;

                String instruction = line.replaceAll(" ",  "").replace("move", "")
                        .replace("from", "-").replace("to", "-");
                String[] pieces = instruction.split("-");

                int repeats = Integer.parseInt(pieces[0]);
                int fromStack = Integer.parseInt(pieces[1]) - 1;
                int toStack = Integer.parseInt(pieces[2]) - 1;

                for (int i = 0; i < repeats; i++) {
                    char crate = stacks.get(fromStack).get(0);
                    stacks.get(fromStack).remove(0);
                    stacks.get(toStack).add(0, crate);

                    char modernCrate = modernStacks.get(fromStack).get(repeats - i - 1);
                    modernStacks.get(fromStack).remove(repeats - i - 1);
                    modernStacks.get(toStack).add(0, modernCrate);
                }
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        // Part 1
        StringBuilder topStacks = new StringBuilder();
        for (List<Character> stack : stacks)
            topStacks.append(stack.get(0));

        // Part 2
        StringBuilder modernTopStacks = new StringBuilder();
        for (List<Character> modernStack : modernStacks)
            modernTopStacks.append(modernStack.get(0));

        long endTime = System.currentTimeMillis();
        long totalTime = endTime - startTime;

        System.out.println("Antwoord 1: " + topStacks);
        System.out.println("Antwoord 2: " + modernTopStacks);
        System.out.println("Tijd: " + totalTime);
    }
}
