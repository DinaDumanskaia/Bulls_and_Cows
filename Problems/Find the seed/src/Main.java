import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] line = scanner.nextLine().split(" ");
        int a = Integer.parseInt(line[0]);
        int b = Integer.parseInt(line[1]);
        int n = Integer.parseInt(line[2]);
        int k = Integer.parseInt(line[3]);
        scanner.close();
        doTheTask(a, b, n, k);
    }

    //--------------------------------------
    private static void doTheTask(int a, int b, int n, int k) {
        Map<Integer, Integer> seedToMaxMap = new HashMap<>();
        for (int seed = a; seed <= b; seed++) {
            Random generator = createRandom(seed);
            List<Integer> randomNumbers = generateNumbers(n, k, generator);
            int max = getMaximumNumber(randomNumbers);
            fillTheMap(seed, max, seedToMaxMap);
        }
        Map.Entry<Integer, Integer> seedAndMinValue = findMinFromValues(seedToMaxMap);
        printResult(seedAndMinValue);
    }

    /**
     * Метод, который распечатывается пару key + value
     * @param seedAndMinValue пара key + value
     */
    private static void printResult(Map.Entry<Integer, Integer> seedAndMinValue) {
        System.out.println(seedAndMinValue.getKey());
        System.out.println(seedAndMinValue.getValue());
    }

    /**
     * Метод, который находит пару key + value с минимальным значением value в Map
     * @param seedToMaxMap Map, значения которого используются для анализа
     * @return пару key + value с минимальным значением value из всего Map
     */
    private static Map.Entry<Integer, Integer> findMinFromValues(Map<Integer, Integer> seedToMaxMap) {
        Map.Entry<Integer, Integer> seedAndMinValue = null;
        int minValue = Integer.MAX_VALUE;

        for (Map.Entry<Integer, Integer> entry : seedToMaxMap.entrySet()) {
            int value = entry.getValue();
            // compare
            if (value < minValue) {
                minValue = value;
                seedAndMinValue = entry;
            }
        }
        return seedAndMinValue;
    }

    /**
     * Метод, который заполняет списак Map переданными значениями
     * @param seed переданное значение для key
     * @param max переданное значение для value
     * @param seedToMaxMap Map, в который записываются переданные значения
     */
    private static void fillTheMap(int seed, int max, Map<Integer, Integer> seedToMaxMap) {
        seedToMaxMap.put(seed, max);
    }

    /**
     * Метод, который находит максимальное значение из чисел в списке
     * @param randomNumbers список значений
     * @return число из переданного списка с максимальным значением
     */
    private static int getMaximumNumber(List<Integer> randomNumbers) {
        int max = Integer.MIN_VALUE;
        for (int i : randomNumbers) {
            if (i > max) {
                max = i;
            }
        }
        return max;
    }

    /**
     * Метод генерирует n чисел меньше k, но больше 0, и возвращает их списком
     * @param n необходимое количество чисел в списке
     * @param k максимальное возможное значение элемента в результирующем списке
     * @param generator генератор случайных чисел
     * @return список случайных чисел, соответствующих указанным условиям генерации
     */
    private static List<Integer> generateNumbers(int n, int k, Random generator) {
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            list.add(generator.nextInt(k));
        }

        return list;
    }

    /**
     * Метод создает генератор случайных чисел
     * @param seed число для инциализации генератора
     * @return генератор случайных чисел
     */
    private static Random createRandom(int seed) {
        return new Random(seed);
    }
}