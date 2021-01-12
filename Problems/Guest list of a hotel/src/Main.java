//put imports you need here

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> list = new ArrayList<>();
        while (scanner.hasNext()) {
            list.add(scanner.nextLine());
        }
        List<String> names = new ArrayList<>();
        for (String a : list) {
            String[] fromLine = a.split(" ");
            for (String m : fromLine) {
                names.add(m);
            }
        }
        printList(names);

    }

    private static void printList(List<String> names) {
        for (int o = names.size() - 1; o >= 0; o--) {
            System.out.println(names.get(o));
        }
    }
}