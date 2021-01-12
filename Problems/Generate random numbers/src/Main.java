import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] line = scanner.nextLine().split(" ");
        int n = Integer.parseInt(line[0]);
        int a = Integer.parseInt(line[1]);
        int b = Integer.parseInt(line[2]);
        scanner.close();
        doTheTask(n, a, b);
    }

    private static void doTheTask(int n, int a, int b) {
        Random generator = createRandom(a, b);
        List<Integer> listOfRandomNumbers = createAList(generator, n, a, b);
        int summ = countASumm(listOfRandomNumbers);
        System.out.println(summ);
    }

    /**
     * Метод, вычисляющий сумму чисел из переданного в параметрах списка
     * @param listOfRandomNumbers список чисел для вычисления
     * @return число, сумму значений элементов переданного списка
     */
    private static int countASumm(List<Integer> listOfRandomNumbers) {
        int summ = 0;
        for (int s : listOfRandomNumbers) {
            summ += s;
        }
        return summ;
    }

    /**
     * Метод, создающий список случайных чисел по заданным параметрам
     * @param generator генератор случайных чисел
     * @param n размер списка случайных чисел
     * @param a минимальное значение для элементов списка чисел (включительно)
     * @param b максимальное значение для элементов списка чисел (включительно)
     * @return список случайных чисел по заданным параметрам
     */
    private static List<Integer> createAList(Random generator, int n, int a, int b) {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int random = generator.nextInt(b - a + 1) + a;
            numbers.add(random);
        }
        return numbers;
    }

    /**
     * Mетод, который создает генератор случайных чисел
     * @param a первая часть seed
     * @param b вторая часть seed
     * @return генератор случайных чисел с seed = a + b
     */
    private static Random createRandom(int a, int b) {
        return new Random(a + b);
    }
}