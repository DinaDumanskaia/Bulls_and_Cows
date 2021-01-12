import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //получаем длину массива
        int length = Integer.parseInt(scanner.nextLine());
        String[] line = scanner.nextLine().split(" ");
        List<Integer> list = new ArrayList<>();
        //создаем список введенных чисел
        for (String s : line) {
            list.add(Integer.parseInt(s));
        }

        int triples = checkTriples(list);
        System.out.println(triples);
    }

    private static int checkTriples(List<Integer> list) {
        int counter = 0;
        if (list.size() < 3) {
            return 0;
        } else {
            for (int i = 0; i < list.size() - 2; i++) {
                if (list.get(i) == list.get(i + 1) - 1 && list.get(i + 1) == list.get(i + 2) - 1) {
                    counter++;
                }
            }
        }
        return counter;
    }
}