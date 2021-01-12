import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] line = scanner.nextLine().split(" ");
        int k = Integer.parseInt(line[0]);
        int n = Integer.parseInt(line[1]);
        double m = Double.parseDouble(line[2]);
        scanner.close();

        long seed = k;
        while (!checkSeed(seed, n, m)) {
            seed++;
        }
        System.out.println(seed);
    }

    private static boolean checkSeed(long seed, int numbersCount, double maxValue) {
        boolean result = true;
        Random generator = new Random(seed);

        for (int i = 0; i < numbersCount; i++) {
            double randomValue = generator.nextGaussian();

            if (randomValue > maxValue) {
                result = false;
                break;
            }
        }

        return result;
    }
}